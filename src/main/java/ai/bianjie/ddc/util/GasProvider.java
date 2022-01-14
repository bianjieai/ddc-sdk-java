package ai.bianjie.ddc.util;

import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.AuthorityFunctions;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GasProvider implements ContractGasProvider {
    //默认值
    private String gasPrice = ConfigCache.get().getGasPrice();
    private String gasLimit = ConfigCache.get().getGasLimit();
    //自定义值
    private String customerGaslimit;

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
        if(ConfigCache.get().getCustomerGasLimit().equals("0")){
            CommonUtils.string2BigInteger(this.gasLimit);
        }
        return CommonUtils.string2BigInteger(ConfigCache.get().getCustomerGasLimit());
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
