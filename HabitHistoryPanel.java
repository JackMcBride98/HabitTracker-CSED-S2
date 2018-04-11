import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class HabitHistoryPanel extends JPanel {

    private Habit habit;
    private JLabel month;
    private JButton leftButton;
    private JButton rightButton;
    private MonthPanel monthPanel;


    public HabitHistoryPanel(Habit habit){
        this.habit = habit;
        add(monthPanel = new MonthPanel(habit.getHistory()));
    }
}
