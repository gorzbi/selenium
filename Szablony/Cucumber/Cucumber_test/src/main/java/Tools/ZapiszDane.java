package Tools;

public class ZapiszDane {

    String info;
    boolean trueFalse;

    private static ZapiszDane zapisz = new ZapiszDane();
    private ZapiszDane() {    }

    public static ZapiszDane getInstance() {
        return zapisz;
    }

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
