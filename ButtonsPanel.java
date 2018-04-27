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
	private JButton leaderboardButton;
	private JButton remindersButton;
	
	public ButtonsPanel(HabitTracker habitTracker){
		setLayout(new GridLayout(2,0));
		this.habitTracker = habitTracker;
		createButton = new JButton("Create habit");
		goalsButton = new JButton("Goals");
		leaderboardButton = new JButton("Leaderboard");
		remindersButton = new JButton("Reminders");
		addButtons();
	}
	
	private void addButtons(){
		
		add(createButton);
		add(goalsButton);
		add(leaderboardButton);
		add(remindersButton);
		
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
		leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habitTracker.viewLeaderboards();
            }
        });
			remindersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habitTracker.viewReminders();
            }
        });
		
		
	}
	
}