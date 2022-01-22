package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.dto.txInfo;
import ai.bianjie.ddc.listener.sign;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class BaseServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();

    BaseService baseService= client.getChargeService();

    @Test
    void getBlockByNumber() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("");
        EthBlock.Block block = baseService.getBlockByNumber(new BigInteger("1"));
        System.out.println("--------------------------------------" + block);
    }

    @Test
    void getTransReceipt() throws ExecutionException, InterruptedException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("");
        TransactionReceipt transactionReceipt = baseService.getTransReceipt("0xb5b02d47f961b9c86d1dd313c40cb88e255fe162c4ddd8b204cf161bc89f0e70");
        System.out.println("--------------------------------------" + transactionReceipt);
    }

    @Test
    void getTransByHash() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("");
        txInfo transaction = baseService.getTransByHash("0xb5b02d47f961b9c86d1dd313c40cb88e255fe162c4ddd8b204cf161bc89f0e70");
        System.out.println("--------------------------------------" + transaction);
    }

    @Test
    void getTransByStatus() throws ExecutionException, InterruptedException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/0e346e1fb134477cafb6c6c2583ce3c4/evmrpc");
        client.setGatewayApiKey("");
        Boolean state = baseService.getTransByStatus("0xb5b02d47f961b9c86d1dd313c40cb88e255fe162c4ddd8b204cf161bc89f0e70");
        System.out.println("--------------------------------------" + state);
    }
}