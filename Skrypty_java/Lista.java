import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lista {

    public static void main(String[] args) {

        List<String> imiona = new ArrayList<>(); // List z wartościami string i nazwą imiona

        imiona.add("Bartek"); // dodawanie do listy
        imiona.add("Adam");
        imiona.add("Adam");

        System.out.println(imiona.get(0)); // pobranie z listy wg nr indexu

        System.out.println("Adam am wartość indeksu " + imiona.indexOf("Adam")); // sprawdzenie pierwszy element z listy jaki nr indexu dla wartości
        System.out.println("Ostatni Adam ma nr " + imiona.lastIndexOf("Adam")); // sprawdza ostatni nr indeksu
        System.out.println(imiona.contains("Krysia")); // sprawdzenie czy lista zawiera wartość (true/false)

        System.out.println(imiona.size()); // zwraca wielkość listy
        System.out.println(imiona.isEmpty()); // czy lista jest pusta? true/false

        List<Integer> liczby = new LinkedList<>(); // Integer nie int
        liczby.add(1);
        liczby.add(3);
        liczby.add(7);

        //metody jak wyżej

        List<String> inneImiona = new ArrayList<>();
        inneImiona.addAll(imiona); // dodajemy elementy z poprzedniej listy

        // pobranie wartości całej tablicy wg nr indeksu
        for (int i=0; i<names.size; i++) {
            System.out.println(names.get[i])
                }

        // zapis alternatywny pętli for
        for (String name : imiona) { // deklarujemy że pozycje z tablicy są stringiem, nadajemy nazwę zmiennej, pod dwukropku podajemy nazwę tablicy
            System.out.println(name) 
        }
    }
}
