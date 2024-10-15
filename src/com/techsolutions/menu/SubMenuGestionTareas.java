package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.DirectAssignmentStrategy;
import classes.Project;
import classes.RandomAssignmentStrategy;
import classes.Task;
import people.Employee;

public class SubMenuGestionTareas {
     static Scanner input = new Scanner(System.in);

    public static void start(Project project){
        System.out.println("=============================");
        System.out.println("Gestión de tareas - " + project.getName());
        System.out.println("=============================");
        System.out.println("1 - Crear nueva tarea");
        System.out.println("2 - Listar tareas");
        System.out.println("3 - Cambiar estado de tarea");
        System.out.println("4 - Asignar tarea a un empleado");
        System.out.println("5 - Ver empleados de una tarea");
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
            case 1:{
                System.out.println("Nombre de nueva tarea:");
                String taskName = input.nextLine();
                project.addTask(taskName);
                
                break;
            }
            case 2:{
                System.out.println("Listando todas las tareas de" + project.getName() + ":\n");
                for (Task task : project.getTasks()){
                    System.out.println("\nNombre: " + task.getName() + " | ID: " + task.getId() +
                    "\nCantidad de empleados: " + task.getEmployees().size() + " Estado: " + task.getStatus());
                }
                break;
            }
            case 3:{
                for (Task task : project.getTasks()){
                    System.out.println("\nNombre: " + task.getName() + " | ID: " + task.getId() +
                    "\nEstado: " + task.getStatus());
                }
                System.out.println("Ingrese ID de tarea: ");
                int id_Task = input.nextInt();
                input.nextLine();
                Task task = project.getTaskByID(id_Task);
                System.out.println("Nuevo estado para tarea " + task.getName() +
                "\n1.PENDIENTE" +
                "\n2.EN CURSO" +
                "\n3.FINALIZADA");
                int newStatus = input.nextInt();
                switch (newStatus) {
                    case 1:
                        task.changeStatus("PENDIENTE");
                        break;
                    case 2:
                        task.changeStatus("EN CURSO");
                        break;
                    case 3:
                        task.changeStatus("FINALIZADA");
                        break;
                    default:
                    System.out.println("Valor ingresado inválido");
                        break;
                }
                break;
            }
            case 4:{
                
                for (Task task : project.getTasks()){
                    System.out.println("\nNombre: " + task.getName() + " | ID: " + task.getId());
                }
                System.out.println("Ingrese ID de tarea: ");
                int id_Task = input.nextInt();
                input.nextLine();
                Task task = project.getTaskByID(id_Task);

                System.out.println("Seleccione método de asignación: ");
                System.out.println("1. Asignación directa");
                System.out.println("2. Asignación aleatoria");
                int assignmentMethod = input.nextInt();
                input.nextLine();
                    switch (assignmentMethod) {
                        case 1:
                            task.setAssignmentStrategy(new DirectAssignmentStrategy());
                            break;
                        case 2:
                            task.setAssignmentStrategy(new RandomAssignmentStrategy());
                            task.assignEmployee(null);
                            return;
                        default:
                            System.out.println("Método de asignación no válido. Se usará asignación directa por defecto.");
                            task.setAssignmentStrategy(new DirectAssignmentStrategy());
                            break;
                    }
                
                
                System.out.println("Asignar tarea " + task.getName() + " al empleado");

                for (Employee employee : project.getEmployees()) {
                    System.out.println("Nombre: " + employee.getName() + " | DNI: " + employee.getDni());
                }
                System.out.println("Ingrese DNI de empleado: ");
                String dni_Employee = input.nextLine();
                Employee employee = project.getEmployeeByDNI(dni_Employee);
                task.assignEmployee(employee);
                break;
            }
            case 5:{
                for (Task task : project.getTasks()){
                    System.out.println("\nNombre: " + task.getName() + " | ID: " + task.getId());
                }
                System.out.println("Ingrese ID de tarea: ");
                int id_Task = input.nextInt();
                input.nextLine();
                Task task = project.getTaskByID(id_Task);
                System.out.println("Empleados de la tarea " + task.getName());
                for (Employee employee : task.getEmployees()){
                    System.out.println("\nNombre: " + employee.getName() + " | Email: " + employee.getEmail());
                }
                break;
            }
            default:
                System.out.println("Valor incorrecto");
                break;
        }
    }
}
