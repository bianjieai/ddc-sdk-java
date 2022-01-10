package ai.bianjie.ddc;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.service.*;
import com.sun.security.ntlm.Client;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public class DDCSdkClientTest {
    @Test
    public void sdkInitTest() throws Exception {
        DDCSdkClient client = new DDCSdkClient("http://192.168.150.43:8545");
        client.init("B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26");

//        Authoritydata ad = client.getad();
//        TransactionReceipt rea = ad.setAuthorityLogicContractAddr("0x368d4064762a22640E8a79cA6B62F0815f3e2F9C");
//        System.out.println("--------------------------------------"+rea.toString()+"------------");
//
//        Chargedata cd = client.getcd();
//        TransactionReceipt rec = cd.setChargeLogicContractAddr("0xcA65BAbCB23053B0b1Fb3bB2d79E487e56e1FBC4");
//        System.out.println("--------------------------------------" + rec.toString() + "------------");
//
//        DDC721data ddc721data = client.getD7();
//        TransactionReceipt re721 = ddc721data.setDDC721LogicAddress("0x02d40d287C851b760342126922f5D239321Dc4BC");
//        System.out.println("--------------------------------------"+re721.toString()+"------------");
//
//        DDC1155data ddc1155data = client.getD1();
//        TransactionReceipt re1155 = ddc1155data.setDDC1155LogicAddress("0xf6Bc71043a176114A8E4cfF686D6F417b971d5bA");
//        System.out.println("--------------------------------------"+re1155.toString()+"------------");

        
        AuthorityService authorityService = client.getAuthorityService();

//        String a= authorityService.addAccount("B049D49C9CCF92C2E32981C27D00E0EA57E26213","test","did:bsn:3wxYHXwAm57grc9JUr2zrPHt9HC");
        String a= authorityService.getAccount("B049D49C9CCF92C2E32981C27D00E0EA57E26213");
        System.out.println("--------------------------------------"+a+"------------");

        ChargeService chargeService = client.getChargeService();
        String hash =chargeService.recharge("308611AF1CFABE10A66763B0900C8086EE946DC9",BigInteger.valueOf(10000));
        System.out.println("--------------------------------------" + hash + "------------");

        String balance =chargeService.balanceOf("308611AF1CFABE10A66763B0900C8086EE946DC9");
        System.out.println("--------------------------------------" + balance + "------------");

    }
}