package classes;

import java.util.ArrayList;
import java.util.List;

import people.Customer;
import people.Employee;
import people.Manager;

public class Company{
    private static Company instance;
    private String name;
    private List<Project> projects;
    private List<Customer> customers;
    private List<Manager> managers;
    private List<Employee> employees;


    private Company(){
        this.projects = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public static Company getInstance(){
        if(instance == null){
            instance = new Company();
        }
        return instance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void createProject(String name){
        int id = projects.size() + 1;
        projects.add(new Project(name, id));
    }
    public List<Project> getProjects() {
        return projects;
    }
    public Project getProjectByID(int id){
        for(Project project: projects){
            if(project.getId() == id){
                return project;
            }
        }
        return null;
    }
    // public void setProjects(List<Project> projects) {
    //     this.projects = projects;
    // }

    public List<Customer> getCustomers() {
        return customers;
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Manager> getManagers() {
        return managers;
    }
    // public void setManagers(List<Manager> managers) {
    //     this.managers = managers;
    // }

    public List<Employee> getEmployees() {
        return employees;
    }
    // public void setEmployees(List<Employee> employees) {
    //     this.employees = employees;
    // }

}