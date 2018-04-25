import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DailyChecklistPanel extends JPanel {

    private ArrayList<Habit> habits;
    private JLabel name;

    public DailyChecklistPanel(ArrayList<Habit> habits){
        this.habits = habits;
        name = new JLabel("Daily CheckList");
        add(name);
        setLayout(new FlowLayout());
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        for (Habit h: habits){
            boolean[] days = h.getDays();
            if ( days[currentDay - 1]){
                add(h);
            }
        }
    }

    public void updateHabits(ArrayList<Habit> habits){
        for (Habit h: this.habits) {
            remove(h);
        }
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        this.habits = habits;
        for (Habit h: habits){
            boolean[] days = h.getDays();
            if ( days[currentDay - 1]){
                add(h);
            }
        }
    }

}
