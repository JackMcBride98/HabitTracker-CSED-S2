import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateHabitPanel extends JPanel {
    private JButton createButton;
    private JTextField habitNameField;
    private HabitTracker habitTracker;

    public CreateHabitPanel(HabitTracker habitTracker){
        this.habitTracker = habitTracker;
        createButton = new JButton("Create New Habit");
        habitNameField = new JTextField(30);
        habitNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ( habitNameField.getText().length() > 15){
                    e.consume();
                }
            }
        });
        habitNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!habitNameField.getText().equals("")) {
                    createNewHabit();
                }
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( habitNameField.getParent() == null) {
                    showCreateHabit();
                }
                else{
                    if (!habitNameField.getText().equals("")) {
                        createNewHabit();
                    }
                }
            }
        });
        add(createButton);
    }

    public void createNewHabit(){
        habitTracker.createNewHabit(habitNameField.getText());

    }

    public void showCreateHabit(){
        add(habitNameField);
        habitTracker.revalidate();
        habitTracker.pack();
    }
}
