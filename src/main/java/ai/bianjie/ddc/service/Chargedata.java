package ai.bianjie.ddc.service;

import ai.bianjie.ddc.util.Web3jUtils;
import ai.bianjie.ddc.contract.ChargeData;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class Chargedata {
    public TransactionReceipt setChargeLogicContractAddr(String chargeLogicContractAddr) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        ChargeData cd = web3jUtils.getChargeData();
        TransactionReceipt c = cd.setChargeLogicContractAddr(chargeLogicContractAddr).send();
        return c;
    }
}
