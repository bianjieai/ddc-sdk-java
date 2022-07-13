package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.Authority;
import ai.bianjie.ddc.contract.Charge;
import ai.bianjie.ddc.contract.DDC1155;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.dto.BlockEventBean;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.util.Web3jUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.web3j.abi.EventEncoder;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Strings;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author kuan
 * Created on 21/12/11.
 */
@Slf4j
public class BlockEventService extends BaseService {

    /**
     * Get block events and parse
     * 1. Get block information based on block height
     * 2. Obtain transaction receipts based on transactions in blocks
     * 3. Traverse the events in the transaction receipt and parse
     *
     * @param blockNumber Block height
     * @return BlockEventBean
     * @throws IOException IOException
     */
    public BlockEventBean getBlockEvent(BigInteger blockNumber) throws IOException {
        ArrayList<BaseEventResponse> arrayList = new ArrayList<>();
        // 1. Get block information
        EthBlock.Block blockInfo = getBlockByNumber(blockNumber);

        if (blockInfo == null) {
            throw new DDCException(400, "cannot get blockInfo by blockNumber:" + blockNumber);
        }

        List<EthBlock.TransactionResult> txs = blockInfo.getTransactions();


        int threadCount = 3;
        int len = txs.size()/threadCount +1;
        GetBlockEvent g = new GetBlockEvent();
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(g);
            if (i == threadCount - 1) {
                g.txs = txs.subList(i*len,txs.size());
                t.start();
                break;
            }
            g.txs = txs.subList(i*len,(i+1)*len);
            t.start();
        }
        arrayList = g.arrayList;


//        if (txs != null) {
//            txs.stream().parallel().forEach(tx->{
//                EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx.get();
//                String hash = transaction.get().getHash();
//                ArrayList<BaseEventResponse> arr = null;
//                boolean ok = true;
//                int i = 0;
//                while (ok) {
//                    if (i >= 3) {
//                        throw new DDCException(400, "cannot get receipt by hash:" + hash);
//                    }
//                    try {
//                        arr = analyzeEventsByTxHash(hash);
//                    } catch (Exception e) {
//                        System.out.println("----------------"+e);
//                        i++;
//                        continue;
//                    }
//                    ok = false;
//                }
//                arrayList.addAll(arr);
//            });
//        }

        // 2. get deal
//        if (txs != null) {
//            txs.forEach(tx -> {
//                EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx.get();
//                String hash = transaction.get().getHash();
//                ArrayList<BaseEventResponse> arr = null;
//                boolean ok = true;
//                int i = 0;
//                while (ok) {
//                    if (i >= 3) {
//                        throw new DDCException(400, "cannot get receipt by hash:" + hash);
//                    }
//                    try {
//                        arr = analyzeEventsByTxHash(hash);
//                    } catch (Exception e) {
//                        i++;
//                        continue;
//                    }
//                    ok = false;
//                }
//                arrayList.addAll(arr);
//            });
//        }

        log.info("块高 {} 解析到区块事件 {}", blockNumber, JSON.toJSONString(arrayList));
        return new BlockEventBean(arrayList, blockInfo.getTimestamp().toString());
    }

    public static ArrayList<BaseEventResponse> analyzeEventsByTxHash(String hash) throws Exception {
        ArrayList<BaseEventResponse> result = new ArrayList<>();
        //hash获取receipt
        TransactionReceipt receipt = getTransReceipt(hash);
        for (int i = 0; i < receipt.getLogs().size(); i++) {
            List<BaseEventResponse> list = new ArrayList<>();
            Log log = receipt.getLogs().get(i);
            if (Strings.isEmpty(log.getAddress())) {
                continue;
            }
            if (ConfigCache.get().getAuthorityLogicAddress().equalsIgnoreCase(log.getAddress())) {
                Authority authority = Web3jUtils.getAuthority();
                if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.ADDACCOUNT_EVENT))) {
                    list.addAll(authority.getAddAccountEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.ADDBATCHACCOUNT_EVENT))) {
                    list.addAll(authority.getAddBatchAccountEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.SETSWITCHERSTATEOFPLATFORM_EVENT))) {
                    list.addAll(authority.getSetSwitcherStateOfPlatformEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.UPDATEACCOUNTSTATE_EVENT))) {
                    list.addAll(authority.getUpdateAccountStateEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.CROSSPLATFORMAPPROVAL_EVENT))) {
                    list.addAll(authority.getAdminChangedEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.SYNCPLATFORMDID_EVENT))) {
                    list.addAll(authority.getSyncPlatformDIDEvents(receipt));
                }
            } else if (ConfigCache.get().getChargeLogicAddress().equalsIgnoreCase(log.getAddress())) {
                Charge charge = Web3jUtils.getCharge();
                if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.RECHARGE_EVENT))) {
                    list.addAll(charge.getRechargeEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.RECHARGEBATCH_EVENT))) {
                    list.addAll(charge.getRechargeBatchEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.SETFEE_EVENT))) {
                    list.addAll(charge.getSetFeeEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.PAY_EVENT))) {
                    list.addAll(charge.getPayEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.DELDDC_EVENT))) {
                    list.addAll(charge.getDelDDCEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.DELFEE_EVENT))) {
                    list.addAll(charge.getDelFeeEvents(receipt));
                }
            } else if (ConfigCache.get().getDdc721Address().equalsIgnoreCase(log.getAddress())) {
                DDC721 ddc721 = Web3jUtils.getDDC721();
                if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.TRANSFER_EVENT))) {
                    list.addAll(ddc721.getTransferEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.ENTERBLACKLIST_EVENT))) {
                    list.addAll(ddc721.getEnterBlacklistEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.EXITBLACKLIST_EVENT))) {
                    list.addAll(ddc721.getExitBlacklistEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.SETURI_EVENT))) {
                    list.addAll(ddc721.getSetURIEvents(receipt));
                }
            } else if (ConfigCache.get().getDdc1155Address().equalsIgnoreCase(log.getAddress())) {
                DDC1155 ddc1155 = Web3jUtils.getDDC1155();
                if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.TRANSFERSINGLE_EVENT))) {
                    list.addAll(ddc1155.getTransferSingleEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.TRANSFERBATCH_EVENT))) {
                    list.addAll(ddc1155.getTransferBatchEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.TRANSFERSINGLE_EVENT))) {
                    list.addAll(ddc1155.getTransferSingleEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.ENTERBLACKLIST_EVENT))) {
                    list.addAll(ddc1155.getEnterBlacklistEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.EXITBLACKLIST_EVENT))) {
                    list.addAll(ddc1155.getExitBlacklistEvents(receipt));
                } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.SETURI_EVENT))) {
                    list.addAll(ddc1155.getSetURIEvents(receipt));
                }
            }
            result.addAll(list);

        }
        return result;
    }
}

class GetBlockEvent extends BaseService implements Runnable {
    List<EthBlock.TransactionResult> txs;
    ArrayList<BaseEventResponse> arrayList = new ArrayList<>();

    public void run(){
        if (this.txs != null) {
            for (int i = 0; i < this.txs.size(); i++) {
                EthBlock.TransactionResult tx = txs.get(i);
                EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx.get();
                String hash = transaction.get().getHash();
                ArrayList<BaseEventResponse> arr = null;
                boolean ok = true;
                int count = 0;
                while (ok) {
                    if (count >= 3) {
                        throw new DDCException(400, "cannot get receipt by hash:" + hash);
                    }
                    try {
                        arr = BlockEventService.analyzeEventsByTxHash(hash);
                    } catch (Exception e) {
                        count++;
                        continue;
                    }
                    ok = false;
                }
                this.txs.remove(tx);
                this.arrayList.addAll(arr);
            }
        }
    }
}