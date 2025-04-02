public class ZadanieKlasaStudent {

    public static void main(String[] args) {

        KlasaStudent adam = new KlasaStudent(); // odwołanie się do innej klasy KlasaStudent i nadanie jej nazwy adam
        adam.imie = "Adam"; // odwoływanie się do określonej nazwy i nadawanie wartości dla kolejnych pól zdefiniowanych w klasie KlasaStudent
        adam.nazwisko = "Adamski";
        adam.email = "mail@wp.pl";
        adam.nrIndeksu = 111;

        KlasaStudent basia = new KlasaStudent();
        basia.imie = "Basia";
        basia.nazwisko = "Bessa";
        basia.email = "bessa@wp.pl";
        basia.nrIndeksu = 222;

        KlasaStudent czesia = new KlasaStudent();
        czesia.imie = "Czesia";
        czesia.nazwisko = "Czesna";
        czesia.email = "czesia@wp.pl";
        czesia.nrIndeksu = 333;

        // stworzenie tablicy
        KlasaStudent[] tablica = new KlasaStudent[3]; // bo jest 3 studentów
        tablica[0] = adam;
        tablica[1] = basia;
        tablica[2] = czesia;

        for (int i=0; i< tablica.length; i++){
            tablica[i].przedstawSie(); // odwołanie się do metod zdefiniowanych w innej klasie KlasaStudent
            tablica[1].zalogujSie();
        }
    }
}

