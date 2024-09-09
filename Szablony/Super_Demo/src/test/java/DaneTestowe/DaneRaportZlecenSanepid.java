package DaneTestowe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DaneRaportZlecenSanepid {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date(System.currentTimeMillis());
    Calendar c = Calendar.getInstance();

    String dataOver7days;
    String dataOver31Days;
    String dataOver6months;

    public String getDataOver7days() {
        c.setTime(currentDate);
        c.add(Calendar.DATE, -8);
        Date modifiedDate = c.getTime();
        dataOver7days = dateFormat.format(modifiedDate);
        return dataOver7days;
    }

    public String getDataOver31Days() {
        c.setTime(currentDate);
        c.add(Calendar.DATE, -32);
        Date modifiedDate = c.getTime();
        dataOver31Days = dateFormat.format(modifiedDate);
        return dataOver31Days;
    }

    public String getDataOver6months() {
        c.setTime(currentDate);
        c.add(Calendar.DATE, -186);
        Date modifiedDate = c.getTime();
        dataOver6months = dateFormat.format(modifiedDate);
        return dataOver6months;
    }
}
