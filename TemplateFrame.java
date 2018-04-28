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

public class TemplateFrame extends JFrame{
	
	private HabitTracker habitTracker;
	private JLabel greetingsLabel;
	private JLabel waterLabel;
	private JLabel jogLabel;
	private JLabel fruitLabel;
	
	private JCheckBox waterCheck;
	private JCheckBox jogCheck;
	private JCheckBox fruitCheck;
	
	private JButton okButton;
	
	
	public TemplateFrame(HabitTracker habitTracker){
		setLayout(new GridLayout(0,2));
		this.habitTracker = habitTracker;
		
		greetingsLabel = new JLabel("Hey " + habitTracker.returnUsername() + ". Want to choose some starter habits to get you going?");
		add(greetingsLabel);
		JLabel placeholder = new JLabel("");
		add(placeholder);
		
		waterCheck = new JCheckBox();
		add(waterCheck);
		waterLabel = new JLabel("(Daily) Get some water");
		add(waterLabel);
		
		jogCheck = new JCheckBox();
		add(jogCheck);
		jogLabel = new JLabel("(Every other day) Jog for 15 minutes");
		add(jogLabel);
		
		fruitCheck = new JCheckBox();
		add(fruitCheck);
		fruitLabel = new JLabel("(Daily) Eat some fruit");
		add(fruitLabel);
		
		okButton = new JButton("Done");
		add(okButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add any selected habits
				if (waterCheck.isSelected()){
					habitTracker.createNewTemplateHabit("Get some water");
				}
				if (jogCheck.isSelected()){
					habitTracker.createNewTemplateHabit("Jog for 15 mins");
				}
				if (fruitCheck.isSelected()){
					habitTracker.createNewTemplateHabit("Eat some fruit");
				}
				
				close();
				
			}
		});
		
		pack();
		setVisible(true);
	}
	
	public void close(){
		habitTracker.setVisible(true);
		dispose();
	}
	
}