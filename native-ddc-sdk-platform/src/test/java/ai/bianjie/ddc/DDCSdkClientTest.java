package ai.bianjie.ddc;

import ai.bianjie.ddc.client.DDCSdkClient;
import ai.bianjie.ddc.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DDCSdkClientTest extends ConfigTest {
    private DDCSdkClient client;

    @BeforeEach
    public void init() {
        client = getTestClient();
    }

    @Test
    @Disabled
    public void queryAccount() {
        String addr = "iaa1ytemz2xqq2s73ut3ys8mcd6zca2564a5lfhtm3";
        Account account = client.getBaseClient().queryAccount(addr);
        assertEquals(addr, account.getAddress());
    }
}
