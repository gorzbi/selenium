import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void main(String[] args) throws IOException { // zapis do pliku obsługuje wyjątek

        FileWriter zapis = new FileWriter("text.txt");
        zapis.write("Zapis tekstu do pliku"); // nadpisuje wszystko co wcześniej było w pliku
        zapis.close();
        System.out.println("Zaktualizowano plik");

    }
}
