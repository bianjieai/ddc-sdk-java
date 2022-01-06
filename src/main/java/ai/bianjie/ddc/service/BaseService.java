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
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Strings;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
public class BaseService {
    protected SignEventListener signEventListener;

    /**
     * 获取区块信息
     * @param blockNumber 区块高度
     * @return 区块信息
     */
    public EthBlock.Block getBlockByNumber(String blockNumber) throws IOException {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }
        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        EthBlock.Block blockInfo = web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST,true).send().getBlock();

        return blockInfo;
    }

    /**
     * 查询交易回执
     * @param hash 交易哈希
     * @return 交易回执
     * @throws InterruptedException InterruptedException
     */
    public EthGetTransactionReceipt getTransReceipt(String hash) throws InterruptedException, ExecutionException {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }

        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        EthGetTransactionReceipt txReceipt = web3j.ethGetTransactionReceipt(hash).sendAsync().get();
        return txReceipt;
    }

    /**
     * 查询交易信息
     * @param hash 交易哈希
     * @return 交易信息
     */
    public EthTransaction getTransByHash(String hash) throws IOException {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }

        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        EthTransaction tx = web3j.ethGetTransactionByHash(hash).send();
        return tx;
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
