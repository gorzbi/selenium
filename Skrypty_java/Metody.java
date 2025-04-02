public class Metody {

    public void obliczWynik() {  /*void oznacza, że nie zwraca wartości, np. obliczy coś
        ale wynik tego nie może być zapisany do zmiennej w innej klasie*/

        int rezultat = 0;
        for (int i=0; i<100; i++) {
            rezultat = rezultat + i;
        }
        System.out.println("Końcowy wynik to: "+ rezultat);
    }

    // zamiast void to dajemy int bo kończy się liczbą, a to będzie można wpisać do zmiennej w innej klasie
    public int pobierzWynik() {

        int rezultat = 0;
        for (int i = 0; i < 100; i++) {
            rezultat = rezultat + i;
        }
        System.out.println("Końcowy wynik to: " + rezultat);
        return rezultat; // aby wynik został zwrócony należy użyć return
    }

    // dodaję określony parametr do metody, np. obliczenia dotyczą liczb więc parametr int o nazwie liczba
    public int obliczWynikParam(int liczba) {

        int rezultat = 0;
        for (int i = 0; i < liczba; i++) {
            rezultat = rezultat + i;
        }
        System.out.println("Końcowy wynik dla parametru to: " + rezultat);
        return rezultat;
    }

}
