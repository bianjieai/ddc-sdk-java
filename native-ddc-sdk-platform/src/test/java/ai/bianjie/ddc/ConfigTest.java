package ai.bianjie.ddc;

import ai.bianjie.ddc.client.DDCSdkClient;
import ai.bianjie.ddc.config.ClientConfig;
import ai.bianjie.ddc.config.OpbConfig;
import ai.bianjie.ddc.exception.IritaSDKException;
import ai.bianjie.ddc.key.KeyManager;
import ai.bianjie.ddc.key.KeyManagerFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigTest {
    public static Properties getTestConfig() {
        Properties properties = new Properties();
        BufferedReader buf = null;
        try {
            buf = new BufferedReader(new FileReader("src/test/resources/config.properties"));
            properties.load(buf);
            return properties;
        } catch (Exception e) {
            throw new IritaSDKException("read test config failed");
        }
    }

    public DDCSdkClient getTestClient() {
        Properties properties = ConfigTest.getTestConfig();
        String mnemonic = properties.getProperty("mnemonic");
        KeyManager km = KeyManagerFactory.createDefault();
        km.recover(mnemonic);

        String nodeUri = properties.getProperty("node_uri");
        String grpcAddr = properties.getProperty("grpc_addr");
        String chainId = properties.getProperty("chain_id");
        String wsAddr = properties.getProperty("ws_addr");
        String projectId = properties.getProperty("project_id");
        String projectKey = properties.getProperty("project_key");

        ClientConfig clientConfig = new ClientConfig(nodeUri, grpcAddr, chainId, wsAddr);
        OpbConfig opbConfig = null;
        if (StringUtils.isNotEmpty(projectId)) {
            opbConfig = new OpbConfig(projectId, projectKey, "");
            opbConfig.setEnableTLS(true);
        }

        DDCSdkClient client = new DDCSdkClient(clientConfig, opbConfig, km);
        assertEquals(properties.getProperty("address"), km.getCurrentKeyInfo().getAddress());
        return client;
    }
}
