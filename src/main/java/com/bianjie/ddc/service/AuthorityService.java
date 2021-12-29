package com.bianjie.ddc.service;

import com.bianjie.ddc.config.ConfigCache;
//import com.bianjie.ddc.contract.AuthorityFunctions;
//import com.bianjie.ddc.contract.ErrorMessage;
//import com.bianjie.ddc.dto.ddc.AccountInfo;
//import com.bianjie.ddc.dto.ddc.AccountRole;
//import com.bianjie.ddc.dto.ddc.AccountState;
//import com.bianjie.ddc.dto.taianchain.ReqJsonRpcBean;
//import com.bianjie.ddc.dto.taianchain.RespJsonRpcBean;
import com.bianjie.ddc.contract.AuthorityLogic;
import com.bianjie.ddc.exception.DDCException;
import com.bianjie.ddc.listener.SignEventListener;
import com.bianjie.ddc.util.AddressUtils;
import com.bianjie.ddc.util.GasProvider;
//import org.fisco.bcos.web3j.abi.datatypes.Address;
//import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
//import org.fisco.bcos.web3j.tx.txdecode.InputAndOutputResult;
//import org.fisco.bcos.web3j.utils.Strings;

import java.util.ArrayList;

public class AuthorityService extends com.bianjie.ddc.service.BaseService {

	//只有一个构造方法，需要传入签名事件监听者来创建对象
    public AuthorityService(SignEventListener signEventListener) {
		super.signEventListener = signEventListener;
	}


	String contractAddr = ConfigCache.get().getAuthorityLogicAddress();
	protected AuthorityLogic con = AuthorityLogic.load(contractAddr, web, credentials, new GasProvider(ConfigCache.get().getGasPrice(),ConfigCache.get().getGasLimit()));

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
//    	if(Strings.isEmpty(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//    	}
//
//    	if(!AddressUtils.isValidAddress(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//    	}
//
//        if (Strings.isEmpty(accName)) {
//            throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
//        }
//
//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(account);
//        arrayList.add(accName);
//        arrayList.add(accDID);
//
//        ReqJsonRpcBean reqJsonRpcBean = assembleAuthorityTransaction(AuthorityFunctions.AddAccount,arrayList);
//        RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(),reqJsonRpcBean, RespJsonRpcBean.class);
//        resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
		return null;
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
//    	if(Strings.isEmpty(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//    	}
//
//    	if(!AddressUtils.isValidAddress(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//    	}
//
//    	if(Strings.isEmpty(accName)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_NAME_IS_EMPTY);
//    	}
//
//    	if(Strings.isEmpty(leaderDID)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_LEADER_DID_IS_EMPTY);
//    	}
//
//    	ArrayList<Object> arrayList = new ArrayList<>();
//    	arrayList.add(new Address(account));
//    	arrayList.add(new Utf8String(accName));
//    	arrayList.add(new Utf8String(accDID));
//    	arrayList.add(new Utf8String(leaderDID));
//
//
//    	ReqJsonRpcBean reqJsonRpcBean = assembleAuthorityTransaction(AuthorityFunctions.AddConsumerByOperator,arrayList);
//    	RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(),reqJsonRpcBean, RespJsonRpcBean.class);
//    	resultCheck(respJsonRpcBean);
//    	return (String) respJsonRpcBean.getResult();
		return null;
    }
    
    /**
     * 删除账户
     * 
     * @param account DDC链账户地址
     * @return 返回交易哈希
     * @throws Exception
     */
    public String delAccount(String account) throws Exception {
//    	if(Strings.isEmpty(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//    	}
//
//    	ArrayList<Object> arrayList = new ArrayList<>();
//    	arrayList.add(new Address(account));
//    	ReqJsonRpcBean reqJsonRpcBean = assembleAuthorityTransaction(AuthorityFunctions.DelAccount,arrayList);
//    	RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(),reqJsonRpcBean, RespJsonRpcBean.class);
//    	resultCheck(respJsonRpcBean);
//    	return (String) respJsonRpcBean.getResult();
		return null;
    }
    
    /**
     *  运营方或平台方通过该方法进行DDC账户信息的查询，上级角色可进行下级角色账户的操作。
     * 
     * @param account DDC用户链账户地址
     * @return 返回DDC账户信息
     * @throws Exception
     */
//    public AccountInfo getAccount(String account) throws Exception {
//    	if(Strings.isEmpty(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//    	}
//
//    	if(!AddressUtils.isValidAddress(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//    	}
//
//    	ArrayList<Object> arrayList = new ArrayList<>();
//    	arrayList.add(account);
//
//    	ReqJsonRpcBean reqJsonRpcBean = assembleAuthorityTransaction(AuthorityFunctions.GetAccount,arrayList);
//    	RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(),reqJsonRpcBean, RespJsonRpcBean.class);
//    	resultCheck(respJsonRpcBean);
//
//    	InputAndOutputResult inputAndOutputResult = analyzeTransactionRecepitOutput(ConfigCache.get().getAuthorityLogicABI(),ConfigCache.get().getAuthorityLogicBIN(),(String)respJsonRpcBean.getResult());
//    	AccountInfo accountInfo = new AccountInfo();
//    	accountInfo.setAccountDID(String.valueOf(inputAndOutputResult.getResult().get(0).getData()));
//    	accountInfo.setAccountName(String.valueOf(inputAndOutputResult.getResult().get(1).getData()));
//    	accountInfo.setLeaderDID(String.valueOf(inputAndOutputResult.getResult().get(3).getData()));
//    	accountInfo.setField(String.valueOf(inputAndOutputResult.getResult().get(6).getData()));
//    	String accountRole = String.valueOf(inputAndOutputResult.getResult().get(2).getData());
//    	if(accountRole != null && !accountRole.trim().isEmpty()) {
//    		accountInfo.setAccountRole(AccountRole.getByVal(Integer.parseInt(accountRole)));
//    	}
//    	String platformState = String.valueOf(inputAndOutputResult.getResult().get(5).getData());
//    	if(platformState != null && !platformState.trim().isEmpty()) {
//    		accountInfo.setPlatformState(AccountState.getByVal(Integer.parseInt(platformState)));
//    	}
//
//    	String operatorState = String.valueOf(inputAndOutputResult.getResult().get(4).getData());
//    	if(operatorState != null && !operatorState.trim().isEmpty()) {
//    		accountInfo.setOperatorState(AccountState.getByVal(Integer.parseInt(operatorState)));
//    	}
//
//        return accountInfo;
//    }
    
    /**
     * 运营方或平台方通过该方法进行DDC账户信息状态的更改。
     * 
     * @param account DDC用户链账户地址
     * @param state  状态 ：Frozen - 冻结状态 ； Active - 活跃状态
     * @return 返回交易哈希
     * @throws Exception
     */
//    public String updateAccState(String account, AccountState state, boolean changePlatformState) throws Exception {
//    	if(Strings.isEmpty(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_EMPTY);
//    	}
//
//    	if(!AddressUtils.isValidAddress(account)) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_IS_NOT_ADDRESS_FORMAT);
//    	}
//
//    	if(state == null) {
//    		throw new DDCException(ErrorMessage.ACCOUNT_STASTUS_IS_EMPTY);
//    	}
//
//    	ArrayList<Object> arrayList = new ArrayList<>();
//    	arrayList.add(new Address(account));
//    	// arrayList.add(new Int(new BigInteger(state.getStatus().toString())));
//    	arrayList.add(state.getStatus());
//    	arrayList.add(changePlatformState);
//
//    	ReqJsonRpcBean reqJsonRpcBean = assembleAuthorityTransaction(AuthorityFunctions.UpdateAccountState,arrayList);
//    	RespJsonRpcBean respJsonRpcBean = restTemplateUtil.sendPost(ConfigCache.get().getOpbGatewayAddress(),reqJsonRpcBean, RespJsonRpcBean.class);
//    	resultCheck(respJsonRpcBean);
//        return (String) respJsonRpcBean.getResult();
//    }

//    private ReqJsonRpcBean assembleAuthorityTransaction(String functionName, ArrayList<Object> params) throws Exception {
//    	return assembleTransaction(getBlockNumber(), ConfigCache.get().getAuthorityLogicABI(), ConfigCache.get().getAuthorityLogicAddress(), functionName,params);
//    }
    
}
