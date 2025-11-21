package persistence;
import domain.Task;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementación de TaskRepository en memoria.
 * No usa archivos ni base de datos, solo mantiene las tareas en una lista.
 */
public class InMemoryTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    /*
     * Devuelve una copia de la lista de tareas en memoria.
     */
    @Override
    public List<Task> loadAll() {
        return new ArrayList<>(tasks);
    }

    /*
     * Reemplaza el contenido interno por la lista de tareas recibida.
     */
    @Override
    public void saveAll(List<Task> tasks) {
        this.tasks.clear();
        if (tasks != null) {
            this.tasks.addAll(tasks);
        }
    }
}
