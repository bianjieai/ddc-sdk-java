package ai.bianjie.ddc;

import ai.bianjie.ddc.dto.Account;
import ai.bianjie.ddc.listener.sign;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.ECKeyPair;

import java.math.BigInteger;

class DDCSdkClientTest {

    @Test
    public void sdkInitTest() throws Exception {
//        DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc").authorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a").chargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7").ddc721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7").ddc1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708").gasLimit("300000").gasPrice("10000000").init();
//        SignEventListener signEventListener = new sign();
//        client.registerSignListener(signEventListener);
//        String a = client.getChargeService().recharge("918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("10"));
//        System.out.println("================================"+a);
//        BigInteger b = client.getChargeService().setGasLimitCharge("1").balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("========================"+b);

        DDCSdkClient client = new DDCSdkClient.Builder()
                .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
                .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
                .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
                .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
                .setGasLimit("300000")
                .setGasPrice("10000000")
                .setSignEventListener(new sign())
                .init();

        client.setGatewayUrl("192.168.42.1");
        client.setGatewayApiKey("x-api-key");

//                client.getChargeService().setFee("0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721","0x52403cE9E235Cf013bA2353F0bf47834C98424c7","0x36351c7c", new BigInteger("10"));
//        System.out.println("================================" + a);
//        Account acc = client.getAuthorityService().createAccount();
//        System.out.println("================================" + acc);
//        BigInteger b = client.getChargeService().setGasLimitCharge("1").balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("========================"+b);
    }
}