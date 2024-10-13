package classes;

import java.util.ArrayList;
import java.util.List;

import people.Customer;
import people.Employee;
import people.Manager;

public class Project{
    private int id;
    private String name;
    private Manager manager;
    private List<Employee> employees = new ArrayList<>();
    private Customer customer;
    private List<Task> tasks = new ArrayList<>();

    public Project(String name, int id){
        this.name = name;
        this.id = id;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
