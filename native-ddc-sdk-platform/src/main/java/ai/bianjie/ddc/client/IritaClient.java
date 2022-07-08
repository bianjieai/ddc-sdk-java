package ai.bianjie.ddc.client;

import ai.bianjie.ddc.config.ClientConfig;
import ai.bianjie.ddc.config.OpbConfig;
import ai.bianjie.ddc.key.KeyManager;
import ai.bianjie.ddc.module.bank.BankClient;
import ai.bianjie.ddc.module.community_gov.CommunityGovClient;
import ai.bianjie.ddc.module.feegrant.FeeGrantClient;
import ai.bianjie.ddc.module.identity.IdentityClient;
import ai.bianjie.ddc.module.nft.NftClient;
import ai.bianjie.ddc.module.perm.PermClient;
import ai.bianjie.ddc.module.record.RecordClient;
import ai.bianjie.ddc.module.service.ServiceClient;
import ai.bianjie.ddc.module.tibc.TibcClient;
import ai.bianjie.ddc.module.wasm.WasmClient;

public class IritaClient {
    private BaseClient baseClient;
    private NftClient nftClient;
    private BankClient bankClient;
    private PermClient permClient;
    private TibcClient tibcClient;
    private IdentityClient identityClient;
    private RecordClient recordClient;
    private WasmClient wasmClient;
    private CommunityGovClient comGovClient;
    private ServiceClient serviceClient;
    private FeeGrantClient feeGrantClient;

    private IritaClient() {
    }

    public IritaClient(ClientConfig clientConfig, OpbConfig opbConfig, KeyManager km) {
        BaseClient baseClient = new BaseClient(clientConfig, opbConfig, km);
        this.baseClient = baseClient;
        this.nftClient = new NftClient(baseClient);
        this.bankClient = new BankClient(baseClient);
        this.permClient = new PermClient(baseClient);
        this.tibcClient = new TibcClient(baseClient);
        this.identityClient = new IdentityClient(baseClient);
        this.recordClient = new RecordClient(baseClient);
        this.wasmClient = new WasmClient(baseClient);
        this.comGovClient = new CommunityGovClient(this.wasmClient);
        this.serviceClient = new ServiceClient(baseClient);
        this.feeGrantClient = new FeeGrantClient(baseClient);
    }

    public BaseClient getBaseClient() {
        return baseClient;
    }

    public IritaClient setBaseClient(BaseClient baseClient) {
        this.baseClient = baseClient;
        return this;
    }

    public NftClient getNftClient() {
        return nftClient;
    }

    public IritaClient setNftClient(NftClient nftClient) {
        this.nftClient = nftClient;
        return this;
    }

    public BankClient getBankClient() {
        return bankClient;
    }

    public IritaClient setBankClient(BankClient bankClient) {
        this.bankClient = bankClient;
        return this;
    }

    public PermClient getPermClient() {
        return permClient;
    }

    public void setPermClient(PermClient permClient) {
        this.permClient = permClient;
    }

    public TibcClient getTibcClient() {
        return tibcClient;
    }

    public IritaClient setTibcClient(TibcClient tibcClient) {
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

    public IritaClient setRecordClient(RecordClient recordClient) {
        this.recordClient = recordClient;
        return this;
    }


    public WasmClient getWasmClient() {
        return wasmClient;
    }

    public IritaClient setWasmClient(WasmClient wasmClient) {
        this.wasmClient = wasmClient;
        return this;
    }


    public CommunityGovClient getComGovClient() {
        return comGovClient;
    }

    public IritaClient setComGovClient(CommunityGovClient comGovClient) {
        this.comGovClient = comGovClient;
        return this;
    }


    public ServiceClient getServiceClient() {
        return serviceClient;
    }

    public IritaClient setServiceClient(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
        return this;
    }

    public FeeGrantClient getFeeGrantClient() {
        return feeGrantClient;
    }

    public void setFeeGrantClient(FeeGrantClient feeGrantClient) {
        this.feeGrantClient = feeGrantClient;
    }
}
