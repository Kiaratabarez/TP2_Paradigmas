package people;

import java.util.ArrayList;
import java.util.List;

import classes.Task;

public abstract class Employee extends Person{
    private List<Task> tasks;

    public Employee(String name, String dni, String phone, String email){
        super(name, dni, phone, email);
    }
    
    public abstract void trabajar();
}
