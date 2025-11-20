package command;

import domain.Task;
import persistence.TaskRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Comando concreto del patrón Command.
 * Se encarga de marcar una tarea como completada usando los datos guardados en memoria.
 */
public class CompleteTaskCommand implements TaskCommand {
    private final TaskRepository repository;
    private final Scanner reader;

    public CompleteTaskCommand(TaskRepository repository, Scanner reader) {
        this.repository = repository;
        this.reader = reader;
    }

    /*
     * Muestra la lista, pide un número y marca la tarea como completada.
     */
    @Override
    public void execute() {
        List<Task> tasks = repository.loadAll();

        if (tasks.isEmpty()) {
            System.out.println("No hay tareas para completar.");
            return;
        }

        System.out.println("Seleccione el número de la tarea a completar: ");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task);
        }

        try {
            System.out.print("Número de tarea: ");
            String line = reader.nextLine();
            int index = Integer.parseInt(line) - 1;

            if (index < 0 || index >= tasks.size()) {
                System.out.println("Número inválido.");
                return;
            }

            Task taskToComplete = tasks.get(index);
            taskToComplete.complete();
            repository.saveAll(tasks);

            System.out.println("Tarea completada: " + taskToComplete);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ser un número.");
        }
    }
}
