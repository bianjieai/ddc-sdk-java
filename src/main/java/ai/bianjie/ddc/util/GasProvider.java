package ai.bianjie.ddc.util;

import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

public class GasProvider implements ContractGasProvider {
    @Override
    public BigInteger getGasPrice(String s) {
        return CommonUtils.string2BigInteger("3");
    }

    @Override
    public BigInteger getGasPrice() {
        return CommonUtils.string2BigInteger("3");
    }

    @Override
    public BigInteger getGasLimit(String s) {
        return CommonUtils.string2BigInteger("30000000");
    }

    @Override
    public BigInteger getGasLimit() {
        return CommonUtils.string2BigInteger("30000000");
    }
}
