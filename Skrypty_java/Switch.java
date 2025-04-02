// obsługuje char, byte, short, int, String

public class Switch {

    public static void main(String[] args) {

        String danie = "Tex Mex";

        switch (danie) {
            case "Capriciosa":
                System.out.println("Capri kosztuje 15ziko");
                break;

            case "Fungi":
                System.out.println("Fun kosztuje 20ziko");
                break;

            case "Tex Mex":
                System.out.println("Tex kosztuje 25ziko");
                break;

            case "Diablo":
                System.out.println("Dia kosztuje 30ziko");
                break;

            default:
                System.out.println("Nie ma takiej");
        }
    }
}
