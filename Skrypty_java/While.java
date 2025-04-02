// najpierw jest sprawdzany warunek a dopiero potem wykonywany kod

public class While {

    public static void main(String[] args) {

        int numer = 0;

        while (numer < 10) {
            System.out.println("Mój nr to " + numer);
            numer ++;
        }
    }
}
