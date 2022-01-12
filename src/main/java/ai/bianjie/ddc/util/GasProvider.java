package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigCache;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

public class GasProvider implements ContractGasProvider {
    private String gasPrice = ConfigCache.get().getGasPrice();
    private String gasLimit = ConfigCache.get().getGasLimit();

    @Override
    public BigInteger getGasPrice(String s) {
        return CommonUtils.string2BigInteger(this.gasPrice);
    }

    @Override
    public BigInteger getGasPrice() {
        return CommonUtils.string2BigInteger(this.gasPrice);
    }

    @Override
    public BigInteger getGasLimit(String s) {
        return CommonUtils.string2BigInteger(this.gasLimit);
    }

    @Override
    public BigInteger getGasLimit() {
        return CommonUtils.string2BigInteger(this.gasLimit);
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }
}
