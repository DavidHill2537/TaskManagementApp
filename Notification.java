import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Notification {
    private String user;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Notification(String user, String message) {
        this(user, message, LocalDateTime.now(), false);
    }

    public Notification(String user, String message, LocalDateTime timestamp, boolean isRead) {
        this.user = user;
        this.message = message;
        this.timestamp = timestamp;
        this.isRead = isRead;
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

    public String formattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("Notification for %s: %s (Received: %s, Read: %s)", 
                             user, message, formattedTimestamp(), isRead ? "Yes" : "No");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return isRead == that.isRead &&
               Objects.equals(user, that.user) &&
               Objects.equals(message, that.message) &&
               Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, message, timestamp, isRead);
    }
}
