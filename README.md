# DDC-SDK-JAVA

## 本SDK中包含运营方可调用的如下方法：

```
1.BSN-DDC-权限管理
    1.1添加下级账户
    1.2添加终端用户
    1.3查询账户
    1.4更新账户状态

2.BSN-DDC-费用管理
    2.1充值
    2.2链账户余额查询
    2.3DDC计费规则查询
    2.4

3.BSN-DDC-721
    3.1生成
    3.2DDC授权
    3.3DDC授权查询
    3.4账户授权
    3.5账户授权查询
    3.6安全转移
    3.7转移
    3.8销毁
    3.9查询数量
    3.10查询拥有者
    3.11获取名称
    3.12获取符号
    3.13获取DDCURI

4.BSN-DDC-1155
    4.1生成
    4.2批量生成
    4.3账户授权
    4.4账户授权查询
    4.5安全转移
    4.6批量安全转移
    4.7销毁
    4.8批量销毁
    4.9查询数量
    4.10批量查询数量
    4.11获取DDCURI

5.BSN-DDC-交易查询
    5.1查询交易信息
    5.2查询交易回执
    5.3查询交易状态

6.BSN-DDC-区块查询
    6.1获取区块信息

7.BSN-DDC-签名事件

8.BSN-DDC-数据解析

    8.1权限数据
        8.1.1添加账户
        8.1.2更新账户状态

    8.2充值数据
        8.2.1充值
        8.2.2DDC业务费扣除
        8.2.3设置DDC计费规则
        8.2.4删除DDC计费规则
        8.2.5按合约删除DDC计费规则

    8.3BSN-DDC-721数据
        8.3.1生成
        8.3.2转移/安全转移
        8.3.3冻结
        8.3.4解冻
        8.3.5销毁

    8.4BSN-DDC-1155数据
        8.4.1生成
        8.4.2批量生成
        8.4.3安全转移
        8.4.4批量安全转移
        8.4.5冻结
        8.4.6解冻
        8.4.7销毁
        8.4.8批量销毁

```

## 本SDK中包含平台方可调用的如下方法：

```
1.BSN-DDC-权限管理
    1.1添加下级账户
    1.2查询账户
    1.3更新账户状态

2.BSN-DDC-费用管理
    2.1充值
    2.2链账户余额查询
    2.3DDC计费规则查询

3.BSN-DDC-721
    3.1生成
    3.2DDC授权
    3.3DDC授权查询
    3.4账户授权
    3.5账户授权查询
    3.6安全转移
    3.7转移
    3.8销毁
    3.9查询数量
    3.10查询拥有者
    3.11获取名称
    3.12获取符号
    3.13获取DDCURI

4.BSN-DDC-1155
    4.1生成
    4.2批量生成
    4.3账户授权
    4.4账户授权查询
    4.5安全转移
    4.6批量安全转移
    4.7销毁
    4.8批量销毁
    4.9查询数量
    4.10批量查询数量
    4.11获取DDCURI

5.BSN-DDC-交易查询
    5.1查询交易信息
    5.2查询交易回执
    5.3查询交易状态

6.BSN-DDC-区块查询
    6.1获取区块信息

7.BSN-DDC-签名事件

8.BSN-DDC-数据解析

    8.1权限数据
        8.1.1添加账户
        8.1.2更新账户状态

    8.2充值数据
        8.2.1充值
        8.2.2DDC业务费扣除
        8.2.3设置DDC计费规则
        8.2.4删除DDC计费规则
        8.2.5按合约删除DDC计费规则

    8.3BSN-DDC-721数据
        8.3.1生成
        8.3.2转移/安全转移
        8.3.3冻结
        8.3.4解冻
        8.3.5销毁

    8.4BSN-DDC-1155数据
        8.4.1生成
        8.4.2批量生成
        8.4.3安全转移
        8.4.4批量安全转移
        8.4.5冻结
        8.4.6解冻
        8.4.7销毁
        8.4.8批量销毁

```

## 怎样使用ddc-sdk-java

### 1.初始化Client (连接测试网)

```
    DDCSdkClient client = new DDCSdkClient("http://192.168.150.43:8545");
    //填写账户私钥
    client.init("443E5162AAB8D1E0B262068CE74C4CD4BD58268A95911140E03BCD5ED6FC788B");
    //
    client.init(credentials, gasPrice, gasLimit, ddc721Address, ddc1155Address, authorityLogicAddress, chargeLogicAddress)
    
```

### 2.使用权限管理

```
    AuthorityService authorityService = client.getAuthorityService(); 
    //添加下级账户
    String Txhash1 = authorityService.addAccount(account, accname, accdid);
    //查询账户
    String resultInfo = authorityService.getAccount(account);
    //更新账户状态
    String Txhash2 = updateAccState(account, 2, false)
```

### 3.使用费用管理

```
    ChargeService chargeService = client.getChargeService();  
    //充值
    String Txhash3 = chargeService.recharge(toaddr, BigInteger.valueOf(10000));  
    //链账户余额查询
    String balance = chargeService.balanceOf(accAddr);
    //DDC计费规则查询
    BigInteger fee = queryFee(ddcAddr, sig);
```

### 4.使用DDC-721

```
    DDC721Service ddc721Service = client.getDDC721Service(); 
    //生成
    String Txhash4 = ddc721Service.mint(toaddr, ddcURI);
    //DDC授权
    String Txhash5 = ddc721Service.approve(toaddr, ddcId);
    //DDC授权查询
    String acc = ddc721Service.getApproved(ddcId);
    //账户授权
    String Txhash6 = ddc721Service.setApprovalForAll(operator, true);
    //账户授权查询
    Boolean result1 = ddc721Service.isApprovedForAll(owner, operator);
    //安全转移
    String Txhash7 = ddc721Service.safeTransferFrom(from, to, ddcId, data);
    //转移
    String Txhash8 = ddc721Service.transferFrom(from, to, ddcId);
    //销毁
    String Txhash9 = ddc721Service.burn(ddcId);
    //查询数量
    BigInteger num = ddc721Service.balanceOf(owner);
    //查询拥有者
    String acc = ddc721Service.ownerOf(ddcId);
    //获取名称
    String name = ddc721Service.name();
    //获取符号
    String symbol = ddc721Service.symbol();
    //获取DDCURI
    String ddcURI = ddc721Service.ddcURI(ddcId);
    
```

### 5.使用DDC-1155

```
    DDC1155Service ddc1155Service = client.getDDC1155Service(); 
    //生成
    String Txhash10  = ddc1155Service.mint(to, amount, ddcURI);
    //批量生成
    String Txhash11  = ddc1155Service.mintBatch(to, ddcInfo);
    //账户授权
    String Txhash12  = ddc1155Service.setApprovalForAll(operator, approved);
    //账户授权查询
    Boolean result = isApprovedForAll(owner, operator);
    //安全转移
    String Txhash13  = ddc1155Service.safeTransferFrom(from, to, ddcId, amount, data);
    //批量安全转移
    String Txhash14  = ddc1155Service.safeBatchTransferFrom(from, to, ddcs, data);
    //销毁
    String Txhash15  = ddc1155Service.burn(owner, ddcId);
    //批量销毁
    String Txhash16  = ddc1155Service.burnBatch(owner, ddcIds);
    //查询数量
    BigInteger num = balanceOf(owner, ddcId);
    //批量查询数量
    List<BigInteger> num= balanceOfBatch(ddcs);
    //获取DDCURI
    String ddcURI = ddcURI(ddcId);
    
```

## 本SDK中包含终端用户可调用的如下方法：

```
1.BSN-DDC-权限管理
    1.1添加下级账户
    1.2查询账户
    1.3更新账户状态

2.BSN-DDC-费用管理
    2.1充值
    2.2链账户余额查询
    2.3DDC计费规则查询

3.BSN-DDC-721
    3.1生成
    3.2DDC授权
    3.3DDC授权查询
    3.4账户授权
    3.5账户授权查询
    3.6安全转移
    3.7转移
    3.8销毁
    3.9查询数量
    3.10查询拥有者
    3.11获取名称
    3.12获取符号
    3.13获取DDCURI

4.BSN-DDC-1155
    4.1生成
    4.2批量生成
    4.3账户授权
    4.4账户授权查询
    4.5安全转移
    4.6批量安全转移
    4.7销毁
    4.8批量销毁
    4.9查询数量
    4.10批量查询数量
    4.11获取DDCURI

5.BSN-DDC-交易查询
    5.1查询交易信息
    5.2查询交易回执
    5.3查询交易状态

6.BSN-DDC-区块查询
    6.1获取区块信息

7.BSN-DDC-签名事件

8.BSN-DDC-数据解析

    8.1权限数据
        8.1.1添加账户
        8.1.2更新账户状态

    8.2充值数据
        8.2.1充值
        8.2.2DDC业务费扣除
        8.2.3设置DDC计费规则
        8.2.4删除DDC计费规则
        8.2.5按合约删除DDC计费规则

    8.3BSN-DDC-721数据
        8.3.1生成
        8.3.2转移/安全转移
        8.3.3冻结
        8.3.4解冻
        8.3.5销毁

    8.4BSN-DDC-1155数据
        8.4.1生成
        8.4.2批量生成
        8.4.3安全转移
        8.4.4批量安全转移
        8.4.5冻结
        8.4.6解冻
        8.4.7销毁
        8.4.8批量销毁

```