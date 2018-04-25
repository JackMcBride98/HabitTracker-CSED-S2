import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class ViewHabitsPanel extends JPanel {

    private HabitTracker habitTracker;
    private ArrayList<Habit> habits;
    private JButton viewButton;
    private Boolean showing;
    private JPanel habitsPanel;

    public ViewHabitsPanel(HabitTracker habitTracker){
        this.habitTracker = habitTracker;
        showing = false;
        habitsPanel = new JPanel();
        viewButton = new JButton("View Habits");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showing) {
                    hideHabits();
                }
                else{
                    showHabits();
                }
            }
        });
        add(viewButton);
    }

    public void hideHabits(){
        removeAll();
        add(viewButton);
        showing = false;
        viewButton.setText("View Habits");
    }

    public void showHabits(){
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        habits = habitTracker.getHabits();
        for (Habit h: habits){
            boolean[] days = h.getDays();
            if ( !days[currentDay-1]){
                habitsPanel.add(h);
            }
        }
        add(habitsPanel);
        habitTracker.revalidate();
        habitTracker.pack();
        showing = true;
        viewButton.setText("Hide Habits");
    }

}
