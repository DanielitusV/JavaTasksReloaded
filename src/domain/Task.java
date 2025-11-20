package domain;

/**
 * Representa una tarea simple de la lista de pendientes.
 * Aplica el patrón Factory Method mediante el método estático 'create'
**/

public class Task {
    private final String title;
    private boolean completed;

    /*
     * Constructor privado para obligar el uso del Factory Method
     * @param title -> título de la tarea
     */
    private Task(String title) {
        this.title = title;
        this.completed = false;
    }

    /*
    * Factory Method: crea una nueva tarea con el título indicado.
    */
    public static Task create(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("El título de la tarea no puede estar vacío");
        }
        return new Task(title);
    }

    public void complete() {
        this.completed = true;
    }
    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[X]": "[ ]";
        return status + " " + title;
    }
}
