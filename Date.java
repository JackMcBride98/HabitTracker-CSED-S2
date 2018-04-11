import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;
    private Calendar date;

    public Date(){
        date = Calendar.getInstance();
        day = date.get(Calendar.DAY_OF_MONTH);
        month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);
    }

    public int getDay() {
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public int getDaysInMonth(){
        return date.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
