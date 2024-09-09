import java.util.Scanner;

public class Base {

    public static void main(String[] args) {
    
    // tablica składa się z ilości elementów y-x+1 (bo x i y są także w tej tablicy)
    // każdy element tablicy jest o 1 większy od poprzedniego
    // wprowadzenie pierwszej x i ostatniej y wartości tablicy

        Liczba num = new Liczba();
        int x = num.liczbaPierwsza();
        int y = num.liczbaDruga();

        while (y<=x) {
            System.out.println("Druga liczba musi być większa od pierwszej");
            y = num.liczbaDruga();
        }

// stworzenie tablicy n elementów
        int[] tablica;
        tablica = new int[y-x+1];

        for (int i=0; i<tablica.length; i++) {
            tablica[i]=i+x;
            System.out.println("Elementy tablicy to "+tablica[i]);
        }

// suma elementów tablicy
        int suma=0;

        for (int j=0; j<tablica.length; j++) {
            suma=suma+tablica[j];
        }
        System.out.println("Suma elementów tablicy to "+suma);
    }
}
