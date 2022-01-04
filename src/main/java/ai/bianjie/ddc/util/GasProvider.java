package ai.bianjie.ddc.util;

import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

public class GasProvider implements ContractGasProvider {
    private String gasPrice;
    private String gasLimit;

    public GasProvider(String gasPrice,String gasLimit){

    }


    public BigInteger getGasPrice(String s) {
        //s.check
        //return BigInteger.valueOf(s);
        return BigInteger.valueOf(Long.parseLong("3000"));
    }

    @Override
    public BigInteger getGasPrice() {
        return null;
    }

    @Override
    public BigInteger getGasLimit(String s) {
        //s.check
        //return BigInteger.valueOf(s);
        return BigInteger.valueOf(Long.parseLong("3000000000000000"));
    }

    @Override
    public BigInteger getGasLimit() {
        return null;
    }
}
