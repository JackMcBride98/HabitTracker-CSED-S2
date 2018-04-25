import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
/*
Class extending frame to allow user to select one of their habits, and attach goals for this habit.
*/
public class GoalSetter extends JFrame{
	private int habitNo;
	private int frequency;
	private int goalType;
	private HabitTracker habitTracker;
	
	public GoalSetter(HabitTracker habitTracker){
		//Add drop down menu for selecting habit, frequency to be completed (?) and an ok button.
		//Fuck knows how this will be displayed in habit tracker, just assign a variable for now? IDEA: int goalTarget(nstc) int = times per day. another variable for doing per week, month.
		this.habitTracker = habitTracker;
		setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Choose a habit:");
		add(label);
			
		JComboBox<String> habitSelect = new JComboBox<String>(habitTracker.getHabitNames());
		add(habitSelect);
		
		JLabel label4 = new JLabel("I want to complete this habit ");
		add(label4);
		
		JTextField freqInput = new JTextField(2);
		add(freqInput);
		
		JLabel label2 = new JLabel(" times");
		add(label2);
		
		JLabel label3 = new JLabel("every ");
		add(label3);
		
		String[] frequencies = {"Day", "Week", "Month"};
		JComboBox<String> freqSelect = new JComboBox<String>(frequencies);
		add(freqSelect);
		
		JButton okButton = new JButton("Ok");
		add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!freqInput.getText().equals("")){
					habitNo = habitSelect.getSelectedIndex();
					if (freqSelect.getSelectedIndex() == 0){
						goalType = 1;
					}
					else if (freqSelect.getSelectedIndex() == 1){
						goalType = 2;
					}
					else{
						goalType = 3;
					}
					frequency = Integer.parseInt(freqInput.getText());
					setValues();
					setVisible(false);
					habitTracker.setVisible(true);
				}
				
			}
		});
		
		pack();
		
	}
	
	private void setValues(){
		Habit habit;
		habit = habitTracker.getHabit(habitNo);
		habit.setGoalType(goalType);
		habit.setGoalFrequency(frequency);
		
		System.out.println("Goal created for habit: " + habit.getName() + " to be completed " + frequency + " times every " + goalType);
	}
	
}