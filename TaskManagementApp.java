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
        boolean running = true;
        while (running) {
            System.out.println("\n--- Task Management System Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Assign Task");
            System.out.println("4. List Users");
            System.out.println("5. List Tasks");
            System.out.println("6. Send Notification");
            System.out.println("7. Exit");

            int choice = getIntegerInput("Select an option: ");
            switch (choice) {
                case 1:
                    String userName = getUserInput("Enter user name: ");
                    taskManager.addUser(new User(userName));
                    System.out.println("User added successfully.");
                    break;
                case 2:
                    String taskDescription = getUserInput("Enter task description: ");
                    taskManager.addTask(new Task(taskDescription));
                    System.out.println("Task added successfully.");
                    break;
                case 3:
                    userName = getUserInput("Enter user name to assign task: ");
                    int taskId = getIntegerInput("Enter task ID to assign: ");
                    taskManager.assignTask(userName, taskId);
                    System.out.println("Task assigned successfully.");
                    break;
                case 4:
                    taskManager.listUsers();
                    break;
                case 5:
                    taskManager.listTasks();
                    break;
                case 6:
                    userName = getUserInput("Enter user name for notification: ");
                    String message = getUserInput("Enter notification message: ");
                    taskManager.sendNotification(userName, message);
                    System.out.println("Notification sent successfully.");
                    break;
                case 7:
                    exitApp();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    private void saveData() {
        // Save data to storage (implementation omitted for brevity)
        System.out.println("Data saved successfully.");
    }

    private void exitApp() {
        saveData();
        System.out.println("Exiting...");
        scanner.close();
    }

    public static void main(String[] args) {
        new TaskManagementApp();
    }
}
