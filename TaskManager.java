import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private List<User> users;
    private List<Task> tasks;

    public TaskManager() {
        users = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription());
    }

    public void assignTask(String userName, int taskId) {
        User user = findUser(userName);
        Task task = findTask(taskId);
        if (user != null && task != null) {
            task.assignTo(user.getName());
            System.out.println("Task assigned: " + task);
        } else {
            System.out.println("Error: User or Task not found.");
        }
    }

    public void listUsers() {
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void listTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void sendNotification(String userName, String message) {
        User user = findUser(userName);
        if (user != null) {
            Notification notification = new Notification(user.getName(), message);
            System.out.println(notification);
        } else {
            System.out.println("Error: User not found.");
        }
    }

    private User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    private Task findTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
