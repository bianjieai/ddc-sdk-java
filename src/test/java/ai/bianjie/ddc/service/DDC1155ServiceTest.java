package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.listener.sign;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DDC1155ServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc")
            .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
            .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
            .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
            .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();

    DDC1155Service ddc1155Service = client.getDDC1155Service();
    String sender="";

    @Test
    void mint() throws Exception {
        System.out.println(ddc1155Service.mint(sender,"918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("3"),"222222"));
    }

    @Test
    void mintBatch() throws Exception {
        Multimap<BigInteger, String> ddcInfo = ArrayListMultimap.create();;
        ddcInfo.put(new BigInteger("3"),"12");
        System.out.println(ddc1155Service.mintBatch(sender,"918F7F275A6C2D158E5B76F769D3F1678958A334",ddcInfo));
    }

    @Test
    void setApprovalForAll() throws Exception {
        System.out.println(ddc1155Service.setApprovalForAll(sender,"918F7F275A6C2D158E5B76F769D3F1678958A334", true));
    }

    @Test
    void isApprovedForAll() throws Exception {
        System.out.println(ddc1155Service.isApprovedForAll(sender,"0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721","918F7F275A6C2D158E5B76F769D3F1678958A334"));
    }

    @Test
    void safeTransferFrom() {
    }

    @Test
    void safeBatchTransferFrom() {
    }

    @Test
    void freeze() {

    }

    @Test
    void unFreeze() {

    }

    @Test
    void burn() {
//        System.out.println(ddc1155Service.burn("",new BigInteger("2")));
    }

    @Test
    void burnBatch() {
//        System.out.println(ddc1155Service.burnBatch("",new BigInteger("2")));
    }

    @Test
    void balanceOf() throws Exception {
        System.out.println(ddc1155Service.balanceOf(sender,"918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("2")));
    }

    @Test
    void balanceOfBatch() throws Exception {
        Multimap<String, BigInteger> ddcs = ArrayListMultimap.create();;
        ddcs.put("918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("3"));
        ddcs.put("918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("5"));
        List<BigInteger> a = new ArrayList<>(2);
        a = ddc1155Service.balanceOfBatch(sender,ddcs);
        System.out.println(a);
    }

    @Test
    void ddcURI() throws Exception {
        System.out.println(ddc1155Service.ddcURI(sender,new BigInteger("3")));
    }
}