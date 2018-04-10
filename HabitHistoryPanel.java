import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class HabitHistoryPanel extends JFrame {

    private Habit habit;
    private ArrayList<Calendar> habitHistory;
    private Calendar dateCreated;
    private JLabel[] dates;
    private Calendar currentDate;
    private JLabel month;


    public HabitHistoryPanel(){
        //this.habit = habit;
        //habitHistory = habit.getHistory();
        //dateCreated = habitHistory.get(0);
        //habitHistory.remove(0);
        setLayout(new BorderLayout());
        habitHistory = new ArrayList<Calendar>();
        Calendar newDate = Calendar.getInstance();
        newDate.set(2018, Calendar.APRIL, 9);
        habitHistory.add(newDate);
        newDate.set(2018, Calendar.APRIL, 7);
        habitHistory.add(newDate);
        currentDate = Calendar.getInstance();
        System.out.println(currentDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        month = new JLabel(currentDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        add(month, BorderLayout.PAGE_START);
        add(new MonthPanel(30, new int[] {7,9}, dateCreated), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args){
        new HabitHistoryPanel();
    }
}
