import java.util.Scanner;

public class For {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbę");
        int liczba = scan.nextInt();

        int i;

        for (i = 0; i <= liczba; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < liczba; j++ ) {
            if (j == 7)
                System.out.println("To jest 7");
            else
                System.out.println("To nie jest 7 " + j);
        }
    }
}
