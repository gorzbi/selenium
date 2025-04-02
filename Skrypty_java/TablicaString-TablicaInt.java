import java.util.Arrays;
import java.util.Scanner;

public class Zadanko {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Wprowadź pierwszy numer: ");
        int number = sc.nextInt();

        // stworzenie ciągu znaków z wprowadzanych numerów
        String numbers = String.valueOf(number);
        // stworzenie separatora dla numerów
        String separator = ";";

        while (number != 0) {
            System.out.println("Wprowadź kolejny numer: ");
            number = sc.nextInt();
            // wypełnianie stringu numbers numerami i seperatorami
            numbers = numbers + separator + number;
        }

        //usunięcie 0 z listy wraz ze znakiem separatora
        numbers = numbers.substring(0, numbers.length() - 2);


        // stworzenie tablicy stringów z numbersów, elementy rozpoznane dzięki seperatorom
        String [] arraySplit = numbers.split(";");

        // stworzenie tablicy int, wielkość określona z tablicy stringów
        int [] arrayInt = new int[arraySplit.length];

        // wypełnienie tablicy int wartościami z tablicy stringów
        for (int i = 0; i < arraySplit.length; i ++){
            arrayInt[i] = Integer.parseInt(arraySplit[i]);
        }

        // wypisanie tablicy i jej elementów
        System.out.println(Arrays.toString(arrayInt));

        int min = arrayInt[0];
        int max = arrayInt[0];
        int sumOfElements = 0;

        for (int i = 0; i < arrayInt.length; i++){
            sumOfElements += arrayInt[i];

            if (arrayInt[i] > max){
                max = arrayInt[i];
            }

            if (arrayInt[i] < min){
                min = arrayInt[i];
            }
        }
        int sumOfMinMax = min + max;
        double average = (double)sumOfElements / (double)arrayInt.length;
        System.out.println("Suma min i max : " + sumOfMinMax);
        System.out.println("Średnia: " + average);
    }
    
}
