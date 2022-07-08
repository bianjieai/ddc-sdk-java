package ai.bianjie.ddc.client;


import ai.bianjie.ddc.config.ClientConfig;
import ai.bianjie.ddc.config.OpbConfig;
import ai.bianjie.ddc.key.KeyManager;

public class DDCSdkClient extends IritaClient {
    public DDCSdkClient(ClientConfig clientConfig, OpbConfig opbConfig, KeyManager km) {
        super(clientConfig, opbConfig, km);
    }
}
