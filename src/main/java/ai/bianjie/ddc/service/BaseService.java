package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.Web3jUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Strings;

import java.util.concurrent.ExecutionException;

@Slf4j
public class BaseService {
    protected SignEventListener signEventListener;

    /**
     * 获取区块信息
     * @param blockNumber 区块高度
     * @return 区块信息
     */
    public String getBlockByNumber(String blockNumber) {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }

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
    public String getTransReceipt(String hash) throws InterruptedException, ExecutionException {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }

        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        EthGetTransactionReceipt txReceipt = web3j.ethGetTransactionReceipt(hash).sendAsync().get();
        return txReceipt.getResult().toString();
    }

    /**
     * 查询交易信息
     * @param hash 交易哈希
     * @return 交易信息
     */
    public String getTransByHash(String hash) {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }

        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        String result = hash + ConfigCache.get().getOpbGatewayAddress() + web3j.ethGetBlockTransactionCountByHash(hash);
//        resultCheck(result);
        return JSON.toJSONString(result);
    }

    /**
     * 查询交易状态
     * @param hash 交易哈希
     * @return 交易状态
     */
    public Boolean getTransByStatus(String hash) throws ExecutionException, InterruptedException {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }

        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
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
