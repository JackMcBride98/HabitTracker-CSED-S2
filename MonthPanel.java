import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MonthPanel extends JPanel {

    private int daysInMonth;
    private int[] daysCompleted;
    private JLabel[] days;
    private Date dateCreated;
    private Date currentDate;
    private ArrayList<Date> history;

    public MonthPanel(ArrayList<Date> history, Date dateCreated){
        this.history = history;
        this.dateCreated = dateCreated;
        currentDate = new Date();
        setLayout(new GridLayout(0,7));
        days = new JLabel[31];
        addDayLabels();
        colourDays();
        if ( history != null) {
            for (Date date : history) {
                if (date.getMonth() == currentDate.getMonth()) {
                    days[date.getDay() - 1].setBackground(Color.green);
                    days[date.getDay() - 1].setOpaque(true);
                }
            }
        }
    }

    public void addDayLabels(){
        daysInMonth = currentDate.getDaysInMonth();
        for (int i = 0; i < daysInMonth; i++){
            days[i] = new JLabel(Integer.toString(i+1));
            add(days[i]);
        }
    }

    public void colourDays(){
        if ( history != null) {
            for (Date date : history) {
                if (date.getMonth() == currentDate.getMonth() && date.getYear() == currentDate.getYear() ) {
                    days[date.getDay() - 1].setBackground(Color.green);
                    days[date.getDay() - 1].setOpaque(true);
                }
            }
        }
        if ( dateCreated.getMonth() == currentDate.getMonth()) {
            days[dateCreated.getDay() - 1].setBackground(Color.CYAN);
            days[dateCreated.getDay() - 1].setOpaque(true);
        }
    }
}
