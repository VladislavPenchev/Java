package p02_services;

public class SmsNotificationService implements NotificationService{

    private boolean isActive;

    public SmsNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    public void sendNotification() {
        System.out.println("sms notification");
    }

    public boolean isActive() {
        return this.isActive;
    }
}
