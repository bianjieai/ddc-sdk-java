package ai.bianjie.ddc.service;

import ai.bianjie.ddc.contract.*;
import ai.bianjie.ddc.dto.BlockEventBean;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.util.Web3jUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.web3j.abi.EventEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthLog;
import org.web3j.protocol.core.methods.response.Log;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class BlockEventService extends BaseService {
    ExecutorService executorService;

    public BlockEventService() {
        int poolSize = 20;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10000);
        RejectedExecutionHandler policy = new ThreadPoolExecutor.AbortPolicy();
        ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize,
                0, TimeUnit.SECONDS,
                queue,
                policy);
        this.executorService = executorService;
    }

    public BlockEventBean getLogs(BigInteger blockNumber, List<String> address) throws IOException, ExecutionException, InterruptedException {
        EthBlock.Block blockInfo = getBlockByNumber(blockNumber);

        if (blockInfo == null) {
            throw new DDCException(400, "cannot get blockInfo by blockNumber:" + blockNumber);
        }

        EthFilter filter = new EthFilter(new DefaultBlockParameterNumber(blockNumber), new DefaultBlockParameterNumber(blockNumber), address)
                .addOptionalTopics(EventEncoder.encode(Authority.ADDACCOUNT_EVENT),
                        EventEncoder.encode(Authority.ADDBATCHACCOUNT_EVENT),
                        EventEncoder.encode(Authority.SETSWITCHERSTATEOFPLATFORM_EVENT),
                        EventEncoder.encode(Authority.UPDATEACCOUNTSTATE_EVENT),
                        EventEncoder.encode(Authority.CROSSPLATFORMAPPROVAL_EVENT),
                        EventEncoder.encode(Authority.SYNCPLATFORMDID_EVENT),
                        EventEncoder.encode(Charge.RECHARGE_EVENT),
                        EventEncoder.encode(Charge.RECHARGEBATCH_EVENT),
                        EventEncoder.encode(Charge.SETFEE_EVENT),
                        EventEncoder.encode(Charge.PAY_EVENT),
                        EventEncoder.encode(Charge.DELDDC_EVENT),
                        EventEncoder.encode(Charge.DELFEE_EVENT),
                        EventEncoder.encode(DDC721.TRANSFER_EVENT),
                        EventEncoder.encode(DDC721.ENTERBLACKLIST_EVENT),
                        EventEncoder.encode(DDC721.EXITBLACKLIST_EVENT),
                        EventEncoder.encode(DDC721.SETURI_EVENT),
                        EventEncoder.encode(DDC1155.TRANSFERSINGLE_EVENT),
                        EventEncoder.encode(DDC1155.TRANSFERBATCH_EVENT),
                        EventEncoder.encode(DDC1155.TRANSFERSINGLE_EVENT),
                        EventEncoder.encode(DDC1155.ENTERBLACKLIST_EVENT),
                        EventEncoder.encode(DDC1155.EXITBLACKLIST_EVENT),
                        EventEncoder.encode(DDC1155.SETURI_EVENT));
        // subscribe to events
        ArrayList<BaseEventResponse> list = new ArrayList<>();
        Web3j w3 = Web3jUtils.getWeb3j();
        List<EthLog.LogResult> logs = w3.ethGetLogs(filter).send().getLogs();
        List<Future<BaseEventResponse>> futureList = new ArrayList<>();
        logs.forEach(l -> {
            Log log = (Log) l;
            Parse parse = new Parse(log);
            Future<BaseEventResponse> submit = executorService.submit(parse);
            futureList.add(submit);
        });

        for (Future<BaseEventResponse> f : futureList) {
            //将汇总好的结果进行轮询，判断任务是否执行完成，确保每个任务执行完成后将结果添加到结果集中
            while (true) {
                if (f.isDone() && !f.isCancelled()) {
                    BaseEventResponse baseEventResponse = f.get();
                    list.add(baseEventResponse);
                    break;
                }
            }
        }

        log.info("块高 {} 解析到区块事件 {}", blockNumber, JSON.toJSONString(list));
        executorService.shutdown();
        return new BlockEventBean(list, blockInfo.getTimestamp().toString());
    }

    static class Parse implements Callable<BaseEventResponse> {
        private Log log;

        public Parse(Log log) {
            this.log = log;
        }

        @Override
        public BaseEventResponse call() throws Exception {
            AuthorityOver authorityOver = Web3jUtils.getAuthorityOver();
            ChargeOver chargeOver = Web3jUtils.getChargeOver();
            DDC721Over ddc721Over = Web3jUtils.getDDC721Over();
            DDC1155Over ddc1155Over = Web3jUtils.getDDC1155Over();
            if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.ADDACCOUNT_EVENT))) {
                return authorityOver.addAccountEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.ADDBATCHACCOUNT_EVENT))) {
                return authorityOver.addBatchAccountEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.SETSWITCHERSTATEOFPLATFORM_EVENT))) {
                return authorityOver.setSwitcherStateOfPlatformEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.UPDATEACCOUNTSTATE_EVENT))) {
                return authorityOver.updateAccountStateEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.CROSSPLATFORMAPPROVAL_EVENT))) {
                return authorityOver.adminChangedEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Authority.SYNCPLATFORMDID_EVENT))) {
                return authorityOver.syncPlatformDIDEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.RECHARGE_EVENT))) {
                return chargeOver.rechargeEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.RECHARGEBATCH_EVENT))) {
                return chargeOver.rechargeBatchEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.SETFEE_EVENT))) {
                return chargeOver.setFeeEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.PAY_EVENT))) {
                return chargeOver.payEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.DELDDC_EVENT))) {
                return chargeOver.delDDCEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(Charge.DELFEE_EVENT))) {
                return chargeOver.delFeeEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.TRANSFER_EVENT))) {
                return ddc721Over.transferEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.ENTERBLACKLIST_EVENT))) {
                return ddc721Over.enterBlacklistEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.EXITBLACKLIST_EVENT))) {
                return ddc721Over.exitBlacklistEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC721.SETURI_EVENT))) {
                return ddc721Over.setURIEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.TRANSFERSINGLE_EVENT))) {
                return ddc1155Over.transferSingleEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.TRANSFERBATCH_EVENT))) {
                return ddc1155Over.transferBatchEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.TRANSFERSINGLE_EVENT))) {
                return ddc1155Over.transferSingleEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.ENTERBLACKLIST_EVENT))) {
                return ddc1155Over.enterBlacklistEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.EXITBLACKLIST_EVENT))) {
                return ddc1155Over.exitBlacklistEventFlowable(log);
            } else if (log.getTopics().get(0).equals(EventEncoder.encode(DDC1155.SETURI_EVENT))) {
                return ddc1155Over.setURIEventFlowable(log);
            }
            return null;
        }
    }
}
