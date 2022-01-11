package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Web3jUtils {
    private Web3j web3j = Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress()));

    private Credentials credentials = Credentials.create(ConfigCache.get().getCredentials());

    public AuthorityLogic getAuthority() {
        return AuthorityLogic.load(ConfigCache.get().getAuthorityLogicAddress(), web3j, credentials, new GasProvider());
    }

    public ChargeLogic getCharge() {
        return ChargeLogic.load(ConfigCache.get().getChargeLogicAddress(), web3j, credentials, new GasProvider());
    }

    public DDC1155 getDDC1155() {
        return DDC1155.load(ConfigCache.get().getDdc1155Address(), web3j, credentials, new GasProvider());
    }

    public DDC721 getDDC721() {
        return DDC721.load(ConfigCache.get().getDdc721Address(), web3j, credentials, new GasProvider());
    }

    public Web3j getWeb3j() {
        return web3j;
    }
}
