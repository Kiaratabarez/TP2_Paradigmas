package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Company;
import classes.Project;

public class MenuGestionProyectos{
    static Scanner input = new Scanner(System.in);

    public static void start(){
        System.out.println("=============================");
        System.out.println("////Gestión de proyectos////");
        System.out.println("=============================");
        System.out.println("1 - Crear nuevo proyecto");
        System.out.println("2 - Listar proyectos");
        System.out.println("3 - Mostrar resúmen de un proyecto");
        System.out.println("4 - Gestionar tareas de un proyecto");
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
                input.close();
                break;
            case 1:
                System.out.println("Nombre del nuevo proyecto:");
                String projectName = input.nextLine();
                Company.getInstance().createProject(projectName);
                break;
            case 2:
                System.out.println("Listando todos los proyectos:\n");
                for (Project project : Company.getInstance().getProjects()) {
                    System.out.println("Nombre: " + project.getName() + " ID: " + project.getId()); //AGREGAR MANAGER Y CLIENTE
                }
                break;
            default:
                break;
        }
    }
}
