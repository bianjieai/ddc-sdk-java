package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.SignEventTest;
import ai.bianjie.ddc.dto.AccountInfo;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

class AuthorityServiceTest {

    // bsn test
    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();
    AuthorityService authorityService = client.getAuthorityService();
    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform

    // dev
//    DDCSdkClient client = new DDCSdkClient.Builder()
//            .setAuthorityLogicAddress("0xfc3041A5Be5B8f7f4326666A3CED1fF926278c98")
//            .setChargeLogicAddress("0x3b0512B6521705649bCd8188CB087184E128fC98")
//            .setDDC721Address("0x510B0210fF2e3820B0662F7888b97E316c3d9034")
//            .setDDC1155Address("0xd4E6Ee8DF49f822e9865ff87dF71f6f804EeCd80")
//            .setGasLimit("300000")
//            .setGasPrice("1")
//            .setSignEventListener(new SignEventTest())
//            .init();
//    AuthorityService authorityService = client.getAuthorityService();
//    String sender = "0x02CEB40D892061D457E7FA346988D0FF329935DF"; // operator
//    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform

    @Test
    void addAccountByPlatform() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(authorityService.addAccountByPlatform(sender, "0xd55172e02723cec9f0a89dbcdc1675098152ac52", "cs", "did:cs"));
    }

    @Test
    void addBatchAccountByPlatform() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        List<AccountInfo> accInfo = new ArrayList<>();
        AccountInfo acc = new AccountInfo() {
        };
        acc.setAddress("0xba65d5b206b7b2594ed19724d434c22a2e5ed5b4");
        acc.setAccountName("cs2");
        acc.setAccountDID("did:cs2");
        accInfo.add(acc);
        System.out.println(authorityService.addBatchAccountByPlatform(sender, accInfo));
    }

    @Test
    void setSwitcherStateOfPlatform() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(authorityService.setSwitcherStateOfPlatform(sender, true));
    }

    @Test
    void switcherStateOfPlatform() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(authorityService.switcherStateOfPlatform());
    }

    @Test
    void addAccountByOperator() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(authorityService.addAccountByOperator(sender, "0xb957edb89c8238640ca91794d1b64b6ee58a6127", "test1", "did:test1", ""));
    }

    @Test
    void addBatchAccountByOperator() throws ExecutionException, InterruptedException {
        client.setGatewayUrl("http://192.168.150.42:8545");
        List<AccountInfo> accInfo = new ArrayList<>();
        AccountInfo acc = new AccountInfo() {
        };
        acc.setAddress("0xba65d5b206b7b2594ed19724d434c22a2e5ed5b4");
        acc.setAccountName("test2");
        acc.setAccountDID("did:test2");
        acc.setLeaderDID("");
        accInfo.add(acc);
        System.out.println(authorityService.addBatchAccountByOperator(sender, accInfo));
    }

    @Test
    void testGetAccount() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        AccountInfo accountInfo = authorityService.getAccount("0xba65d5b206b7b2594ed19724d434c22a2e5ed5b4");
        System.out.println(accountInfo.getAccountName());
    }

    @Test
    void testUpdateAccState() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(authorityService.updateAccState(sender, "0x5804A5F927CE7382AD194FD25BCAA189DAD92A39", new BigInteger("0"), true));
    }

    @Test
    void testCrossPlatformApproval() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(authorityService.crossPlatformApproval(sender, "0x5804A5F927CE7382AD194FD25BCAA189DAD92A39", "0x918F7F275A6C2D158E5B76F769D3F1678958A334", true));
    }

    @Test
    void syncPlatformDID() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        List<String> dids = new ArrayList<>();
        dids.add("cs3");
        System.out.println(authorityService.syncPlatformDID(sender, dids));
    }
}