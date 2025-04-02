import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException { // odczyt ma wyjątek pliki nie znaleziono

        File odczyt = new File("text.txt");
        Scanner myReader = new Scanner(odczyt); // tworzymy coś co będzie czytać plik

        while (myReader.hasNext()) { // hasNext() funkcja sprawdzająca czy jest kolejna linijka w pliku
            String linijka = myReader.nextLine(); // pobierz linijki tekstu
            System.out.println(linijka); // wypisz linijki tekstu
        }
        myReader.close(); // zamykamy czytacza
    }
}
