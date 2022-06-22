package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.dto.BlockEventBean;
import ai.bianjie.ddc.SignEventTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

class BlockEventServiceTest {
//    DDCSdkClient client = new DDCSdkClient.Builder()
//            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
//            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
//            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
//            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
//            .setGasLimit("300000")
//            .setGasPrice("1")
//            .setSignEventListener(new SignEventTest())
//            .init();

//        DDCSdkClient client = new DDCSdkClient.Builder()
//            .setAuthorityLogicAddress("0xBcE9AA1924D7197C9C945e43638Bf589f91bcB71")
//            .setChargeLogicAddress("0xF41b6185bFB22E2EFC5fB8395Fa3B952951E2d0b")
//            .setDDC721Address("0x74b6114d011891Ac21FD1d586bc7F3407c63c216")
//            .setDDC1155Address("0x9f7388e114DfDFAbAF8e4b881894E4C7e1b52C17")
//            .setGasLimit("300000")
//            .setGasPrice("1")
//            .setSignEventListener(new SignEventTest())
//            .init();

    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xfc3041A5Be5B8f7f4326666A3CED1fF926278c98")
            .setChargeLogicAddress("0x3b0512B6521705649bCd8188CB087184E128fC98")
            .setDDC721Address("0x510B0210fF2e3820B0662F7888b97E316c3d9034")
            .setDDC1155Address("0xd4E6Ee8DF49f822e9865ff87dF71f6f804EeCd80")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();
//1483851
    //1411202
    @Test
    void getBlockEvent() throws Exception {
//        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
//        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
//        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        client.setGatewayUrl("http://192.168.150.42:8545");
        BlockEventService blockEventService = new BlockEventService();
        BlockEventBean blockEvent = blockEventService.getBlockEvent(new BigInteger("1483851"));
        System.out.println(blockEvent.getList());
    }
}