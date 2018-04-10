import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class MonthPanel extends JPanel {

    private int daysInMonth;
    private int[] daysCompleted;
    private Calendar dateCreated;
    private JLabel[] days;

    public MonthPanel(int daysInMonth, int[] daysCompleted, Calendar dateCreated){
        this.daysInMonth = daysInMonth;
        this.daysCompleted = daysCompleted;
        this.dateCreated = dateCreated;
        setLayout(new GridLayout(0,7));
        days = new JLabel[daysInMonth];
        for (int i = 0; i < daysInMonth; i++){
            days[i] = new JLabel(Integer.toString(i+1));
            add(days[i]);
        }
        for (int i = 0; i < daysCompleted.length; i++){
            days[daysCompleted[i]-1].setOpaque(true);
            days[daysCompleted[i]-1].setBackground(Color.green);
        }
    }

}
