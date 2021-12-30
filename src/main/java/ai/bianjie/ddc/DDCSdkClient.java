package ai.bianjie.ddc;


import ai.bianjie.ddc.config.ConfigCache;
import ai.bianjie.ddc.listener.SignEventListener;
import ai.bianjie.ddc.service.AuthorityService;
import ai.bianjie.ddc.service.ChargeService;
import ai.bianjie.ddc.service.DDC1155Service;
import ai.bianjie.ddc.service.DDC721Service;

public class DDCSdkClient {
    private String opbGateWebAddress;

    private SignEventListener signEventListener;

    public DDCSdkClient(String opbGateWebAddress){ this.opbGateWebAddress=opbGateWebAddress; }
    /**
     * SDK 初始化方法，在此方法中解析SDK的配置文件，并且放到程序缓存中。
     * 四个地址可以传入自定义参数，传入将被使用，否则使用默认地址
     *
     */
    public void init(String credentials, String gasPrice, String gasLimit){
        ConfigCache.initCache(opbGateWebAddress,credentials,gasPrice,gasLimit,null,null,null,null);
    }
    public void init(String credentials, String gasPrice, String gasLimit, String ddc721Address, String ddc1155Address, String authorityLogicAddress, String chargeLogicAddress){
        ConfigCache.initCache(opbGateWebAddress,credentials,gasPrice,gasLimit,ddc721Address,ddc1155Address,authorityLogicAddress,chargeLogicAddress);
    }

    /**
     * SDK注册全局的签名事件，所有发起的交易将通过此事件进行签名处理
     *
     * @param signEventListener 签名事件
     */
    public void registerSignListener(SignEventListener signEventListener) {
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
