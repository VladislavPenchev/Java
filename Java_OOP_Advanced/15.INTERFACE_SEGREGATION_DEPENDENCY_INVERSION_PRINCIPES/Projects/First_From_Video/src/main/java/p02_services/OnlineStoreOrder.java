package p02_services;

public class OnlineStoreOrder {

    private NotificationService notificationServices[];

    public OnlineStoreOrder(NotificationService... services){
        this.notificationServices = services;
    }

    public void process() {
        for (NotificationService notification : notificationServices) {
            if (notification.isActive()) {
                notification.sendNotification();
            }
        }
    }
}
