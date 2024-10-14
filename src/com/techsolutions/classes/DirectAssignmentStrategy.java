package classes;

import classes.Task;
import people.Employee;

public class DirectAssignmentStrategy implements TaskAssignmentStrategy {
    @Override
    public void assignTask(Task task, Employee employee) {
        employee.addTask(task);
        task.addEmployee(employee);
        System.out.println("La tarea '" + task.getName() + "' ha sido asignada directamente a " + employee.getName());
    }
}