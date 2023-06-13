import java.util.*;

public class Agenda {

    private static Map<String, String> contactos = new HashMap<>();

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("****Menú****");
            System.out.println("1 --> Añadir nuevo contacto");
            System.out.println("2 --> Buscar teléfono de contacto");
            System.out.println("3 --> Mostrar información de todos los contactos");
            System.out.println("4 --> Salir");
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    agregarContacto(sc);
                    break;
                case 2:
                    buscarTelefono(sc);
                    break;
                case 3:
                    mostrarContactosOrdenados ();
                    break;
                case 4:
                    System.out.println("Hasta luego!!!");
                    break;
                default:
                    System.out.println("Opción no permitida, Intenta de nuevo: ");
                    break;
            }

            System.out.println();
        } while (opcion !=4);

        sc.close();
    }

    private static void agregarContacto (Scanner scanner) {
        System.out.println("Ingresa el nombre del contacto");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa el número de teléfono");
        String telefono = scanner.nextLine();

        String informacion = nombre + " : " + telefono;
        contactos.put(nombre.toLowerCase(), informacion);

        System.out.println("Contacto agregado correctamente");

    }

    private static void buscarTelefono (Scanner scanner){
        System.out.println("Ingresa el nombre del contacto a buscar");
        String nombre = scanner.nextLine();

        String informacion = contactos.get(nombre.toLowerCase());
        if (informacion != null){
            String [] partes = informacion.split(":");
            String telefono = partes[1];
            System.out.println("Teléfono : " + telefono);

        } else {
            System.out.println("Contacto no encontrado");
        }

    }

    private static void mostrarContactosOrdenados () {
        List<String> nombres = new ArrayList<>(contactos.keySet());
        Collections.sort(nombres);

        System.out.println("Lista de contactos");

        for (String nombre : nombres ) {
            String informacion = contactos.get(nombre);
            String[] partes = informacion.split(":");
            String telefono = partes [1];
            System.out.println("Nombre: " + nombre + ", Teléfono: " + telefono );
        }
    }
}