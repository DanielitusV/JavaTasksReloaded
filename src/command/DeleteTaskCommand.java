package command;

import domain.Task;
import persistence.TaskRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Comando concreto del patrón Command.
 * Se encarga de eliminar una tarea seleccionada por el usuario.
 */
public class DeleteTaskCommand implements TaskCommand {
    private final TaskRepository repository;
    private final Scanner reader;

    public DeleteTaskCommand(TaskRepository repository, Scanner reader) {
        this.repository = repository;
        this.reader = reader;
    }

    /*
     * Muestra la lista, pide un número y elimina la tarea elegida.
     */
    @Override
    public void execute() {
        List<Task> tasks = repository.loadAll();

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }

        System.out.println("Seleccione el número de la tarea a eliminar:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task);
        }

        try {
            System.out.println("Número de tarea: ");
            String line = reader.nextLine();
            int index = Integer.parseInt(line) - 1;

            if (index < 0 || index >= tasks.size()) {
                System.out.println("Número inválido.");
                return;
            }

            Task removed = tasks.remove(index);
            repository.saveAll(tasks);

            System.out.println("Tarea eliminada: " + removed);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ser un número.");
        }
    }
}
