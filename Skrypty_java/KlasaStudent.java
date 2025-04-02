public class KlasaStudent {

    public String imie; // definiowanie pól do wykorzystania w innej klasie metodą main
    public String nazwisko;
    public String email;
    public int nrIndeksu;

    public void przedstawSie() { // definiowanie metod które coś wykonują
        System.out.println("Nazywam się " + imie + " " + nazwisko);
    }

    public void zalogujSie() {
        System.out.println(("Podaj dane " + email + " " + nrIndeksu));
    }
}
