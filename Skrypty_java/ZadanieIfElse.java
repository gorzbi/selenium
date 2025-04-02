import java.sql.SQLOutput;
import java.util.Scanner;

public class ZadanieIfElse {

    public static void main(String[] args) {

        Scanner wiek = new Scanner(System.in);
        System.out.println("Ile masz lat?");
        int liczba = wiek.nextInt();

        if (liczba < 18 && liczba >= 0)  {
            System.out.println("Jesteś niepełnoletni");
        } else if (liczba < 0) {
            System.out.println("Wprowadć wartość większą od 0");
        }
            else {
            System.out.println("Jesteś pełnoletni");
        }
    }
}
