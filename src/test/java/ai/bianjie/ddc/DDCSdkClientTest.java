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
//        DDCSdkClient client = new DDCSdkClient("http://192.168.150.43:8545");
//        client.init("B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26");

//        AuthorityService authorityService = client.getAuthorityService();
//        TransactionReceipt a= authorityService.addOperator("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A","test","did:bsn:3wxYHXwAm57grc9JUr2zrPHt9HC");
//        System.out.println("--------------------------------------"+a+"------------");

//        client.init("B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26");
//        AuthorityService authorityService = client.getAuthorityService();
//        String pt = authorityService.addAccount("918F7F275A6C2D158E5B76F769D3F1678958A334","pt1","did:bsn:3qwYHXwAm57grc9JUr2zrPHt9HCv");
//        System.out.println("--------------------------------------"+ pt +"------------");

//        client.init("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
//        AuthorityService authorityService = client.getAuthorityService();
//        String zd1 = authorityService.addAccount("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC","zd1","did:bsn:3qwYHXwAq57grc9JUr2zrPHt9HC");
//        System.out.println("--------------------------------------"+ zd1 +"------------");

//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        AuthorityService authorityService = client.getAuthorityService();
//        String zd2 = authorityService.addConsumerByOperator("59F2175B2380AAA12F512360D43CBD77B7841A51","zd2","did:bsn:3qwYHXwAq57grc9JUr2zjPHt9HC","did:bsn:3qwYHXwAm57grc9JUr2zrPHt9HC");
//        System.out.println("--------------------------------------"+ zd2 +"------------");

//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        AuthorityService authorityService = client.getAuthorityService();
//        String yyy = authorityService.getAccount("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------"+ yyy +"------------");
//        String ypt = authorityService.getAccount("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------"+ ypt +"------------");
//        String yzd = authorityService.getAccount("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------"+ yzd +"------------");

//        client.init("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
//        AuthorityService authorityService = client.getAuthorityService();
//        String pyy = authorityService.getAccount("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------"+ pyy +"------------");
//        String ppt = authorityService.getAccount("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------"+ ppt +"------------");
//        String pzd = authorityService.getAccount("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------"+ pzd +"------------");

//        client.init("1B8C36A57CB8D7FA20594283498EF310DCA9DFECDF6E9FDD04E992A5DA164E0B");
//        AuthorityService authorityService = client.getAuthorityService();
//        String zyy = authorityService.getAccount("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------"+ zyy +"------------");
//        String zpt = authorityService.getAccount("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------"+ zpt +"------------");
//        String zzd = authorityService.getAccount("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------"+ zzd +"------------");

//        client.init("B78DFAE7BC5AD6533004438D20D331C7B8C2FDD69340E7998DFB8D672E428A26");
//        AuthorityService authorityService = client.getAuthorityService();
//        TransactionReceipt a= authorityService.addOperator("6F561802FDAD741EDA7254C3F5651DAAAB266A90","test01","did:bsn:3zjYHXwAm57grc9JUr2zrPHt9HC");
//        System.out.println("--------------------------------------"+a+"------------");


//        client.init("83DF11A2E876A96ABC073AAEAC89A84732B5210BED0E913BAE96CAD7DA768B43");
//        AuthorityService authorityService = client.getAuthorityService();
//        String yupy = authorityService.updateAccState("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A",new BigInteger("1"),false);
//        System.out.println("--------------------------------------"+ yupy +"------------");
//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        AuthorityService authorityService = client.getAuthorityService();
//        String yupp = authorityService.updateAccState("918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("1"),false);
//        System.out.println("--------------------------------------"+ yupp +"------------");
//        String yupz = authorityService.updateAccState("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC",new BigInteger("1"),true);
//        System.out.println("--------------------------------------"+ yupz +"------------");

//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        ChargeService chargeService = client.getChargeService();
//        String balancey =chargeService.balanceOf("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------" + balancey + "------------");
//        String balancep =chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------" + balancep + "------------");
//        String balancez1 =chargeService.balanceOf("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------" + balancez1 + "------------");

//        client.init("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
//        ChargeService chargeService = client.getChargeService();
//        String pbalancey =chargeService.balanceOf("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------" + pbalancey + "------------");
//        String pbalancep =chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------" + pbalancep + "------------");
//        String pbalancez1 =chargeService.balanceOf("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------" + pbalancez1 + "------------");

//        client.init("1B8C36A57CB8D7FA20594283498EF310DCA9DFECDF6E9FDD04E992A5DA164E0B");
//        ChargeService chargeService = client.getChargeService();
//        String zbalancey =chargeService.balanceOf("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------" + zbalancey + "------------");
//        String zbalancep =chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------" + zbalancep + "------------");
//        String zbalancez1 =chargeService.balanceOf("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------" + zbalancez1 + "------------");

//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        ChargeService chargeService = client.getChargeService();
//        String hashy =chargeService.recharge("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A",BigInteger.valueOf(10000));
//        System.out.println("--------------------------------------" + hashy + "------------");
//        String hashp =chargeService.recharge("918F7F275A6C2D158E5B76F769D3F1678958A334",BigInteger.valueOf(10000));
//        System.out.println("--------------------------------------" + hashp + "------------");
//        String hashz1 =chargeService.recharge("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC",BigInteger.valueOf(10000));
//        System.out.println("--------------------------------------" + hashz1 + "------------");
//        String zbalancey =chargeService.balanceOf("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------" + zbalancey + "------------");
//        String zbalancep =chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------" + zbalancep + "------------");
//        String zbalancez1 =chargeService.balanceOf("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------" + zbalancez1 + "------------");


//        client.init("1B8C36A57CB8D7FA20594283498EF310DCA9DFECDF6E9FDD04E992A5DA164E0B");
//        ChargeService chargeService = client.getChargeService();
//        AuthorityService au =client.getAuthorityService();
//        String hash =chargeService.selfRecharge(BigInteger.valueOf(1000000000));
//        System.out.println("--------------------------------------" + hash + "------------");
//        String balance =chargeService.balanceOf("8A853214BD4AEADEF6351FBFEC5E4B7A3E65703A");
//        System.out.println("--------------------------------------" + balance + "------------");
//        String hashy =chargeService.recharge("918F7F275A6C2D158E5B76F769D3F1678958A334",BigInteger.valueOf(10000));
//        System.out.println("--------------------------------------" + hashy + "------------");
//        String balance =chargeService.balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("--------------------------------------" + balance + "------------");
//        String hashy =chargeService.recharge("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC",BigInteger.valueOf(10000));
//        System.out.println("--------------------------------------" + hashy + "------------");
//        String balance =chargeService.balanceOf("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println("--------------------------------------" + balance + "------------");

//           String ha = au.addFunction(BigInteger.valueOf(2),ConfigCache.get().getDdc721Address(),new byte[]{-48,-34,-11,33}) ;
//         String hash =chargeService.delFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_MINT);
//       System.out.println("--------------------------------------" + hash + "------------");
//       String hash1 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_MINT,BigInteger.valueOf(10));
//       String hash2 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_APPROVE,BigInteger.valueOf(10));
//       String hash3 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_GETAPPROVED,BigInteger.valueOf(10));
//       String hash4 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_ISAPPROVEDFORALL,BigInteger.valueOf(10));
//       String hash5 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_SETAPPROVALFORALL,BigInteger.valueOf(10));
//       String hash6 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_BALANCEOF,BigInteger.valueOf(10));
//       String hash7 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_BURN,BigInteger.valueOf(10));
//       String hash8 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_DDCURI,BigInteger.valueOf(10));
//       String hash9 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_FREEZE,BigInteger.valueOf(10));
//       String hash10 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_UNFREEZE,BigInteger.valueOf(10));
//       String hash11 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_SYMBOL,BigInteger.valueOf(10));
//       String hash12 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_NAME,BigInteger.valueOf(10));
//       String hash13 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_TRANSFERFROM,BigInteger.valueOf(10));
//       String hash14 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_SAFETRANSFERFROM,BigInteger.valueOf(10));
//       String hash15 =chargeService.setFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_OWNEROF,BigInteger.valueOf(10));
//        DDC721Service dd = client.getDDC721Service();
//        String hash = dd.mint("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC","qqqqqq")   ;
//        System.out.println("--------------------------------------" + hash + "------------");
//          BigInteger hash =chargeService.queryFee(ConfigCache.get().getDdc721Address(), DDC721.FUNC_MINT);
//          System.out.println("--------------------------------------" + hash + "------------");
//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        AuthorityService authorityService = client.getAuthorityService();
//        String re = authorityService.addFunction(BigInteger.valueOf(1), ConfigCache.get().getDdc721Address(), DDC721.FUNC_MINT.getBytes());
//        System.out.println("--------------------------------------" + re + "------------");


//        client.init("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
//      AuthorityService authorityService = client.getAuthorityService();
//
//        DDC721Service ddc721Service = client.getDDC721Service();
////      String h = authorityService.hasper("918F7F275A6C2D158E5B76F769D3F1678958A334",ConfigCache.get().getDdc721Address(),DDC721.FUNC_MINT.getBytes())    ;
//        String hash = ddc721Service.mint("07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC","111111")     ;
//        System.out.println("--------------------------------------" + hash + "------------");

        DDCSdkClient client = new DDCSdkClient.Builder("http://192.168.150.43:8545").credentials("").gasLimit("30000").gasPrice("100000000000").init();

//        DDCSdkClient client = new DDCSdkClient("http://192.168.150.43:8545");
//        client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
//        AccountInfo info = client.getAuthorityService().getAccount("0x07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC");
//        System.out.println(info.toString());
//
//        String s = client.getAuthorityService().updateAccState("0x07B7BE76ED588CCEFB4C4A573CB28A7D2A1403CC", BigInteger.valueOf((long) 1), true);
//        System.out.println(s);
    }
}