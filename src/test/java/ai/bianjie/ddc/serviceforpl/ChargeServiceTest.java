package ai.bianjie.ddc.serviceforpl;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.listener.sign;
import ai.bianjie.ddc.service.ChargeService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class ChargeServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc")
            .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
            .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
            .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
            .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();
    ChargeService chargeService = client.getChargeService();
    String sender="";

    @Test
    void recharge() throws Exception {
        String hash = chargeService.recharge(sender,"918F7F275A6C2D158E5B76F769D3F1678958A334", new BigInteger("100000"));
        System.out.print(hash);
    }

    @Test
    void balanceOf() throws Exception {
        BigInteger balance = chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
        System.out.print(balance);
    }

    @Test
    void queryFee() throws Exception {
        BigInteger fee = chargeService.queryFee("", "");
        System.out.print(fee);
    }
}