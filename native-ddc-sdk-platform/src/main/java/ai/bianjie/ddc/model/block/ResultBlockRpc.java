package ai.bianjie.ddc.model.block;

import ai.bianjie.ddc.model.RpcBase;

public class ResultBlockRpc extends RpcBase {
    private ResultBlock result;

    public ResultBlock getResult() {
        return result;
    }

    public void setResult(ResultBlock result) {
        this.result = result;
    }
}
