package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.AuthorityFunctions;
import ai.bianjie.ddc.constant.ChargeFunctions;
import ai.bianjie.ddc.constant.DDC1155Functions;
import ai.bianjie.ddc.constant.DDC721Functions;
import ai.bianjie.ddc.contract.AuthorityLogic;
import ai.bianjie.ddc.contract.ChargeLogic;
import ai.bianjie.ddc.contract.DDC1155;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.util.Web3jUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kuan
 * Created on 21/12/11.
 * @description
 */
@Slf4j
public class BlockEventService extends BaseService {

    /**
     * 获取区块事件并解析
     * 1. 根据块高获取区块信息
     * 2. 根据块中交易获取交易回执
     * 3. 遍历交易回执中的事件并解析
     *
     * @param blockNumber blockNumber
     * @return ArrayList<Object>
     * @throws IOException   IOException
     */
    public ArrayList<BaseEventResponse> getBlockEvent(String blockNumber) throws IOException, InterruptedException {
        ArrayList<BaseEventResponse> arrayList = new ArrayList<>();
        // 1. 获取区块信息
        EthBlock.Block blockInfo = getBlockByNumber(blockNumber);

        List<EthBlock.TransactionResult> txs = blockInfo.getTransactions();

        // 2. 获取交易
        if (txs != null) {
            txs.forEach(tx -> {
                EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx.get();
                String hash = transaction.get().getHash();
                try {
                    ArrayList<BaseEventResponse> arr = analyzeEventsByTxHash(hash);
                    arrayList.addAll(arr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        log.info("块高 {} 解析到区块事件 {}", blockNumber, JSONObject.toJSONString(arrayList));
        return arrayList;
    }

    private ArrayList<BaseEventResponse> analyzeEventsByTxHash(String hash) throws Exception {
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
                //List<Type> res = FunctionReturnDecoder.decode(log.getData(), AuthorityLogic.ADDACCOUNT_EVENT.getParameters());
                AuthorityLogic authorityLogic = Web3jUtils.getAuthority();
                switch (log.getTopics().get(0)) {
                    case AuthorityFunctions.AddAccountEvent:
                        list.addAll(authorityLogic.getAddAccountEvents(receipt));
                        break;
                    case AuthorityFunctions.UpdateAccountEvent:
                        list.addAll(authorityLogic.getUpdateAccountEvents(receipt));
                        break;
                    case AuthorityFunctions.UpdateAccountStateEvent:
                        list.addAll(authorityLogic.getUpdateAccountStateEvents(receipt));
                        break;
                }
            } else if (ConfigCache.get().getChargeLogicAddress().equalsIgnoreCase(log.getAddress())) {
                ChargeLogic chargeLogic = Web3jUtils.getCharge();
                switch (log.getTopics().get(0)) {
                    case ChargeFunctions.RechargeEvent:
                        list.addAll(chargeLogic.getRechargeEvents(receipt));
                        break;
                    case ChargeFunctions.SetFeeEvent:
                        list.addAll(chargeLogic.getSetFeeEvents(receipt));
                        break;
                    case ChargeFunctions.PayEvent:
                        list.addAll(chargeLogic.getPayEvents(receipt));
                        break;
                    case ChargeFunctions.DeleteDDCEvent:
                        list.addAll(chargeLogic.getDeleteDDCEvents(receipt));
                        break;
                    case ChargeFunctions.DeleteFeeEvent:
                        list.addAll(chargeLogic.getDeleteFeeEvents(receipt));
                        break;
                }
            } else if (ConfigCache.get().getDdc721Address().equalsIgnoreCase(log.getAddress())) {
                DDC721 ddc721 = Web3jUtils.getDDC721();
                switch (log.getTopics().get(0)) {
                    case DDC721Functions.DDC721TransferEvent:
                        list.addAll(ddc721.getTransferEvents(receipt));
                        break;
                    case DDC721Functions.DDC721FreezeEvent:
                        list.addAll(ddc721.getEnterBlacklistEvents(receipt));
                        break;
                    case DDC721Functions.DDC721UnFreezeEvent:
                        list.addAll(ddc721.getExitBlacklistEvents(receipt));
                        break;
                }
            } else if (ConfigCache.get().getDdc1155Address().equalsIgnoreCase(log.getAddress())) {
                DDC1155 ddc1155 = Web3jUtils.getDDC1155();
                switch (log.getTopics().get(0)) {
                    case DDC1155Functions.DDC1155TransferBatchEvent:
                        list.addAll(ddc1155.getTransferBatchEvents(receipt));
                        break;
                    case DDC1155Functions.DDC1155TransferSingleEvent:
                        list.addAll(ddc1155.getTransferSingleEvents(receipt));
                        break;
                    case DDC1155Functions.DDC1155FreezeEvent:
                        list.addAll(ddc1155.getEnterBlacklistEvents(receipt));
                        break;
                    case DDC1155Functions.DDC1155UnFreezeEvent:
                        list.addAll(ddc1155.getExitBlacklistEvents(receipt));
                        break;
                }
            }
            result.addAll(list);

        }
        return result;
    }
}
