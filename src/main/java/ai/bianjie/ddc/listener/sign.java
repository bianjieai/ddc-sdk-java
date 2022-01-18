package ai.bianjie.ddc.listener;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.utils.Numeric;

public class sign implements SignEventListener{
    @Override
    public String signEvent(SignEvent signEvent) {
        Credentials credentials = Credentials.create("1A1AE89CC2517570C4CD898B325B3518888F8C87ECBB88FBDA761F1EC535D54B");
        byte[] signMessage = TransactionEncoder.signMessage(signEvent.rawTransaction, credentials);

        return Numeric.toHexString(signMessage);
    }

}
