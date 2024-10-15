package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Company;
import people.Customer;
import people.Employee;
import people.EmployeeFactory;
import people.Manager;

public class MenuGestionEmpleados{
        static Scanner input = new Scanner(System.in);

        public static void start(){
        String name;
        String dni;
        String phone;
        String email;
        String projectName;

        System.out.println("=============================");
        System.out.println("////Gestión de empleados////");
        System.out.println("=============================");
        System.out.println("1 - Crear nuevo empleado");
        System.out.println("2 - Listar empleados");
        System.out.println("3 - Asignar empleado a proyecto");
        System.out.println("4 - Crear nuevo gerente");
        System.out.println("5 - Listar gerentes");
        System.out.println("6 - Asignar gerente a un proyecto");
        System.out.println("0 - Atrás");

        int selection = 0;
        try {
            selection = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número valido.");
            input.nextLine();
        }
        switch(selection) {
            case 0:
                break;
            case 1:
                System.out.println("Nombre del empleado:");
                name = input.nextLine();
                System.out.println("DNI:");
                dni = input.nextLine();
                System.out.println("Número de teléfono:");
                phone = input.nextLine();
                System.out.println("Email:");
                email = input.nextLine();
                System.out.println("Rol(Designer/Developer/Tester):");
                String rol = input.nextLine();
                Company.getInstance().addEmployee(EmployeeFactory.createEmployee(name, dni, phone, email, rol));
                System.out.println("Empleado " + name + " creado.");
                break;
            case 2:
                System.out.println("Listando todos los empleados:\n");
                for(Employee employee : Company.getInstance().getEmployees()) {
                    projectName = (employee.getProject() != null) ? employee.getProject().getName() : "No asignado";
                    System.out.println("Nombre: " + employee.getName()  + " | Proyecto: " + projectName);
                }
                break;
            case 3:
                for (Customer customer : Company.getInstance().getCustomers()) {
                    System.out.println("Nombre: " + customer.getName()  + " | DNI: " + customer.getDni());
                }
                System.out.println("Ingrese DNI de cliente: ");
                String dni_Customer = input.nextLine();
                Customer customer = Company.getInstance().getCustomerByDNI(dni_Customer);
                String projectName = (customer.getProject() != null) ? customer.getProject().getName() : "No asignado";
                System.out.println("Datos del cliente " + customer.getName());
                System.out.println("DNI:" + customer.getDni() + " | Proyecto: " + projectName);
                System.out.println("Telefono: " + customer.getPhone() + " | Email: " + customer.getEmail());
                break;
            case 4:
                System.out.println("Nombre del gerente:");
                name = input.nextLine();
                System.out.println("DNI:");
                dni = input.nextLine();
                System.out.println("Número de teléfono:");
                phone = input.nextLine();
                System.out.println("Email:");
                email = input.nextLine();
                Company.getInstance().addCustomer(new Customer(name, dni, phone, email, Company.getInstance().getSizeManagers()+1));
                System.out.println("Gerente " + name + " creado.");
                break;
            case 5:
                System.out.println("Listando todos los gerentes:\n");
                for(Manager manager : Company.getInstance().getManagers()){
                    projectName = (manager.getProject() != null) ? manager.getProject().getName() : "No asignado";
                    System.out.println("Nombre: " + manager.getName()  + " | Proyecto: " + projectName);
                }
                break;
            case 6:
                break;
            default:
                System.out.println("Valor incorrecto");
                break;
        }
    }
}
