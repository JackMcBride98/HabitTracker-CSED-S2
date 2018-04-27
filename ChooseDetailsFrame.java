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
	private boolean[] days;

	public ChooseDetailsFrame(HabitTracker habitTracker, Habit habit){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//System.out.println("Showing day selector??");
		
		this.habitTracker = habitTracker;
		setLayout(new FlowLayout());
		createDayCheckbox("Monday", 1);
		createDayCheckbox("Tuesday", 2);
		createDayCheckbox("Wednesday", 3);
		createDayCheckbox("Thursday", 4);
		createDayCheckbox("Friday", 5);
		createDayCheckbox("Saturday", 6);
		createDayCheckbox("Sunday", 0);
		
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
					habit.setDays(getDaysArray());
					habitTracker.setVisible(true);
					//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					//Finish
				}
			}
		});
		
		revalidate();
		this.setVisible(true);
		

	}
	
	private void createDayCheckbox(String day, int dayNo){
		
		JLabel dayName = new JLabel(day);		
		JCheckBox checkBox = new JCheckBox();
		checkBoxArray[dayNo] = checkBox;
		
		add(dayName);
		add(checkBox);
		//System.out.println("Adding day " + day + " to selector");
		revalidate();
		
	}
	
	public boolean validSelection(){
		
		for (int i = 0; i < 7; i++){
			
			if (checkBoxArray[i].isSelected()){
				return true;
			}
			
		}
		
		return false;
		
	}

	public boolean[] getDaysArray(){
	    boolean[] days = new boolean[7];
	    for (int i=0; i < 7; i++){
	        if (checkBoxArray[i].isSelected()){
	            days[i] = true;
            }
            else{
	            days[i] = false;
            }
        }
        return days;
    }
	
	public Boolean getDays(int day){
		
		if( checkBoxArray[day].isSelected()){
			return true;
		}else{
			return false;
		}
		
	}
	
	
}