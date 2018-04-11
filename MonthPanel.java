import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MonthPanel extends JPanel {

    private int daysInMonth;
    private int[] daysCompleted;
    private JLabel[] days;

    private Date currentDate;
    private Date dateCreated;
    private ArrayList<Date> history;

    public MonthPanel(ArrayList<Date> history){
        this.history = history;
        dateCreated = history.get(0);
        history.remove(0);
        currentDate = new Date();
        daysInMonth = currentDate.getDaysInMonth();
        setLayout(new GridLayout(0,7));
        days = new JLabel[daysInMonth];
        for (int i = 0; i < daysInMonth; i++){
            days[i] = new JLabel(Integer.toString(i+1));
            add(days[i]);
        }
        for (Date date: history){
            if ( date.getMonth() == currentDate.getMonth()){
                days[date.getDay()-1].setBackground(Color.green);
                days[date.getDay()-1].setOpaque(true);
            }
        }
        if ( dateCreated.getMonth() == currentDate.getMonth()){
            days[currentDate.getDay()-1].setBackground(Color.CYAN);
            days[currentDate.getDay()-1].setOpaque(true);
        }
    }



}
