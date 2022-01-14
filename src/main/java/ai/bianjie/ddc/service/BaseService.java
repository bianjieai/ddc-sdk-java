package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.CommonUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import lombok.extern.slf4j.Slf4j;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.tx.Contract;
import org.web3j.utils.Strings;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@Slf4j
public class BaseService {

    protected SignEventListener signEventListener;
    private String gasLimit = ConfigCache.get().getGasLimit();

    /**
     * 获取区块信息
     *
     * @return 区块信息
     */
    public EthBlock.Block getBlockByNumber(String blockNumber) throws IOException {
        return Web3jUtils.getWeb3j().ethGetBlockByNumber(CommonUtils.getDefaultBlockParamter(blockNumber), true).send().getBlock();
    }

    /**
     * 查询交易回执
     *
     * @param hash 交易哈希
     * @return 交易回执
     * @throws InterruptedException InterruptedException
     */
    public TransactionReceipt getTransReceipt(String hash) throws InterruptedException, ExecutionException {
        TransactionReceipt txReceipt = Web3jUtils.getWeb3j().ethGetTransactionReceipt(hash).sendAsync().get().getTransactionReceipt().get();
        return txReceipt;
    }

    /**
     * 查询交易信息
     *
     * @param hash 交易哈希
     * @return 交易信息
     */
    public Transaction getTransByHash(String hash) throws IOException {
        return Web3jUtils.getWeb3j().ethGetTransactionByHash(hash).send().getTransaction().get();
    }

    /**
     * 查询交易状态
     *
     * @param hash 交易哈希
     * @return 交易状态
     */
    public Boolean getTransByStatus(String hash) throws ExecutionException, InterruptedException {
        TransactionReceipt txReceipt = Web3jUtils.getWeb3j().ethGetTransactionReceipt(hash).sendAsync().get().getTransactionReceipt().get();
        return !Strings.isEmpty(txReceipt.toString());
    }

    public BaseService setgasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
        return this;
    }

    /**
     * 签名并发送
     *
     * @param contract          合约实例
     * @param functionName      调用的方法名
     * @param encodedFunction   经过RLP序列化编码的function
     * @param signEventListener 负责签名的实例
     * @return EthSendTransaction 交易的结果
     */
    public EthSendTransaction signAndSend(Contract contract, String functionName, String encodedFunction, SignEventListener signEventListener) throws Exception {

        Web3j web3j = Web3jUtils.getWeb3j();

        BigInteger gasPrice = new BigInteger("100000000");
        //这个参数后续可以改为根据方法名获取不同的limit
        BigInteger gasLimit = new BigInteger("300000");

        //后续改为用户init时传入：调用者的账户地址
        String callerAddr = "0x918F7F275A6C2D158E5B76F769D3F1678958A334";
        String contractAddr = contract.getContractAddress();//目标合约地址


        //2. 获取调用者的交易笔数
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(callerAddr, DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = ethGetTransactionCount.getTransactionCount();

        //3. 生成待签名的交易
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, contractAddr, encodedFunction);

        //4. 调用签名方法，获取签名后的hexString
        String hexString_signedMessage = signEventListener.signEvent(rawTransaction);

        //5. 返回交易结果
        return web3j.ethSendRawTransaction(hexString_signedMessage).sendAsync().get();

    }


}
