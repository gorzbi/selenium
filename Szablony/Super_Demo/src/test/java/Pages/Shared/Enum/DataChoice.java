package Pages.Shared.Enum;

public enum DataChoice {

    takie_samo_jak ("takie samo jak"),
    inne_niz ("inne niż"),
    pozniejsza_niz ("późniejsza niż"),
    taka_sama_lub_pozniej ("taka sama lub późniejsza niż"),
    wczesniejsza_niz ("wcześniejsza niż"),
    taka_sama_lub_wczesniej ("taka sama lub wcześniejsza niż"),
    od_do ("od/do");

    String dataChoice;

    DataChoice(String dataChoice) {
        this.dataChoice = dataChoice;
    }

    public String getDataChoice() {
        return dataChoice;
    }
}
