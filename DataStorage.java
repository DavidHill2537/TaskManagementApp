import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataStorage {
    private static final String USER_FILE = "users.dat";
    private static final String TASK_FILE = "tasks.dat";
    private static final Logger logger = Logger.getLogger(DataStorage.class.getName());

    public static void saveUsers(List<User> users) {
        if (users == null) {
            logger.warning("Attempted to save null user list.");
            return;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            out.writeObject(users);
            logger.info("Users saved successfully.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error saving users.", e);
        }
    }

    public static void saveTasks(List<Task> tasks) {
        if (tasks == null) {
            logger.warning("Attempted to save null task list.");
            return;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TASK_FILE))) {
            out.writeObject(tasks);
            logger.info("Tasks saved successfully.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error saving tasks.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<User> loadUsers() {
        if (!fileExists(USER_FILE)) {
            logger.warning("User file does not exist.");
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            List<User> users = (List<User>) in.readObject();
            logger.info("Users loaded successfully.");
            return users;
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error loading users.", e);
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Task> loadTasks() {
        if (!fileExists(TASK_FILE)) {
            logger.warning("Task file does not exist.");
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(TASK_FILE))) {
            List<Task> tasks = (List<Task>) in.readObject();
            logger.info("Tasks loaded successfully.");
            return tasks;
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error loading tasks.", e);
            return new ArrayList<>();
        }
    }

    private static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
