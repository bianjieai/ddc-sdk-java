package ai.bianjie.ddc.function;

import ai.bianjie.ddc.module.service.ServiceResponseInfo;

// RespondCallback defines the callback function of the service response
@FunctionalInterface
public interface RespondCallback {
    ServiceResponseInfo apply(String reqCtxID, String reqID, String input);
}
