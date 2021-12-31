package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.listener.Secp256K1SignEventListener;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ChargeServiceTest {

    String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
            "MIGEAgEAMBAGByqGSM49AgEGBSuBBAAKBG0wawIBAQQgseEExMPXTcSpExzejzYZ\n" +
            "wcLWikQtoZ3BRhWergMR2LGhRANCAATCEQFr8dEbUI6ZYChl4+pE3UopdpWknZiv\n" +
            "rK7WWNymFHQQyIN15nsq5ZZat8G+iPNLtCdRSaU3h769ObArmgvB\n" +
            "-----END PRIVATE KEY-----";

    String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEjRHf7EbOKvUwRJW/kn4N6Vmf++n/gBu0\n" +
            "WEBUzovj+TAxwvgB26tCfoqk9X2gTdjwwKh6o/hvtx66EDB9GlzgTA==\n" +
            "-----END PUBLIC KEY-----";
    static {
        DDCSdkClient sdk = new DDCSdkClient("http://127.0.0.1:8545");
        sdk.init("B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26","3","300000000");
    }

    @Test
    void recharge() throws Exception {
        ChargeService chargeService =new ChargeService(new Secp256K1SignEventListener(privateKey, publicKey));
        String to = "0x522bc3e4e29276A13f7b7BE9D404961826a82bf8";
        BigInteger amount;
        amount = new BigInteger("300000");

        String txhash = chargeService.recharge(to, amount);
        assertNotNull(txhash);
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