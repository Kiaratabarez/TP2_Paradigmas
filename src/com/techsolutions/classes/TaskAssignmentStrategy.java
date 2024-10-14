package classes;

import classes.Task;
import people.Employee;

public interface TaskAssignmentStrategy {
    void assignTask(Task task, Employee employee);
}
