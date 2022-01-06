package ai.bianjie.ddc;
import ai.bianjie.ddc.service.Adata;
import ai.bianjie.ddc.service.ChargeService;
import ai.bianjie.ddc.service.AuthorityService;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class DDCSdkClientTest {
    @Test
    public void sdkInitTest() throws Exception {
        //测试网地址http://127.0.0.1:8545
        DDCSdkClient client = new DDCSdkClient("http://127.0.0.1:8545");
        //B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26，测试账户私钥
        client.init("E0DC7EB0A31946737D381C5DBBD196E448DDAECD368BBC2802C104B074481B45");
//        AuthorityService authorityService = client.getAuthorityService();
//        authorityService.getAccount("1DFD9E10AA5244591ABE8FA4B0750B4B98D4F89D");

//        ChargeService chargeService = client.getChargeService();
//        String ba=chargeService.balanceOf("308611AF1CFABE10A66763B0900C8086EE946DC9");
//        System.out.println("--------------------------------------"+ba+"------------");

        Adata da = client.getad();
        TransactionReceipt re = da.setAuthorityLogicContractAddr("0xb0983a0dD117a6574E70739963336149033f8b30");
        System.out.println("--------------------------------------"+re.toString()+"------------");
    }
}