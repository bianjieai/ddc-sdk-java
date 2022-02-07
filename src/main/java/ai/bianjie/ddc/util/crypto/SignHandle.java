package ai.bianjie.ddc.util.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;

public class SignHandle {

    ISignHandle sign;

    public SignHandle(SignType st, String prvKey, String pubKey) {
        if (st == SignType.SECP256K1) {
            try {
                this.sign = new Secp256K1Handle(prvKey, pubKey);
            } catch (Exception e) {
                throw new SignException(e.toString());
            }
        } else {
            throw new SignException("Not implemented");
        }
    }

    public String sign(byte[] data) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (this.sign == null) {
            throw new SignException("this sign is null");
        }

        byte[] s = this.sign.sign(data);
        return Arrays.toString(s);
    }

    public boolean verify(byte[] data, String mac) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        byte[] s = mac.getBytes();
        return this.sign.verify(data, s);
    }


    public String address() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return this.sign.getAddress();
    }


}


