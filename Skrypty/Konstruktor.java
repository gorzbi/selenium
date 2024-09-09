Po co konstruktor?
1. np. mamy klasę user, która składa się z pól name i password i są one bez wartości
2. wartości do tych pól będziemy przypisywać w innej klasie, będziemy je dopiero tworzyć
3. czyli wywołamy klasę user user = new user() w jakiejś innej klasie i tu dopiero tworzymy wartości dla pól, czyli tworzymy nowy obiekt tej klasy user

Kiedy nie potrzebny?
1. gdy klasa user od razu ma przypisane wartości dla pól name i pass
2. wówczas wystarczą tylko gettery dla tych pól
    
best practice:
- każda klasa powinna mieć w sobie swój konstruktor, a nie korzystać z zewnętrznych
- zewnętrzny konstruktor ma tylko pola wspólne dla innych
- inne mają tylko dodatkowe pola
- inne klasy korzystają z extends gdy dodają nowe pola

1. sposób:
Podstawowy konstruktor + inne klasy z uzupełniającymi konstruktorami

1. klasa konstruktora
public class Konstruktor {

// zawiera wspólne pola
// zawiera główny konstruktor

    protected String imie;
    protected String plec;
    protected int wiek;

    public Konstruktor(String imie, String plec, int wiek) {
        this.imie = imie;
        this.plec = plec;
        this.wiek = wiek;
    }
}

2. klasa testowa
public class Student extends Konstruktor{

// jest rozszerzeniem głównego konstruktora
// zawiera dodatkowe pole

    private String uczelnia;

// "super" to główny konstruktor + this.dodatkowe pole
// nazwa metody jak nazwa klasy

    public Student(String imie, String plec, int wiek, String uczelnia) {
        super(imie, plec, wiek);
        this.uczelnia = uczelnia;
    }

// tworzymy nowy obiekt

    public void test(){
        new Student("Damian", "NN", 99, "AM");
    }

}


2. sposób:
Konstruktor wykorzystywany w innych klasach

1. klasa konstruktora
public class Konstruktor {

// zawiera te same pola dla wszystkich

    protected String imie;
    protected String plec;
    protected int wiek;

// można stworzyć konstruktory z wybranymi polami, ale nie w różnych kombinacjach

    public Konstruktor(String imie, String plec, int wiek) {
        this.imie = imie;
        this.plec = plec;
        this.wiek = wiek;
    }

// nie można stworzyć kolejnego konstruktora z innymi dwoma parametrami

    public Konstruktor(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

// nie można stworzyć kolejnego konstruktora z innym parametrem

    public Konstruktor(int wiek) {
        this.wiek = wiek;
    }
}


2. klasa testowa
public class Student {

// odwołujemy się do konkretnego konstruktora i tworzymy jego obiekt

    Konstruktor pelny = new Konstruktor("Adam", "NN", 12);
    Konstruktor niepelny = new Konstruktor("Adam", 12);
    Konstruktor pojedynczy = new Konstruktor(12);

}



3. sposób:
Każda klasa w której tworzy się obiekty ma swój wewnętrzny dedykowany Konstruktor

1. klasa testowa z konstruktorem

public class Teacher {

    private String imie;
    private String plec;
    private int wiek;
    private String przedmiot;

// metoda musi coś zwracać - void
// nazwa metody inna niż klasy

    public void dodajTeacher(String imie, String plec, int wiek, String przedmiot) {
        this.imie = imie;
        this.plec = plec;
        this.wiek = wiek;
        this.przedmiot = przedmiot;
        System.out.println("Nowy nauczyciel to "+imie+", "+plec+", "+wiek+", "+przedmiot);
    }


    @Test
    public void nowy() {

// wywołanie konstruktora bez "new"

        dodajTeacher("Ala", "M", 12, "WF");
        dodajTeacher("Elo", "K", 22, "His");
    }
}
