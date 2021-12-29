package com.bianjie.ddc.config;

public class ConfigInfo {
    private String opbGatewayAddress = "http://127.0.0.1:8545";

	private String credentials;

	private String gasPrice;

	private String gasLimit;

//721合约
//    private String ddc721ABI;
//
//    private String ddc721BIN;

    private String ddc721Address = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";

//1155合约
//    private String ddc1155ABI;
//
//    private String ddc1155BIN;
    
    private String ddc1155Address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbb";

//authority合约
//    private String authorityLogicABI;
//
//    private String authorityLogicBIN;
   
    private String authorityLogicAddress = "cccccccccccccccccccccccccccc";

//charge合约
//    private String chargeLogicABI;
//
//    private String chargeLogicBIN;

    private String chargeLogicAddress = "dddddddddddddddddddddddddd";

//公钥私钥
    private String privateKey;
    
    private String publicKey;

	public String getOpbGatewayAddress() {
		return opbGatewayAddress;
	}

	public void setOpbGatewayAddress(String opbGatewayAddress) {
		this.opbGatewayAddress = opbGatewayAddress;
	}

	public String getDdc721Address() {
		return ddc721Address;
	}

	public void setDdc721Address(String ddc721Address) {
		this.ddc721Address = ddc721Address;
	}

	public String getDdc1155Address() {
		return ddc1155Address;
	}

	public void setDdc1155Address(String ddc1155Address) {
		this.ddc1155Address = ddc1155Address;
	}

	public String getAuthorityLogicAddress() {
		return authorityLogicAddress;
	}

	public void setAuthorityLogicAddress(String authorityLogicAddress) {
		this.authorityLogicAddress = authorityLogicAddress;
	}

	public String getChargeLogicAddress() {
		return chargeLogicAddress;
	}

	public void setChargeLogicAddress(String chargeLogicAddress) {
		this.chargeLogicAddress = chargeLogicAddress;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(String gasPrice) {
		this.gasPrice = gasPrice;
	}

	public String getGasLimit() {
		return gasLimit;
	}

	public void setGasLimit(String gasLimit) {
		this.gasLimit = gasLimit;
	}
}
