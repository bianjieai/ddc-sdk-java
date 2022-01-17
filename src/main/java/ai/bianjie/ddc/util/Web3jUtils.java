package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.*;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Web3jUtils {
    public static ECKeyPair ecKeyPair;

    static {
        try {
            ecKeyPair = Keys.createEcKeyPair();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public static Authority getAuthority() {
        return Authority.load(ConfigCache.get().getAuthorityLogicAddress(), Web3jUtils.getWeb3j(), Credentials.create(ecKeyPair), new GasProvider());
    }

    public static Charge getCharge() {
        return Charge.load(ConfigCache.get().getChargeLogicAddress(), Web3jUtils.getWeb3j(), Credentials.create(ecKeyPair), new GasProvider());
    }

    public static DDC1155 getDDC1155() {
        return DDC1155.load(ConfigCache.get().getDdc1155Address(), Web3jUtils.getWeb3j(), Credentials.create(ecKeyPair), new GasProvider());
    }

    public static DDC721 getDDC721() {
        return DDC721.load(ConfigCache.get().getDdc721Address(), Web3jUtils.getWeb3j(), Credentials.create(ecKeyPair), new GasProvider());
    }

    public static Web3j getWeb3j() {
        return Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress()));
    }
}
