package ai.bianjie.ddc.config;

public class ConfigInfo {
    private String opbGatewayAddress = "http://127.0.0.1:8545";

	private String credentials;

	private String gasPrice;

	private String gasLimit;

//721合约
    private String ddc721BIN;

    private String ddc721Address = "0x1110Ea00ddbb5Db69297B578451f98CD2B8Cb802";

//1155合约
    private String ddc1155BIN;
    
    private String ddc1155Address = "0x4396F79Dc965d0a01fA144E2D0eE2dA66167589b";

//authority合约
    private String authorityLogicBIN;
   
    private String authorityLogicAddress = "0x7754DeF40211373925F5Ea27081E2Af8803C5Da0";

//charge合约
    private String chargeLogicBIN;

    private String chargeLogicAddress = "0xFb7237841ea645A2f91D9B4730486A0086820270v";

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

	public String getDdc721BIN() {
		return ddc721BIN;
	}

	public void setDdc721BIN(String ddc721BIN) {
		this.ddc721BIN = ddc721BIN;
	}

	public String getDdc1155BIN() {
		return ddc1155BIN;
	}

	public void setDdc1155BIN(String ddc1155BIN) {
		this.ddc1155BIN = ddc1155BIN;
	}

	public String getAuthorityLogicBIN() {
		return authorityLogicBIN;
	}

	public void setAuthorityLogicBIN(String authorityLogicBIN) {
		this.authorityLogicBIN = authorityLogicBIN;
	}

	public String getChargeLogicBIN() {
		return chargeLogicBIN;
	}

	public void setChargeLogicBIN(String chargeLogicBIN) {
		this.chargeLogicBIN = chargeLogicBIN;
	}
}
