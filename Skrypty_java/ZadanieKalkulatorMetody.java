import java.util.Scanner;

public class ZadanieKalkulatorMetody {

    public static void main(String[] args) {

        Scanner pierwszySkaner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        int pierwszaLiczba = pierwszySkaner.nextInt();

        Scanner drugiSkaner = new Scanner(System.in);
        System.out.println("Podaj drugą liczbę");
        int drugaLiczba = drugiSkaner.nextInt();


        MetodyKalkulatora obliczenia = new MetodyKalkulatora();
        obliczenia.suma(pierwszaLiczba, drugaLiczba);
        obliczenia.roznica(pierwszaLiczba, drugaLiczba);
        obliczenia.mnozenie(pierwszaLiczba, drugaLiczba);

    }
}
