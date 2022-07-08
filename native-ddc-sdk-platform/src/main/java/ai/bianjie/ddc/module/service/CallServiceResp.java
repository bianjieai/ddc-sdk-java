package ai.bianjie.ddc.module.service;

import ai.bianjie.ddc.model.ResultTx;

public class CallServiceResp {
    private String reqCtxId;
    private ResultTx resultTx;

    public CallServiceResp(String reqCtxId, ResultTx resultTx) {
        this.reqCtxId = reqCtxId;
        this.resultTx = resultTx;
    }

    public ResultTx getResultTx() {
        return resultTx;
    }

    public void setResultTx(ResultTx resultTx) {
        this.resultTx = resultTx;
    }

    public String getReqCtxId() {
        return reqCtxId;
    }

    public void setReqCtxId(String reqCtxId) {
        this.reqCtxId = reqCtxId;
    }
}
