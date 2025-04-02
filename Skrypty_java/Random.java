public void random() {

        // liczba i wpisanie do nazwy
        // math.random() generuje liczby od 0.0 do 1.0
        int randomNumber = (int) (Math.random()*1000);
        String nazwa = "screen" + randomNumber;
        
        // od 200 do 400
        int b = (int)(Math.random()*(400-200+1)+200); 
        
        int min = 200;  
        int max = 400; 
        int b = (int)(Math.random()*(max-min+1)+min); 
        
        // string składający się z 10 znaków
        String generatedNazwisko = RandomStringUtils.randomAlphabetic(10);
        System.out.println(generatedNazwisko);
