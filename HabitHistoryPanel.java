import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class HabitHistoryPanel extends JPanel {

    private Habit habit;
    private JLabel month;
    private JButton leftButton;
    private JButton rightButton;
    private MonthPanel monthPanel;
    private Date currentDate;


    public HabitHistoryPanel(Habit habit){
        this.habit = habit;
        currentDate = new Date();
        add(leftButton = new JButton("<"),BorderLayout.PAGE_START);
        add(month = new JLabel(currentDate.getMonthText()),BorderLayout.PAGE_START);
        add(rightButton = new JButton(">"), BorderLayout.PAGE_START);
        add(monthPanel = new MonthPanel(habit.getHistory(), habit.getDateCreated()),BorderLayout.CENTER);
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthDown();
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthUp();
            }
        });
    }

    public void monthDown(){
        currentDate.decrementMonth();
        month.setText(currentDate.getMonthText());
    }

    public void monthUp(){
        currentDate.incrementMonth();
        month.setText(currentDate.getMonthText());
    }
}
