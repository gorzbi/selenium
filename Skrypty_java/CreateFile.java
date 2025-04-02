import java.io.File;
import java.io.IOException;

public class CreateFile {

    public static void main(String[] args) throws IOException { // tworzenie pliku obsługuje wyjątek

        File plik = new File("text.txt"); // tworzymy plik na ścieżce

        if (plik.createNewFile()) { // domyślnie jest true dlatego możemy sprawdzić czy plik już istnieje
            System.out.println("Stowrzyłem nowy plik");
        } else {
            System.out.println("Plik już istniał");
        }

    }

}
