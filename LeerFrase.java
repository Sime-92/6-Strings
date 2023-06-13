import java.util.Arrays;

public class LeerFrase {

    public static void main(String[] args) {
        String frase = "Había una vez un perro, llegó otro y habían dos.";

        // Dividir la frase en palabras
        String[] palabras = frase.split(" ");

        // Ordenar las palabras
        Arrays.sort(palabras);

        // Mostrar las palabras ordenadas
        System.out.println("Palabras ordenadas:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}
