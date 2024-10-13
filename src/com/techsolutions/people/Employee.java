package people;

import java.util.ArrayList;
import java.util.List;

import classes.Task;

public abstract class Employee extends Person{
    private List<Task> tasks;

    public abstract void trabajar();
}
