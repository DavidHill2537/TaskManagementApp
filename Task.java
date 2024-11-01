class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private String assignedTo;

    public Task(String description) {
        this.id = idCounter++;
        this.description = description;
        this.assignedTo = null;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void assignTo(String user) {
        this.assignedTo = user;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description + ", Assigned To: " + (assignedTo != null ? assignedTo : "Unassigned");
    }
}
