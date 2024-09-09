// liczba i wpisanie do nazwy
// math.random() generuje liczby od 0.0 do 1.0
   int randomNumber = (int) (Math.random()*1000);
   String nazwa = "screen" + randomNumber;
        
// od 200 do 400
   int b = (int)(Math.random()*(400-200+1)+200); 
        
   int min = 200;  
   int max = 400; 
   int b = (int)(Math.random()*(max-min+1)+min); 
        
// nazwa
   tring generatedNazwisko = RandomStringUtils.randomAlphabetic(10);
   System.out.println(generatedNazwisko);


// losuj randomo metodę do wykonania
public class LosujRandomListy {

    @Test
    public void thankYou() throws Exception {

        int min = 0;
        int max = 2;
        int r = (int)(Math.random()*(max-min+1)+min);

        System.out.println("Wylosowano case "+r);

        switch (r) {
            case 0:
                metodaFirst();
                break;
            case 1:
                metodaSecond();
                break;
            case 2:
                metodaThird();
                break;
            default:
                throw new Exception("ThankYou(" + r + "): unsupported value!");
        }
    }
    
// lista metod z których jest losowanie

    private void metodaFirst() {
        System.out.println("Thank you one");
    }

    private void metodaSecond() {
        System.out.println("Thank you two");
    }

    private void metodaThird() {
        System.out.println("Thank you three");
    }
}
