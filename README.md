# JavaTasksReloaded

JavaTasksReloaded es una pequeña aplicación de consola escrita en **Java** para gestionar una lista de tareas (ToDo list) de forma simple.

Permite:

- Agregar tareas escribiendo un título.
- Listar todas las tareas registradas.
- Marcar una tarea como completada.
- Eliminar una tarea de la lista.
- Salir del programa.

Las tareas se guardan en memoria mientras la aplicación está en ejecución.

---

## Tecnologías

- Lenguaje: **Java** (recomendado 17+).
- Tipo de aplicación: **consola**, sin GUI.
- Dependencias externas: ninguna (solo librería estándar de Java).

---

## Uso

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/JavaTasksReloaded.git
cd JavaTasksReloaded
```

2. Compilar los archivos `.java` (ejemplo con `javac`):
```
javac src/**/*.java
```

3. Ejecutar la aplicación:
```
java -cp src Main
```

4. En consola se mostrará un menú:
```
---- MENU ----
1. Agregar tarea
2. Listar tareas
3. Completar tarea
4. Eliminar una tarea
5. Salir
```
- Ingrese `1` para crear una nueva tarea.
- Ingrese `2` para ver la lista de tareas (y luego presione `Enter` para volver al menú).
- Ingrese `3` para completar una tarea eligiéndola por número.
- Ingrese `4` para eliminar una tarea.
- Ingrese `5` para salir.

## Estructura del proyecto
```
src/
  Main.java

  domain/
    Task.java

  persistence/
    TaskRepository.java
    InMemoryTaskRepository.java

  command/
    TaskCommand.java
    AddTaskCommand.java
    ListTasksCommand.java
    CompleteTaskCommand.java
    DeleteTaskCommand.java

```
- `domain/Task`: Modela una tarea con título y estado (completada o no).
- `persistence/TaskRepository`: Define el contrato para guardar y cargar tareas.
- `persistence/InMemoryTaskRepository`: Mantiene las tareas en una lista en memoria.
- `command/`: contiene la interfaz `TaskCommand` y las acciones concretas del menú.
- `Main`: Crea el repositorio, los comandos y maneja el ciclo del menú.

## Diseño interno
La aplicación utiliza algunos patrones de diseño para mantener el código simple y organizado:
- **Factory method** en `Task.create(String title)` para centralizar la creación de tareas.
- **DAO / Repository** con `TaskRepository` e `InMemoryTaskRepository` para encapsular el acceso a los datos.
- **Command** con la interfaz `TaskCommand` y las clases `AddTaskCommand`, `ListTasksCommand`, `CompleteTaskCommand` y `DeleteTaskCommand` para representar cada acción del menú como un comando ejecutable.

## Licencia
Este proyecto se distribuye sin una licencia específica.
El código puede usarse con fines educativos y personales.