package ai.bianjie.ddc.serviceforpl;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.listener.sign;
import ai.bianjie.ddc.service.AuthorityService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class AuthorityServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc")
            .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
            .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
            .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
            .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();

    AuthorityService authorityService = client.getAuthorityService();
    String sender = "";

    @Test
    void getAccount() throws Exception {
        System.out.println(authorityService.getAccount("0x5804A5F927CE7382AD194FD25BCAA189DAD92A39"));
    }

    @Test
    void updateAccState() throws Exception {
        System.out.println(authorityService.updateAccState(sender, "0x5804A5F927CE7382AD194FD25BCAA189DAD92A39", new BigInteger("0"), true));
    }
}