package ai.bianjie.ddc.listener;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.utils.Numeric;

public class sign implements SignEventListener{
    @Override
    public String signEvent(RawTransaction rawTransaction) {
        Credentials credentials = Credentials.create("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);

        return Numeric.toHexString(signMessage);
    }

}
