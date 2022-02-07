package ai.bianjie.ddc.util.crypto;

import org.web3j.crypto.ECKeyPair;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public interface ISignHandle {

    public byte[] sign(byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;

    public boolean verify(byte[] data, byte[] mac) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;

    public byte[] hash(byte[] data);

    public String getAddress() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;

    public ECKeyPair getKeyPair();

    public int getEncryptType();
}
