package ai.bianjie.ddc;
import ai.bianjie.ddc.service.AuthorityService;
import org.junit.jupiter.api.Test;

public class DDCSdkClientTest {
    @Test
    public void sdkInitTest() throws Exception {
        //http://192.168.150.43:8545测试网地址
        DDCSdkClient client = new DDCSdkClient("http://192.168.150.43:8545");
        //B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26，测试账户私钥
        client.init("B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26");
//        AuthorityService authorityService = client.getAuthorityService();
//        authorityService.getAccount("1DFD9E10AA5244591ABE8FA4B0750B4B98D4F89D");

        System.out.println("--------------------------------------");

    }
}