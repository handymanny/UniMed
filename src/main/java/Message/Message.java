package Message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("data")
    @Expose
    private String data;

    public Message(String path, String method, String data) {
        this.path = path;
        this.method = method;
        this.data = data;
    }

    public Message(String path, String method) {
        this.path = path;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
