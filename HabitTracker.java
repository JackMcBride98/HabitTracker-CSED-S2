import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class HabitTracker extends JFrame {
	private String username;
	private ArrayList<Habit> habits;
	private LoginPanel loginPanel;
	private CreateHabitPanel createHabitPanel;
	private File userFile;
	private DailyChecklistPanel dailyChecklistPanel;
	private ViewHabitsPanel viewHabits;

	private JButton goalsButton;
	private GoalSetter goalSetter;

	public HabitTracker(int none){
        dispose();
    }

	public HabitTracker() {
		loginPanel = new LoginPanel(this);
		createHabitPanel = new CreateHabitPanel(this);
		habits = new ArrayList<Habit>();
		setTitle("HabitTracker");
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
		goalsButton = new JButton("Goals"); //NEW

		goalsButton.addActionListener(new ActionListener(){//NEW
		@Override
			public void actionPerformed(ActionEvent e){
				openGoals();
			}
		});

		setVisible(true);
		pack();
	}

	public void createNewHabit(String name){
		Habit newHabit = new Habit(name, username, this);
		habits.add(newHabit);
        ChooseDetailsFrame chooseDetailsFrame = new ChooseDetailsFrame(this,newHabit );
        setVisible(false);
        chooseDetailsFrame.setVisible(true);
		dailyChecklistPanel.updateHabits(habits);
		revalidate();
		pack();
	}

	//saves the users habits to file
	public void saveData(){
			try {
                PrintWriter lineWriter = new PrintWriter(new FileWriter(userFile));
			    if (!habits.isEmpty()) {
                    for (Habit h : habits) {
                        h.saveData();
                        lineWriter.println(h.getName());
                    }
                    lineWriter.close();
                }
                else{
			        lineWriter.println();
                }
			} catch (IOException e) {
				e.printStackTrace();
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
		viewHabits = new ViewHabitsPanel(this);
		add(viewHabits);
		remove(loginPanel);
		add(createHabitPanel);
		add(goalsButton);
		add(dailyChecklistPanel = new DailyChecklistPanel(habits));
		pack();
		setTitle("HabitTracker - " + username);
	}
	
	public String returnUsername() {
		return username;
	}
	
	
	public void openGoals(){ //WHOLE METHOD NEW
		setVisible(false);
		goalSetter = new GoalSetter(this);
		goalSetter.setVisible(true);
	}
	
	//NEW
	public String[] getHabitNames(){
		//perhaps obsolete but im tired
		String[] habitNames = new String[habits.size()];
		
		for (int i = 0; i < habits.size(); i++){
			habitNames[i] = (habits.get(i).getName());
		}
		
		return habitNames;
	}
	
	//New accessor for habits
	public Habit getHabit(int index){
		return habits.get(index);
	}
	

	public ArrayList<Habit> getHabits(){
	    return habits;
    }
	
	public static void main(String[] args) {
		HabitTracker habitTracker = new HabitTracker();
	}
}
