import java.util.Scanner;

public class TaskManagementApp {
    private TaskManager taskManager;
    private Scanner scanner;

    public TaskManagementApp() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
        loadData();
        runApp();
    }

    private void loadData() {
        // Load data from storage (implementation omitted for brevity)
        System.out.println("Data loaded successfully.");
    }

    private void runApp() {
        while (true) {
            System.out.println("\n--- Task Management System Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Assign Task");
            System.out.println("4. List Users");
            System.out.println("5. List Tasks");
            System.out.println("6. Send Notification");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    taskManager.addUser(new User(userName));
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    taskManager.addTask(new Task(taskDescription));
                    break;
                case 3:
                    System.out.print("Enter user name to assign task: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task ID to assign: ");
                    int taskId = scanner.nextInt();
                    taskManager.assignTask(userName, taskId);
                    break;
                case 4:
                    taskManager.listUsers();
                    break;
                case 5:
                    taskManager.listTasks();
                    break;
                case 6:
                    System.out.print("Enter user name for notification: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter notification message: ");
                    String message = scanner.nextLine();
                    taskManager.sendNotification(userName, message);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    saveData(); // Save data before exit
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void saveData() {
        // Save data to storage (implementation omitted for brevity)
        System.out.println("Data saved successfully.");
    }

    public static void main(String[] args) {
        new TaskManagementApp();
    }
}
