    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // obiekt czytający co podamy
        System.out.println("Ile liczb wczytać?");
        int number = scan.nextInt(); // przechowuje liczbę

        for (int i=0; i<=number; i++) {
            System.out.println(i);
        }

        Scanner name = new Scanner(System.in);
        System.out.println("Podaj imię");
        String txt = name.nextLine(); // przechowuje wartość string

        System.out.println("Cześć "+txt+", podałeś liczbę "+number);
        
    }
