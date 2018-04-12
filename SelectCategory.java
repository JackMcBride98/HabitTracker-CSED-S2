import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class SelectCategory extends JPanel{
	//Change to JPanel add add to select days panel? to create.. details panel?
	//Works as is for now.
	

	private HabitTracker habitTracker;
	private Habit habit;
	private String category;
	
	public SelectCategory(HabitTracker habitTracker, Habit habit){
		
		this.habitTracker = habitTracker;
		this.habit = habit;
		
		setLayout(new FlowLayout());
		
		//Create new frame with drop down box(?) of categories
		String[] categories = {"Exercise", "Diet", "Water", "Productivity", "Custom"};
		JButton okButton = new JButton("Ok");
		JComboBox<String> categoryList = new JComboBox<String>(categories);
		//categories.setSelectedIndex(4);
		//categories.addActionListener(this);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					setVisible(false);
					habit.setCategory((String)categoryList.getSelectedItem());
					
				
				
			}
		});
		
		add(categoryList);
		//add(okButton);
		//pack();
		
		
	}
}