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
            .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
            .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
            .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
            .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();

    BaseService baseService= client.getChargeService();

    @Test
    void getBlockByNumber() throws IOException {
        EthBlock.Block block = baseService.getBlockByNumber(new BigInteger("3058179"));
        System.out.println("--------------------------------------" + block);
    }

    @Test
    void getTransReceipt() throws ExecutionException, InterruptedException {
        TransactionReceipt transactionReceipt = baseService.getTransReceipt("0x79bc4b5128e4b663876a3d4b097bd160fa512c1c5e93a615df45a86ccf0422ad");
        System.out.println("--------------------------------------" + transactionReceipt);
    }

    @Test
    void getTransByHash() throws IOException {
        txInfo transaction = baseService.getTransByHash("0xb5b02d47f961b9c86d1dd313c40cb88e255fe162c4ddd8b204cf161bc89f0e70");
        System.out.println("--------------------------------------" + transaction);
    }

    @Test
    void getTransByStatus() throws ExecutionException, InterruptedException {
        Boolean state = baseService.getTransByStatus("0xb5b02d47f961b9c86d1dd313c40cb88e255fe162c4ddd8b204cf161bc89f0e70");
        System.out.println("--------------------------------------" + state);
    }

    @Test
    void getLatestBlockNumber() throws IOException {
        System.out.println(baseService.getLatestBlockNumber());
    }
}