package ai.bianjie.ddc.service;

import ai.bianjie.ddc.contract.DDC1155;
import ai.bianjie.ddc.contract.DDC1155Data;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.contract.DDC721Data;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class DDC1155data {
    public TransactionReceipt setDDC1155LogicAddress(String ddc721Logic) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        DDC721Data ad = web3jUtils.getDDC721Data();
        TransactionReceipt a = ad.setDDC721LogicAddress(ddc721Logic).send();
        return a;
    }
    public TransactionReceipt setAuthorityLogicAddress(String AuthorityLogic) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        DDC1155 ad = web3jUtils.getDDC1155();
        TransactionReceipt a = ad.setAuthorityLogicAddress(AuthorityLogic).send();
        return a;
    }
    public TransactionReceipt setChargeLogic(String ChargeLogic) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        DDC1155 ad = web3jUtils.getDDC1155();
        TransactionReceipt a = ad.setChargeLogicAddress(ChargeLogic).send();
        return a;
    }
}
