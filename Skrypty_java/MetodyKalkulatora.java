public class MetodyKalkulatora {

    public int suma(int pierwszaLiczba, int drugaLiczba) {
        int suma = pierwszaLiczba + drugaLiczba;
        System.out.println("Suma to: "+ suma);
        return suma;
    }

    public int roznica(int pierwszaLiczba, int drugaLiczba) {
        int roznica = pierwszaLiczba - drugaLiczba;
        System.out.println("Różnica to: "+ roznica);
        return roznica;
    }

    public int mnozenie(int pierwszaLiczba, int drugaLiczba) {
        int mnozenie = pierwszaLiczba * drugaLiczba;
        System.out.println("Mnożenie to: "+ mnozenie);
        return mnozenie;
    }
}
