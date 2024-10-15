package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Company;
import classes.Project;
import people.Customer;

public class MenuGestionClientes{
    static Scanner input = new Scanner(System.in);

    public static void start(){
        System.out.println("=============================");
        System.out.println("////Gestión de clientes////");
        System.out.println("=============================");
        System.out.println("1 - Agregar nuevo cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Mostrar datos de un cliente");
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
                System.out.println("Nombre del cliente:");
                String name = input.nextLine();
                System.out.println("DNI:");
                String dni = input.nextLine();
                System.out.println("Número de teléfono:");
                String phone = input.nextLine();
                System.out.println("Email:");
                String email = input.nextLine();
                Customer newCustomer = new Customer(name, dni, phone, email, Company.getInstance().getSizeCustomers()+1);
                Company.getInstance().addCustomer(newCustomer);
                System.out.println("Cliente " + name + " creado.");
                break;
            case 2:
                System.out.println("Listando todos los clientes:\n");
                for (Customer customer : Company.getInstance().getCustomers()) {
                    String projectName = (customer.getProject() != null) ? customer.getProject().getName() : "No asignado";
                    System.out.println("Nombre: " + customer.getName()  + " | Proyecto: " + projectName);
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
            default:
                System.out.println("Valor incorrecto");
                break;
        }
    }
}
