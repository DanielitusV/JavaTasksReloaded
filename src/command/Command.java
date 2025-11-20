package command;

/**
 * Interfaz base para el patrón Command.
 * Representa cada acción ejecutable dentro de la aplicación.
 */
public interface Command {
    /*
     * Ejecuta la acción asociada al comando.
     */
    public void execute();
}
