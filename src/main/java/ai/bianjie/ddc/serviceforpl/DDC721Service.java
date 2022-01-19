package ai.bianjie.ddc.serviceforpl;

import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.service.BaseService;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.utils.Strings;

import java.math.BigInteger;


public class DDC721Service extends BaseService {
    private DDC721 ddc721;
    private String encodedFunction;

    //注册签名事件
    public DDC721Service(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
        //获取合约实体
        this.ddc721 = Web3jUtils.getDDC721();
    }

    /**
     * 生成DDC
     * 平台方或终端用户可以通过调用该方法进行DDC的生成
     *
     * @param sender 调用者地址
     * @param to     接收者账户
     * @param ddcURI DDC资源标识符
     * @return hash  交易哈希
     * @throws Exception Exception
     */
    public String mint(String sender, String to, String ddcURI) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
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

        //4.获取序列化编码好的方法
        encodedFunction = ddc721.mint(to, ddcURI).encodeFunctionCall();

        //5.签名并发送，获取hash
        return signAndSend(ddc721, DDC721.FUNC_MINT, encodedFunction, signEventListener, sender).getTransactionHash();

    }

    /**
     * 安全生成
     * 平台方或终端用户可以通过调用该方法进行DDC的安全生成
     *
     * @param sender 调用者地址
     * @param to     接收者账户
     * @param ddcURI DDC资源标识符
     * @return hash  交易哈希
     * @throws Exception Exception
     */
    public String safeMint(String sender, String to, String ddcURI, byte[] data) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
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

        //4.获取序列化编码好的方法
        encodedFunction = ddc721.safeMint(to, ddcURI, data).encodeFunctionCall();

        //5.签名并发送，获取hash
        return signAndSend(ddc721, DDC721.FUNC_SAFEMINT, encodedFunction, signEventListener, sender).getTransactionHash();

    }

    /**
     * DDC授权
     * DDC拥有者可以通过调用该方法进行DDC的授权，发起者需要是DDC的拥有者
     *
     * @param sender 调用者地址
     * @param to     授权者账户
     * @param ddcId  DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String approve(String sender, String to, BigInteger ddcId) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }

        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        encodedFunction = ddc721.approve(to, ddcId).encodeFunctionCall();

        return signAndSend(ddc721, DDC721.FUNC_APPROVE, encodedFunction, signEventListener, sender).getTransactionHash();
    }


    /**
     * DDC授权查询
     * 运营方、平台方和终端用户都可以通过调用该方法查询DDC的授权情况
     *
     * @param ddcId DDC唯一标识
     * @return 授权的账户
     * @throws Exception Exception
     */
    public String getApproved(BigInteger ddcId) throws Exception {

        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        return Web3jUtils.getDDC721().getApproved(ddcId).send();
    }

    /**
     * 账户授权
     * DDC拥有者可以通过调用该方法进行账户授权，发起者需要是DDC的拥有者。
     *
     * @param sender   调用者地址
     * @param operator 授权者账户
     * @param approved 授权标识
     * @return 交易hash
     * @throws Exception
     * @desc DDC拥有者通过该方法授权给指定用户
     */
    public String setApprovalForAll(String sender, String operator, Boolean approved) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (Strings.isEmpty(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        encodedFunction = ddc721.setApprovalForAll(operator, approved).encodeFunctionCall();

        return signAndSend(ddc721, DDC721.FUNC_SETAPPROVALFORALL, encodedFunction, signEventListener, sender).getTransactionHash();
    }


    /**
     * 账户授权查询
     * 运营方、平台方或终端用户可以通过调用该方法进行账户授权查询。
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

        return Web3jUtils.getDDC721().isApprovedForAll(owner, operator).send();
    }


    /**
     * DDC的安全转移
     * DDC的拥有者或授权者可以通过调用该方法进行DDC的转移。
     *
     * @param sender 调用者地址
     * @param from   拥有者账户
     * @param to     授权者账户
     * @param ddcId  DDC唯一标识
     * @param data   附加数据
     * @return 交易hash
     * @throws Exception Exception
     * @desc DDC的拥有者或授权者可以通过调用该方法进行DDC的安全转移。
     */
    public String safeTransferFrom(String sender, String from, String to, BigInteger ddcId, byte[] data) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

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
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        encodedFunction = ddc721.safeTransferFrom(from, to, ddcId, data).encodeFunctionCall();

        return signAndSend(ddc721, DDC721.FUNC_SAFETRANSFERFROM, encodedFunction, signEventListener, sender).getTransactionHash();
    }


    /**
     * 转移
     * DDC拥有者或授权者可以通过调用该方法进行DDC的转移。
     *
     * @param sender 调用者地址
     * @param from   拥有者账户
     * @param to     接收者账户
     * @param ddcId  ddc唯一标识
     * @return 交易hash
     * @throws Exception Exception
     * @desc DDC拥有者或授权者可以通过调用该方法进行DDC的转移。
     */
    public String transferFrom(String sender, String from, String to, BigInteger ddcId) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

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
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        encodedFunction = ddc721.transferFrom(from, to, ddcId).encodeFunctionCall();

        return signAndSend(ddc721, DDC721.FUNC_TRANSFERFROM, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * 销毁
     * DDC拥有者或DDC授权者可以通过调用该方法进行DDC的销毁。
     *
     * @param sender 调用者地址
     * @param ddcId  DDC唯一标识
     * @return 交易hash
     * @throws Exception Exception
     */
    public String burn(String sender, BigInteger ddcId) throws Exception {
        if (!AddressUtils.isValidAddress(sender)) {
            throw new DDCException(ErrorMessage.SENDER_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        encodedFunction = ddc721.burn(ddcId).encodeFunctionCall();
        return signAndSend(ddc721, DDC721.FUNC_BURN, encodedFunction, signEventListener, sender).getTransactionHash();
    }

    /**
     * 查询数量
     * 运营方、平台方以及终端用户可以通过调用该方法进行查询当前账户拥有的DDC的数量。
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

        return Web3jUtils.getDDC721().balanceOf(owner).send();
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

        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        return Web3jUtils.getDDC721().ownerOf(ddcId).send();
    }

    /**
     * 获取名称
     *
     * @return DDC运营方名称
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC的名称。
     */
    public String name() throws Exception {

        return Web3jUtils.getDDC721().name().send();
    }

    /**
     * 获取符号
     *
     * @return DDC运营方符号
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC的符号标识。
     */
    public String symbol() throws Exception {

        return Web3jUtils.getDDC721().symbol().send();
    }

    /**
     * 获取DDCURI
     *
     * @param ddcId ddc唯一标识符
     * @return DDC资源标识符
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法查询当前DDC的资源标识符。
     */
    public String ddcURI(BigInteger ddcId) throws Exception {

        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        return Web3jUtils.getDDC721().ddcURI(ddcId).send();
    }

}