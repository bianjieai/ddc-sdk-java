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

//        DDCSdkClient client = new DDCSdkClient("http://192.168.150.43:8545");
//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");

//        TestService testService = new TestService();
//        testService.test();

//        AccountInfo info = client.getAuthorityService().getAccount("0x07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println(info.toString());
//
//        String s = client.getAuthorityService().updateAccState("0x07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC", BigInteger.valueOf((long) 1), true);
//        System.out.println(s);
    }
}