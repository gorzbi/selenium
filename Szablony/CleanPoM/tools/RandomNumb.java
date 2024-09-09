package tools;

import java.util.Random;

public class RandomNumb {
    public int randomNumb(int liczbaMax) {
        int int_random;
        Random rand = new Random();
        if(liczbaMax > 0){
            int_random = rand.nextInt(liczbaMax);
        }else{
            int_random = 0;
        }
        return int_random;
    }
}
