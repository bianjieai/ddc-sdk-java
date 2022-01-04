package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Strings;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Slf4j
public class BaseService {
    protected Web3j web3j = Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress()));

    Credentials credentials = Credentials.create(ConfigCache.get().getCredentials());
    protected SignEventListener signEventListener;


    /**
     * 获取区块信息
     * @param blockNumber 区块高度
     * @return 区块信息
     */
    public String getBlockByNumber(String blockNumber) {
        String result = blockNumber + ConfigCache.get().getOpbGatewayAddress();
        //        resultCheck(result);
        return JSON.toJSONString(result);
    }

    /**
     * 查询交易回执
     * @param hash 交易哈希
     * @return 交易回执
     * @throws InterruptedException InterruptedException
     */
    public String getTxReceipt(String hash) throws InterruptedException, ExecutionException {
        EthGetTransactionReceipt txReceipt = web3j.ethGetTransactionReceipt(hash).sendAsync().get();
        return txReceipt.getResult().toString();
    }

    /**
     * 查询交易信息
     * @param hash 交易哈希
     * @return 交易信息
     */
    public String getTxByHash(String hash) {
        String result = hash + ConfigCache.get().getOpbGatewayAddress() + web3j.ethGetBlockTransactionCountByHash(hash);
//        resultCheck(result);
        return JSON.toJSONString(result);
    }

    /**
     * 查询交易状态
     * @param hash 交易哈希
     * @return 交易状态
     */
    public Boolean getTxByStatus(String hash) throws ExecutionException, InterruptedException {
        EthGetTransactionReceipt txReceipt = web3j.ethGetTransactionReceipt(hash).sendAsync().get();
        if(Strings.isEmpty(txReceipt.toString())){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * 校验交易结果
     */
    public void resultCheck(TransactionReceipt result) {
        if (null == result) {
            log.error("resultCheck {}", ErrorMessage.REQUEST_FAILED);
            throw new DDCException(ErrorMessage.REQUEST_FAILED);
        }

//        if (result.error != null) {
//            log.error("resultCheck {}", result.getError());
//            throw new DDCException(ErrorMessage.REQUEST_FAILED, result.getError());
//        }
    }
}
