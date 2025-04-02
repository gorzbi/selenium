import java.util.Scanner;

public class ZadanieKalkulator {

    public static void main(String[] args) {

        Scanner pierwszySkaner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        int pierwszaLiczba = pierwszySkaner.nextInt();

        Scanner drugiSkaner = new Scanner(System.in);
        System.out.println("Podaj drugą liczbę");
        int drugaLiczba = drugiSkaner.nextInt();

        int suma = pierwszaLiczba + drugaLiczba;
        int roznica = pierwszaLiczba - drugaLiczba;
        int iloczyn = pierwszaLiczba * drugaLiczba;
        int iloraz = pierwszaLiczba / drugaLiczba;
        int resztaDzielenie = pierwszaLiczba%drugaLiczba;

        System.out.println("Suma liczba to: " + suma);
        System.out.println("Różnica liczb to: " + roznica);
        System.out.println("Iloczyn liczb to: " + iloczyn);
        System.out.println("Iloraz liczb to: " + iloraz);
        System.out.println("Reszta z dzielenia to: " + resztaDzielenie);
    }
}
