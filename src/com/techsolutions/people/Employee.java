package people;

import java.util.ArrayList;
import java.util.List;

import classes.Task;

public abstract class Employee extends Person{
    private List<Task> tasks;
    private classes.TaskAssignmentStrategy taskAssignmentStrategy;

    public Employee(String name, String dni, String phone, String email){
        super(name, dni, phone, email);
        this.tasks = new ArrayList<>();
    }
    
    public void setTaskAssignmentStrategy(classes.TaskAssignmentStrategy strategy) {
        this.taskAssignmentStrategy = strategy;
    }

    public void assignTask(Task task) {
        if (taskAssignmentStrategy != null) {
            taskAssignmentStrategy.assignTask(task, this);
        } else {
            System.out.println("No hay estrategia de asignación definida.");
        }
    }

    public abstract void trabajar();

    public List<Task> getTasks() { return tasks; }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
