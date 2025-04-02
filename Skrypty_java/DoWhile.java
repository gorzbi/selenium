// kod jest wykonywany conajmniej raz

public class DoWhile {

    public static void main(String[] args) {

        int numer = 10;

        do {
            System.out.println("Mój nr to " + numer);
            numer ++;
        }
        while (numer < 10);
    }
}
