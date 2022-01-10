package ai.bianjie.ddc.config;

public class ConfigInfo {

    private String opbGatewayAddress = "http://192.168.150.43:8545";

	private String credentials = "B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26";

	private String gasPrice = "10";

	private String gasLimit = "10000000";


//authority合约
    private String authorityLogicBIN;
   
    private String authorityLogicAddress = "0x368d4064762a22640E8a79cA6B62F0815f3e2F9C";

//charge合约
    private String chargeLogicBIN;

    private String chargeLogicAddress = "0xcA65BAbCB23053B0b1Fb3bB2d79E487e56e1FBC4";

	//721合约
	private String ddc721BIN;

	private String ddc721Address = "0x02d40d287C851b760342126922f5D239321Dc4BC";

	//1155合约
	private String ddc1155BIN;

	private String ddc1155Address = "0xf6Bc71043a176114A8E4cfF686D6F417b971d5bA";

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
