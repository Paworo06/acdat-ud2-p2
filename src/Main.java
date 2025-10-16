import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    /**
     * Programa base para la gestión de ficheros y directorios con java.io.File.
     * <p>
     * TODO:
     * - Implementar menú principal en consola.
     * - Usar únicamente la clase File para las operaciones.
     * - Reutilizar la comprobación de existencia/tipo de la práctica anterior.
     * - Manejar errores y mensajes.
     */
    public static void main(String[] args) {
        // TODO: Inicializar lectura de entrada y, si procede, ruta base desde args.
        // TODO: Bucle del menú hasta seleccionar Salir.
        // TODO: Enrutar cada opción a su método correspondiente.
        // TODO: Mensaje final al salir.

        int opcion = 0;

        do {
            System.out.println("""
                    -------- Menú --------
                    1. Crear directorio
                    2. Eliminar directorio
                    3. Crear fichero
                    4. Eliminar fichero
                    5. Salir
                    ----------------------""");

            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
                    eliminarDirectorio();
                    break;
                case 3:
                    crearFichero();
                    break;
                case 4:
                    eliminarFichero();
                    break;
                case 5:
                    System.out.println("Gracias por usar nuestro programa. Hasta la próxima!!!");
                    break;
                default:
                    System.out.println("Opción no válida. Solo opciones entre 1-5.");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * Crear directorio.
     * <p>
     * TODO:
     * - Pedir ruta del directorio.
     * - Validar entrada.
     * - Elegir mkdir o mkdirs.
     * - Mostrar éxito o motivo de fallo.
     */
    public static void crearDirectorio() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
        System.out.print("Introduce la ruta en la que deseas crear el directorio: ");
        String ruta = sc.nextLine();

        System.out.print("Dime el nombre del directorio: ");
        String nombre = sc.nextLine();

        File directorio = new File(ruta + "/" + nombre);
        if (directorio.mkdir()) {
            System.out.println("Directorio guardado correctamente.");
        } else  {
            System.out.println("Ruta no existente.");
        }
    }

    /**
     * Eliminar directorio.
     * <p>
     * TODO:
     * - Pedir ruta y verificar exists e isDirectory.
     * - Intentar delete (solo si está vacío).
     * - Informar si no se puede eliminar.
     */
    public static void eliminarDirectorio() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
        System.out.print("Introduce la ruta del directorio que deseas eliminar: ");
        String ruta = sc.nextLine();

        File directorio = new File(ruta);
        if (directorio.exists() && directorio.isDirectory() && directorio.delete()) {
            System.out.println("Directorio eliminado correctamente.");
        } else {
            System.out.println("No se puede eliminar el directorio. Asegurate que esté vacío o que exista.");
        }
    }

    /**
     * Crear fichero.
     * <p>
     * TODO:
     * - Pedir ruta completa del fichero.
     * - Verificar si existe.
     * - Crear con createNewFile controlando posibles excepciones.
     * - Si el directorio padre no existe, decidir si crearlo.
     */
    public static void crearFichero() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
    }

    /**
     * Eliminar fichero.
     * <p>
     * TODO:
     * - Pedir ruta y verificar exists() e isFile().
     * - Confirmar con el usuario antes de borrar.
     * - Eliminar con delete y mostrar resultado.
     */
    public static void eliminarFichero() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
        System.out.print("Introduce la ruta del archivo que deseas eliminar: ");
        String ruta = sc.nextLine();

        File fichero = new File(ruta);
        if (fichero.exists() && fichero.isFile()) {
            System.out.println("Archivo localizado con éxito");

            System.out.print("\n¿Está seguro que desea eliminar el fichero? (s/n)");
            String respuesta = sc.nextLine();

            if  (respuesta.equalsIgnoreCase("s") && fichero.delete()) {
                System.out.println("Fichero eliminado correctamente.");
            } else if  (respuesta.equalsIgnoreCase("n")) {
                System.out.println("El fichero no se eliminará");
            } else {
                System.out.println("Campo introducido no válido. El archivo no se eliminará");
            }
        } else {
            System.out.println("El archivo no existe o la ruta es incorrecta.");
        }
    }
}