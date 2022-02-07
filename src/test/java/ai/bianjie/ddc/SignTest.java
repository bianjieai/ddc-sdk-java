package ai.bianjie.ddc;

import ai.bianjie.ddc.listener.SignEvent;
import ai.bianjie.ddc.listener.SignEventListener;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.utils.Numeric;

import static org.junit.jupiter.api.Assertions.assertNull;

public class SignTest implements SignEventListener {
    @Override
    @Test
    public String signEvent(SignEvent signEvent) {
        Credentials credentials = Credentials.create("17AAB5FD9E5D21C4ED53B39832723F56A0BC195D2C27566742349A4035406CD8");
        Credentials credentials1 = Credentials.create("5f810be7f68e7921cec0b6ed2ad069b17d1c06349cc5d5502f5ab516c26d12fc");
        assertNull(TransactionEncoder.signMessage(signEvent.rawTransaction, credentials));
        byte[] signMessage = TransactionEncoder.signMessage(signEvent.rawTransaction, credentials);
        return Numeric.toHexString(signMessage);
    }
}
