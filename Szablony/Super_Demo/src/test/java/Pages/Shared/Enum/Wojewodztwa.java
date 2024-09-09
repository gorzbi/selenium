package Pages.Shared.Enum;

public enum Wojewodztwa {

    // najpierw lista enum z ich przypisanymi wartościami
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

    // deklaracja pola, dla którego będą wartości z listy enum
    String name;

    // wywołanie wartości do enum
    Wojewodztwa (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
