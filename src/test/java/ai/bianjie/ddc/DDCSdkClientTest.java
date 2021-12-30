package ai.bianjie.ddc;

import ai.bianjie.ddc.service.AuthorityService;

public class DDCSdkClientTest {
   // @Test
    public void sdkInitTest() throws Exception {
        DDCSdkClient client = new DDCSdkClient("http://192.168.31.47:8080");
        client.init("","","");
        AuthorityService authorityService = client.getAuthorityService();
        String s = authorityService.addAccount("","","");
        System.out.println(s);
        //0x629D3dBe479e4c72Bed306fE3FAE96bEc4335848
        //EE57139E049E4A6E6D71DE6988B5A65FEEE899CAAAE28DBE6DF31563C541798B
    }
}
