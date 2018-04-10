import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class HabitTracker extends JFrame {
	private String username;
	private ArrayList<Habit> habits;
	private LoginPanel loginPanel;
	private CreateHabitPanel createHabitPanel;
	private File userFile;
	private DailyChecklistPanel dailyChecklistPanel;
	
	public HabitTracker() {
		loginPanel = new LoginPanel(this);
		createHabitPanel = new CreateHabitPanel(this);
		habits = new ArrayList<Habit>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (username != null && habits != null) {
					saveData();
				}
			}
		});
		add(loginPanel);
		setVisible(true);
		pack();
	}

	public void createNewHabit(String name){
		Habit newHabit = new Habit(name, username, this);
		habits.add(newHabit);
		dailyChecklistPanel.updateHabits(habits);
		revalidate();
		pack();
	}

	//saves the users habits to file
	public void saveData(){
		if (!habits.isEmpty()) {
			try {
				PrintWriter lineWriter = new PrintWriter(new FileWriter(userFile));
				for (Habit h : habits) {
					h.saveData();
					lineWriter.println(h.getName());
				}
				lineWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//loads the user's habits from file.
	public void loadData(){
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(userFile));
			String line;
			while ( (line = lineReader.readLine()) != null){
				habits.add(new Habit(line, username, this));
			}
			lineReader.close();
		} catch (FileNotFoundException e){
			return;
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public void userLogin(String username) {
		this.username = username;
		userFile = new File(username + ".txt");
		loadData();
		remove(loginPanel);
		add(createHabitPanel);
		add(dailyChecklistPanel = new DailyChecklistPanel(habits));
		pack();
	}
	
	public static void main(String[] args) {
		HabitTracker habitTracker = new HabitTracker();
	}
}
