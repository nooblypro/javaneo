import java.io.Serializable;

class AppConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    private String environment;
    private int timeout;

    public AppConfig(String environment, int timeout) {
        this.environment = environment;
        this.timeout = timeout;
    }

    public String getEnvironment() { return environment; }
    public int getTimeout() { return timeout; }
    public void addTimeout(int extra) { this.timeout += extra; }
}
