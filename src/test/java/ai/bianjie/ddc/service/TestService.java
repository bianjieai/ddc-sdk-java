package ai.bianjie.ddc.service;

import ai.bianjie.ddc.contract.AuthorityLogic;
import ai.bianjie.ddc.contract.ChargeLogic;
import ai.bianjie.ddc.util.GasProvider;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class TestService {

    public String recharge(String account) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("http://192.168.150.43:8545"));
        Credentials credentials = Credentials.create("FAAA797E663FA08C8DAA3972ED1FA42448AC0334FF4AAFB3C8892987D12E55C2");
        String contractAddr = "0xFb7237841ea645A2f91D9B4730486A0086820270v";
        ChargeLogic chargeLogic = ChargeLogic.load(contractAddr, web3j, credentials, new GasProvider("10","300000000"));
        BigInteger res = chargeLogic.balanceOf(account).send();
        System.out.println("002---------------------------------------------------------------------------------");

//      RemoteCall<TransactionReceipt> account1 = authorityLogic.getAccount(account);
        System.out.println("003---------------------------------------------------------------------------------");
        return res.toString();
    }

}
