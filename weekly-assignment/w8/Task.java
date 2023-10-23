public class Task {
    private String description;
    private int priority;
    private int workload;

    public Task(String description, int priority, int workload) {
        this.description = description;
        this.priority = priority;
        this.workload = workload;
    }

    public int getWorkload() {
        return workload;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return description + " takes " + workload + " minutes and has priority " + translatePriority(priority);
    }

    private String translatePriority(int priority) {
        return switch (priority) {
            case 1 -> "very important";
            case 2 -> "important";
            case 3 -> "unimportant";
            case 4 -> "after learn Portuguese";
            default -> "not in range";
        };

    }
}
