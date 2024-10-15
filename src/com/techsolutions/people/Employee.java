package people;

import java.util.ArrayList;
import java.util.List;

import classes.Task;
// import classes.TaskAssignmentStrategy;

public abstract class Employee extends Person{
    private List<Task> tasks;
    // private TaskAssignmentStrategy taskAssignmentStrategy;

    public Employee(String name, String dni, String phone, String email, int id){
        super(name, dni, phone, email, id);
        this.tasks = new ArrayList<>();
    }
    
    // public void setTaskAssignmentStrategy(TaskAssignmentStrategy strategy) {
    //     this.taskAssignmentStrategy = strategy;
    // }

    // public void assignTask(Task task) {
    //     if (taskAssignmentStrategy != null) {
    //         taskAssignmentStrategy.assignTask(task, this);
    //     } else {
    //         System.out.println("No hay estrategia de asignación definida.");
    //     }
    // }

    public abstract void trabajar();

    public List<Task> getTasks() { return tasks; }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
