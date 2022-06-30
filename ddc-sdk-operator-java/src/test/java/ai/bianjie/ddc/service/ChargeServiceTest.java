package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.SignEventTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class ChargeServiceTest {
    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xfc3041A5Be5B8f7f4326666A3CED1fF926278c98")
            .setChargeLogicAddress("0x3b0512B6521705649bCd8188CB087184E128fC98")
            .setDDC721Address("0x510B0210fF2e3820B0662F7888b97E316c3d9034")
            .setDDC1155Address("0xd4E6Ee8DF49f822e9865ff87dF71f6f804EeCd80")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();

    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform
    ChargeService chargeService = client.getChargeService();

    @Test
    void recharge() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        client.setConnectTimeout(20);
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @SneakyThrows
                public void run() {
                    chargeService.setNonce(new BigInteger(String.valueOf(finalI)));
                    String hash = chargeService.recharge(sender, "0xd55172e02723cec9f0a89dbcdc1675098152ac52", new BigInteger("10"));
                    System.out.print(hash);
                }
            }, String.valueOf(finalI)).start();
        }
    }

    @Test
    void balanceOf() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        BigInteger balance = chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
        System.out.print(balance);
    }

    @Test
    void queryFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        BigInteger fee = chargeService.queryFee("0x503f45958F57Da55170B54796F4eD224c9fef9d7", "0xe985e9c5");
        System.out.print(fee);
    }

    @Test
    void selfRecharge() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.selfRecharge(sender, new BigInteger("1000"));
        System.out.print(hash);
    }

    @Test
    void setFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.setFee(sender, "0x503f45958F57Da55170B54796F4eD224c9fef9d7", "0xe985e9c5", new BigInteger("1000"));
        System.out.print(hash);
    }

    @Test
    void delFee() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.delFee(sender, "0x503f45958F57Da55170B54796F4eD224c9fef9d7", "0xe985e9c5");
        System.out.print(hash);
    }

    @Test
    void delDDC() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("903f4f9268ab4e2eac717c7200429776");
        client.setGatewayApiValue("0c1dd14a41b14cfa83048d839a0593ff");
        String hash = chargeService.delDDC(sender, "0x503f45958F57Da55170B54796F4eD224c9fef9d7");
        System.out.print(hash);
    }

}