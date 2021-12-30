package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.DDC1155;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.GasProvider;
import lombok.extern.slf4j.Slf4j;
//import org.fisco.bcos.web3j.tx.txdecode.InputAndOutputResult;
//import org.fisco.bcos.web3j.utils.Strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class DDC1155Service extends BaseService {

    public DDC1155Service(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
    }

    String contractAddr = ConfigCache.get().getDdc1155Address();
    protected DDC1155 ddc1155 = DDC1155.load(contractAddr, web3j, credentials, new GasProvider(ConfigCache.get().getGasPrice(),ConfigCache.get().getGasLimit()));


    /**
     * DDC的创建
     *
     * @param to     接收者账户
     * @param amount DDC数量
     * @param ddcURI DDCURI
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String mint(String to, BigInteger amount, String ddcURI) throws Exception {
        //验证account为标准address格式
//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(to)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//
//        //3.	检查需要生成的DDC数量是否大于0
//        if (null == amount || BigInteger.valueOf(0).compareTo(amount) >= 0) {
//            throw new DDCException(ErrorMessage.AMOUNT_IS_EMPOTY);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(to);
//        arrayList.add(amount);
//        arrayList.add(ddcURI);
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.Mint, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的批量创建
     *
     * @param to      接收者账户
     * @param ddcInfo DDC信息
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String mintBatch(String to, Map<BigInteger, String> ddcInfo) throws Exception {
        //验证account为标准address格式
//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(to)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        List<String> amountList = new ArrayList<>();
//        List<String> ddcURI = new ArrayList<>();
//
//        ddcInfo.forEach((key, value) -> {
//            //验证accName不为空
//            if (null == key || BigInteger.valueOf(0).compareTo(key) == 0) {
//                throw new DDCException(ErrorMessage.AMOUNT_IS_EMPOTY);
//            }
//
//            amountList.add(key.toString());
//            ddcURI.add(value);
//        });
//
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(to);
//        arrayList.add(amountList.stream().collect(Collectors.joining(",")));
//        arrayList.add(ddcURI.stream().collect(Collectors.joining(",")));
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.MintBatch, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的授权
     *
     * @param operator 授权者账户
     * @param approved 授权标识
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String setApprovalForAll(String operator, Boolean approved) throws Exception {
        //验证account为标准address格式
//        if (Strings.isEmpty(operator)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(operator)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(operator);
//        arrayList.add(approved);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.SetApprovalForAll, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的授权查询
     *
     * @param owner    拥有者账户
     * @param operator 授权者账户
     * @return 授权结果
     * @throws Exception Exception
     */
    public String isApprovedForAll(String owner, String operator) throws Exception {
        //验证account为标准address格式
//        if (Strings.isEmpty(owner)) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
//        }
//        if (Strings.isEmpty(operator)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(owner)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (!AddressUtils.isValidAddress(operator)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(owner);
//        arrayList.add(operator);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.IsApprovedForAll, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的转移
     *
     * @param from   拥有者账户
     * @param to     接收者账户
     * @param ddcId  DDCID
     * @param amount 数量
     * @param data   附加数据
     * @return 转移结果
     * @throws Exception Exception
     */
    public String safeTransferFrom(String from, String to, BigInteger ddcId, BigInteger amount, byte[] data) throws Exception {
        //验证account为标准address格式
//        if (Strings.isEmpty(from)) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
//        }
//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(from) || !AddressUtils.isValidAddress(to)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(from);
//        arrayList.add(to);
//        arrayList.add(ddcId);
//        arrayList.add(amount);
//        arrayList.add(data);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.SafeTransferFrom, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的批量转移
     *
     * @param from 拥有者账户
     * @param to   接收者账户
     * @param ddcs 拥有者DDCID集合
     * @param data 附加数据
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String safeBatchTransferFrom(String from, String to, Map<BigInteger, BigInteger> ddcs, ArrayList<byte[]> data) throws Exception {
//        if (Strings.isEmpty(from)) {
//            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
//        }
//        if (Strings.isEmpty(to)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(from) || !AddressUtils.isValidAddress(to)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcs) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<String> ddcIds = new ArrayList();
//        ArrayList<String> amounts = new ArrayList();
//
//        ddcs.forEach((key, value) -> {
//            //验证accName不为空
//            if (null == key || BigInteger.valueOf(0).compareTo(value) == 0) {
//                throw new DDCException(ErrorMessage.AMOUNT_IS_EMPOTY);
//            }
//
//            ddcIds.add(String.valueOf(key));
//            amounts.add(String.valueOf(value));
//        });
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(from);
//        arrayList.add(to);
//        arrayList.add(ddcIds.stream().collect(Collectors.joining(",")));
//        arrayList.add(amounts.stream().collect(Collectors.joining(",")));
//        arrayList.add(data.stream().map(Object::toString).collect(Collectors.joining(",")));
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.SafeBatchTransferFrom, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的冻结
     *
     * @param ddcId DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String freeze(BigInteger ddcId) throws Exception {
//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.Freeze, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的解冻
     *
     * @param ddcId DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String unFreeze(BigInteger ddcId) throws Exception {
//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.UnFreeze, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的销毁
     *
     * @param owner 拥有者账户
     * @param ddcId DDCID
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String burn(String owner, BigInteger ddcId) throws Exception {
//        if (Strings.isEmpty(owner)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(owner)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(owner);
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.Burn, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * DDC的批量销毁
     *
     * @param owner  拥有者账户
     * @param ddcIds DDCID集合
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String burnBatch(String owner, List<BigInteger> ddcIds) throws Exception {
//        if (Strings.isEmpty(owner)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(owner)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcIds) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(owner);
//        arrayList.add(ddcIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.BurnBatch, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
        return null;
    }

    /**
     * 查询当前账户拥有的DDC的数量
     *
     * @param owner 拥有者账户
     * @param ddcId DDCID
     * @return 拥有者账户所对应的DDCID所拥用的数量
     * @throws Exception
     */
    public BigInteger balanceOf(String owner, BigInteger ddcId) throws Exception {
//        if (Strings.isEmpty(owner)) {
//            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
//        }
//        if (!AddressUtils.isValidAddress(owner)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//        }
//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(owner);
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.BalanceOf, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc1155ABI(), ConfigCache.get().getDdc1155BIN(), respJsonRpcBean.getResult().toString());
//        return new BigInteger(inputAndOutputResult.getResult().get(0).getData().toString());
        return null;
    }

    /**
     * 批量查询账户拥有的DDC的数量
     *
     * @param ddcs 拥有者DDCID集合
     * @return 拥有者账户所对应的每个DDCID所拥用的数量
     * @throws Exception
     */
    public List<BigInteger> balanceOfBatch(Map<String, BigInteger> ddcs) throws Exception {
//        if (null == ddcs || ddcs.size() == 0) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//
//        ArrayList<Object> params = new ArrayList<>();
//
//        ArrayList<String> owners = new ArrayList<>();
//        ArrayList<String> ddcIds = new ArrayList<>();
//
//        ddcs.forEach((key, value) -> {
//            owners.add(key);
//            ddcIds.add(String.valueOf(value));
//        });
//        params.add(owners.stream().collect(Collectors.joining(",")));
//        params.add(ddcIds.stream().collect(Collectors.joining(",")));
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.BalanceOfBatch, params);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc1155ABI(), ConfigCache.get().getDdc1155BIN(), respJsonRpcBean.getResult().toString());
//        ArrayList<BigInteger> result = new ArrayList<>();
//        ArrayList<BigInteger> datas = (ArrayList<BigInteger>) inputAndOutputResult.getResult().get(0).getData();
//        datas.forEach(it -> {
//            result.add(new BigInteger(it.toString()));
//        });
//        return result;
        return null;
    }

    /**
     * 获取ddcURI
     *
     * @param ddcId ddcId
     * @return DDCURI
     * @throws Exception Exception
     */
    public String ddcURI(BigInteger ddcId) throws Exception {
//        if (null == ddcId) {
//            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(ddcId);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleDDC1155Transaction(DDC1155Functions.DDCURI, arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(), reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//
//        InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getDdc1155ABI(), ConfigCache.get().getDdc1155BIN(), respJsonRpcBean.getResult().toString());
//        return inputAndOutputResult.getResult().get(0).getData().toString();
//    }
//
//    private ReqJsonRpcBean assembleDDC1155Transaction(String functionName, ArrayList<Object> params) throws Exception {
//        return assembleTransaction(getBlockNumber(), ConfigCache.get().getDdc1155ABI(), ConfigCache.get().getDdc1155Address(), functionName, params);
        return null;
    }


}