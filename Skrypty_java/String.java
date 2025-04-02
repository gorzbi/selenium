    public static void main(String[] args) {
        String hello = "Witaj ";
        String world = "Świecie!";
        String powitanie = hello + world; //łączenie dwóch napisów
        System.out.println(powitanie);

        String czesc = powitanie.substring(0, 6) + "uczniu"; // substring bierze tekst od 1 do 7 znaku
        
        String text = powitanie.substring(0, powitanie.indexOf('}')+1); // od 1 do pierwszego znaku "}"
        
        System.out.println(czesc);
    }
