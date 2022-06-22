package ai.bianjie.ddc;

import ai.bianjie.ddc.listener.SignEventListener;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.utils.Numeric;

public class SignEventTest implements SignEventListener {

    @Override
    @Test
    public String signEvent(ai.bianjie.ddc.listener.SignEvent signEvent) {
        Credentials credentials = Credentials.create("E253AB375A5806FA331E7DB32EDE524BD7D998475A60C957806066F14F479C25");
        byte[] signMessage = TransactionEncoder.signMessage(signEvent.getRawTransaction(), credentials);
        return Numeric.toHexString(signMessage);
    }
}
