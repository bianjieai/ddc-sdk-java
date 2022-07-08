package ai.bianjie.ddc.module.feegrant;

import ai.bianjie.ddc.client.BaseClient;
import ai.bianjie.ddc.model.Account;
import ai.bianjie.ddc.model.BaseTx;
import ai.bianjie.ddc.model.ResultTx;
import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import org.apache.commons.lang3.StringUtils;
import proto.cosmos.base.v1beta1.CoinOuterClass;
import proto.cosmos.feegrant.v1beta1.Feegrant;
import proto.cosmos.feegrant.v1beta1.Tx;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FeeGrantClient {

    private final BaseClient baseClient;

    public FeeGrantClient (BaseClient baseClient){
        this.baseClient = baseClient;
    }

    /**
     * if set denom&amount grant only onice
     * default denom=null&amount=null
     * timestamp is expiration time
     * @param granter
     * @param grantee
     * @param denom
     * @param amount
     * @param timestamp
     * @param baseTx
     * @return
     * @throws IOException
     */
    public ResultTx GrantAllowance(String granter, String grantee, String denom, String amount, Timestamp timestamp, BaseTx baseTx) throws IOException {
        Account account = baseClient.queryAccount(baseTx);
        CoinOuterClass.Coin coinOuterClass = null;
        if (StringUtils.isNotEmpty(denom) && StringUtils.isNotEmpty(amount)){
            coinOuterClass = CoinOuterClass.Coin.newBuilder()
                    .setAmount(amount)
                    .setDenom(denom)
                    .build();
        }
        Feegrant.BasicAllowance.Builder basicAllowanceBuilder = Feegrant.BasicAllowance.newBuilder();
        if (coinOuterClass != null){
            basicAllowanceBuilder.addSpendLimit(coinOuterClass);
        }
        if (timestamp != null){
            basicAllowanceBuilder.setExpiration(timestamp);
        }
        Feegrant.BasicAllowance f = basicAllowanceBuilder.build();
        Any.Builder anyBuilder = Any.newBuilder();
        anyBuilder.setTypeUrl("/"+f.getDescriptorForType().getFullName());
        if (f.getSpendLimitList().size() >0){
            anyBuilder.setValue(f.toByteString());
        }
        Tx.MsgGrantAllowance msg = Tx.MsgGrantAllowance.newBuilder()
                .setGranter(granter)
                .setGrantee(grantee)
                .setAllowance(anyBuilder.build())
                .build();
        List<GeneratedMessageV3> msgs = Collections.singletonList(msg);
        return baseClient.buildAndSend(msgs, baseTx, account);
    }

    public ResultTx GrantAllowance(String granter, String grantee, BaseTx baseTx) throws IOException {
        Account account = baseClient.queryAccount(baseTx);
        Feegrant.BasicAllowance f = Feegrant.BasicAllowance.newBuilder().build();
        Any.Builder anyBuilder = Any.newBuilder();
        anyBuilder.setTypeUrl("/"+f.getDescriptorForType().getFullName());
        Tx.MsgGrantAllowance msg = Tx.MsgGrantAllowance.newBuilder()
                .setGranter(granter)
                .setGrantee(grantee)
                .setAllowance(anyBuilder.build())
                .build();
        List<GeneratedMessageV3> msgs = Collections.singletonList(msg);
        return baseClient.buildAndSend(msgs, baseTx, account);
    }

    public ResultTx RevokeAllowance(String granter, String grantee, BaseTx baseTx) throws IOException {
        Account account = baseClient.queryAccount(baseTx);
        Tx.MsgRevokeAllowance msg = Tx.MsgRevokeAllowance.newBuilder()
                .setGranter(granter)
                .setGrantee(grantee)
                .build();

        List<GeneratedMessageV3> msgs = Collections.singletonList(msg);
        return baseClient.buildAndSend(msgs, baseTx, account);
    }

}
