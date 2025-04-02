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

// lub

int[] table = {first, second, third};
System.out.println("Max z tablicy to "+Arrays.stream(table).max().getAsInt());
System.out.println("Min z tablicy to "+Arrays.stream(table).min().getAsInt());

public class Tablica {

    public static void main(String[] args) {

        String[] imiona = new String[3]; // utworzenie tablicy o nazwie "imiona" z wartościami string, zawiera 3 elementy (od 0 do 2)
        imiona[0] = "Adam"; // pierwsza wartość na pozycji 0
        imiona[1] = "Bartek";
        imiona[2] = "Czesio";

        System.out.println(imiona[1]); // wypisujemy z tablicy wartość na miejscu 2 (indeks 1)

        int[] lottoNumbers = new int[] {1,2,3,4,5,6}; // inny sposób deklaracji wartości tablicy, indekd od 0 do 5

        System.out.println(lottoNumbers[3]);

        // .length -> sprawdzenie ile elementów ma tablica
        System.out.println("Tablica ma " + lottoNumbers.length + " elementów");

        // wypisanie elementów tablicy przy użyciu pętli
        for (int i=0; i< imiona.length; i++) {
            System.out.println(imiona[i]);
        }

    }
}
