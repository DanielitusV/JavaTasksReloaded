package persistence;

import domain.Task;
import java.util.List;

/**
 * Interfaz para el acceso a datos de tareas (DAO).
 * Separa la lógica de persistencia del resto de la aplicación.
 **/

public interface TaskRepository {
    /*
    * Carga todas las tareas desde la fuente de datos.
    * @return lista de tareas encontradas
    */
    List<Task> loadAll();

    /*
    * Guarda todas las tareas en la fuente de datos.
    * @param tasks lista de tareas a persistir.
    */
    void saveAll(List<Task> tasks);
}
