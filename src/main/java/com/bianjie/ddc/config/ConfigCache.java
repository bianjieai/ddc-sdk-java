package com.bianjie.ddc.config;


import java.util.concurrent.ConcurrentHashMap;

public class ConfigCache {

	private static final String DDC_SDK_CACHE_KEY = "ddc_sdk_config";
	
	private static final ConcurrentHashMap<String,ConfigInfo> MAP = new ConcurrentHashMap<>();
	
	public static void initCache(String opbGateWebAddress, String credentials, String gasPrice, String gasLimit, String ddc721Address, String ddc1155Address, String authorityLogicAddress, String chargeLogicAddress) {
		ConfigInfo configInfo = new ConfigInfo();
		//opb处理，验证非空，验证有效性
		if(1==1){
			configInfo.setOpbGatewayAddress(opbGateWebAddress);
		}
		//地址验证
		if(1==1){
			configInfo.setCredentials(credentials);
		}
		if(ddc721Address!=null){
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
