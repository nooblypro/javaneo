import java.util.*;

interface Notifier {
    void send(String recipient, String message);
}

class EmailNotifier implements Notifier {
    public void send(String recipient, String message) {
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String recipient, String message) {
        System.out.println("SMS sent to " + recipient + ": " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String channel = sc.nextLine().trim();
        String recipient = sc.nextLine().trim();
        String message = sc.nextLine().trim();
        Notifier n = channel.equals("EMAIL") ? new EmailNotifier() : new SMSNotifier();
        n.send(recipient, message);
    }
}
