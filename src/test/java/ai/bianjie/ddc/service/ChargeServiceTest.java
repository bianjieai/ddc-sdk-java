package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.listener.SignEvent;
import ai.bianjie.ddc.listener.SignEventListener;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ChargeServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder("http://192.168.150.43:8545").gasLimit("30000").gasPrice("1000000").credentials("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B").init();
    SignEventListener signEventListener =new SignEventListener() {
        @Override
        public String signEvent(SignEvent event) {
            return null;
        }
    };
    ChargeService chargeService = new ChargeService(signEventListener);
    @Test
    void recharge() throws Exception {
        String hash = chargeService.recharge("59F2175B2380AAA12F512360D43CBD77B7841A51",new BigInteger("100"));
        System .out.print(hash);
    }

    @Test
    void balanceOf() throws Exception {
        BigInteger balance = chargeService.balanceOf("59F2175B2380AAA12F512360D43CBD77B7841A51");
        System .out.print(balance);
    }

    @Test
    void queryFee() {
    }

    @Test
    void selfRecharge() {
    }

    @Test
    void setFee() {
    }

    @Test
    void delFee() {
    }

    @Test
    void delDDC() {
    }
}