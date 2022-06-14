package ai.bianjie.ddc;

import ai.bianjie.ddc.dto.Account;
import ai.bianjie.ddc.service.AuthorityService;
import ai.bianjie.ddc.service.BaseService;
import ai.bianjie.ddc.service.ChargeService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;


class DDCSdkClientTest {

    @Test
    void sdkInitTest() throws Exception {

        DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xfc3041A5Be5B8f7f4326666A3CED1fF926278c98")
            .setChargeLogicAddress("0x3b0512B6521705649bCd8188CB087184E128fC98")
            .setDDC721Address("0x510B0210fF2e3820B0662F7888b97E316c3d9034")
            .setDDC1155Address("0xd4E6Ee8DF49f822e9865ff87dF71f6f804EeCd80")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();

        client.setGatewayUrl("http://192.168.150.42:8545");
//        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
//        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
//        client.setConnectTimeout(20);

//        BaseService baseService = new BaseService();
//        baseService.setFuncGasLimit("100000");
//        Account acc = baseService.createAccount();
//        System.out.println("================================" + acc.getAddress());
//        System.out.println("================================" + acc.getPrivateKey());
//        String addHex = baseService.accountHexToBech32(acc.getAddress());
//        System.out.println("================================" + addHex);

        String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform
        ChargeService chargeService = client.getChargeService();
        String hash = chargeService.recharge(sender, "0xd55172e02723cec9f0a89dbcdc1675098152ac52", new BigInteger("10"));
        System.out.print(hash);

        String hash1 = chargeService.recharge(sender, "0xd55172e02723cec9f0a89dbcdc1675098152ac52", new BigInteger("10"));
        System.out.print(hash1);

        String hash2 = chargeService.recharge(sender, "0xd55172e02723cec9f0a89dbcdc1675098152ac52", new BigInteger("10"));
        System.out.print(hash2);
    }
}