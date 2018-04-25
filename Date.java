import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;
    private Calendar date;

    public Date(){
        date = Calendar.getInstance();
        day = date.get(Calendar.DAY_OF_MONTH);
        month = date.get(Calendar.MONTH) + 1;
        year = date.get(Calendar.YEAR);
    }

    public void incrementMonth(){
        month++;
        if (month > 12){
            month = 1;
            year++;
        }
    }

    public void decrementMonth(){
        month--;
        if (month < 1){
            month = 12;
            year--;
        }
    }

    public String getMonthText(){
        String monthText = "";
        if ( month == 1){
            monthText = "JAN";
        }
        else if ( month == 2){
            monthText = "FEB";
        }
        else if ( month == 3){
            monthText = "MAR";
        }
        else if (month == 4){
            monthText =  "APR";
        }
        else if ( month == 5){
            monthText = "MAY";
        }
        else if ( month == 6){
            monthText =  "JUN";
        }
        else if ( month == 7){
            monthText =  "JUL";
        }
        else if ( month == 8){
            monthText = "AUG";
        }
        else if ( month == 9){
            monthText = "SEP";
        }
        else if ( month == 10){
            monthText = "OCT";
        }
        else if ( month == 11){
            monthText = "NOV";
        }
        else if ( month == 12){
            monthText = "DEC";
        }
        return monthText;
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
        date.set(Calendar.MONTH, month-1);
        date.set(Calendar.YEAR, year);
        return date.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
