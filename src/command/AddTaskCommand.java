package command;

import domain.Task;
import persistence.TaskRepository;

import java.util.List;
import java.util.Scanner;

public class AddTaskCommand implements TaskCommand {
    private final TaskRepository repository;
    private final Scanner reader;

    public AddTaskCommand(TaskRepository repository, Scanner reader) {
        this.repository = repository;
        this.reader = reader;
    }

    /*
     * Ejecuta la acción de crear una nueva tarea
     */
    @Override
    public void execute() {
        System.out.print("Ingrese el título de la nueva tarea: ");
        String title = reader.nextLine();

        List<Task> tasks = repository.loadAll();
        Task newTask = Task.create(title);
        tasks.add(newTask);
        repository.saveAll(tasks);

        System.out.println("Tarea agregada: " + newTask);
    }
}
