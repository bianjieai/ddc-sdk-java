package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.SignEventTest;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class DDC1155ServiceTest {

    // bsn test
//    DDCSdkClient client = new DDCSdkClient.Builder()
//            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
//            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
//            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
//            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
//            .setGasLimit("300000")
//            .setGasPrice("10000000")
//            .setSignEventListener(new SignEventTest())
//            .init();
//
//    DDC1155Service ddc1155Service = client.getDDC1155Service();
//    String sender = "0x953488F7E292A7D6CB0BFF81BA806B82E5FD47A2";

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
    DDC1155Service ddc1155Service = client.getDDC1155Service();
    //    String sender = "0x0DF4E53A8A273E7813F0D7D0B2C8510C1D546E06"; // owner
    String sender = "0x02CEB40D892061D457E7FA346988D0FF329935DF"; // operator
//    String sender = "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"; // platform

    @Test
    void safeMint() throws Exception {
//        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
//        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
//        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        client.setGatewayUrl("http://192.168.150.42:8545");
        byte[] data = {10, 10, 10};
        System.out.println(ddc1155Service.safeMint(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", new BigInteger("3"), "222222", data));
    }

    @Test
    void safeMintBatch() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Multimap<BigInteger, String> ddcInfo = ArrayListMultimap.create();
        ;
        ddcInfo.put(new BigInteger("3"), "12");
        byte[] data = {10, 10, 10};
        System.out.println(ddc1155Service.safeMintBatch(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", ddcInfo, data));
    }

    @Test
    void setApprovalForAll() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.setApprovalForAll(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", true));
    }

    @Test
    void isApprovedForAll() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.isApprovedForAll("0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"));
    }

    @Test
    void safeTransferFrom() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        byte[] data = {10, 10, 10};
        System.out.println(ddc1155Service.safeTransferFrom(sender, "0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", new BigInteger("1"), new BigInteger("11"), data));
    }

    @Test
    void safeBatchTransferFrom() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Multimap<BigInteger, BigInteger> ddcs = ArrayListMultimap.create();
        ddcs.put(new BigInteger("3"), new BigInteger("3"));
        byte[] data = {10, 10, 10};
        System.out.println(ddc1155Service.safeBatchTransferFrom(sender, "0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721", "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", ddcs, data));
    }

    @Test
    void freeze() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.freeze(sender, new BigInteger("12")));
    }

    @Test
    void unFreeze() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.unFreeze(sender, new BigInteger("12")));
    }

    @Test
    void burn() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.burn(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", new BigInteger("2")));
    }

    @Test
    void burnBatch() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        List<BigInteger> ddcIds = new ArrayList<>();
        ddcIds.add(BigInteger.valueOf(12));
        System.out.println(ddc1155Service.burnBatch(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", ddcIds));
    }

    @Test
    void balanceOf() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.balanceOf("0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", new BigInteger("2")));
    }

    @Test
    void balanceOfBatch() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Multimap<String, BigInteger> ddcs = ArrayListMultimap.create();
        ddcs.put("0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", new BigInteger("1"));
        List<BigInteger> a = new ArrayList<>(2);
        a = ddc1155Service.balanceOfBatch(ddcs);
        System.out.println(a);
    }

    @Test
    void ddcURI() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.ddcURI(new BigInteger("3")));
    }

    @Test
    void setURI() throws Exception {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(ddc1155Service.setURI(sender, "0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E", new BigInteger("3"), "1234"));
    }

    @Test
    void getLatestDDCId() throws Exception {
        client.setGatewayUrl("http://192.168.150.42:8545");
        System.out.println(ddc1155Service.getLatestDDCId());
    }
}