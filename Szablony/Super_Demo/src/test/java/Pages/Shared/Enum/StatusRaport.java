package Pages.Shared.Enum;

public enum StatusRaport {

    oczekuje ("oczekuje na przygotowanie"),
    w_trakcie ("w trakcie przygotowania"),
    gotowy ("gotowy"),
    uszkodzony ("uszkodzony"),
    usuniety ("usunięty");

    String status;

    StatusRaport(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
