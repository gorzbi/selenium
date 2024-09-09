// klasa z getterami i setterami

public class Base {

    private String first;
    private String second;
    private int third;

    public String getFirst() {
        return first+" niepotrzebny tekst";
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }
/*
    // z dodatkowymi obostrzeniami
    // tutaj test zakończy się powodzeniem z odpowiednim info
    public void setThird(int third) {
        if (third < 0) {
            System.out.println("Mniejszy od 0!");
        } else {
            System.out.println("Większy od 0");
        }
        this.third = third;
    }*/

    // alternatywne rozwiązanie z obsługą wyjątku
    // tu test zakończy się failem
    public void setThird(int third) {
        if (third < 0) { throw new IllegalArgumentException("Koleś zła liczba");
        }
        this.third = third;
    }

}


// klasa wywołująca

public class GetSet {

@Test
    public void firstTest(){

    // pierwszy obiekt z Base zmieniamy jedno wybrane pole

    Base ustaw = new Base();
    ustaw.setFirst("hej");
    System.out.println("Pierwszy first to: "+ustaw.getFirst());

    // ponowna zmiana tego parametru w tym obiekcie
    ustaw.setFirst("znowu hej");
    System.out.println("Pierwszy first po zmianie to: "+ustaw.getFirst());

    // drugi obiekt
    Base ustawInny = new Base();
    System.out.println("Drugi first to: "+ustawInny.getFirst()); // null
    ustawInny.setFirst("hello");
    System.out.println("Drugi first po zmianie to: "+ustawInny.getFirst()); // hello

    // trzeci obiekt
    Base ustawOstatni = new Base();
    ustawOstatni.setThird(8);
    System.out.println("Ostatni to: "+ustawOstatni.getThird());
}
}

