
## [v0.1.3](https://github.com/bianjieai/ddc-sdk-java/releases/tag/v0.1.3)

***2022-07-01***

### 优化

- 新增离线维护 Nonce 方法：<service>.setNonce(txNonce)

### 背景

近日文昌链很多用户反馈发送 DDC 交易时由于 Nonce 错误导致交易失败的情况，根据 [以太坊 Web3J](https://docs.web3j.io/4.8.7/transactions/transaction_nonce/) 的描述：一个 Nonce 只能被一笔交易使用一次，直到该交易在链上被确认。

而随着业务量的爆发，很多业务需要使用「单一」链账户，在一个区块内发送多笔交易，于是就造成了上一笔交易还没有被链上确认，下一笔交易就使用了相同的 Nonce，导致被区块链拒绝执行。

这时候可以通过「离线维护 Nonce」的方案，避免相同的 Nonce 被重复使用，文昌链 DDC-SDK 为此提供了更便捷的方法。

### 代码示例

```java
    void nonceTest() throws Exception {

	// 初始化 DDC 客户端      
        DDCSdkClient client = new DDCSdkClient.Builder()
                .setAuthorityLogicAddress("0xFa1d2d3EEd20C4E4F5b927D9730d9F4D56314B29") // 官方合约地址
                .setChargeLogicAddress("0x0B8ae0e1b4a4Eb0a0740A250220eE3642d92dc4D") // 官方合约地址
                .setDDC721Address("0x354c6aF2cB870BEFEA8Ea0284C76e4A46B8F2870") // 官方合约地址
                .setDDC1155Address("0x0E762F4D11439B1130D402995328b634cB9c9973") // 官方合约地址
                .setGasLimit("300000") // 自定义 Gas 上限
                .setGasPrice("1") // 固定 Gas Price，无需修改
                .setSignEventListener(new SignEventTest()) // 签名事件示例，建议参考示例自行实现
                .init();

        client.setGatewayUrl("https://opbningxia.bsngate.com:18602/api/项目ID/evmrpc"); // EVM RPC 地址
        client.setConnectTimeout(20);// 请求超时时间，自定义
        String sender = "平台方链账户地址"; // 平台方链账户地址

      	// 以充值接口为例
        ChargeService chargeService = client.getChargeService();

        // 链上查询最新的 Nonce
        EthGetTransactionCount ethGetTransactionCount = Web3jUtils.getWeb3j().ethGetTransactionCount(sender, DefaultBlockParameterName.PENDING).sendAsync().get();
        BigInteger txNonce = ethGetTransactionCount.getTransactionCount();

      	// 循环调用，每调用一次 Nonce 离线加一，不需要重新从链上查询
        for (int i = 1; i < 10; i++) {
            // 设置 Nonce
            chargeService.setNonce(txNonce); 
            // 发送请求
            String hash = chargeService.recharge(sender, "被充值的链账户地址", new BigInteger("充值业务费数量"));
            // Nonce 离线加一
            txNonce = txNonce.add(new BigInteger("1"));
        }
    }
```


