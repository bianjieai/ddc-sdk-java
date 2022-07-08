package ai.bianjie.ddc.client;

import ai.bianjie.ddc.config.ClientConfig;
import ai.bianjie.ddc.key.KeyManager;
import ai.bianjie.ddc.module.bank.BankClient;
import ai.bianjie.ddc.module.identity.IdentityClient;
import ai.bianjie.ddc.module.nft.NftClient;
import ai.bianjie.ddc.module.record.RecordClient;
import ai.bianjie.ddc.module.tibc.TibcClient;
import ai.bianjie.ddc.module.wasm.WasmClient;

public class IrisHubClient {
    private BaseClient baseClient;
    private NftClient nftClient;
    private BankClient bankClient;
    private TibcClient tibcClient;
    private IdentityClient identityClient;
    private RecordClient recordClient;
    private WasmClient wasmClient;

    private IrisHubClient() {
    }

    public IrisHubClient(ClientConfig clientConfig, KeyManager km) {
        BaseClient baseClient = new BaseClient(clientConfig, null, km);
        this.baseClient = baseClient;
        this.nftClient = new NftClient(baseClient);
        this.bankClient = new BankClient(baseClient);
        this.tibcClient = new TibcClient(baseClient);
        this.identityClient = new IdentityClient(baseClient);
        this.recordClient = new RecordClient(baseClient);
        this.wasmClient = new WasmClient(baseClient);
    }

    public BaseClient getBaseClient() {
        return baseClient;
    }

    public IrisHubClient setBaseClient(BaseClient baseClient) {
        this.baseClient = baseClient;
        return this;
    }

    public NftClient getNftClient() {
        return nftClient;
    }

    public IrisHubClient setNftClient(NftClient nftClient) {
        this.nftClient = nftClient;
        return this;
    }

    public BankClient getBankClient() {
        return bankClient;
    }

    public IrisHubClient setBankClient(BankClient bankClient) {
        this.bankClient = bankClient;
        return this;
    }

    public TibcClient getTibcClient() {
        return tibcClient;
    }

    public IrisHubClient setTibcClient(TibcClient tibcClient) {
        this.tibcClient = tibcClient;
        return this;
    }

    public IdentityClient getIdentityClient() {
        return identityClient;
    }

    public void setIdentityClient(IdentityClient identityClient) {
        this.identityClient = identityClient;
    }

    public RecordClient getRecordClient() {
        return recordClient;
    }

    public IrisHubClient setRecordClient(RecordClient recordClient) {
        this.recordClient = recordClient;
        return this;
    }


    public WasmClient getWasmClient() {
        return wasmClient;
    }

    public IrisHubClient setWasmClient(WasmClient wasmClient) {
        this.wasmClient = wasmClient;
        return this;
    }
}
