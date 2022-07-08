package ai.bianjie.ddc.model.tx;

import ai.bianjie.ddc.model.RpcBase;

public class TxRpc extends RpcBase {
    private Result result;

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}