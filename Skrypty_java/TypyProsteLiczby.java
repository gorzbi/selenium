public class TypyProsteLiczby {

    // przechowują tylko dane, nie wykonuje się na nich operacji, nie wywołuje metod np. pierwszaLiczba.click()

        // liczby całkowite

        byte pierwszaLiczba = 127; // 1 bajt -128 do 127
        short drugaLiczba = 32767; // 2 bajty -32 768 do 32 767
        int trzeciaLiczba = 2147483647; // 4 bajty -2 147 483 648 do 2 147 483 647
        long czwartaLiczba = 222147483647L; // 8 bajtów -2^63 do 2^63-1 ! ma na końcu L

        // liczby zmiennoprzecinkowe

        float piataLiczba = 127.444F; // 4 bajty - max ok 6-7 liczb po przecinku (posiadają przyrostek F, lub f)
        double szostaLiczba = 348.4847373662D; // 8 bajtów - max ok 15 cyfr po przecinku (posiadają przyrostek D, lub d)

}