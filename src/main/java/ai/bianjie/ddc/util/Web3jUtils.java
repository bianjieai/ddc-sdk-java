package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Web3jUtils {
    private Web3j web3j = Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress()));

    private Credentials credentials = Credentials.create(ConfigCache.get().getCredentials());

    public static AuthorityLogic getAuthority() {
        return AuthorityLogic.load(ConfigCache.get().getAuthorityLogicAddress(), Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress())), Credentials.create(ConfigCache.get().getCredentials()), new GasProvider());
    }

    public static ChargeLogic getCharge() {
        return ChargeLogic.load(ConfigCache.get().getChargeLogicAddress(), Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress())), Credentials.create(ConfigCache.get().getCredentials()), new GasProvider());
    }

    public static DDC1155 getDDC1155() {
        return DDC1155.load(ConfigCache.get().getDdc1155Address(), Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress())), Credentials.create(ConfigCache.get().getCredentials()), new GasProvider());
    }

    public static DDC721 getDDC721() {
        return DDC721.load(ConfigCache.get().getDdc721Address(), Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress())), Credentials.create(ConfigCache.get().getCredentials()), new GasProvider());
    }

    public static Web3j getWeb3j() {
        return Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress()));
    }
}
