public class MetodyTest {

    public static void main(String[] args) {

        Metody obliczenia =new Metody(); // przypisanie do zmiennej obliczenia klasy Metody
        obliczenia.obliczWynik(); // do zmiennej obliczenia odowłoanie się do metody obliczWynik z klasy Metody
        int pobranaDana = obliczenia.pobierzWynik(); // teraz można pobrać wynik metody pobierzWynik i np. zapisać do zmiennej

        System.out.println("Pobrany wynik pomnożony pzez 2 to: " + (pobranaDana*2));

        obliczenia.obliczWynikParam(2); // nadana wartość dla parametru i dla niego będzie oblieczenie

    }
}
