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
        // owner
//        Credentials credentials = Credentials.create("1933ABA4A5525F648FEA7EB7D8E368D5E23F482BF7CD31A9FF9DEA48F607EC6D");
        // operator
        Credentials credentials = Credentials.create("E253AB375A5806FA331E7DB32EDE524BD7D998475A60C957806066F14F479C25");
        // platform
//        Credentials credentials = Credentials.create("ED43B9686AB520C896BC33A1461BAF163EDBF0DBC4D3199E77793A49B9BB2568");
        byte[] signMessage = TransactionEncoder.signMessage(signEvent.getRawTransaction(), credentials);
        return Numeric.toHexString(signMessage);
    }
}
