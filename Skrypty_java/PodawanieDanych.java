import java.util.Scanner;

public class PodawanieDanych {
    public static void main(String[] args) {

        Scanner pierwszySkaner = new Scanner(System.in); // pole do wpisywania tekstu
        System.out.println("Wpisz imię");
        String imie = pierwszySkaner.nextLine(); //nextLine odczytuje tekst
        System.out.println("Cześć " + imie + " :)");

        Scanner drugiSkaner = new Scanner(System.in);
        System.out.println("Podaj liczbę");
        int liczba = drugiSkaner.nextInt(); //nextInt odczytuje liczbę
        System.out.println("Kwadrat liczby " + liczba + " to: " + liczba*liczba);

    }
}
