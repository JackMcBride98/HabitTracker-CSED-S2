import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class CreateHabitPanel extends JFrame {//changed to jframe
    private JButton createButton;
    private JTextField habitNameField;
    private HabitTracker habitTracker;
    private ChooseDetailsFrame chooseDetailsFrame;

    public CreateHabitPanel(HabitTracker habitTracker){
		setLayout(new FlowLayout());
        this.habitTracker = habitTracker;
        createButton = new JButton("Ok");
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
               // if ( habitNameField.getParent() == null) { //COMMENTED OUT
                 //   showCreateHabit();
                //}
               // else{
                    if (!habitNameField.getText().equals("")) {
                        createNewHabit();
                    }
               // }
            }
        });
		add(habitNameField);
        add(createButton);
		pack();
    }

    public void createNewHabit(){
        ArrayList<Habit> currentHabits = habitTracker.getHabits();
        for (Habit h: currentHabits){
            if (h.getName().equals(habitNameField.getText())){
                return;
            }
        }
        habitTracker.createNewHabit(habitNameField.getText());
      //  remove(habitNameField);
       // habitNameField.setText("");
	   
		
		//habit.setVisible(true);
        habitTracker.revalidate();
		dispose();
    }

    public void showCreateHabit(){
        add(habitNameField);
        habitTracker.revalidate();
    }
}
