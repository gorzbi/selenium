// wydruk pełnej tablicy
System.out.println(Arrays.toString(nazwa tablicy));

// średnia z tablicy
double sr = sumaElements/tablica.length;

//min i max z tablicy Integer
 Integer[] tablica = {x,y,z};

// wartość min
 int min = Collections.min(Arrays.asList(tablica)); // tablica musi być Integer a nie int
 System.out.println("Minimum to "+min);

// tablica int
int[] tab = {4,1,8,7};
int mini = Arrays.stream(tab)
            .min()
            .getAsInt();
int maxi = Arrays.stream(tab)
            .max()
            .getAsInt();


//inicjalizacja tablicy i wartości:

//1. sposób:
// tablica z max 5 liczbami calkowitymi
int[] calkowite = new int[5];
calkowite[0] = 10;
calkowite[1] = 15;

// nie podając innych wartości domyślnie będą one = 0

//2. sposob:
// tablica z max 3 wartosci rzeczywistymi 3.14, 5, -20.5
double[] rzeczywiste = { 3.14, 5, -20.5 };

//3. sposób:
// tablica dla ciągu znaków bez określenia ile i jakie wartości
String[] slowa;
inicjalizacja elementów
slowa = new String[] { "Ala", "ma", "kota" };

// nie podając wartości domyślnie będą one = null


//działania na tablicach:

//ilość elementów:
calkowite.length -> sprawdza ilość elementów tablicy calkowite
slowa.length -> sprawdza ilość elementów tablicy slowa
slowa[0].length() -> sprawdza ilość znaków ->"length()"<- pierwszego słowa z tablicy slowa 

//pętla
int[] liczby = { -5, 100, 1, 0, 20 };
for (int i = 0; i < liczby.length; i++) { //lenngth=5 a w tablicy nie ma pozycji nr 5 (jest 4 bo liczy się od 0)
System.out.print(liczby[i] + " ");
}

// pętla w odwrotnej kolejności
for (int i = liczby.length - 1; i >= 0 ; i--) {
System.out.print(liczby[i] + " ");
}

// przykład szukania konkretnej liczby
    boolean znaleziona = false;
    int[] liczby = { -20, 105, 0, 26, -99, 7, 1026 };
    int szukanaLiczba = 7;
    for (int i = 0; i < liczby.length; i++) {
      if (liczby[i] == szukanaLiczba) {
        znaleziona = true;
        break; // znalezlismy liczbe - mozemy wiec przerwac petle
      }
    }
    if (znaleziona) {
      System.out.println("Liczba zostala znaleziona!");
    } else {
      System.out.println("Liczba nie zostala znaleziona.");
    }



// porównywanie tablic

    int[] pierwszaTablica = { 10, 5, 20 };
    int[] drugaTablica = { 10, 5, 20 };
    // jezeli tablice maja rozne rozmiary,
    // to na pewno nie bede takie same
    if (pierwszaTablica.length != drugaTablica.length) {
      System.out.println("Tablice nie sa takie same.");
    } else {
      boolean czyRoznicaZnaleziona = false;
      for (int i = 0; i < pierwszaTablica.length; i++) {
        // sprawdzamy, czy elementy o tych samych indeksach roznia
        // sie wartoscia - jezeli znajdziemy choc jedna roznice,
        // to bedziemy wiedziec, iz tablice nie sa takie same
        if (pierwszaTablica[i] != drugaTablica[i]) {
          czyRoznicaZnaleziona = true;
          break;
        }
      }
      if (czyRoznicaZnaleziona) {
        System.out.println("Tablice nie sa takie same.");
      } else {
        System.out.println("Tablice sa takie same.");
      }
    }


// zmiana wielkości tablicy - nie da się zmienić wielkości zadeklarowanej tablicy, dlatego tworzy się nową z elementami tej pierwszej

int[] liczby = { 10, 100, -5 };
System.out.println("Elementy tablicy liczby:");
for (int x : liczby) {
System.out.print(x + ", ");
}
    
System.out.println(); // przejdz do nowej linii

// tworzymy druga tablice o wiekszym rozmiarze
int[] tymczasowaTabela = new int[5];

// przepisujemy elementy z pierwszej tablicy
for (int i = 0; i < liczby.length; i++) {
tymczasowaTabela[i] = liczby[i];
}

// ustawiamy dodatkowe elementy
tymczasowaTabela[3] = 20;
tymczasowaTabela[4] = 1;
    
// przypisujemy druga tablice do pierwszej
liczby = tymczasowaTabela;
System.out.println("Elementy tablicy liczby:");
for (int x : liczby) {
System.out.print(x + ", ");
}
