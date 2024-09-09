import java.util.Date; // util a nie sql !!
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// pobranie aktualnej daty w formacie yyyy-mm-dd
LocalDate ld = LocalDate.now();
System.out.println("Lokal date => "+ld);

// pobranie aktualnej daty w dowolnym formacie
public void testowane() {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date currentDate = new Date(System.currentTimeMillis());
    System.out.println(dateFormat.format(currentDate));
}

// manipulacja daty -> dodawanie
    public void testowane() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.YEAR, -1); // minus
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 1); 
        c.add(Calendar.HOUR, 1);
        c.add(Calendar.MINUTE, 1);
        c.add(Calendar.SECOND, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();

        System.out.println("Zmieniona data to -> "+dateFormat.format(currentDatePlusOne));

    }
