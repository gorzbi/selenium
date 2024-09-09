package DaneTestowe;

public class DaneSzybkaWyszukiwarkaOsob {

    // tst
    String pesel = "96122282198"; // tst 01320488985  pre 96122282198
    String nazwisko = "Morar"; // tst Michel pre Morar
    String idOsoby = "31399827"; // tst 96122282198 pre 31399827
    String idZlecenia = "48643787"; // tst 48638757 pre 48643787


    String typIdentyfikatora = "Imigrant"; // Pacjent NN
    String nrIdentyfikatora = "AKK441816"; // tst XX34EFDW (imigrant) pre AKK441816

    public String getPesel() {
        return pesel;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public String getTypIdentyfikatora() {
        return typIdentyfikatora;
    }
    public String getNrIdentyfikatora() {
        return nrIdentyfikatora;
    }

    public String getIdOsoby() {
        return idOsoby;
    }
    public String getIdZlecenia() {
        return idZlecenia;
    }

}
