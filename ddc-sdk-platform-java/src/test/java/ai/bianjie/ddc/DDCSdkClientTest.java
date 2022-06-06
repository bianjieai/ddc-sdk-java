package ai.bianjie.ddc;

import ai.bianjie.ddc.dto.Account;
import ai.bianjie.ddc.service.BaseService;
import org.junit.jupiter.api.Test;


class DDCSdkClientTest {

    @Test
    void sdkInitTest() throws Exception {

        DDCSdkClient client = new DDCSdkClient.Builder()
                .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
                .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
                .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
                .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
                .setGasLimit("300000")
                .setGasPrice("1")
                .setSignEventListener(new SignEventTest())
                .init();

        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("b011c1a9337344a698cf7996d194ec18");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        client.setConnectTimeout(20);

        BaseService baseService = new BaseService();
        baseService.setFuncGasLimit("100000");
        Account acc = baseService.createAccount();
        System.out.println("================================" + acc.getAddress());
        System.out.println("================================" + acc.getPrivateKey());
        String addHex = baseService.accountHexToBech32(acc.getAddress());
        System.out.println("================================" + addHex);
    }
}