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
        Credentials credentials = Credentials.create("ED43B9686AB520C896BC33A1461BAF163EDBF0DBC4D3199E77793A49B9BB2568");
        byte[] signMessage = TransactionEncoder.signMessage(signEvent.getRawTransaction(), credentials);
        return Numeric.toHexString(signMessage);
    }
}
