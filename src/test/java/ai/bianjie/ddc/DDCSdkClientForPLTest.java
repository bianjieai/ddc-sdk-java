package ai.bianjie.ddc;

import ai.bianjie.ddc.dto.txInfo;
import ai.bianjie.ddc.listener.sign;
import ai.bianjie.ddc.service.BaseService;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

class DDCSdkClientForPLTest {

    @Test
    public void sdkInitTest() throws Exception {
//        DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc").authorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a").chargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7").ddc721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7").ddc1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708").gasLimit("300000").gasPrice("10000000").init();
//        SignEventListener signEventListener = new sign();
//        client.registerSignListener(signEventListener);
//        String a = client.getChargeService().recharge("918F7F275A6C2D158E5B76F769D3F1678958A334",new BigInteger("10"));
//        System.out.println("================================"+a);
//        BigInteger b = client.getChargeService().setGasLimitCharge("1").balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("========================"+b);

        DDCSdkClientForPL client = new DDCSdkClientForPL.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc")
                .setAuthorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a")
                .setChargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7")
                .setDDC721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7")
                .setDDC1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708")
                .setGasLimit("300000")
                .setGasPrice("10000000")
                .setSignEventListener(new sign())
                .init();

//        String a = client.getChargeService().setFee("0x2A14331F1f2D3BA0D750f4c4916E69B1DC38d721","0x52403cE9E235Cf013bA2353F0bf47834C98424c7","0x36351c7c", new BigInteger("10"));
//        System.out.println("================================" + a);
//        Account acc = client.getAuthorityService().createAccount();
//        System.out.println("================================" + acc);
//        BigInteger b = client.getChargeService().setGasLimitCharge("1").balanceOf("918F7F275A6C2D158E5B76F769D3F1678958A334");
//        System.out.println("========================"+b);

        BaseService baseService = new BaseService();
        TransactionReceipt a = baseService.getTransReceipt("0x4b286a32b43e3bf07e9b4967573871bf1eec808f33c577581c6f9f4620a3097e");
        System.out.println("================================" + a);
        EthBlock.Block b = baseService.getBlockByNumber(new BigInteger("2884"));
        System.out.println("================================" + b);
        txInfo c = baseService.getTransByHash("0x4b286a32b43e3bf07e9b4967573871bf1eec808f33c577581c6f9f4620a3097e");
        System.out.println("================================" + c);

    }
}