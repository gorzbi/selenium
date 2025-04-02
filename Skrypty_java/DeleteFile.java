import java.io.File;

public class DeleteFile {

    public static void main(String[] args) {

        File plik = new File("text.txt");

        if (plik.delete()) {
            System.out.println("Plik usunięto");
        } else {
            System.out.println("Nie udało się usunąć pliku");
        }
    }
}
