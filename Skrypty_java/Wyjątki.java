    public static void main(String[] args) throws ExceptionRaty, ExceptionCena { // musimy podać że metoda wybija utworzone wyjątki

        try {
            next(); // wykonujemy metodę next
        } catch (ExceptionCena | ExceptionRaty a) { // tu łapiemy je wszystkie
            //throw a; // spowoduje wyrzucenie wyjątku i przerwanie programu
            System.out.println(a.getMessage());
            next(); // ponownie wykonujemy metodę next po wyrzuceniu wyjątku
        }

    }


    public static void next() throws ExceptionCena, ExceptionRaty { // metoda wyrzuca nasze utworzone wyjątki
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj cenę towaru");
        double cena = scan.nextInt();
        System.out.println("Podaj liczbę rat");
        int raty = scan.nextInt();

        double odsetkiRoczne;
        double odsetkiMiesieczne;

        if (raty >= 6 && raty <= 12) {
            odsetkiRoczne = cena * 0.025;
        } else if (raty >= 13 && raty <= 24) {
            odsetkiRoczne = cena * 0.05;
        } else {
            odsetkiRoczne = cena * 0.1;
        }

        odsetkiMiesieczne = odsetkiRoczne/12;

        if (cena < 100 || cena > 10000) {
            throw new ExceptionCena("Cena musi być w przedziale 100 - 10k"); // tu wrzucamy wyjątek z error message
        } else if (raty < 6 || raty > 48) {
            throw new ExceptionRaty("Raty muszą być w przedziale 6-48"); // tu wrzucamy drugi wyjątek z error message
        } else {
            System.out.println("Roczne odsetki to "+odsetkiRoczne);
            System.out.println("Miesięczne odsetki to "+odsetkiMiesieczne);
        }
    }

// Pozostałe dwie klasy z utworzonymi wyjątkami - nazwa klasy = nazwa metody

public class ExceptionCena extends Exception{

    public ExceptionCena (String message) {
        super(message);
    }
}
-------------
public class ExceptionRaty extends Exception{

    public ExceptionRaty(String message) {
        super(message);
    }
}
