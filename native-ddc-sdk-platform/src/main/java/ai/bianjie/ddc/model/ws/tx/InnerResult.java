package ai.bianjie.ddc.model.ws.tx;

import ai.bianjie.ddc.model.Events;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InnerResult {
    private String data;
    private String log;
    @JsonProperty("gas_wanted")
    private String gasWanted;
    @JsonProperty("gas_used")
    private String gasUsed;
    private List<ai.bianjie.ddc.model.Events> events;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return log;
    }

    public void setGasWanted(String gasWanted) {
        this.gasWanted = gasWanted;
    }

    public String getGasWanted() {
        return gasWanted;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setEvents(List<ai.bianjie.ddc.model.Events> events) {
        this.events = events;
    }

    public List<Events> getEvents() {
        return events;
    }

}