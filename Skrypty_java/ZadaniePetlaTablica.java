public class ZadaniePetlaTablica {

    public static void main(String[] args) {

        for (int i=0; i<=100; i++) {
            if (i%3==0)
            System.out.println("Liczba dzielona przez 3 bez reszty to " +i);
        }

        // odwrócenie wartości elementów tablicy
        int[] tablica = new int[] {1,3,5,7,9};

        for (int i=0; i<(tablica.length/2); i++) {
            int temp = tablica[i]; // tymczasowo przechowuje wartość elementów tablicy
            tablica[i] = tablica[tablica.length - 1 - i]; // przenoszenie ostatnich na pierwsze
            tablica[tablica.length - 1 - i] = temp; // przenoszenie pierwszych na ostatnie
        }

        for (int i=0; i< tablica.length; i++) {
            System.out.println(tablica[i]);

            System.out.println("test");
        }

    }
}
