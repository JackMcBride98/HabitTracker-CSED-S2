import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
//NEW CLASSU
public class ButtonsPanel extends JPanel{
	
	//panel for add habit button and view goals button
	private HabitTracker habitTracker;
	private JButton createButton;
	private JButton goalsButton;
	
	public ButtonsPanel(HabitTracker habitTracker){
		this.habitTracker = habitTracker;
		createButton = new JButton("Create habit");
		goalsButton = new JButton("Goals");
		addButtons();
	}
	
	private void addButtons(){
		
		add(createButton);
		add(goalsButton);
		goalsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				habitTracker.openGoals();
			}
		});
		
		createButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				habitTracker.createHabit();
			}
		});
		
		
		
	}
	
}