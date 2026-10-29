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
