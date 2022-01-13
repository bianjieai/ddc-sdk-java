package ai.bianjie.ddc;
import ai.bianjie.ddc.contract.DDC721;
import ai.bianjie.ddc.dto.AccountInfo;
import ai.bianjie.ddc.service.*;
import ai.bianjie.ddc.util.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DDCSdkClientTest {
    @Test
    public void sdkInitTest() throws Exception {
        DDCSdkClient client = new DDCSdkClient.Builder("").init();
        BlockEventService blockEventService = new BlockEventService();
        ArrayList<BaseEventResponse> blockEvent = blockEventService.getBlockEvent("160506");
        blockEvent.forEach(b->{
            System.out.println(b.log.getTopics());
        });
//        AuthorityService authorityService = client.getAuthorityService();
//        authorityService.addAccount("","","");
    }
}