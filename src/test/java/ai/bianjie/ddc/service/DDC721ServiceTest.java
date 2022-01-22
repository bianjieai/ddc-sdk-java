package ai.bianjie.ddc.service;

import ai.bianjie.ddc.DDCSdkClient;
import ai.bianjie.ddc.listener.sign;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class DDC721ServiceTest {

    DDCSdkClient client = new DDCSdkClient.Builder()
            .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
            .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
            .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
            .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
            .setGasLimit("300000")
            .setGasPrice("10000000")
            .setSignEventListener(new sign())
            .init();

    DDC721Service ddc721Service = client.getDDC721Service();

    String sender="";

    @Test
    void mint() throws Exception {
        System.out.println(ddc721Service.mint(sender,"0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721","11111"));
    }

    @Test
    void approve() throws Exception {
        System.out.println(ddc721Service.approve(sender,"6F561802FDAD741EDA7254C3F5651DAAAB266A90",new BigInteger("11")));
    }

    @Test
    void getApproved() throws Exception {
        System.out.println(ddc721Service.getApproved(new BigInteger("2")));
    }

    @Test
    void setApprovalForAll() throws Exception {
        System.out.println(ddc721Service.setApprovalForAll(sender,"6F561802FDAD741EDA7254C3F5651DAAAB266A90",true));
    }

    @Test
    void isApprovedForAll() throws Exception {
        System.out.println(ddc721Service.isApprovedForAll("0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721","6F561802FDAD741EDA7254C3F5651DAAAB266A90"));
    }

    @Test
    void safeTransferFrom() throws Exception {
        System.out.println(ddc721Service.safeTransferFrom(sender,"","",new BigInteger("2"),new byte[]{}));
    }

    @Test
    void transferFrom() throws Exception {
        System.out.println(ddc721Service.transferFrom(sender,"","",new BigInteger("2")));
    }

    @Test
    void freeze() throws Exception {
        System.out.println(ddc721Service.freeze(sender,new BigInteger("2")));
    }

    @Test
    void unFreeze() throws Exception {
        System.out.println(ddc721Service.unFreeze(sender,new BigInteger("2")));
    }

    @Test
    void burn() throws Exception {
        System.out.println(ddc721Service.burn(sender,new BigInteger("4")));
    }

    @Test
    void balanceOf() throws Exception {
        System.out.println(ddc721Service.balanceOf("0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721"));
    }

    @Test
    void ownerOf() throws Exception {
        System.out.println(ddc721Service.ownerOf(new BigInteger("2")));
    }

    @Test
    void name() throws Exception {
        System.out.println(ddc721Service.name());
    }

    @Test
    void symbol() throws Exception {
        System.out.println(ddc721Service.symbol());
    }

    @Test
    void ddcURI() throws Exception {
        System.out.println(ddc721Service.ddcURI(new BigInteger("1")));
    }
}