import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DailyChecklistPanel extends JPanel {

    private ArrayList<Habit> habits;

    public DailyChecklistPanel(ArrayList<Habit> habits){

        this.habits = habits;
        setLayout(new FlowLayout());
        for (Habit h: habits){
                add(h);
        }
    }

    public void updateHabits(ArrayList<Habit> habits){
		setLayout(new GridLayout(0,1));//new
        for (Habit h: this.habits) {
            remove(h);
        }
        this.habits = habits;
        for (Habit h: habits){
                add(h);
            }
        }
}
