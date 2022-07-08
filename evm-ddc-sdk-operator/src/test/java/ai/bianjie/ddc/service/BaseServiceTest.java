package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.dto.Account;
import ai.bianjie.ddc.dto.TxInfo;
import ai.bianjie.ddc.SignEventTest;
import org.bitcoinj.crypto.MnemonicException;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

class BaseServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xa7FC5B0F4A0085c5Ce689b919a866675Ce37B66b")
            .setChargeLogicAddress("0x3BBb01B38958d4dbF1e004611EbB3c65979B0511")
            .setDDC721Address("0x3B09b7A00271C5d9AE84593850dE3A526b8BF96e")
            .setDDC1155Address("0xe5d3b9E7D16E03A4A1060c72b5D1cb7806DD9070")
            .setGasLimit("300000")
            .setGasPrice("1")
            .setSignEventListener(new SignEventTest())
            .init();

    BaseService baseService = client.getChargeService();

    @Test
    void getBlockByNumber() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        EthBlock.Block block = baseService.getBlockByNumber(new BigInteger("3058179"));
        System.out.println("--------------------------------------" + block.getHash());
    }

    @Test
    void getTransReceipt() throws ExecutionException, InterruptedException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        TransactionReceipt transactionReceipt = baseService.getTransReceipt("0x79bc4b5128e4b663876a3d4b097bd160fa512c1c5e93a615df45a86ccf0422ad");
        System.out.println("--------------------------------------" + transactionReceipt);
    }

    @Test
    void getTransByHash() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        TxInfo transaction = baseService.getTransByHash("0x79bc4b5128e4b663876a3d4b097bd160fa512c1c5e93a615df45a86ccf0422ad");
        System.out.println("--------------------------------------" + transaction);
    }

    @Test
    void getTransByStatus() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Boolean state = baseService.getTransByStatus("0x7cccfb8c469f59784fc195df21ab31c854f9b320850b22180570e3fec2cb13d4");
        System.out.println("--------------------------------------" + state);
    }

    @Test
    void getLatestBlockNumber() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(baseService.getLatestBlockNumber());
    }

    @Test
    void AccoutHexToBech32() throws MnemonicException.MnemonicLengthException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Account acc = baseService.createAccount();
        System.out.println(baseService.accountHexToBech32(acc.getAddress()));
    }

    @Test
    void AccountBech32ToHex() throws MnemonicException.MnemonicLengthException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        Account acc = baseService.createAccount();
        System.out.println(acc.getAddress());
        String a = baseService.accountHexToBech32(acc.getAddress());
        System.out.println(baseService.accountBech32ToHex(a));
    }

    @Test
    void createAccount() {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(baseService.createAccount().getAddress());
        System.out.println(baseService.createAccount().getPrivateKey());
        System.out.println(baseService.createAccount().getKeyseed());
    }

    @Test
    void balanceOfGas() throws IOException {
        client.setGatewayUrl("https://opbtest.bsngate.com:18602/api/3c7c78de11494f219025f087bbacbd2a/evmrpc");
        client.setGatewayApiKey("x-api-key");
        client.setGatewayApiValue("5823d69e2198453e8662758e11cadacb");
        System.out.println(baseService.BalanceOfGas("0x7FAF93F524FFDD1FB36BEC0ED6A167E8CE55BC4E"));
    }
}