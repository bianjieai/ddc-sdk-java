package ai.bianjie.ddc;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.dto.AccountInfo;
import ai.bianjie.ddc.service.*;
import ai.bianjie.ddc.util.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public class DDCSdkClientTest {
    @Test
    public void sdkInitTest() throws Exception {
        DDCSdkClient client = new DDCSdkClient.Builder("").gasLimit("22").init();
        AuthorityService authorityService = client.getAuthorityService();
        authorityService.addAccount("","","");

    }
}