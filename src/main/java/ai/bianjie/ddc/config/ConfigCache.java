package ai.bianjie.ddc.config;


import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.util.ConfigUtils;
import org.web3j.utils.Strings;

import java.util.concurrent.ConcurrentHashMap;

public class ConfigCache {

	private static final String DDC_SDK_CACHE_KEY = "ddc_sdk_config";
	
	private static final ConcurrentHashMap<String,ConfigInfo> MAP = new ConcurrentHashMap<>();
	
	public static void initCache(String opbGateWebAddress, String credentials, String gasPrice, String gasLimit, String ddc721Address, String ddc1155Address, String authorityLogicAddress, String chargeLogicAddress) {
		ConfigInfo configInfo = ConfigUtils.loadConfigFromFile();
		//opb处理，验证非空，验证有效性
		if(Strings.isEmpty(opbGateWebAddress)){
			throw new DDCException(ErrorMessage.OPB_GATEWAY_ADDRESS_EMPTY);
		}
		configInfo.setOpbGatewayAddress(opbGateWebAddress);
		//地址验证
		if(1==2){

		}
		configInfo.setCredentials(credentials);
		if (Strings.isEmpty(gasPrice)){
			throw new DDCException(ErrorMessage.UNKNOWN_ERROR);
		}
		configInfo.setGasPrice(gasPrice);
		if (gasLimit!=null){
			configInfo.setGasLimit(gasLimit);
		}if(ddc721Address!=null){
			configInfo.setDdc721Address(ddc721Address);
		}if(ddc1155Address!=null){
			configInfo.setDdc1155Address(ddc1155Address);
		}if(authorityLogicAddress!=null){
			configInfo.setAuthorityLogicAddress(authorityLogicAddress);
		}if(chargeLogicAddress!=null){
			configInfo.setChargeLogicAddress(chargeLogicAddress);
		}
		MAP.put(DDC_SDK_CACHE_KEY, configInfo);

	}
	
	public static final ConfigInfo get() {
		return MAP.get(DDC_SDK_CACHE_KEY);
	}
	
}
