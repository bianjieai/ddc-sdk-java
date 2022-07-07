package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.SignEventTest;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class DDC721ServiceTest {

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
//    DDC721Service ddc721Service = client.getDDC721Service();
//    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E";

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
    DDC721Service ddc721Service = client.getDDC721Service();
    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform

    @Test
    void mint() throws Exception {
//        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
//        client.setGatewayApiKey("x-api-key");
//        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(ddc721Service.mint(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", "11111"));
    }

    @Test
    void safeMint() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        byte[] data = {10, 10, 10};
        System.out.println(ddc721Service.safeMint(sender, "0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "11111", data));
    }

    @Test
    void approve() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.approve(sender, "6F561802FDAD741EDA7254C3F5651DAAAB266A90", new BigInteger("11")));
    }

    @Test
    void getApproved() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.getApproved(new BigInteger("12")));
    }

    @Test
    void setApprovalForAll() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.setApprovalForAll(sender, "6F561802FDAD741EDA7254C3F5651DAAAB266A90", true));
    }

    @Test
    void isApprovedForAll() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.isApprovedForAll("0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "6F561802FDAD741EDA7254C3F5651DAAAB266A90"));
    }

    @Test
    void safeTransferFrom() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.safeTransferFrom(sender, "0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "918F7F275A6C2D158E5B76F769D3F1678958A334", new BigInteger("2"), new byte[]{10}));
    }

    @Test
    void transferFrom() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.transferFrom(sender, "0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "918F7F275A6C2D158E5B76F769D3F1678958A334", new BigInteger("2")));
    }

    @Test
    void burn() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.burn(sender, new BigInteger("4")));
    }

    @Test
    void balanceOf() throws Exception {
//        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
//        client.setGatewayApiKey("x-api-key");
//        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(ddc721Service.balanceOf("0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"));
    }

    @Test
    void ownerOf() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.ownerOf(new BigInteger("12")));
    }

    @Test
    void name() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(ddc721Service.name());
    }

    @Test
    void symbol() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(ddc721Service.symbol());
    }

    @Test
    void ddcURI() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.ddcURI(new BigInteger("12")));
    }

    @Test
    void setURI() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc721Service.setURI(sender, new BigInteger("12"), "1234"));
    }
}