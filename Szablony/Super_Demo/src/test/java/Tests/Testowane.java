package Tests;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Testowane {

    @Test
    public void testowane() {

        LocalDate ld = LocalDate.now();
        String data = ld.toString();
        System.out.println("Lokal date => "+data);


    }
}
