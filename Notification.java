import java.time.LocalDateTime;

public class Notification {
    private String user;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Notification(String user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    @Override
    public String toString() {
        return "Notification for " + user + ": " + message + " (Received: " + timestamp + ", Read: " + isRead + ")";
    }
}
