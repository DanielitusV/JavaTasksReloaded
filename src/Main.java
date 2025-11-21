import command.*;

import persistence.InMemoryTaskRepository;
import persistence.TaskRepository;

import java.util.Scanner;

/**
 * Clase principal de la aplicación JavaTasksReloaded.
 * Muestra un menú simple en consola y ejecuta comandos CRUD
 * que usan el repositorio de tareas en memoria.
 */
public class Main {
   public static void main(String[] args) {
       Scanner reader = new Scanner(System.in);
       TaskRepository repository = new InMemoryTaskRepository();

       TaskCommand addCommand = new AddTaskCommand(repository, reader);
       TaskCommand listCommand = new ListTasksCommand(repository, reader);
       TaskCommand completeCommand = new CompleteTaskCommand(repository, reader);
       TaskCommand deleteCommand = new DeleteTaskCommand(repository, reader);

       boolean running = true;
       System.out.println("JavaTasksReloaded - Gestor simple de tareas");

       while (running) {
           System.out.println();
           System.out.println("---- MENÚ ----");
           System.out.println("1. Agregar tarea");
           System.out.println("2. Listar tareas");
           System.out.println("3. Completar tareas");
           System.out.println("4. Eliminar Tarea");
           System.out.println("5. Salir");
           System.out.print("Opción: ");

           String input = reader.nextLine();

           switch (input) {
               case "1":
                   addCommand.execute();
                   break;
               case "2":
                   listCommand.execute();
                   break;
               case "3":
                   completeCommand.execute();
                   break;
               case "4":
                   deleteCommand.execute();
                   break;
               case "5":
                   running = false;
                   System.out.println("Adiós!");
                   break;
               default:
                   System.out.println("Opción inválida.");
           }
       }
       reader.close();
   }
}
