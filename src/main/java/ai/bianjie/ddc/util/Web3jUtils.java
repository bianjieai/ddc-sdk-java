package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.contract.*;
import ai.bianjie.ddc.service.Chargedata;
import ai.bianjie.ddc.service.DDC1155data;
import ai.bianjie.ddc.service.DDC721data;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class Web3jUtils {
    private Web3j web3j =  Web3j.build(new HttpService(ConfigCache.get().getOpbGatewayAddress()));
    private Credentials credentials = Credentials.create(ConfigCache.get().getCredentials());

    public AuthorityData getAuthorityData() {
        return AuthorityData.load("0x1A970f5D08374472947301C4a2Dd058EFd79e772", web3j, credentials, new GasProvider());
    }
    public ChargeData getChargeData() {
        return ChargeData.load("0x2A936a9462EB061458ebef6DD11B2E2c773E3ab2", web3j, credentials, new GasProvider());
    }
    public DDC721Data getDDC721Data() {
        return DDC721Data.load("0x2Ac33b600863f0Ef11577D4cD59099070DEA3190", web3j, credentials, new GasProvider());
    }
    public DDC1155Data getDDC1155Data() {
        return DDC1155Data.load("0x2345381685aa0Ed446c0A05ee026fb25799BCaED", web3j, credentials, new GasProvider());
    }

    public AuthorityLogic getAuthority() {
        return AuthorityLogic.load(ConfigCache.get().getAuthorityLogicAddress(), web3j, credentials, new GasProvider());
    }public ChargeLogic getCharge() {
        return ChargeLogic.load(ConfigCache.get().getChargeLogicAddress(), web3j, credentials, new GasProvider());
    }public DDC1155 getDDC1155() {
        return DDC1155.load(ConfigCache.get().getDdc1155Address(), web3j, credentials, new GasProvider());
    }public DDC721 getDDC721() {
        return DDC721.load(ConfigCache.get().getDdc721Address(), web3j, credentials, new GasProvider());
    }public Web3j getWeb3j() { return web3j; }
}
