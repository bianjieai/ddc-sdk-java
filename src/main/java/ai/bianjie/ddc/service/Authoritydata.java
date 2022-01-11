package ai.bianjie.ddc.service;

import ai.bianjie.ddc.contract.AuthorityData;
import ai.bianjie.ddc.util.Web3jUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class Authoritydata {

    public TransactionReceipt setAuthorityLogicContractAddr(String authorityLogicContractAddr) throws Exception {
        Web3jUtils web3jUtils = new Web3jUtils();
        AuthorityData ad = web3jUtils.getAuthorityData();
        TransactionReceipt a =  ad.setAuthorityLogicContractAddr(authorityLogicContractAddr).send();

        return a;
//        return ad.setAuthorityLogicContractAddr(authorityLogicContractAddr);
    }


}
