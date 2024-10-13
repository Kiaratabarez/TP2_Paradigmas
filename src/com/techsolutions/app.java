import classes.Company;
import classes.Project;
import people.Developer;
import people.Customer;
import people.Employee;
import people.EmployeeFactory;

import java.util.Scanner;

public class app{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Company.getInstance().setName("Twice Entertainment");
        Company.getInstance().createProject("Comer sandía");
        Company.getInstance().createProject("Salir a caminar");
        Company.getInstance().createProject("Saltar en el trampolín");

        Employee empleado3 = EmployeeFactory.createEmployee("Francisco", "46237591", "3764", "fbagneres@gmail.com", "Developer");
        Employee empleado4 = EmployeeFactory.createEmployee("Romina", "123456", "12345678", "romina@gmail.com", "Developer");

        Developer empleado1 = new Developer("Francisco", "46237591", "3764", "fbagneres@gmail.com");
        Developer empleado2 = new Developer("Romina", "123456", "12345678", "romina@gmail.com");

        Company.getInstance().getProjectByID(1).addEmployee(empleado3);
        Company.getInstance().getProjectByID(1).addEmployee(empleado4);

        System.out.println("Bienvenido al sistema de la empresa " + Company.getInstance().getName());

        while(true){
            System.out.println("¿Qué acción desea realizar?" +
            "\n1- Crear nuevo proyecto" +
            "\n2- Mostrar los proyectos" +
            "\n3- Agregar nuevo cliente" +
            "\n4- Listar clientes");
            int selection = input.nextInt();
            input.nextLine();
            switch(selection) {
                case 0:{
                    break;
                }
                case 1:{
                    System.out.println("creando wea weosa");
                    break;
                }
                case 2:{
                    System.out.println("Listando todos los proyectos:\n");
                    for(Project project: Company.getInstance().getProjects()){
                        System.out.println("Nombre: " + project.getName() + "ID: " + project.getId());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Nombre:");
                    String name = input.nextLine();
                    System.out.println("Dni:");
                    String dni = input.nextLine();
                    System.out.println("N. Teléfono:");
                    String phone = input.nextLine();
                    System.out.println("Email:");
                    String email = input.nextLine();
                    System.out.println("Se ha creado el cliente " + name + " con el dni " + dni + ", telefono " + phone + " email " + email);

                    Customer newCustomer = new Customer(name, dni, phone, email);
                    Company.getInstance().addCustomer(newCustomer);
                    break;
                }
                case 4:{
                    System.out.println("Listando todos los clientes:\n");
                    for(Customer customer: Company.getInstance().getCustomers()){
                        System.out.println("Nombre: " + customer.getName());
                    }
                    break;
                }
                case 5:{
                    System.out.println("Listando todos los empleados:\n");
                    for(Employee employee: Company.getInstance().getProjectByID(1).getEmployees()){
                        System.out.println("Nombre: " + employee.getName());
                    }
                    break;
                }
                default:
                    System.out.println("Valor inválido.");
                    break;
            }

            if(selection == 0){
                break;
            }
        }
        input.close();
    }
}