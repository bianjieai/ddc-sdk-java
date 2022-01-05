package ai.bianjie.ddc;

import ai.bianjie.ddc.service.ChargeService;
import org.junit.jupiter.api.Test;

public class DDCSdkClientTest {
   @Test
    public void sdkInitTest() throws Exception {
        DDCSdkClient client = new DDCSdkClient("http://192.168.31.47:8545");
        client.init("FAAA797E663FA08C8DAA3972ED1FA42448AC0334FF4AAFB3C8892987D12E55C2","10","3000000000");
        ChargeService authorityService = client.getChargeService();
        String s = authorityService.balanceOf("FAAA797E663FA08C8DAA3972ED1FA42448AC0334FF4AAFB3C8892987D12E55C2");
        System.out.println(s);
        //0x629D3dBe479e4c72Bed306fE3FAE96bEc4335848
        //EE57139E049E4A6E6D71DE6988B5A65FEEE899CAAAE28DBE6DF31563C541798B
    }
}
