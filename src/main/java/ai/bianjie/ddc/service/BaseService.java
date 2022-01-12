package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.Web3jUtils;
import lombok.extern.slf4j.Slf4j;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.utils.Strings;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Slf4j
public class BaseService {
    protected SignEventListener signEventListener;
    private String gasLimit = ConfigCache.get().getGasLimit();

    /**
     * 获取区块信息
     * @return 区块信息
     */
    public EthBlock.Block getBlockByNumber() throws IOException {
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
    public TransactionReceipt getTransReceipt(String hash) throws InterruptedException, ExecutionException {
        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        return web3j.ethGetTransactionReceipt(hash).sendAsync().get().getTransactionReceipt().get();
    }

    /**
     * 查询交易信息
     * @param hash 交易哈希
     * @return 交易信息
     */
    public Transaction getTransByHash(String hash) throws IOException {
        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        return web3j.ethGetTransactionByHash(hash).send().getTransaction().get();
    }

    /**
     * 查询交易状态
     * @param hash 交易哈希
     * @return 交易状态
     */
    public Boolean getTransByStatus(String hash) throws ExecutionException, InterruptedException {
        Web3jUtils web3jUtils = new Web3jUtils();
        Web3j web3j = web3jUtils.getWeb3j();
        TransactionReceipt txReceipt = web3j.ethGetTransactionReceipt(hash).sendAsync().get().getTransactionReceipt().get();
        return !Strings.isEmpty(txReceipt.toString());

    }

    public BaseService setgasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
        return this;
    }
}
