package ai.bianjie.ddc.service;

import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.contract.DDC721Data;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class DDC721data {
    public TransactionReceipt setDDC721LogicAddress(String ddc721Logic) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        DDC721Data ad = web3jUtils.getDDC721Data();
        TransactionReceipt a = ad.setDDC721LogicAddress(ddc721Logic).send();
        return a;
    }
    public TransactionReceipt setAuthorityLogicAddress(String AuthorityLogic) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        DDC721 ad = web3jUtils.getDDC721();
        TransactionReceipt a = ad.setAuthorityLogic(AuthorityLogic).send();
        return a;
    }
    public TransactionReceipt setChargeLogic(String ChargeLogic) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        DDC721 ad = web3jUtils.getDDC721();
        TransactionReceipt a = ad.setChargeLogic(ChargeLogic).send();
        return a;
    }
}
