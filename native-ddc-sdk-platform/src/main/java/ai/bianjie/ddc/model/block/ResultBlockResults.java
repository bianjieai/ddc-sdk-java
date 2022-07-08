package ai.bianjie.ddc.model.block;

import ai.bianjie.ddc.model.RpcBase;

public class ResultBlockResults extends RpcBase {
    private BlockResult result;

    public BlockResult getResult() {
        return result;
    }

    public void setResult(BlockResult result) {
        this.result = result;
    }
}
