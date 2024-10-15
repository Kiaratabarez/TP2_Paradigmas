import classes.Company;
import classes.Project;
import people.Developer;
import people.Customer;
import people.Employee;
import people.EmployeeFactory;
import classes.Task;
import classes.TxtFileAdapter;
import menu.MenuGestionProyectos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Company company = Company.getInstance();

        // Company company = adapter.readCompanyData();
        // TxtFileAdapter adapter = new TxtFileAdapter("ruta_del_archivo.txt");

        company.setName("Twice Entertainment");
        company.createProject("Comer sandía");
        company.createProject("Salir a caminar");
        company.createProject("Saltar en el trampolín");

        // Crear empleados
        Employee empleado1 = EmployeeFactory.createEmployee("Francisco", "46237591", "3764", "fbagneres@gmail.com", "Developer");
        Employee empleado2 = EmployeeFactory.createEmployee("Romina", "123456", "12345678", "romina@gmail.com", "Developer");
        company.getProjectByID(1).addEmployee(empleado1);
        company.getProjectByID(1).addEmployee(empleado2);

        System.out.println("Bienvenido al sistema de la empresa " + company.getName());

        while (true) {
            System.out.println("\n=============================");
            System.out.println("Seleccione una opcion");
            System.out.println("1 - Gestionar proyectos");
            System.out.println("2 - Gestionar clientes");
            System.out.println("3 - Gestionar empleados");
            System.out.println("0 - Salir");
            System.out.println("=============================");


            int selection;
            try {
                selection = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número valido.");
                input.nextLine();
                continue;
            }

            switch(selection){
                case 0:
                    System.out.println("Saliendo del sistema...");
                    input.close();
                    return;
                case 1:
                    MenuGestionProyectos.start();
                    break;
                case 2:
                    System.out.println("Listando todos los proyectos:\n");
                    for (Project project : company.getProjects()) {
                        System.out.println("Nombre: " + project.getName() + " ID: " + project.getId());
                    }
                    break;
                case 3:
                    System.out.println("Nombre del cliente:");
                    String name = input.nextLine();
                    System.out.println("DNI:");
                    String dni = input.nextLine();
                    System.out.println("Número de teléfono:");
                    String phone = input.nextLine();
                    System.out.println("Email:");
                    String email = input.nextLine();
                    Customer newCustomer = new Customer(name, dni, phone, email);
                    company.addCustomer(newCustomer);
                    System.out.println("Cliente " + name + " creado.");
                    break;
                case 4:
                    System.out.println("Listando todos los clientes:\n");
                    for (Customer customer : company.getCustomers()) {
                        System.out.println("Nombre: " + customer.getName());
                    }
                    break;
                case 5:
                    System.out.println("ID del proyecto para crear la tarea:");
                    int projectId = input.nextInt();
                    input.nextLine();
                    System.out.println("Nombre de la tarea:");
                    String taskName = input.nextLine();
                    company.getProjectByID(projectId).addTask(taskName);
                    break;
                case 6:
                    System.out.println("ID del proyecto para mostrar resumen:");
                    int projectSummaryId = input.nextInt();
                    input.nextLine();
                    company.getProjectByID(projectSummaryId).showProjectSummary();
                    break;
                default:
                    System.out.println("Valor inválido.");
                    break;
            }
        }
    }
}
