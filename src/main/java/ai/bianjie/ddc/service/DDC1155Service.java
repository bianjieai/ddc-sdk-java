package ai.bianjie.ddc.service;

import ai.bianjie.ddc.constant.DDC1155Functions;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.contract.DDC1155;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.web3j.utils.Strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DDC1155Service extends BaseService {
    private DDC1155 ddc1155;
    private String encodedFunction;

    public DDC1155Service(SignEventListener signEventListener) {
        super.signEventListener = signEventListener;
        this.ddc1155=Web3jUtils.getDDC1155();
    }

    /**
     * 创建DDC
     *
     * @param to     接收者账户
     * @param amount DDC数量
     * @param ddcURI DDCURI
     * @return 交易哈希
     * @throws Exception Exception
     * @desc 平台方或终端用户可以通过调用该方法进行DDC的批量创建。
     */
    public String mint(String to, BigInteger amount, String ddcURI) throws Exception {
        //1.检查接收者账户地址是否为空
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        //2.检查接收者账户地址是否正确
        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        //3.检查需要生成的DDC数量是否大于0
        if (amount == null || amount.intValue() <= 0) {
            throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
        }
        //4.检查DDCURI是否为空
        if (Strings.isEmpty(ddcURI)) {
            throw new DDCException(ErrorMessage.DDCURI_IS_EMPTY);
        }

        encodedFunction=ddc1155.mint(to, amount, ddcURI).encodeFunctionCall();

        return signAndSend(ddc1155, DDC1155Functions.Mint,encodedFunction,signEventListener).getTransactionHash();
    }

    /**
     * 批量DDC的创建
     *
     * @param to      接收者账户
     * @param ddcInfo DDC信息
     * @return 交易哈希
     * @throws Exception Exception
     * @desc 平台方或终端用户可以通过调用该方法进行批量DDC的创建。
     */
    public String mintBatch(String to, Multimap<BigInteger, String> ddcInfo) throws Exception {
        //1.检查接收者账户地址信息是否为空；
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        //2.检查接收者账户地址格式是否正确；
        if (!AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        List<BigInteger> amounts = new ArrayList<>();
        List<String> ddcURIS = new ArrayList<>();

        ddcInfo.forEach((amount, URI) -> {
            //4.检查生成的DDC数量集合中每个DDC数量是否大于0；
            if (amount == null || amount.intValue() <= 0) {
                throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
            }
            //5.检查生成的DDCURI集合中每个DDCURI是否为空；
            if (Strings.isEmpty(URI)) {
                throw new DDCException(ErrorMessage.DDCURI_IS_EMPTY);
            }
            amounts.add(amount);
            ddcURIS.add(URI);

        });

        encodedFunction=ddc1155.mintBatch(to,amounts,ddcURIS).encodeFunctionCall();

        return signAndSend(ddc1155,DDC1155Functions.MintBatch,encodedFunction,signEventListener).getTransactionHash();

    }

    /**
     * DDC的授权
     *
     * @param operator 授权者账户
     * @param approved 授权标识
     * @return 交易哈希
     * @throws Exception Exception
     * @desc DDC拥有者可以通过调用该方法进行账户授权，发起者需要是DDC的拥有者。
     */
    public String setApprovalForAll(String operator, Boolean approved) throws Exception {
        if (Strings.isEmpty(operator)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }


        return Web3jUtils.getDDC1155().setApprovalForAll(operator, approved).send().getTransactionHash();
    }

    /**
     * DDC的授权查询
     *
     * @param owner    拥有者账户
     * @param operator 授权者账户
     * @return 授权结果（boolean）
     * @throws Exception Exception
     * @desc 运营方、平台方或终端用户可以通过调用该方法进行账户授权查询。
     */
    public Boolean isApprovedForAll(String owner, String operator) throws Exception {
        if (Strings.isEmpty(owner)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
        }
        if (Strings.isEmpty(operator)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(owner)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (!AddressUtils.isValidAddress(operator)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }

        return Web3jUtils.getDDC1155().isApprovedForAll(owner, operator).send();

    }

    /**
     * DDC的安全转移
     *
     * @param from   拥有者账户
     * @param to     接收者账户
     * @param ddcId  DDCID
     * @param amount 需要转移的DDC数量
     * @param data   附加数据
     * @return 交易哈希
     * @throws Exception Exception
     */
    public String safeTransferFrom(String from, String to, BigInteger ddcId, BigInteger amount, byte[] data) throws Exception {
        if (Strings.isEmpty(from)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
        }
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(from) || !AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }
        if (amount == null || amount.intValue() <= 0) {
            throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
        }

        return Web3jUtils.getDDC1155().safeTransferFrom(from, to, ddcId, amount, data).send().getTransactionHash();

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
     * @desc DDC拥有者或DDC授权者可以通过调用该方法进行DDC的批量转移。
     */
    public String safeBatchTransferFrom(String from, String to, Multimap<BigInteger, BigInteger> ddcs, byte[] data) throws Exception {
        if (Strings.isEmpty(from)) {
            throw new DDCException(ErrorMessage.FROM_ACCOUNT_IS_EMPTY);
        }
        if (Strings.isEmpty(to)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(from) || !AddressUtils.isValidAddress(to)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (ddcs == null) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }


        ArrayList<BigInteger> ddcIds = new ArrayList();
        ArrayList<BigInteger> amounts = new ArrayList();
        ddcs.forEach((ddcId, amount) -> {
            if (ddcId == null || ddcId.intValue() <= 0) {
                throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
            }
            if (amount == null || amount.intValue() <= 0) {
                throw new DDCException(ErrorMessage.AMOUNT_IS_EMPTY);
            }
            ddcIds.add(ddcId);
            amounts.add(amount);
        });

        return Web3jUtils.getDDC1155().safeBatchTransferFrom(from, to, ddcIds, amounts, data).send().getTransactionHash();
    }

    /**
     * DDC的冻结
     *
     * @param ddcId DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     * @desc 运营方可以通过调用该方法进行DDC的冻结。
     */
    public String freeze(BigInteger ddcId) throws Exception {
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        return Web3jUtils.getDDC1155().freeze(ddcId).send().getTransactionHash();
    }

    /**
     * DDC的解冻
     *
     * @param ddcId DDC唯一标识
     * @return 交易哈希
     * @throws Exception Exception
     * @desc 运营方可以通过调用该方法进行DDC的解冻。
     */
    public String unFreeze(BigInteger ddcId) throws Exception {
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        return Web3jUtils.getDDC1155().unFreeze(ddcId).send().getTransactionHash();
    }

    /**
     * DDC的销毁
     *
     * @param owner 拥有者账户
     * @param ddcId DDCID
     * @return 交易哈希
     * @throws Exception Exception
     * @desc DDC拥有者或DDC授权者可以通过调用该方法进行DDC的销毁。
     */
    public String burn(String owner, BigInteger ddcId) throws Exception {
        if (Strings.isEmpty(owner)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(owner)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        return Web3jUtils.getDDC1155().burn(owner, ddcId).send().getTransactionHash();
    }

    /**
     * DDC的批量销毁
     *
     * @param owner  拥有者账户
     * @param ddcIds DDCID集合
     * @return 交易哈希
     * @throws Exception Exception
     * @desc DDC拥用者或DDC授权者可以通过调用该方法进行DDC的批量销毁。
     */
    public String burnBatch(String owner, List<BigInteger> ddcIds) throws Exception {
        if (Strings.isEmpty(owner)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(owner)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if (ddcIds == null) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }




        return Web3jUtils.getDDC1155().burnBatch(owner, ddcIds).send().getTransactionHash();
    }

    /**
     * 查询当前账户拥有的DDC的数量
     *
     * @param owner 拥有者账户
     * @param ddcId DDCID
     * @return 拥有者账户所对应的DDCID所拥用的数量
     * @throws Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法进行查询当前账户拥有的DDC的数量。
     */
    public BigInteger balanceOf(String owner, BigInteger ddcId) throws Exception {
        if (Strings.isEmpty(owner)) {
            throw new DDCException(ErrorMessage.TO_ACCOUNT_IS_EMPTY);
        }
        if (!AddressUtils.isValidAddress(owner)) {
            throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
        }
        if(ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        return Web3jUtils.getDDC1155().balanceOf(owner, ddcId).send();
    }

    /**
     * 批量查询账户拥有的DDC的数量
     *
     * @param ddcs 拥有者DDCID集合
     * @return 拥有者账户所对应的每个DDCID所拥用的数量
     * @throws Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法进行批量查询账户拥有的DDC的数量。
     */
    public List<BigInteger> balanceOfBatch(Multimap<String, BigInteger> ddcs) throws Exception {
        if (ddcs == null || ddcs.size() == 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        ArrayList<String> owners = new ArrayList<>();
        ArrayList<BigInteger> ddcIds = new ArrayList<>();
        ddcs.forEach((owner,ddcId)->{
            if (Strings.isEmpty(owner)) {
                throw new DDCException(ErrorMessage.ACC_ADDR_IS_EMPTY);
            }
            if (!AddressUtils.isValidAddress(owner)) {
                throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
            }
            if(ddcId==null||ddcId.intValue()<=0){
                throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
            }
            owners.add(owner);
            ddcIds.add(ddcId);
        });




        ddcs.forEach((owner,ddcId)->{
            if (Strings.isEmpty(owner)) {
                throw new DDCException(ErrorMessage.ACC_ADDR_IS_EMPTY);
            }
            if (!AddressUtils.isValidAddress(owner)) {
                throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
            }
            if(ddcId==null||ddcId.intValue()<=0){
                throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
            }
            owners.add(owner);
            ddcIds.add(ddcId);
        });


        return Web3jUtils.getDDC1155().balanceOfBatch(owners, ddcIds).send();
    }

    /**
     * 获取ddcURI
     *
     * @param ddcId ddcId
     * @return DDCURI
     * @throws Exception Exception
     * @desc 运营方、平台方以及终端用户可以通过调用该方法进行查询当前DDC的资源标识符。
     */
    public String ddcURI(BigInteger ddcId) throws Exception {
        if (ddcId == null || ddcId.intValue() <= 0) {
            throw new DDCException(ErrorMessage.DDCID_IS_WRONG);
        }

        return Web3jUtils.getDDC1155().ddcURI(ddcId).send();
    }


}
