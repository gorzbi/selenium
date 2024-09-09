public enum Wojewodztwa {

    // najpierw lista enum z ich przypisanymi wartościami -> name
    wszystkie("Wszystkie"),
    malopolskie("MAŁOPOLSKIE"),
    podkarpackie("PODKARPACKIE"),
    warmia_mazury("WARMIŃSKO-MAZURSKIE"),
    lubuskie("LUBUSKIE"),
    podlaskie("PODLASKIE"),
    oposlkie("OPOLSKIE"),
    zachodniopomorskie("ZACHODNIOPOMORSKIE"),
    pomorskie("POMORSKIE"),
    slaskie("ŚLĄSKIE"),
    lubelskie("LUBELSKIE"),
    dolnoslaskie("DOLNOŚLĄSKIE"),
    swietokrzyskie("ŚWIĘTOKRZYSKIE"),
    mazowieckie("MAZOWIECKIE"),
    lodzkie("ŁÓDZKIE"),
    kujawsko_pomorskie("KUJAWSKO-POMORSKIE"),
    wielkopolskie("WIELKOPOLSKIE");

    // deklaracja pola, dla którego będą pobierane wartości do listy enum
    String name;

    // konstruktor -> wywołanie wartości do enum
    Wojewodztwa (String name){
        this.name = name;
    }

    // getter -> pobieranie wartości pola dla wskazanej pozycji z listy enum
    public String getName() {
        return name;
    }
}

// wywołanie określonej wartości dla wskazanego województwa w innej klasie

Wojewodztwa.wielkopolskie.getName();
String wojew = Wojewodztwa.wielkopolskie.getName();
