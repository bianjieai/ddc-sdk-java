package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.dto.BlockEventBean;
import ai.bianjie.ddc.listener.sign;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

class BlockEventServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc")
            .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
            .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
            .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
            .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();

    @Test
    void getBlockEvent() throws IOException, InterruptedException {
        BlockEventService blockEventService = new BlockEventService();
        BlockEventBean blockEvent = blockEventService.getBlockEvent(new BigInteger("2856"));
    }
}