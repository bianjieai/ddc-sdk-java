package ai.bianjie.ddc.service;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.GasProvider;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Strings;

import java.math.BigInteger;


public class DDC721Service extends BaseService {

    //注册签名事件
    public DDC721Service(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
    }

    /**
     * 创建DDC
     *
     * @param to     接收者账户
     * @param ddcURI DDC资源标识符
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String mint(String to, String ddcURI) throws Exception {
        //1.检查接收者账户地址是否为空
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        //2.检查接收者账户地址是否正确
        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        //3.检查DDCURI是否为空
        if (Strings.isEmpty(ddcURI)) {
            throw new DDCException(ErrorMessage.DDCURI_IS_EMPTY);
        }
        //4.检查签名事件是否被注册
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }

        DDC721 ddc721 = Web3jUtils.getDDC721();

        //调用合约上的对应方法
        TransactionReceipt transactionReceipt = ddc721.mint(to, ddcURI).send();

        resultCheck(transactionReceipt);

        return transactionReceipt.getTransactionHash();
    }


    /**
     * 授权DDC
     *
     * @param to    授权者账户
     * @param ddcId DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String approve(String to, BigInteger ddcId) throws Exception {

        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (ddcId == null || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }

        DDC721 ddc721 = Web3jUtils.getDDC721();

        TransactionReceipt transactionReceipt = ddc721.approve(to, ddcId).send();
        resultCheck(transactionReceipt);

        return transactionReceipt.getTransactionHash();
    }


    /**
     * 授权查询：
     * 运营方、平台方和终端用户都可以通过调用该方法查询DDC的授权情况
     *
     * @param ddcId DDC唯一标识
     * @return 授权的账户
     * @throws Exception Exception
     */
    public String getApproved(BigInteger ddcId) throws Exception {


        if (ddcId == null || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }

        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.getApproved(ddcId).send();
    }

    /**
     * 授权DDC
     *
     * @param operator 授权者账户
     * @param approved 授权标识
     * @return 交易hash
     * @throws Exception
     * @desc DDC拥有者通过该方法授权给指定用户
     */
    public String setApprovalForAll(String operator, Boolean approved) throws Exception {

        if (Strings.isEmpty(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.setApprovalForAll(operator, approved).send().getTransactionHash();
    }


    /**
     * DDC授权查询
     *
     * @param owner    拥有者账户
     * @param operator 授权者账户
     * @return 授权标识
     * @throws Exception Exception
     */
    public Boolean isApprovedForAll(String owner, String operator) throws Exception {

        if (Strings.isEmpty(owner) || Strings.isEmpty(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(owner) || !AddressUtils.isValidAddress(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        /*代做：根据hash返回结果（bool）*/
        return ddc721.isApprovedForAll(owner, operator).send();
    }


    /**
     * DDC的安全转移
     *
     * @param from  拥有者账户
     * @param to    授权者账户
     * @param ddcId DDC唯一标识
     * @param data  附加数据
     * @return 交易hash
     * @throws Exception Exception
     * @desc DDC的拥有者或授权者可以通过调用该方法进行DDC的安全转移。
     */
    public String safeTransferFrom(String from, String to, BigInteger ddcId, byte[] data) throws Exception {

        if (Strings.isEmpty(from)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
        }
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(from)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (ddcId == null || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();


        return ddc721.safeTransferFrom(from, to, ddcId, data).send().getTransactionHash();
    }


    /**
     * 转移
     *
     * @param from  拥有者账户
     * @param to    接收者账户
     * @param ddcId ddc唯一标识
     * @return 交易hash
     * @throws Exception Exception
     * @desc DDC拥有者或授权者可以通过调用该方法进行DDC的转移。
     */
    public String transferFrom(String from, String to, BigInteger ddcId) throws Exception {

        if (Strings.isEmpty(from)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
        }
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(from)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (ddcId == null || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.transferFrom(from, to, ddcId).send().getTransactionHash();
    }


    /**
     * 冻结
     *
     * @param ddcId DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     * @desc 运营方可以通过调用该方法进行DDC的冻结。
     */
    public String freeze(BigInteger ddcId) throws Exception {

        if (ddcId == null || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.freeze(ddcId).send().getTransactionHash();
    }

    /**
     * 解冻
     *
     * @param ddcId DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     * @desc 运营方可以通过调用该方法进行DDC的解冻。
     */
    public String unFreeze(BigInteger ddcId) throws Exception {

        if (ddcId == null || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.unFreeze(ddcId).send().getTransactionHash();
    }

    /**
     * 销毁
     *
     * @param ddcId DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     */
    public String burn(BigInteger ddcId) throws Exception {

        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.burn(ddcId).send().getTransactionHash();
    }

    /**
     * 查询数量
     *
     * @param owner 拥有者账户
     * @return ddc的数量
     * @throws Exception Exception
     */
    public BigInteger balanceOf(String owner) throws Exception {

        if (Strings.isEmpty(owner)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(owner)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.balanceOf(owner).send();
    }

    /**
     * 查询拥有者
     *
     * @param ddcId ddc唯一标识
     * @return 拥有者账户
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC的拥有者。
     */
    public String ownerOf(BigInteger ddcId) throws Exception {

        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.ownerOf(ddcId).send();
    }

    /**
     * DDC运营方名称
     *
     * @return DDC运营方名称
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC运营方的名称。
     */
    public String name() throws Exception {
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.name().send();
    }

    /**
     * 获取DDC运营方符号
     *
     * @return DDC运营方符号
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC的符号标识。
     */
    public String symbol() throws Exception {
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.symbol().send();
    }

    /**
     * 获取DDCURI
     *
     * @return DDC资源标识符
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC的资源标识符。
     */
    public String ddcURI(BigInteger ddcId) throws Exception {
        if (null == ddcId || ddcId.compareTo(new BigInteger("0")) <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (this.signEventListener == null) {
            throw new DDCException(ErrorMessage.SIG_IS_EMPTY);
        }
        DDC721 ddc721 = Web3jUtils.getDDC721();

        return ddc721.ddcURI(ddcId).send();
    }

}
