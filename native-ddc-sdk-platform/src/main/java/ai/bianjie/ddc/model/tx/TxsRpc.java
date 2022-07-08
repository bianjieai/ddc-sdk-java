package ai.bianjie.ddc.model.tx;

import ai.bianjie.ddc.model.RpcBase;

public class TxsRpc extends RpcBase {
    private TxsResult result;

    public TxsResult getResult() {
        return result;
    }

    public void setResult(TxsResult result) {
        this.result = result;
    }
}
