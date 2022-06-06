package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.SignEventTest;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class ChargeServiceTest {

    // bsn test
//    DDCSdkClient client = new DDCSdkClient.Builder()
//            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
//            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
//            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
//            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
//            .setGasLimit("300000")
//            .setGasPrice("1")
//            .setSignEventListener(new SignEventTest())
//            .init();
//
//    ChargeService chargeService = client.getChargeService();
//    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E";// platform

    // dev
    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xfc3041A5Be5B8f7f4326666A3CED1fF926278c98")
            .setChargeLogicAddress("0x3b0512B6521705649bCd8188CB087184E128fC98")
            .setDDC721Address("0x510B0210fF2e3820B0662F7888b97E316c3d9034")
            .setDDC1155Address("0xd4E6Ee8DF49f822e9865ff87dF71f6f804EeCd80")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();
    ChargeService chargeService = client.getChargeService();
    String sender = "0x02CEB40D892061D457E7FA346988D0FF329935DF"; // operator
//    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform

    @Test
    void recharge() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        String hash = chargeService.recharge(sender, "0xd55172e02723cec9f0a89dbcdc1675098152ac52", new BigInteger("100000"));
        System.out.print(hash);
    }

    @Test
    void balanceOf() throws Exception {
//        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
//        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
//        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        client.setGatewayUrl("http://192.168.150.42:8545");
        BigInteger balance = chargeService.balanceOf("0x02CEB40D892061D457E7FA346988D0FF329935DF");
        System.out.print(balance);
    }

    @Test
    void queryFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        BigInteger fee = chargeService.queryFee("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e", "0xe985e9c5");
        System.out.print(fee);
    }

    @Test
    void rechargeBatch() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Multimap<String, BigInteger> accounts = ArrayListMultimap.create();
        ;
        accounts.put("0xd55172e02723cec9f0a89dbcdc1675098152ac52", new BigInteger("10"));
        System.out.println(chargeService.rechargeBatch(sender, accounts));
    }

    @Test
    void balanceOfBatch() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        List<String> accAddrs = new ArrayList<>();
        accAddrs.add("0x02CEB40D892061D457E7FA346988D0FF329935DF");
        System.out.println(chargeService.balanceOfBatch(accAddrs));
    }
}