import java.io.*;
import java.util.*;

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

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String env = sc.next();
        int timeout = sc.nextInt();
        int extra = sc.nextInt();
        File file = new File("config.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(new AppConfig(env, timeout));
        }
        AppConfig config;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            config = (AppConfig) ois.readObject();
        }
        config.addTimeout(extra);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(config);
        }
        AppConfig reloaded;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            reloaded = (AppConfig) ois.readObject();
        }
        System.out.println("Environment: " + reloaded.getEnvironment());
        System.out.println("Timeout: " + reloaded.getTimeout() + "s");
    }
}
