package pojo;

import java.util.List;

public class BaseRequest<T extends BaseReq> {

    private String sourceSoftware;

    private List<T> logs;

    public String getSourceSoftware() {
        return sourceSoftware;
    }

    public void setSourceSoftware(String sourceSoftware) {
        this.sourceSoftware = sourceSoftware;
    }

    public List<T> getLogs() {
        return logs;
    }

    public void setLogs(List<T> logs) {
        this.logs = logs;
    }
}
