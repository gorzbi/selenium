package DaneTestowe;

public class DaneSuEdytorZlecen {

    // ---- filtry

    String filtrIdZlecenia = "48641681"; // tst 48638561 pre 48641681
    String filtrImie = "Sandrine"; // tst Savannah pre Sandrine
    String filtrNazwisko = "White"; // tst Zemlak pre White
    String filtrStatus = "Zlecone przez zlecającego";
    String filtrPesel ="02272746880"; // tst 06122370403 pre 02272746880
    String filtrNrDok = "xx";
    String filtrZrodloTestu = "PM [EWP]";
    String filtrPotrzebaKaretki = "Tak";
    String filtrGrupyStatusow = "Zadania usunięte";
    String filtrTypTestu = "Test COVID19-ANTYGEN";
    String filtrZrodloFinansowania = "środki NFZ (pełna odpłatność)";
    String filtrDataZlecenia = "późniejsza niż";
    String filtrDataZleceniaValue = "2023-01-15";


    public String getFiltrIdZlecenia() {
        return filtrIdZlecenia;
    }
    public String getFiltrStatus() {
        return filtrStatus;
    }
    public String getFiltrImie() {
        return filtrImie;
    }
    public String getFiltrNazwisko() {
        return filtrNazwisko;
    }
    public String getFiltrPesel() {
        return filtrPesel;
    }
    public String getFiltrNrDok() {
        return filtrNrDok;
    }
    public String getFiltrZrodloTestu() {
        return filtrZrodloTestu;
    }
    public String getFiltrPotrzebaKaretki() {
        return filtrPotrzebaKaretki;
    }
    public String getFiltrGrupyStatusow() {
        return filtrGrupyStatusow;
    }
    public String getFiltrTypTestu() {
        return filtrTypTestu;
    }
    public String getFiltrZrodloFinansowania() {
        return filtrZrodloFinansowania;
    }
    public String getFiltrDataZlecenia() {
        return filtrDataZlecenia;
    }
    public String getFiltrDataZleceniaValue() {
        return filtrDataZleceniaValue;
    }


    // ---- identyfikacyjne
    String idOsoby = "31396732"; // tst 31396688 pre 31396732
    String dataZlecenia = "2023-01-01 10:00";
    String statusZlecenia = "Zwrócono z laboratorium (ZLECTEST LABORATORIUM)";
    String cito = "Nie";
    String his = "xxx";

    public String getIdOsoby() {
        return idOsoby;
    }
    public String getDataZlecenia() {
        return dataZlecenia;
    }
    public String getStatusZlecenia() {
        return statusZlecenia;
    }

    public String getCito() {
        return cito;
    }
    public String getHis() {
        return his;
    }


    // ---- podstawowe
    String imiePacjenta = "Darius";
    String nazwiskoPacjenta = "Max";
    String pesel = "36222222922";
    String nrDok = "xxx666";
    String zawod = "lekarz";
    String nrTel = "+48521568748";


    public String getImiePacjenta() {
        return imiePacjenta;
    }
    public String getNazwiskoPacjenta() {
        return nazwiskoPacjenta;
    }
    public String getPesel() {
        return pesel;
    }
    public String getNrDok() {
        return nrDok;
    }
    public String getZawod() {
        return zawod;
    }
    public String getNrTel() {
        return nrTel;
    }

    // ---- adresowe
    String dodatkoweInfo = "elomelo";
    String nrLokalu = "666x";
    String nrBudynku = "333";
    String kodPocztowy = "83-666";
    String wojew = "POMORSKIE";
    String powiat = "Gdynia";
    String gmina = "Gdynia";
    String miasto = "Gdynia (teryt:226201)";
    String ulica = "Warszawska";

    public String getDodatkoweInfo() {
        return dodatkoweInfo;
    }
    public String getNrLokalu() {
        return nrLokalu;
    }
    public String getNrBudynku() {
        return nrBudynku;
    }
    public String getKodPocztowy() {
        return kodPocztowy;
    }
    public String getWojew() {
        return wojew;
    }
    public String getPowiat() {
        return powiat;
    }
    public String getGmina() {
        return gmina;
    }
    public String getMiasto() {
        return miasto;
    }
    public String getUlica() {
        return ulica;
    }

    // ---- zlecenie

    String typTestu = "COVID19";
    String zrodloFinans = "inne finansowanie (np. komercyjne)";
    String zrodloTestu = "PM [EWP]";
    String przyczynaTestu = "objawy chorobowe";
    String stanPacjenta = "objawowy";
    String kodKreskowy = "ccxxzz";
    String sugerowanaData = "2023-03-03 12:00";
    String widocznePm = "Tak";
    String potrzebaKaretki = "Tak";
    String wyslanoKaretke = "Tak";
    String punktPobran = "(344) ZOZ w Wągrowcu";

    public String getTypTestu() {
        return typTestu;
    }
    public String getZrodloFinans() {
        return zrodloFinans;
    }
    public String getZrodloTestu() {
        return zrodloTestu;
    }
    public String getPrzyczynaTestu() {
        return przyczynaTestu;
    }
    public String getStanPacjenta() {
        return stanPacjenta;
    }
    public String getKodKreskowy() {
        return kodKreskowy;
    }
    public String getSugerowanaData() {
        return sugerowanaData;
    }
    public String getWidocznePm() {
        return widocznePm;
    }
    public String getPotrzebaKaretki() {
        return potrzebaKaretki;
    }
    public String getWyslanoKaretke() {
        return wyslanoKaretke;
    }
    public String getPunktPobran() {
        return punktPobran;
    }

    // ---- dane zlecającego
    String imieZlecajacego = "Asterix";
    String nazwiskoZlecajacego = "Obelix";
    String telZlecajacego = "+48125785412";

    public String getImieZlecajacego() {
        return imieZlecajacego;
    }
    public String getNazwiskoZlecajacego() {
        return nazwiskoZlecajacego;
    }
    public String getTelZlecajacego() {
        return telZlecajacego;
    }

    // ---- dane wprowadzającego
    String imieWprowadzajacego = "Typek";
    String nazwiskoWprowadzajacego = "Random";
    String jednostkaWprowadzajacego = "Jednostka";

    public String getImieWprowadzajacego() {
        return imieWprowadzajacego;
    }
    public String getNazwiskoWprowadzajacego() {
        return nazwiskoWprowadzajacego;
    }
    public String getJednostkaWprowadzajacego() {
        return jednostkaWprowadzajacego;
    }

    // ---- dane lekarza
    String imieLekarza = "Doktorek";
    String nazwiskoLekarza = "Hyde";
    String npwz = "123";
    String telefonLekarza = "+9564488555";

    public String getImieLekarza() {
        return imieLekarza;
    }
    public String getNazwiskoLekarza() {
        return nazwiskoLekarza;
    }
    public String getNpwz() {
        return npwz;
    }
    public String getTelefonLekarza() {
        return telefonLekarza;
    }

    // ---- logistyka
    String lab = "Cieszyńskkie Pogotowie Ratunkowe";

    public String getLab() {
        return lab;
    }

    // ---- laboratorium

    String dataPobrania = "2023-05-01 10:00";
    String nrProbki = "numereczek666";
    String rodzajMaterialu = "Osocze";
    String dataDostarczenia = "2023-05-01 10:00";
    String nazwaTestu = "(1199) CAT ";
    String dataWyniku = "2023-05-01 10:00";
    String wynik = "Negatywny";
    String pochodzenieTestu = "Antygenowy (zakupiony przez szpital)";
    String komentarzStatusu ="Próbka dostarczona niezgodnie z zaleceniami";

    public String getDataPobrania() {
        return dataPobrania;
    }
    public String getNrProbki() {
        return nrProbki;
    }
    public String getRodzajMaterialu() {
        return rodzajMaterialu;
    }
    public String getDataDostarczenia() {
        return dataDostarczenia;
    }
    public String getNazwaTestu() {
        return nazwaTestu;
    }
    public String getDataWyniku() {
        return dataWyniku;
    }
    public String getWynik() {
        return wynik;
    }
    public String getPochodzenieTestu() {
        return pochodzenieTestu;
    }
    public String getKomentarzStatusu() {
        return komentarzStatusu;
    }
}
