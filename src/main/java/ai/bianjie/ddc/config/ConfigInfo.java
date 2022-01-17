package ai.bianjie.ddc.config;

import ai.bianjie.ddc.constant.AuthorityFunctions;
import ai.bianjie.ddc.constant.ChargeFunctions;
import ai.bianjie.ddc.constant.DDC1155Functions;
import ai.bianjie.ddc.constant.DDC721Functions;

import java.util.HashMap;
import java.util.Map;

public class  ConfigInfo {
    private Map<String,String> map = new HashMap<>();

    private String opbGatewayAddress = "http://192.168.150.43:8545";

    private String headerKey;

    private String headerValue;

    private String gasPrice = "10000000";

    private String gasLimit = "300000";

    private String funcGasLimit = "0";


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

    public ConfigInfo() {
        map.put(AuthorityFunctions.GetAccount,"0");
        map.put(AuthorityFunctions.AddAccount,"0");
        map.put(AuthorityFunctions.AddConsumerByOperator,"0");
        map.put(AuthorityFunctions.UpdateAccountState,"0");
        map.put(AuthorityFunctions.GetAccount,"0");
        map.put(AuthorityFunctions.AddAccount,"0");
        map.put(AuthorityFunctions.AddConsumerByOperator,"0");
        map.put(AuthorityFunctions.UpdateAccountState,"0");
        map.put(ChargeFunctions.Recharge,"0");
        map.put(ChargeFunctions.BalanceOf,"0");
        map.put(ChargeFunctions.QueryFee,"0");
        map.put(ChargeFunctions.SelfRecharge,"0");
        map.put(ChargeFunctions.SetFee,"0");
        map.put(ChargeFunctions.DeleteFee,"0");
        map.put(DDC721Functions.MINT,"0");
        map.put(DDC721Functions.APPROVE,"0");
        map.put(DDC721Functions.GET_APPROVED,"0");
        map.put(DDC721Functions.SET_APPROVAL_FOR_ALL,"0");
        map.put(DDC721Functions.IS_APPROVED_FOR_ALL,"0");
        map.put(DDC721Functions.SAFE_TRANSFER_FROM,"0");
        map.put(DDC721Functions.TRANSFER_FROM,"0");
        map.put(DDC721Functions.FREEZE,"0");
        map.put(DDC721Functions.UNFREEZE,"0");
        map.put(DDC721Functions.BURN,"0");
        map.put(DDC721Functions.BALANCE_OF,"0");
        map.put(DDC721Functions.OWNER_OF,"0");
        map.put(DDC721Functions.NAME,"0");
        map.put(DDC721Functions.SYMBOL,"0");
        map.put(DDC721Functions.DDC_URI,"0");
        map.put(DDC1155Functions.SafeMint,"0");
        map.put(DDC1155Functions.SAFE_MINT_BATCH,"0");
        map.put(DDC1155Functions.SetApprovalForAll,"0");
        map.put(DDC1155Functions.IsApprovedForAll,"0");
        map.put(DDC1155Functions.SafeTransferFrom,"0");
        map.put(DDC1155Functions.SafeBatchTransferFrom,"0");
        map.put(DDC1155Functions.Freeze,"0");
        map.put(DDC1155Functions.UnFreeze,"0");
        map.put(DDC1155Functions.Burn,"0");
        map.put(DDC1155Functions.BurnBatch,"0");
        map.put(DDC1155Functions.BalanceOf,"0");
        map.put(DDC1155Functions.BalanceOfBatch,"0");
        map.put(DDC1155Functions.DDCURI,"0");
    }

    public String getOpbGatewayAddress() {
        return opbGatewayAddress;
    }

    public String getHeaderKey() {
        return headerKey;
    }

    public void setHeaderKey(String headerKey) {
        this.headerKey = headerKey;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
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

    public String getFuncGasLimit() {
        return funcGasLimit;
    }

    public void setFuncGasLimit(String customerGasLimit) {
        this.funcGasLimit = customerGasLimit;
    }

    public void setChargeLogicBIN(String chargeLogicBIN) {
        this.chargeLogicBIN = chargeLogicBIN;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
