import java.util.Scanner;

public class ZadanieOperatoryPorownania {

    public static void main(String[] args) {

        Scanner pierwszySkaner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        int pierwszaLiczba = pierwszySkaner.nextInt();

        Scanner drugiSkaner = new Scanner(System.in);
        System.out.println("Podaj drugą liczbę");
        int drugaLiczba = drugiSkaner.nextInt();

        System.out.println("a > b: " + (pierwszaLiczba > drugaLiczba));
        System.out.println("a < b: " + (pierwszaLiczba < drugaLiczba));
        System.out.println("a >= b: " + (pierwszaLiczba >= drugaLiczba));
        System.out.println("a <= b: " + (pierwszaLiczba <= drugaLiczba));
        System.out.println("a == b: " + (pierwszaLiczba == drugaLiczba));
        System.out.println("a != b: " + (pierwszaLiczba != drugaLiczba));

    }
}
