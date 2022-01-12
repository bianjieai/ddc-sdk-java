package ai.bianjie.ddc;


import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.constant.ErrorMessage;
import ai.bianjie.ddc.exception.DDCException;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.service.*;

public class DDCSdkClient {
    private String opbGateWebAddress;
    private String credentials;
    private String gasPrice;
    private String gasLimit;
    private String ddc721Address;
    private String ddc1155Address;
    private String authorityLogicAddress;
    private String chargeLogicAddress;

    /**
     * SDK 初始化方法
     */
    private DDCSdkClient(Builder builder) {
        this.opbGateWebAddress = builder.opbGateWebAddress;
        this.credentials = builder.credentials;
        this.gasPrice = builder.gasPrice;
        this.gasLimit = builder.gasLimit;
        this.ddc721Address = builder.ddc721Address;
        this.ddc1155Address = builder.ddc1155Address;
        this.authorityLogicAddress = builder.authorityLogicAddress;
        this.chargeLogicAddress = builder.chargeLogicAddress;
    }

    public static class Builder {
        private String opbGateWebAddress;
        private String credentials;
        private String gasPrice;
        private String gasLimit;
        private String ddc721Address;
        private String ddc1155Address;
        private String authorityLogicAddress;
        private String chargeLogicAddress;

        public Builder(String opbGateWebAddress) {
            this.opbGateWebAddress = opbGateWebAddress;
        }

        public Builder credentials(String credentials) {
            this.credentials = credentials;
            return this;
        }

        public Builder gasPrice(String gasPrice) {
            this.gasPrice = gasPrice;
            return this;
        }

        public Builder gasLimit(String gasLimit) {
            this.gasLimit = gasLimit;
            return this;
        }

        public Builder ddc721Address(String ddc721Address) {
            this.ddc721Address = ddc721Address;
            return this;
        }

        public Builder ddc1155Address(String ddc1155Address) {
            this.ddc1155Address = ddc1155Address;
            return this;
        }

        public Builder authorityLogicAddress(String authorityLogicAddress) {
            this.authorityLogicAddress = authorityLogicAddress;
            return this;
        }

        public Builder chargeLogicAddress(String chargeLogicAddress) {
            this.chargeLogicAddress = chargeLogicAddress;
            return this;
        }

        public DDCSdkClient init() {
            ConfigCache.initCache(opbGateWebAddress, credentials, gasPrice, gasLimit, ddc721Address, ddc1155Address, authorityLogicAddress, chargeLogicAddress);
            return new DDCSdkClient(this);
        }
    }

    private SignEventListener signEventListener;

    /**
     * SDK注册全局的签名事件，所有发起的交易将通过此事件进行签名处理
     *
     * @param signEventListener 签名事件
     */
    public void registerSignListener(SignEventListener signEventListener) {
        if(signEventListener == null) {
            throw new DDCException(ErrorMessage.NO_SIGN_EVENT_LISTNER);
        }
        this.signEventListener = signEventListener;
    }

    /**
     * 获取权限管理服务的示例
     *
     * @return 返回权限管理服务的实例
     */
    public AuthorityService getAuthorityService() {
        return new AuthorityService(signEventListener);
    }

    /**
     * 获取费用管理服务的实例
     *
     * @return 返回费用管理服务的实例
     */
    public ChargeService getChargeService() {
        return new ChargeService(signEventListener);
    }

    /**
     * 获取BSN-DDC-1155合约服务的实例
     *
     * @return 返回BSN-DDC-1155合约服务的实例
     */
    public DDC1155Service getDDC1155Service() {
        return new DDC1155Service(signEventListener);
    }

    /**
     * 获取BSN-DDC-721合约服务的实例
     *
     * @return 返回BSN-DDC-721合约服务的实例
     */
    public DDC721Service getDDC721Service() {
        return new DDC721Service(signEventListener);
    }

}
