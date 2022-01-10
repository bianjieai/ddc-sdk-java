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
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Strings;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kuan
 * Created on 21/12/11.
 * @description
 */
@Slf4j
public class BlockEventService extends BaseService {
//    private Web3jUtils web3jUtils;
//    private AuthorityLogic authorityLogic;
//    private ChargeLogic chargeLogic;
//    private DDC721 ddc721;
//    private DDC1155 ddc1155;

    // 外部可通过修改hashMap内的属性增加或删除需要解析的事件
//    public HashMap<String, Class> eventBeanMap = new HashMap<>();
//
//    public BlockEventService() {
//        // 进行事件方法与实体类的绑定
//        eventBeanMap.put(AuthorityFunctions.AddAccountEvent, AuthorityLogic.AddAccountEventResponse.class);
//        eventBeanMap.put(AuthorityFunctions.UpdateAccountEvent, AuthorityLogic.UpdateAccountEventResponse.class);
//        eventBeanMap.put(AuthorityFunctions.UpdateAccountStateEvent, AuthorityLogic.UpdateAccountStateEventResponse.class);
//
//        eventBeanMap.put(ChargeFunctions.RechargeEvent,ChargeLogic.RechargeEventResponse.class);
//        eventBeanMap.put(ChargeFunctions.PayEvent, ChargeLogic.PayEventResponse.class);
//        eventBeanMap.put(ChargeFunctions.SetFeeEvent, ChargeLogic.SetFeeEventResponse.class);
//        eventBeanMap.put(ChargeFunctions.DeleteFeeEvent, ChargeLogic.DeleteFeeEventResponse.class);
//        eventBeanMap.put(ChargeFunctions.DeleteDDCEvent, ChargeLogic.DeleteDDCEventResponse.class);
//
//        eventBeanMap.put(DDC721Functions.DDC721TransferEvent, DDC721.TransferEventResponse.class);
//        eventBeanMap.put(DDC721Functions.DDC721FreezeEvent, DDC721.EnterBlacklistEventResponse.class);
//        eventBeanMap.put(DDC721Functions.DDC721UnFreezeEvent, DDC721.ExitBlacklistEventResponse.class);
//
//        eventBeanMap.put(DDC1155Functions.DDC1155TransferSingleEvent, DDC1155.TransferSingleEventResponse.class);
//        eventBeanMap.put(DDC1155Functions.DDC1155TransferBatchEvent, DDC1155.TransferBatchEventResponse.class);
//        eventBeanMap.put(DDC1155Functions.DDC1155FreezeEvent, DDC1155.EnterBlacklistEventResponse.class);
//        eventBeanMap.put(DDC1155Functions.DDC1155UnFreezeEvent, DDC1155.ExitBlacklistEventResponse.class);
//    }

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
    public <T extends BaseEventResponse> ArrayList<T> getBlockEvent(String blockNumber) throws IOException, InterruptedException {
        ArrayList<T> arrayList = new ArrayList<>();
        // 1. 获取区块信息
        Web3j web3j = (new Web3jUtils()).getWeb3j();

        EthBlock.Block blockInfo = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(Long.parseLong(blockNumber))),false).send().getBlock();
        List<EthBlock.TransactionResult> txs = blockInfo.getTransactions();

        // 2. 获取交易
        if (txs != null){
            txs.forEach(tx->{
                EthBlock.TransactionHash transaction = (EthBlock.TransactionHash) tx.get();
                String hash = transaction.get();
                try {
                    ArrayList<T> arr = analyzeEventsByTxHash(hash);
                    arrayList.addAll(arr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        log.info("块高 {} 解析到区块事件 {}",blockNumber, JSONObject.toJSONString(arrayList));
        return arrayList;
    }

    private <T extends BaseEventResponse>ArrayList<T> analyzeEventsByTxHash(String hash) throws Exception {

        ArrayList<BaseEventResponse> result = new ArrayList<>();
        //hash获取receipt
        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        TransactionReceipt receipt = web3j.ethGetTransactionReceipt(hash).send().getTransactionReceipt().get();
        for (int i = 0; i < receipt.getLogs().size(); i++) {
            List<BaseEventResponse> list = new ArrayList<>();
            Log log = receipt.getLogs().get(i);
            if (Strings.isEmpty(log.getAddress())) {
                continue;
            }
            if (ConfigCache.get().getAuthorityLogicAddress().equalsIgnoreCase(log.getAddress())) {
                //List<Type> res = FunctionReturnDecoder.decode(log.getData(), AuthorityLogic.ADDACCOUNT_EVENT.getParameters());
                AuthorityLogic authorityLogic = web3jUtils.getAuthority();
                if (log.getTopics().get(0).equals(AuthorityFunctions.AddAccountEvent)) {
                    List<AuthorityLogic.AddAccountEventResponse> responses = authorityLogic.getAddAccountEvents(receipt);
                    list.addAll(responses);
                }if (log.getTopics().get(0).equals(AuthorityFunctions.UpdateAccountEvent)) {
                    List<AuthorityLogic.UpdateAccountEventResponse> responses = authorityLogic.getUpdateAccountEvents(receipt);
                    list.addAll(responses);
                }if (log.getTopics().get(0).equals(AuthorityFunctions.UpdateAccountStateEvent)) {
                    List<AuthorityLogic.UpdateAccountStateEventResponse> responses = authorityLogic.getUpdateAccountStateEvents(receipt);
                    list.addAll(responses);
                }
            }if (ConfigCache.get().getChargeLogicAddress().equalsIgnoreCase(log.getAddress())) {
                ChargeLogic chargeLogic = web3jUtils.getCharge();
                if(log.getTopics().get(0).equals(ChargeFunctions.RechargeEvent)) {
                    List<ChargeLogic.RechargeEventResponse> responses =chargeLogic.getRechargeEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(ChargeFunctions.SetFeeEvent)) {
                    List<ChargeLogic.SetFeeEventResponse> responses =chargeLogic.getSetFeeEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(ChargeFunctions.PayEvent)) {
                    List<ChargeLogic.PayEventResponse> responses =chargeLogic.getPayEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(ChargeFunctions.DeleteDDCEvent)) {
                    List<ChargeLogic.DeleteDDCEventResponse> responses =chargeLogic.getDeleteDDCEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(ChargeFunctions.DeleteFeeEvent)) {
                    List<ChargeLogic.DeleteFeeEventResponse> responses =chargeLogic.getDeleteFeeEvents(receipt);
                    list.addAll(responses);
                }
            }if (ConfigCache.get().getDdc721Address().equalsIgnoreCase(log.getAddress())) {
                DDC721 ddc721 = web3jUtils.getDDC721();
                if(log.getTopics().get(0).equals(DDC721Functions.DDC721TransferEvent)) {
                    List<DDC721.TransferEventResponse> responses =ddc721.getTransferEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(DDC721Functions.DDC721FreezeEvent)) {
                    List<DDC721.EnterBlacklistEventResponse> responses =ddc721.getEnterBlacklistEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(DDC721Functions.DDC721UnFreezeEvent)) {
                    List<DDC721.ExitBlacklistEventResponse> responses =ddc721.getExitBlacklistEvents(receipt);
                    list.addAll(responses);
                }
            }if (ConfigCache.get().getDdc1155Address().equalsIgnoreCase(log.getAddress())) {
                DDC1155 ddc1155 = web3jUtils.getDDC1155();
                if(log.getTopics().get(0).equals(DDC1155Functions.DDC1155TransferBatchEvent)) {
                    List<DDC1155.TransferBatchEventResponse> responses = ddc1155.getTransferBatchEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(DDC1155Functions.DDC1155TransferSingleEvent)) {
                    List<DDC1155.TransferSingleEventResponse> responses = ddc1155.getTransferSingleEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(DDC1155Functions.DDC1155FreezeEvent)) {
                    List<DDC1155.EnterBlacklistEventResponse> responses = ddc1155.getEnterBlacklistEvents(receipt);
                    list.addAll(responses);
                }if(log.getTopics().get(0).equals(DDC1155Functions.DDC1155UnFreezeEvent)) {
                    List<DDC1155.ExitBlacklistEventResponse> responses = ddc1155.getExitBlacklistEvents(receipt);
                    list.addAll(responses);
                }
            }
            result.addAll(list);

        }
            return (ArrayList<T>) result;
    }
}
