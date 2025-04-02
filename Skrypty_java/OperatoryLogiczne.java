public class OperatoryLogiczne { // przechowują wartości true / false

    public static void main(String[] args) {

        boolean first = true;
        boolean second = false;
        boolean third = false;
        boolean fourth = true;

        // && -> "i" zwraca true gdy porównywane wartości mają true
        System.out.println(first && fourth);

        // || -> "lub" zwraca true gdy jedna z wartości jest true
        System.out.println(first || second);

        // ! -> negacja, zwraca wartość przeciwną niż ta, przed którą stoi
        System.out.println(!first);
        System.out.println(!(first && second));
    }
}
