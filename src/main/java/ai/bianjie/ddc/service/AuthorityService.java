package ai.bianjie.ddc.service;

import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.contract.AuthorityLogic;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.util.AddressUtils;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.utils.Strings;

import java.math.BigInteger;


public class AuthorityService extends BaseService {

	//只有一个构造方法，需要传入签名事件监听者来创建对象
    public AuthorityService(SignEventListener signEventListener) {
		super.signEventListener = signEventListener;
	}

	public TransactionReceipt addOperator(String operator, String accountName, String accountDID) throws Exception {
		Web3jUtils web3jUtils = new Web3jUtils();
		AuthorityLogic authorityLogic = web3jUtils.getAuthority();
		TransactionReceipt res = authorityLogic.addOperator(operator,accountName,accountDID).send();
		return res;
	}

	/**
     * 运营方或平台方通过调用该方法进行DDC账户信息的创建，上级角色可进行下级角色账户的操作，如运营方可以为平台方添加账户、平台方可以为终端用户添加账户，但运营方不能直接为终端用户添加账户。
     * 
     * @param account DDC链账户地址
     * @param accName DDC账户对应的账户名称
     * @param accDID DDC账户对应的DID信息（普通用户可为空）
     * @return  返回交易哈希
     * @throws Exception
     */
	public String addAccount(String account, String accName, String accDID) throws Exception {
    	if(Strings.isEmpty(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
    	}

    	if(!AddressUtils.isValidAddress(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
    	}

        if (Strings.isEmpty(accName)) {
            throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
        }
		Web3jUtils web3jUtils = new Web3jUtils();
		AuthorityLogic authorityLogic = web3jUtils.getAuthority();
		TransactionReceipt res = authorityLogic.addAccount(account, accName, accDID).send();
		return res.toString();
    }
    
	
	/**
	 * 运营方通过调用该方法可以直接对平台方的终端用户进行创建。
	 * 
	 * @param account DDC链账户地址
	 * @param accName  DDC账户对应的账户名称
	 * @param accDID  DDC账户对应的DID信息
	 * @param leaderDID 该普通账户对应的上级账户的DID
	 * @return 返回交易哈希
	 * @throws Exception
	 */
    public String addConsumerByOperator(String account, String accName, String accDID, String leaderDID) throws Exception {
    	if(Strings.isEmpty(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
    	}

    	if(!AddressUtils.isValidAddress(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
    	}

    	if(Strings.isEmpty(accName)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
    	}

    	if(Strings.isEmpty(leaderDID)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_LEADER_DID_IS_EMPTY);
    	};
		Web3jUtils web3jUtils = new Web3jUtils();
		AuthorityLogic authorityLogic = web3jUtils.getAuthority();
		TransactionReceipt res = authorityLogic.addConsumerByOperator(account,accName,accDID,leaderDID).send();
		return res.toString();
    }
    
    /**
     * 删除账户
     * 
     * @param account DDC链账户地址
     * @return 返回交易哈希
     * @throws Exception
     */
    public String delAccount(String account) throws Exception {
    	if(Strings.isEmpty(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
    	}

		return null;
    }
    
    /**
     *  运营方或平台方通过该方法进行DDC账户信息的查询，上级角色可进行下级角色账户的操作。
     * 
     * @param account DDC用户链账户地址
     * @return 返回DDC账户信息
     * @throws Exception
     */
    public String getAccount(String account) throws Exception {
    	if(Strings.isEmpty(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
    	}

    	if(!AddressUtils.isValidAddress(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
    	}
		Web3jUtils web3jUtils = new Web3jUtils();
		AuthorityLogic authorityLogic = web3jUtils.getAuthority();
		Tuple7<String, String, BigInteger, String, BigInteger, BigInteger, String> res = authorityLogic.getAccount(account).send();
		System.out.println(res.toString());
		return res.toString();
    }
    
    /**
     * 运营方或平台方通过该方法进行DDC账户信息状态的更改。
     * 
     * @param account DDC用户链账户地址
     * @param state  状态 ：Frozen - 冻结状态 ； Active - 活跃状态
     * @return 返回交易哈希
     * @throws Exception
     */
    public String updateAccState(String account, BigInteger state, boolean changePlatformState) throws Exception {
    	if(Strings.isEmpty(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
    	}

    	if(!AddressUtils.isValidAddress(account)) {
    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
    	}

    	if(state == null) {
    		throw new DDCException(ErrorMessage.ACCOUNT_STASTUS_IS_EMPTY);
    	}
		Web3jUtils web3jUtils = new Web3jUtils();
		AuthorityLogic authorityLogic = web3jUtils.getAuthority();
		TransactionReceipt res = authorityLogic.updateAccountState(account,state,changePlatformState).send();

        return res.toString();
    }
    
}
