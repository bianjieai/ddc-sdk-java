# DDC-SDK-JAVA

## 运营方可调用的如下方法：

### 1.初始化Client (连接测试网)

```
    
    //创建客户端，导入网关
    //也可设置相关参数值 gasprice，gaslimit，相关合约地址
    //irita 中 gaslimit 设置值即消耗值，扣费换算：1 uirita = 1e12 wei
    //建议 gaslimit 设置为300000以上，gasprice 设置为10000000以上
    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc").authorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a").chargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7").ddc721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7").ddc1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708").gasLimit("300000").gasPrice("10000000").init();
    
    //注册签名事件
    SignEventListener signEventListener = new sign();
        client.registerSignListener(signEventListener);
    
    //签名处理示例
     public String signEvent(RawTransaction rawTransaction) {
        Credentials credentials = Credentials.create("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        return Numeric.toHexString(signMessage);
    }
    
    //可单独为每个方法设置gaslimit
    AuthorityService authorityService = client.getAuthorityService(); 
    authorityService.setFuncGasLimit("100000")
    String Txhash1 = authorityService。addAccount(account, accName, accDID);
    
```

### 2.BSN-DDC-权限管理

```
    AuthorityService authorityService = client.getAuthorityService(); 
    
    //添加下级账户
    
    //account DDC链账户地址
    //accName DDC账户对应的账户名称
    //accDID  DDC账户对应的DID信息（普通用户可为空）
    //返回交易哈希
    String Txhash1 = authorityService.addAccount(account, accName, accDID);
    
    //添加终端用户
    
    //account   DDC链账户地址
    //accName   DDC账户对应的账户名称
    //accDID    DDC账户对应的DID信息
    //leaderDID 该普通账户对应的上级账户的DID
    //返回交易哈希
    String Txhash2 = authorityService.addConsumerByOperator(account, accName, accDID，leaderDID);
    
    //查询账户
    
	//account DDC用户链账户地址
    //返回DDC账户信息
    AccountInfo info = authorityService.getAccount(account);
    
    //更新账户状态
    
    //account DDC用户链账户地址
    //state   枚举，状态 ：Frozen - 冻结状态 ； Active - 活跃状态
    //changePlatformState
    //返回交易哈希
    String Txhash3 = updateAccState(account, 1， false);
```

### 3.BSN-DDC-费用管理

```
    ChargeService chargeService = client.getChargeService();  
    
    //充值
    
    //to 充值账户的地址
	//amount 充值金额
	//返回交易哈希
    String Txhash1 = chargeService.recharge(to, BigInteger.valueOf(10000));  
    
    //链账户余额查询
    
    //accAddr 查询的账户地址
	//返回账户所对应的业务费余额
    BigInteger balance = chargeService.balanceOf(accAddr);
    
    //DDC计费规则查询
    
    //ddcAddr DDC业务主逻辑合约地址
	//sig Hex格式的合约方法ID
	//返回DDC合约业务费
    BigInteger fee = queryFee(ddcAddr, "0x36351c7c");
    
    //运营账户充值
    
    //amount 对运营方账户进行充值的业务费
    //返回交易哈希
    String Txhash2 = chargeService.selfRecharge(BigInteger.valueOf(10000));
	
	//设置DDC计费规则
    
    //ddcAddr DDC业务主逻辑合约地址
    //sig Hex格式的合约方法ID
    //amount 业务费用
    //返回交易哈希
    String Txhash3 = chargeService.setFee(ddcAddr, sig, amount);
    
    //删除DDC计费规则
    
    //ddcAddr DDC业务主逻辑合约地址
    //sig Hex格式的合约方法ID
    //返回交易哈希
    String Txhash4 = chargeService.delFee(ddcAddr, sig);
    
    //按合约删除DDC计费规则
    //ddcAddr DDC业务主逻辑合约地址
    //返回交易哈希
    String Txhash5 = chargeService.delDDC(ddcAddr);
    
```

### 4.BSN-DDC-721

```
    
    DDC721Service ddc721Service = client.getDDC721Service(); 
    
    //DDC授权
    
    //to    授权者账户
    //ddcId DDC唯一标识
    //返回交易哈希
    String Txhash1 = ddc721Service.approve(to, ddcId);
    
    //DDC授权查询
    
    //ddcId DDC唯一标识
    //返回授权的账户
    String account = ddc721Service.getApproved(ddcId);
    
    //账户授权
    
    //operator 授权者账户
    //approved 授权标识
    //返回交易hash
    String Txhash2 = ddc721Service.setApprovalForAll(operator, true);
    
    //账户授权查询
    
    //owner    拥有者账户
    //operator 授权者账户
    //返回授权标识
    Boolean result = ddc721Service.isApprovedForAll(owner, operator);
    
    //安全转移
    
    //from  拥有者账户
    //to    授权者账户
    //ddcId DDC唯一标识
    //data  附加数据
    //返回交易hash
    String Txhash3 = ddc721Service.safeTransferFrom(from, to, ddcId, data);
    
    //转移
    
    //from  拥有者账户
    //to    接收者账户
    //ddcId ddc唯一标识
    //返回交易hash
    String Txhash4 = ddc721Service.transferFrom(from, to, ddcId);
    
    //冻结
    
    //ddcId DDC唯一标识
    //返回交易hash
    String Txhash5 = ddc721Service.freeze(ddcId);
    
    //解冻
    
    //ddcId DDC唯一标识
    //返回交易hash
     String Txhash5 = ddc721Service.unFreeze(ddcId);
    
    //销毁
    
    //ddcId DDC唯一标识
    //返回交易hash
    String Txhash6 = ddc721Service.burn(ddcId);
    
    //查询数量
    
    //owner 拥有者账户
    //返回ddc的数量
    BigInteger num = ddc721Service.balanceOf(owner);
    
    //查询拥有者
    
    //ddcId ddc唯一标识
    //返回拥有者账户
    String account = ddc721Service.ownerOf(ddcId);
    
    //获取名称
    
    //返回DDC运营方名称
    String name = ddc721Service.name();
    
    //获取符号
    
    //返回DDC运营方符号
    String symbol = ddc721Service.symbol();
    
    //获取DDCURI
    
    //返回DDC资源标识符
    String ddcURI = ddc721Service.ddcURI(ddcId);
    
```

### 5.BSN-DDC-1155

```
    
    DDC1155Service ddc1155Service = client.getDDC1155Service(); 
    
    //账户授权
    
    //operator 授权者账户
    //approved 授权标识
    //返回交易哈希
    String Txhash1  = ddc1155Service.setApprovalForAll(operator, approved);
    
    //账户授权查询
    
    //owner    拥有者账户
    //operator 授权者账户
    //返回授权结果（boolean）
    Boolean result = isApprovedForAll(owner, operator);
    
    //安全转移
    
    //from   拥有者账户
    //to     接收者账户
    //ddcId  DDCID
    //amount 需要转移的DDC数量
    //data   附加数据
    //返回交易哈希
    String Txhash2  = ddc1155Service.safeTransferFrom(from, to, ddcId, amount, data);
    
    //批量安全转移
    
    //from 拥有者账户
    //to   接收者账户
    //ddcs 拥有者DDCID集合
    //data 附加数据
    //返回交易哈希
    String Txhash3  = ddc1155Service.safeBatchTransferFrom(from, to, ddcs, data);
    
    //冻结
    
    //ddcId DDC唯一标识
    //返回交易哈希
    String Txhash4  = ddc1155Service.freeze(ddcId);
    
    //解冻
    
    //ddcId DDC唯一标识
    //返回交易哈希
    String Txhash5  = ddc1155Service.unFreeze(ddcId);
    
    //销毁
    String Txhash6  = ddc1155Service.burn(owner, ddcId);
    
    //批量销毁
    String Txhash7  = ddc1155Service.burnBatch(owner, ddcIds);
    
    //查询数量
    BigInteger num = balanceOf(owner, ddcId);
    
    //批量查询数量
    List<BigInteger> num= balanceOfBatch(ddcs);
    
    //获取DDCURI
    String ddcURI = ddcURI(ddcId);
    
```

### 6.BSN-DDC-交易查询

```
	BaseService baseService = new BaseService();
	
	//查询交易回执
	//hash 交易哈希
    //返回交易回执
     TransactionReceipt TxReceipt = baseService.getTransReceipt(hash)
     
     //查询交易信息
     //hash 交易哈希
     //返回交易信息
     Transaction Tx = baseService.getTransByHash(hash)
     
     //查询交易状态
     //hash 交易哈希
     //返回交易状态
     Boolean state = baseService.getTransByStatus(hash)
	
```

### 7.BSN-DDC-区块查询

```

	BaseService baseService = new BaseService();
	
    //获取区块信息
    EthBlock.Block blockinfo = baseService.getBlockByNumber(blockNumber)
    
```

### 8.BSN-DDC-数据解析

```
5.BSN-DDC-数据解析
    5.1权限数据
        5.1.1添加账户
        5.1.2更新账户状态

    5.2充值数据
        5.2.1充值
        5.2.2DDC业务费扣除
        5.2.3设置DDC计费规则
        5.2.4删除DDC计费规则
        5.2.5按合约删除DDC计费规则

    5.3BSN-DDC-721数据
        5.3.1生成
        5.3.2转移/安全转移
        5.3.3冻结
        5.3.4解冻
        5.3.5销毁

    5.4BSN-DDC-1155数据
        5.4.1生成
        5.4.2批量生成
        5.4.3安全转移
        5.4.4批量安全转移
        5.4.5冻结
        5.4.6解冻
        5.4.7销毁
        5.4.8批量销毁
```

```

	BlockEventService blockEventService = new BlockEventService();
	//获取区块事件并解析
	//1. 根据块高获取区块信息
    //2. 根据块中交易获取交易回执
    //3. 遍历交易回执中的事件并解析
    //blockNumber 块高
    //返回 ArrayList<Object>

	ArrayList<BaseEventResponse> blockEvent = blockEventService.getBlockEvent("28684");
	blockEvent.forEach(b->{
            System.out.println(b.log);
        });
        
```

## 平台方可调用的如下方法：

### 1.初始化Client (连接测试网)

```
    
     //创建客户端，导入网关
    //也可设置相关参数值 gasprice，gaslimit，相关合约地址
    //irita 中 gaslimit 设置值即消耗值，扣费换算：1 uirita = 1e12 wei
    //建议 gaslimit 设置为300000以上，gasprice 设置为10000000以上
    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc").authorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a").chargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7").ddc721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7").ddc1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708").gasLimit("300000").gasPrice("10000000").init();
    
    //注册签名事件
    SignEventListener signEventListener = new sign();
        client.registerSignListener(signEventListener);
    
    //签名处理示例
     public String signEvent(RawTransaction rawTransaction) {
        Credentials credentials = Credentials.create("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        return Numeric.toHexString(signMessage);
    }
    
    //可单独为每个方法设置gaslimit
    AuthorityService authorityService = client.getAuthorityService(); 
    authorityService.setFuncGasLimit("100000")
    String Txhash1 = authorityService。addAccount(account, accName, accDID);
    
```

### 2.BSN-DDC-权限管理

```
     AuthorityService authorityService = client.getAuthorityService(); 
     
    //查询账户
    
	//account DDC用户链账户地址
    //返回DDC账户信息
    AccountInfo info = authorityService.getAccount(account);
    
    //更新账户状态
    
    //account DDC用户链账户地址
    //state   枚举，状态 ：Frozen - 冻结状态 ； Active - 活跃状态
    //changePlatformState
    //返回交易哈希
    String Txhash3 = updateAccState(account, 1， false)
```

### 3.BSN-DDC-费用管理

```
    ChargeService chargeService = client.getChargeService();  
    
    //充值
    
    //to 充值账户的地址
	//amount 充值金额
	//返回交易哈希
    String Txhash1 = chargeService.recharge(to, BigInteger.valueOf(10000));  
    
    //链账户余额查询
    
    //accAddr 查询的账户地址
	//返回账户所对应的业务费余额
    BigInteger balance = chargeService.balanceOf(accAddr);
    
    //DDC计费规则查询
    
    //ddcAddr DDC业务主逻辑合约地址
	//sig Hex格式的合约方法ID
	//返回DDC合约业务费
    BigInteger fee = queryFee(ddcAddr, "0x36351c7c");
```

### 4.BSN-DDC-721

```
    DDC721Service ddc721Service = client.getDDC721Service(); 
    
    //生成
    
    //to     接收者账户
    //ddcURI DDC资源标识符
    //返回交易哈希
    String Txhash = ddc721Service.mint(toaddr, ddcURI);
    
    //安全生成（合约未更新）
    
    //DDC授权
    
    //to    授权者账户
    //ddcId DDC唯一标识
    //返回交易哈希
    String Txhash1 = ddc721Service.approve(to, ddcId);
    
    //DDC授权查询
    
    //ddcId DDC唯一标识
    //返回授权的账户
    String account = ddc721Service.getApproved(ddcId);
    
    //账户授权
    
    //operator 授权者账户
    //approved 授权标识
    //返回交易hash
    String Txhash2 = ddc721Service.setApprovalForAll(operator, true);
    
    //账户授权查询
    
    //owner    拥有者账户
    //operator 授权者账户
    //返回授权标识
    Boolean result = ddc721Service.isApprovedForAll(owner, operator);
    
    //安全转移
    
    //from  拥有者账户
    //to    授权者账户
    //ddcId DDC唯一标识
    //data  附加数据
    //返回交易hash
    String Txhash3 = ddc721Service.safeTransferFrom(from, to, ddcId, data);
    
    //转移
    
    //from  拥有者账户
    //to    接收者账户
    //ddcId ddc唯一标识
    //返回交易hash
    String Txhash4 = ddc721Service.transferFrom(from, to, ddcId);
    
    //销毁
    
    //ddcId DDC唯一标识
    //返回交易hash
    String Txhash6 = ddc721Service.burn(ddcId);
    
    //查询数量
    
    //owner 拥有者账户
    //返回ddc的数量
    BigInteger num = ddc721Service.balanceOf(owner);
    
    //查询拥有者
    
    //ddcId ddc唯一标识
    //返回拥有者账户
    String account = ddc721Service.ownerOf(ddcId);
    
    //获取名称
    
    //返回DDC运营方名称
    String name = ddc721Service.name();
    
    //获取符号
    
    //返回DDC运营方符号
    String symbol = ddc721Service.symbol();
    
    //获取DDCURI
    
    //返回DDC资源标识符
    String ddcURI = ddc721Service.ddcURI(ddcId);
    
```

### 5.BSN-DDC-1155

```
    DDC1155Service ddc1155Service = client.getDDC1155Service(); 
    
    //生成
    String Txhash  = ddc1155Service.mint(to, amount, ddcURI);
    
    //批量生成
    String Txhash  = ddc1155Service.mintBatch(to, ddcInfo);
    
    //账户授权
    
    //operator 授权者账户
    //approved 授权标识
    //返回交易哈希
    String Txhash1  = ddc1155Service.setApprovalForAll(operator, approved);
    
    //账户授权查询
    
    //owner    拥有者账户
    //operator 授权者账户
    //返回授权结果（boolean）
    Boolean result = isApprovedForAll(owner, operator);
    
    //安全转移
    
    //from   拥有者账户
    //to     接收者账户
    //ddcId  DDCID
    //amount 需要转移的DDC数量
    //data   附加数据
    //返回交易哈希
    String Txhash2  = ddc1155Service.safeTransferFrom(from, to, ddcId, amount, data);
    
    //批量安全转移
    
    //from 拥有者账户
    //to   接收者账户
    //ddcs 拥有者DDCID集合
    //data 附加数据
    //返回交易哈希
    String Txhash3  = ddc1155Service.safeBatchTransferFrom(from, to, ddcs, data);
   
    //销毁
    String Txhash6  = ddc1155Service.burn(owner, ddcId);
    
    //批量销毁
    String Txhash7  = ddc1155Service.burnBatch(owner, ddcIds);
    
    //查询数量
    BigInteger num = balanceOf(owner, ddcId);
    
    //批量查询数量
    List<BigInteger> num= balanceOfBatch(ddcs);
    
    //获取DDCURI
    String ddcURI = ddcURI(ddcId);
    
```

### 6.BSN-DDC-交易查询

```

	BaseService baseService = new BaseService();
	
	//查询交易回执
	//hash 交易哈希
    //返回交易回执
     TransactionReceipt TxReceipt = baseService.getTransReceipt(hash)
     
     //查询交易信息
     //hash 交易哈希
     //返回交易信息
     Transaction Tx = baseService.getTransByHash(hash)
     
     //查询交易状态
     //hash 交易哈希
     //返回交易状态
     Boolean state = baseService.getTransByStatus(hash)

```

### 7.BSN-DDC-区块查询

```

	BaseService baseService = new BaseService();
	
    //获取区块信息
    EthBlock.Block blockinfo = baseService.getBlockByNumber(blockNumber)
    
```

### 8.BSN-DDC-数据解析

```
7.BSN-DDC-数据解析
    7.1权限数据
        7.1.1添加账户
        7.1.2更新账户状态

    7.2充值数据
        7.2.1充值
        7.2.2DDC业务费扣除
        7.2.3设置DDC计费规则
        7.2.4删除DDC计费规则
        7.2.5按合约删除DDC计费规则

    7.3BSN-DDC-721数据
        7.3.1生成
        7.3.2转移/安全转移
        7.3.3冻结
        7.3.4解冻
        7.3.5销毁

    7.4BSN-DDC-1155数据
        7.4.1生成
        7.4.2批量生成
        7.4.3安全转移
        7.4.4批量安全转移
        7.4.5冻结
        7.4.6解冻
        7.4.7销毁
        7.4.8批量销毁
```

```

	BlockEventService blockEventService = new BlockEventService();
	//获取区块事件并解析
	//1. 根据块高获取区块信息
    //2. 根据块中交易获取交易回执
    //3. 遍历交易回执中的事件并解析
    //blockNumber 块高
    //返回 ArrayList<Object>

	ArrayList<BaseEventResponse> blockEvent = blockEventService.getBlockEvent("28684");
	blockEvent.forEach(b->{
            System.out.println(b.log);
        });
        
```

## 终端账户可调用的如下方法：

### 1.初始化Client (连接测试网)

```
    
     //创建客户端，导入网关
    //也可设置相关参数值 gasprice，gaslimit，相关合约地址
    //irita 中 gaslimit 设置值即消耗值，扣费换算：1 uirita = 1e12 wei
    //建议 gaslimit 设置为300000以上，gasprice 设置为10000000以上
    DDCSdkClient client = new DDCSdkClient.Builder("https://opbtest.bsngate.com:18602/api/IRISnetrest/evmrpc").authorityLogicAddress("0xdAc50c90b934AdED33b6ADc9f5855ab8a9EFB09a").chargeLogicAddress("0x52403cE9E235Cf013bA2353F0bf47834C98424c7").ddc721Address("0x503f45958F57Da55170B54796F4eD224c9fef9d7").ddc1155Address("0xe7310D2D79c67a3078DBeFA67344c7047AC28708").gasLimit("300000").gasPrice("10000000").init();
    
    //注册签名事件
    SignEventListener signEventListener = new sign();
        client.registerSignListener(signEventListener);
    
    //签名处理示例
     public String signEvent(RawTransaction rawTransaction) {
        Credentials credentials = Credentials.create("2F6976C530CFD2D0CC19EFC1868BD6A0AA1886D0BFCFA5A59D9B8899BE9B7241");
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        return Numeric.toHexString(signMessage);
    }
    
    //可单独为每个方法设置gaslimit
    AuthorityService authorityService = client.getAuthorityService(); 
    authorityService.setFuncGasLimit("100000")
    String Txhash1 = authorityService。addAccount(account, accName, accDID);
    
```

### 2.BSN-DDC-权限管理

```
	AuthorityService authorityService = client.getAuthorityService(); 
    
    //查询账户
    
	//account DDC用户链账户地址
    //返回DDC账户信息
    AccountInfo info = authorityService.getAccount(account);
```

### 3.BSN-DDC-费用管理

```
    ChargeService chargeService = client.getChargeService();  
    
    //链账户余额查询
    
    //accAddr 查询的账户地址
	//返回账户所对应的业务费余额
    BigInteger balance = chargeService.balanceOf(accAddr);
    
    //DDC计费规则查询
    
    //ddcAddr DDC业务主逻辑合约地址
	//sig Hex格式的合约方法ID
	//返回DDC合约业务费
    BigInteger fee = queryFee(ddcAddr, "0x36351c7c");
    
```

### 4.BSN-DDC-721

```
     DDC721Service ddc721Service = client.getDDC721Service(); 
    
    //生成
    
    //to     接收者账户
    //ddcURI DDC资源标识符
    //返回交易哈希
    String Txhash = ddc721Service.mint(toaddr, ddcURI);
    
    //安全生成（合约未更新）
    
    //DDC授权
    
    //to    授权者账户
    //ddcId DDC唯一标识
    //返回交易哈希
    String Txhash1 = ddc721Service.approve(to, ddcId);
    
    //DDC授权查询
    
    //ddcId DDC唯一标识
    //返回授权的账户
    String account = ddc721Service.getApproved(ddcId);
    
    //账户授权
    
    //operator 授权者账户
    //approved 授权标识
    //返回交易hash
    String Txhash2 = ddc721Service.setApprovalForAll(operator, true);
    
    //账户授权查询
    
    //owner    拥有者账户
    //operator 授权者账户
    //返回授权标识
    Boolean result = ddc721Service.isApprovedForAll(owner, operator);
    
    //安全转移
    
    //from  拥有者账户
    //to    授权者账户
    //ddcId DDC唯一标识
    //data  附加数据
    //返回交易hash
    String Txhash3 = ddc721Service.safeTransferFrom(from, to, ddcId, data);
    
    //转移
    
    //from  拥有者账户
    //to    接收者账户
    //ddcId ddc唯一标识
    //返回交易hash
    String Txhash4 = ddc721Service.transferFrom(from, to, ddcId);
    
    //销毁
    
    //ddcId DDC唯一标识
    //返回交易hash
    String Txhash6 = ddc721Service.burn(ddcId);
    
    //查询数量
    
    //owner 拥有者账户
    //返回ddc的数量
    BigInteger num = ddc721Service.balanceOf(owner);
    
    //查询拥有者
    
    //ddcId ddc唯一标识
    //返回拥有者账户
    String account = ddc721Service.ownerOf(ddcId);
    
    //获取名称
    
    //返回DDC运营方名称
    String name = ddc721Service.name();
    
    //获取符号
    
    //返回DDC运营方符号
    String symbol = ddc721Service.symbol();
    
    //获取DDCURI
    
    //返回DDC资源标识符
    String ddcURI = ddc721Service.ddcURI(ddcId);
    
```

### 5.BSN-DDC-1155

```
    DDC1155Service ddc1155Service = client.getDDC1155Service(); 
    
    //生成
    String Txhash  = ddc1155Service.mint(to, amount, ddcURI);
    
    //批量生成
    String Txhash  = ddc1155Service.mintBatch(to, ddcInfo);
    
    //账户授权
    
    //operator 授权者账户
    //approved 授权标识
    //返回交易哈希
    String Txhash1  = ddc1155Service.setApprovalForAll(operator, approved);
    
    //账户授权查询
    
    //owner    拥有者账户
    //operator 授权者账户
    //返回授权结果（boolean）
    Boolean result = isApprovedForAll(owner, operator);
    
    //安全转移
    
    //from   拥有者账户
    //to     接收者账户
    //ddcId  DDCID
    //amount 需要转移的DDC数量
    //data   附加数据
    //返回交易哈希
    String Txhash2  = ddc1155Service.safeTransferFrom(from, to, ddcId, amount, data);
    
    //批量安全转移
    
    //from 拥有者账户
    //to   接收者账户
    //ddcs 拥有者DDCID集合
    //data 附加数据
    //返回交易哈希
    String Txhash3  = ddc1155Service.safeBatchTransferFrom(from, to, ddcs, data);
   
    //销毁
    String Txhash6  = ddc1155Service.burn(owner, ddcId);
    
    //批量销毁
    String Txhash7  = ddc1155Service.burnBatch(owner, ddcIds);
    
    //查询数量
    BigInteger num = balanceOf(owner, ddcId);
    
    //批量查询数量
    List<BigInteger> num= balanceOfBatch(ddcs);
    
    //获取DDCURI
    String ddcURI = ddcURI(ddcId);
    
```

### 6.BSN-DDC-数据解析

```
5.BSN-DDC-数据解析
    5.1权限数据
        5.1.1添加账户
        5.1.2更新账户状态

    5.2充值数据
        5.2.1充值
        5.2.2DDC业务费扣除
        5.2.3设置DDC计费规则
        5.2.4删除DDC计费规则
        5.2.5按合约删除DDC计费规则

    5.3BSN-DDC-721数据
        5.3.1生成
        5.3.2转移/安全转移
        5.3.3冻结
        5.3.4解冻
        5.3.5销毁

    5.4BSN-DDC-1155数据
        5.4.1生成
        5.4.2批量生成
        5.4.3安全转移
        5.4.4批量安全转移
        5.4.5冻结
        5.4.6解冻
        5.4.7销毁
        5.4.8批量销毁
```

```

	BlockEventService blockEventService = new BlockEventService();
	//获取区块事件并解析
	//1. 根据块高获取区块信息
    //2. 根据块中交易获取交易回执
    //3. 遍历交易回执中的事件并解析
    //blockNumber 块高
    //返回 ArrayList<Object>

	ArrayList<BaseEventResponse> blockEvent = blockEventService.getBlockEvent("28684");
	blockEvent.forEach(b->{
            System.out.println(b.log);
        });
        
```

## 测试用例

[AuthorityServiceTest.java](/src/test/java/ai/bianjie/ddc/service/AuthorityServiceTest.java)

[ChargeServiceTest.java](/src/test/java/ai/bianjie/ddc/service/ChargeServiceTest.java)

[BaseServiceTest.java](/src/test/java/ai/bianjie/ddc/service/BaseServiceTest.java)

[BlockEventServiceTest.java](/src/test/java/ai/bianjie/ddc/service/BlockEventServiceTest.java)

[DDC721ServiceTest.java](/src/test/java/ai/bianjie/ddc/service/DDC721ServiceTest.java)

[DDC1155ServiceTest.java](/src/test/java/ai/bianjie/ddc/service/DDC1155ServiceTest.java)
