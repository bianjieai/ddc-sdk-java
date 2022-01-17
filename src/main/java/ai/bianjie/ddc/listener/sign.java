package ai.bianjie.ddc.listener;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.utils.Numeric;

public class sign implements SignEventListener{
    @Override
    public String signEvent(RawTransaction rawTransaction) {
        Credentials credentials = Credentials.create("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);

        return Numeric.toHexString(signMessage);
    }



}
