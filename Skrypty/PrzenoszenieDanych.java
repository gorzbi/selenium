public class ZapiszDane {
  
  // metody które muszą być
  
    private static ZapiszDane zapisz = new ZapiszDane();
    private ZapiszDane() {    }

    public static ZapiszDane getInstance() {
        return zapisz;
    }
  
  // elementy dla których można przenosić dane między klasami

    String info;
    boolean trueFalse;

 // getter i setter

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isTrueFalse() {
        return trueFalse;
    }

    public void setTrueFalse(boolean trueFalse) {
        this.trueFalse = trueFalse;
    }
}

inna klasa w której będziemy chcieli korzystać
// deklaracja 
ZapiszDane zd = ZapiszDane.getInstance();

// korzystać można po przez zapis i pobranie danych, np.
zd.setInfo("jakies_info"); // zapisujemy do zmiennej "info" która jest stringiem w klasie ZapiszDane
zd.getInfo(); // pobieramy wyżej zapisane info -> możemy także je pobrać z zupełnie innej klasie (oczywiście wcześniej deklaracja w takiej klasie)
// info jest trzymane dopóki nie nadpiszemy innym lub jak zakończy się test
