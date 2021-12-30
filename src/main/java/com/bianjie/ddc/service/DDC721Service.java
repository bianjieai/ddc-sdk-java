package com.bianjie.ddc.service;

import com.bianjie.ddc.config.ConfigCache;
import com.bianjie.ddc.contract.DDC721;
import com.bianjie.ddc.listener.SignEventListener;
import com.bianjie.ddc.util.GasProvider;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;


public class DDC721Service extends BaseService {

    //唯一构造方法，传入监听者创建对象
	public DDC721Service(SignEventListener signEventListener) {
		super.signEventListener = signEventListener;
	}

    String contractAddr = ConfigCache.get().getDdc721Address();
    protected DDC721 con = DDC721.load(contractAddr, web, credentials, new GasProvider(ConfigCache.get().getGasPrice(),ConfigCache.get().getGasLimit()));

    /**
     * 创建DDC
     * @param to     接收者账户
     * @param ddcURI DDC资源标识符
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String mint(String to, String ddcURI) throws Exception {

//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (Strings.isEmpty(ddcURI)) {
//            throw new DDCException(ErrorMessage.DDCURI_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }

        //发请求

        TransactionReceipt res =  con.mint(to, ddcURI).send();
        resultCheck(res);
        return res.toString();
    }


    /**
     * 授权DDC
     * @param to    授权者账户
     * @param ddcId DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String approve(String to, BigInteger ddcId) throws Exception {

//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        if (!AddressUtils.isValidAddress(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }

//        con.approve();
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }


    /**
     * 授权查询
     * @param ddcId DDC唯一标识
     * @return 授权的账户
     * @throws Exception Exception
     */
    public String getApproved(BigInteger ddcId) throws Exception {

//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        if(ddcId.compareTo(new BigInteger("0")) <= 0) {
//        	throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.GET_APPROVED, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return inputAndOutputResult.getResult().get(0).getData().toString();
        return null;
    }

    /**
     * 授权DDC
     * @param operator 授权者账户
     * @param approved 授权标识
     * @return 交易hash
     * @throws Exception
     */
    public String setApprovalForAll(String operator, Boolean approved) throws Exception {

//        if (Strings.isEmpty(operator)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(operator)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == approved) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(operator);
//        arrayList.add(approved);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.SET_APPROVAL_FOR_ALL, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }


    /**
     * DDC授权查询
     *
     * @param owner 拥有者账户
     * @param operator 授权者账户
     * @return 授权标识
     * @throws Exception Exception
     */
    public Boolean isApprovedForAll(String owner, String operator) throws Exception {

//        if (Strings.isEmpty(owner) || Strings.isEmpty(operator)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(owner) || !AddressUtils.isValidAddress(operator)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(owner);
//        arrayList.add(operator);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.IS_APPROVED_FOR_ALL, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return Boolean.valueOf(inputAndOutputResult.getResult().get(0).getData().toString());
        return null;
    }


    /**
     * DDC的转移
     *
     * @param from  拥有者账户
     * @param to    授权者账户
     * @param ddcId DDC唯一标识
     * @param data  附加数据
     * @return 交易hash
     * @throws Exception Exception
     */
    public String safeTransferFrom(String from, String to, BigInteger ddcId, byte[] data) throws Exception {

//        if (Strings.isEmpty(from)) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
//        }
//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(from) ) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (!AddressUtils.isValidAddress(to) ) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(from);
//        arrayList.add(to);
//        arrayList.add(ddcId);
//        arrayList.add(data);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.SAFE_TRANSFER_FROM, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }


    /**
     * 转移
     *
     * @param from  拥有者账户
     * @param to    接收者账户
     * @param ddcId ddc唯一标识
     * @return 交易hash
     * @throws Exception Exception
     */
    public String transferFrom(String from, String to, BigInteger ddcId) throws Exception {

//        if (Strings.isEmpty(from)) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
//        }
//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(from) ) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (!AddressUtils.isValidAddress(to) ) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(from);
//        arrayList.add(to);
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.TRANSFER_FROM, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }


    /**
     * 冻结
     *
     * @param ddcId DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     */
    public String freeze(BigInteger ddcId) throws Exception {

//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.FREEZE, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * 解冻
     *
     * @param ddcId DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     */
    public String unFreeze(BigInteger ddcId) throws Exception {

//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.UNFREEZE, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * 销毁
     *
     * @param ddcId DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     */
    public String burn(BigInteger ddcId) throws Exception {

//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.BURN, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * 查询数量
     *
     * @param owner 拥有者账户
     * @return ddc的数量
     * @throws Exception Exception
     */
    public BigInteger balanceOf(String owner) throws Exception {

//        if (Strings.isEmpty(owner)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(owner)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(owner);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.BALANCE_OF, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return new BigInteger(inputAndOutputResult.getResult().get(0).getData().toString());
        return null;
    }

    /**
     * 查询拥有者
     *
     * @param ddcId ddc唯一标识
     * @return 拥有者账户
     * @throws Exception Exception
     */
    public String ownerOf(BigInteger ddcId) throws Exception {

//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.OWNER_OF, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return inputAndOutputResult.getResult().get(0).getData().toString();
        return null;
    }

    /**
     * DDC运营方名称
     *
     * @return DDC运营方名称
     * @throws Exception Exception
     */
    public String name() throws Exception {

//        ArrayList<Object> arrayList = new ArrayList<>();
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.NAME, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return inputAndOutputResult.getResult().get(0).getData().toString();
        return null;
    }

    /**
     * 获取DDC运营方符号
     *
     * @return DDC运营方符号
     * @throws Exception Exception
     */
    public String symbol() throws Exception {

//        ArrayList<Object> arrayList = new ArrayList<>();
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.SYMBOL, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return inputAndOutputResult.getResult().get(0).getData().toString();
        return null;
    }

    /**
     * 获取DDCURI
     *
     * @return DDC资源标识符
     * @throws Exception Exception
     */
    public String ddcURI(BigInteger ddcId) throws Exception {
//        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC721Transaction(DDC721Functions.DDC_URI, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721BIN(), respJsonRpcBean.getResult().toString());
//        return inputAndOutputResult.getResult().get(0).getData().toString();
        return null;
    }

//    private ReqJsonRpcBean assembleDDC721Transaction(String functionName, ArrayList<Object> params) throws Exception {
//        return assembleTransaction(getBlockNumber(), ConfigCache.get().getDdc721ABI(), ConfigCache.get().getDdc721Address(), functionName, params);
//    }
}
