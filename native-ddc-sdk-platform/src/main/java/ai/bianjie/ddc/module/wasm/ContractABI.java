package ai.bianjie.ddc.module.wasm;

import ai.bianjie.ddc.exception.IritaSDKException;
import ai.bianjie.ddc.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

// ContractABI define a message for executing contract
public class ContractABI {
    private String method;
    private Map<String, Object> args;


    public byte[] build() {
        if (StringUtils.isEmpty(method)) {
            throw new IritaSDKException("no method pass");
        }

        Map<String, Map<String, Object>> map = new HashMap<>();
        if (args == null) {
            map.put(method, new HashMap<>());
        } else {
            map.put(method, args);
        }
        try {
            return JsonUtils.writeValueAsBytes(map);
        } catch (JsonProcessingException e) {
            throw new IritaSDKException(e.getMessage());
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getArgs() {
        return args;
    }

    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }
}
