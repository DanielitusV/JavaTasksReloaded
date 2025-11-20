package command;

import domain.Task;
import persistence.TaskRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Comando concreto del patrón Command.
 * Se encarga de mostrar todas las tareas almacenadas en el repositorio.
 */
public class ListTasksCommand implements TaskCommand {
    private final TaskRepository repository;
    private final Scanner reader;

    public ListTasksCommand(TaskRepository repository, Scanner reader) {
        this.repository = repository;
        this.reader = reader;
    }

    /*
     * Ejecuta la acción de listar las tareas en consola
     */
    @Override
    public void execute() {
        List<Task> tasks = repository.loadAll();

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("Listado de tareas:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(i + 1 + ". " + task);
        }

        System.out.println();
        System.out.print("Presione Enter para volver al menú: ");
        reader.nextLine();
    }
}
