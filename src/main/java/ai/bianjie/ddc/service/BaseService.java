package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import lombok.extern.slf4j.Slf4j;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

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
//        ReqJsonRpcBean reqGetBlockNumberBean = new ReqJsonRpcBean();
//        reqGetBlockNumberBean.setMethod(FiscoFunctions.GetBlockByNumber);
//        ArrayList<Object> params = new ArrayList<>();
//        params.add(SignedTransactionsUtils.getGroupId());
//        params.add(blockNumber);
//        params.add(true);
//        reqGetBlockNumberBean.setParams(params);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqGetBlockNumberBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return JSONObject.parseObject(JSONObject.toJSONString(respJsonRpcBean.getResult()),BlockInfoBean.class);
        return null;
    }

    /**
     * 查询交易回执
     * @param hash 交易哈希
     * @return 交易回执
     * @throws InterruptedException InterruptedException
     */
    public String getTransReceipt(String hash) throws InterruptedException {
//        ReqJsonRpcBean reqJsonRpcBean = new ReqJsonRpcBean();
//        ArrayList<Object> params = new ArrayList<>();
//        reqJsonRpcBean.setMethod(FiscoFunctions.GetTransactionReceipt);
//        params.add(SignedTransactionsUtils.getGroupId());
//        params.add(hash);
//        reqJsonRpcBean.setParams(params);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return JSONObject.parseObject(JSONObject.toJSONString(respJsonRpcBean.getResult()),TransactionRecepitBean.class);
        return null;
    }

    /**
     * 查询交易信息
     * @param hash 交易哈希
     * @return 交易信息
     */
    public String getTransByHash(String hash) {
//        ReqJsonRpcBean reqJsonRpcBean = new ReqJsonRpcBean();
//        ArrayList<Object> params = new ArrayList<>();
//        reqJsonRpcBean.setMethod(FiscoFunctions.GetTransactionByHash);
//        params.add(SignedTransactionsUtils.getGroupId());
//        params.add(hash);
//        reqJsonRpcBean.setParams(params);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return JSONObject.parseObject(JSONObject.toJSONString(respJsonRpcBean.getResult()),TransactionInfoBean.class);
        return null;
    }

    /**
     * 查询交易状态
     * @param hash 交易哈希
     * @return 交易状态
     */
    public Boolean getTransByStatus(String hash){
        return null;
    }

    /**
     * 根据交易hash查询交易回执并解析交易回执中的output
     * @param hash 交易哈希
     * @return 解析的output结果
     * @throws InterruptedException InterruptedException
     * @throws BaseException BaseException
     * @throws TransactionException TransactionException
     */
//    public InputAndOutputResult analyzeTransactionRecepitOutput(String abi, String bin, String hash) throws InterruptedException, BaseException, TransactionException {
//        Thread.sleep(1 * 1000);
//        TransactionRecepitBean transactionRecepitBean = getTransactionRecepit(hash);
//
//        if (null == transactionRecepitBean) {
//            log.error("analyzeTransactionRecepitOutput {}",ErrorMessage.REQUEST_FAILED);
//            throw new DDCException(ErrorMessage.REQUEST_FAILED);
//        }
//
//        if (!transactionRecepitBean.getStatus().equals("0x0")) {
//            String errorMsg = new String(Hex.decode(transactionRecepitBean.getOutput().substring(2).getBytes(StandardCharsets.UTF_8)));
//            log.error("analyzeTransactionRecepitOutput {}",errorMsg);
//            throw new DDCException(ErrorMessage.REQUEST_FAILED.getCode(),errorMsg);
//        }
//
//        InputAndOutputResult inputAndOutputResult = AnalyzeChainInfoUtils.analyzeTransactionOutput(abi, bin, transactionRecepitBean.getInput(), transactionRecepitBean.getOutput());
//        if (inputAndOutputResult.getResult().size() == 0) {
//            log.error("analyzeTransactionRecepitOutput {}",ErrorMessage.REQUEST_FAILED);
//            throw new DDCException(ErrorMessage.REQUEST_FAILED);
//        }
//        return inputAndOutputResult;
//    }

    /**
     * 组装交易
     *
     * @param blockHeight 区块高度
     * @param abi 合约abi
     * @param contractAddress 合约地址
     * @param funcName 合约名称
     * @param params 合约参数
     * @return ReqJsonRpcBean
     * @throws Exception Exception
     */
//    public ReqJsonRpcBean assembleTransaction(BigInteger blockHeight, String abi, String contractAddress, String funcName, ArrayList<Object> params) throws Exception {
//        ReqTransBean reqTransBean = new ReqTransBean();
//        reqTransBean.setGroupId(1);
//        reqTransBean.setBlockNumber(blockHeight);
//        reqTransBean.setContractAbi(abi);
//        reqTransBean.setContractAddress(contractAddress);
//        reqTransBean.setFuncName(funcName);
//        reqTransBean.setFuncParam(params);
//
//        if(signEventListener == null) {
//            log.error("assembleTransaction {}",ErrorMessage.NO_SIGN_EVENT_LISTNER);
//        	throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
//        }
//
//        byte[] signedResult = SignedTransactionsUtils.buildTrans(reqTransBean, signEventListener, blockHeight);
//
//        ReqJsonRpcBean reqJsonRpcBean = new ReqJsonRpcBean();
//        reqJsonRpcBean.setMethod(FiscoFunctions.SendRawTransaction);
//        reqJsonRpcBean.setId(1);
//        reqJsonRpcBean.setJsonrpc("2.0");
//        List<Object> jsonParams = new ArrayList<>();
//        jsonParams.add(1);
//        jsonParams.add(new String(signedResult));
//        reqJsonRpcBean.setParams(jsonParams);
//
//        return reqJsonRpcBean;
//    }

//    private BigInteger getHeight(String result) {
//        try {
//            JSONObject getHeightJson = JSONObject.parseObject(result);
//
//            if (null == getHeightJson) {
//                return null;
//            }
//
//            String blockNumberHexString = getHeightJson.getString("result");
//            if (blockNumberHexString.contains("0x")) {
//                blockNumberHexString = blockNumberHexString.replace("0x", "");
//            }
//            return BigInteger.valueOf(Long.parseLong(blockNumberHexString, 16));
//        } catch (RuntimeException e) {
//            return null;
//        }
//    }

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
