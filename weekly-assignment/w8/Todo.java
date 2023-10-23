import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Todo {
    private ArrayList<Task> todoList = new ArrayList<>();
    private int totalWorkload;

    public Todo() {
        ArrayList<Task> todoList;
        totalWorkload = 0;
    }

    public void addTask(String description, int priority, int minutes) {
        boolean error = false;
        if (priority < 1 || priority > 4) {
            System.out.println(description + " has invalid priority");
            error = true;
        }
        if (minutes < 0) {
            System.out.println(description + " has invalid workload");
            error = true;
        }
        if (error) {
            return;
        } else todoList.add(new Task(description, priority, minutes));
    }

    public void print() {
        System.out.println("Todo:\n-----");
        if (todoList.isEmpty()) System.out.println("You're all done for today! #TodoZero");
        else {
            for (Task task : todoList) {
                System.out.println(task.toString());
            }
        }
        if (totalWorkload > 0) System.out.println(totalWorkload + " minutes of work done!");
    }

    public void completeTask(int index) {
        if (index < 0 || index >= todoList.size()) System.out.println("Invalid index");
        else {
            totalWorkload += todoList.get(index).getWorkload();
            todoList.remove(index);
        }
    }

    public void printPriority(int limit) {
        System.out.println("Filtered todo:\n--------------");

        boolean nothingPrinted = true;
        for (Task task : todoList) {
            if (task.getPriority() <= limit) {
                System.out.println(task.toString());
                nothingPrinted = false;
            }
        }
        if (nothingPrinted) {
            System.out.println("No tasks with given priority");
        }
    }

    public void printPrioritized() {
        System.out.println("Prioritized todo:\n-----------------");

        //Thanks chatGPT for help with this
        Comparator<Task> prioritize = Comparator.comparingInt(Task::getPriority)
                .thenComparing(Task::getWorkload);

        todoList.sort(prioritize);

        for (Task task : todoList) {
            System.out.println(task.toString());
        }
    }
}