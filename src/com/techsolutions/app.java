import classes.Company;
import people.Employee;
import people.EmployeeFactory;

import menu.MenuGestionClientes;
import menu.MenuGestionEmpleados;
import menu.MenuGestionProyectos;
import menu.Clear;

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
        Employee empleado2 = EmployeeFactory.createEmployee("Romina", "123456", "12345678", "romina@gmail.com", "Tester");
        company.getProjectByID(1).addEmployee(empleado1);
        company.getProjectByID(1).addEmployee(empleado2);


        System.out.println(empleado1.getClass());
        System.out.println(empleado2.getClass());

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
                    MenuGestionClientes.start();
                    break;
                case 3:
                    MenuGestionEmpleados.start();
                    break;
                default:
                    System.out.println("Valor inválido.");
                    break;
            }
        }
    }
}
