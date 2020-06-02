package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService smsNotification = new SmsNotificationService(true);
        NotificationService emailNotification = new EmailNotificationService(true);

        OnlineStoreOrder order = new OnlineStoreOrder(smsNotification, emailNotification);

        order.process();

    }
}
