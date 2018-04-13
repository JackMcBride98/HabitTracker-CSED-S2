import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class ChooseDetailsFrame extends JFrame{
	
	private HabitTracker habitTracker;
	private JCheckBox[] checkBoxArray = new JCheckBox[7];
	private JButton okButton;
	
	public ChooseDetailsFrame(HabitTracker habitTracker, Habit habit){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.out.println("Showing day selector??");
		
		this.habitTracker = habitTracker;
		setLayout(new FlowLayout());
		createDayCheckbox("Monday", 0);
		createDayCheckbox("Tuesday", 1);
		createDayCheckbox("Wednesday", 2);
		createDayCheckbox("Thursday", 3);
		createDayCheckbox("Friday", 4);
		createDayCheckbox("Saturday", 5);
		createDayCheckbox("Sunday", 6);
		
		okButton = new JButton("Ok");
		
		
		SelectCategory selectCategory = new SelectCategory(habitTracker, habit);
		add(selectCategory);
		
		
		add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check that at least one day is selected
				if (validSelection()){
					SelectCategory selectCategory = new SelectCategory(habitTracker, habit);
					setVisible(false);
					selectCategory.setVisible(true);
					habit.setDays();
					habitTracker.setVisible(true);
					//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					//Finish
				}
			}
		});
		
		pack();
		this.setVisible(true);
		

	}
	
	private void createDayCheckbox(String day, int dayNo){
		
		JLabel dayName = new JLabel(day);		
		JCheckBox checkBox = new JCheckBox();
		checkBoxArray[dayNo] = checkBox;
		
		add(dayName);
		add(checkBox);
		//System.out.println("Adding day " + day + " to selector");
		pack();
		
	}
	
	public boolean validSelection(){
		
		for (int i = 0; i < 7; i++){
			
			if (checkBoxArray[i].isSelected()){
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public Boolean getDays(int day){
		
		if( checkBoxArray[day].isSelected()){
			return true;
		}else{
			return false;
		}
		
	}
	
	
}