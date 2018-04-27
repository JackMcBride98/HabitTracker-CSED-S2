import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Arrays;

public class ReminderSetter extends JFrame{
	
	private HabitTracker habitTracker;
	private Habit habit;
	private int habitNo;
	private int timeSelected;
	private JComboBox<String> habitSelect;
	private JComboBox<String> timeSelect;
	private JComboBox<String> timeSelect2;
	
	
	int timeHour; 
	int timeMin;

	public ReminderSetter(HabitTracker habitTracker){
		this.habitTracker = habitTracker;
		setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Set reminiders for your habits. Choose a habit:");
		add(label);
		
		habitSelect = new JComboBox<String>(habitTracker.getHabitNames());
		add(habitSelect);
		
		JLabel label2 = new JLabel("      Remind me to do this habit at:");
		add(label2);
		
		timeSelect = new JComboBox<String>(writeHours());
		add(timeSelect);
		
		JLabel label3 = new JLabel(":");
		add(label3);
		
		timeSelect2 = new JComboBox<String>(writeMinutes());
		add(timeSelect2);
		
		JButton okButton = new JButton("Ok");
		add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//habitNo = habitSelect.getSelectedIndex();
				//habit = habitTracker.getHabit(habitNo);

				timeHour = timeSelect.getSelectedIndex();
				timeMin = timeSelect2.getSelectedIndex();
				setValues();
				
				dispose();
				habitTracker.setVisible(true);
			
				
			}
		});
		
		revalidate();
		
		
	}

	
	public String[] writeHours(){
		String[] times = new String[24];
		
		for (int i = 0; i < 24; i++){
			times[i] = Integer.toString(i);
		}
		
		return times; 
	}
	
	public String[] writeMinutes(){
		String[] times2 = new String[60];
		
		for (int i = 0; i < 60; i++){
			if (i < 10){
				times2[i] = ("0" + Integer.toString(i));
			} else{
				times2[i] = Integer.toString(i);
			}
		}
		
		return times2;
		
	}
	
	public void setValues(){
		String name = habitSelect.getSelectedItem().toString();
		habitTracker.setReminder(name, timeHour, timeMin);
		
		
	}
}