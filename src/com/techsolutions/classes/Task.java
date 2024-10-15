package classes;
import people.Employee;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;
    private String name;
    private String status;
    private List<Employee> Employees;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = "Pendiente";
        this.Employees = new ArrayList<>();
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
        // notifyEmployees();
    }

    public void addEmployee(Employee employee) {
        Employees.add(employee);
        // notifyEmployee(employee);
    }

    // private void notifyEmployee(Employee employee) {
    //     System.out.println("Notificando a " + employee.getName() + ": la tarea '" + name + "' ha sido asignada.");
    // }

    // private void notifyEmployees() {
    //     for (Employee employee : assignedEmployees) {
    //         System.out.println("Notificando a " + employee.getName() + ": el estado de la tarea '" + name + "' ha cambiado a " + status + ".");
    //     }
    // }

    // Getters y Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public List<Employee> getEmployees() { return Employees; }
}
