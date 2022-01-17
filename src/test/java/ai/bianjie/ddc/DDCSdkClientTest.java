package ai.bianjie.ddc;

import ai.bianjie.ddc.listener.sign;
import ai.bianjie.ddc.service.ChargeService;
import ai.bianjie.ddc.service.DDC721Service;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;


public class DDCSdkClientTest {
    @Test
    public void chargeTest(){
        DDCSdkClient ddcSdkClient = new DDCSdkClient.Builder("http://58.33.6.114:18545")
                .ddc721Address("0x02d40d287C851b760342126922f5D239321Dc4BC")
                .chargeLogicAddress("0xcA65BAbCB23053B0b1Fb3bB2d79E487e56e1FBC4")
                .init();

    }

    @Test
    public void signTest() throws Exception {
        DDCSdkClient ddcSdkClient = new DDCSdkClient.Builder("http://58.33.6.114:18545")
                .chargeLogicAddress("0xcA65BAbCB23053B0b1Fb3bB2d79E487e56e1FBC4")
                .init();
        ddcSdkClient.registerSignListener(new sign());
        ChargeService chargeService = ddcSdkClient.getChargeService();
        String hash = chargeService.recharge("59F2175B2380AAA12F512360D43CBD77B7841A51", new BigInteger("100"));

        System.out.println("Recharge:======" + hash);

        chargeService.recharge("59F2175B2380AAA12F512360D43CBD77B7841A51", new BigInteger("10"));
        chargeService.setGasLimit("1");
        chargeService.recharge("59F2175B2380AAA12F512360D43CBD77B7841A51", new BigInteger("10"));
        chargeService.setGasLimit("2");
        chargeService.recharge("59F2175B2380AAA12F512360D43CBD77B7841A51", new BigInteger("10"));



    }

}