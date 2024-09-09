package DaneTestowe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DaneRaportOsobySanepid {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date(System.currentTimeMillis());
    Calendar c = Calendar.getInstance();
    LocalDate ld = LocalDate.now(); // zwraca datę yyyy-mm-dd
    String dataToday;
    String dataOver31Days;

    public String getDataToday() {
        dataToday = ld.toString();
        return dataToday;
    }

    public String getDataOver31Days() {
        c.setTime(currentDate);
        c.add(Calendar.DATE, -32);

        Date modifiedDate = c.getTime();

        dataOver31Days = dateFormat.format(modifiedDate);

        return dataOver31Days;
    }

}
