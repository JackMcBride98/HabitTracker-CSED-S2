import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HabitTracker extends JFrame {
	private static String username;
	private ArrayList<Habit> habits;
	private LoginPanel loginPanel;
	private CreateHabitPanel createHabitPanel;
	private File userFile;
	private DailyChecklistPanel dailyChecklistPanel;

	private JButton goalsButton;
	private GoalSetter goalSetter;
	private ButtonsPanel buttons;
	
	public HabitTracker(int none){
        dispose();
    }
	
	public HabitTracker() {
		loginPanel = new LoginPanel(this);
		setTitle("HabitTracker");
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
		buttons = new ButtonsPanel(this);
	
		
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
	
	public void createNewTemplateHabit(String name){ //NEW
		Habit newHabit = new Habit(name, username, this);
		
		
		
		if (name.equals("Jog for 15 mins")){
			boolean[] boolArray = new boolean[]{true,false,true,false,true,false,false};
			newHabit.setDays(boolArray);
			newHabit.setCategory("Exercise");
		}
		else{
			boolean[] boolArray = new boolean[]{true,true,true,true,true,true,true};
			newHabit.setDays(boolArray);
			if(name.equals("Eat some fruit")){
				newHabit.setCategory("Diet");
			}
			else{
				newHabit.setCategory("Water");
			}
		}
		habits.add(newHabit);
		dailyChecklistPanel.updateHabits(habits);
		revalidate();
		pack();
	}
	
	//NEW
	public void createHabit(){
		//its me thats broken
		createHabitPanel = new CreateHabitPanel(this);
		createHabitPanel.setVisible(true);
		setVisible(false);
	}

	public void saveUsers(){
	    try {
	        ArrayList<String> users = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String user;
            while ((user = reader.readLine()) != null){
                users.add(user);
            }
            for(String s: users){
                if ( s.equals(username)){
                    usersToFile(users);
                    return;
                }
            }
            users.add(username);
            usersToFile(users);
        } catch (Exception e){

        }

    }

    public void usersToFile(ArrayList<String> users){
	    try {
            PrintWriter pw = new PrintWriter(new FileWriter("users.txt"));
            for (String s : users) {
                pw.println(s);
            }
            pw.close();
        } catch (IOException e){

        }
    }

	//saves the users habits to file
	public void saveData(){
			try {
                saveUsers();
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
			//New user?
			setVisible(false);
			TemplateFrame templateFrame = new TemplateFrame(this);
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
		//add(createHabitPanel); CHANGED
		//add(goalsButton);
		add(buttons);
		add(dailyChecklistPanel = new DailyChecklistPanel(habits));			
		dailyChecklistPanel.updateHabits(habits);
		setTitle("HabitTracker - " + username);
		pack();
	}
	
	public static String returnUsername() {
		return username;
	}
	
	
	public void openGoals(){
		setVisible(false);
		goalSetter = new GoalSetter(this);
		goalSetter.setVisible(true);
	}
	

	public String[] getHabitNames(){
		String[] habitNames = new String[habits.size()];
		
		for (int i = 0; i < habits.size(); i++){
			habitNames[i] = (habits.get(i).getName());
		}
		
		return habitNames;
	}
	
	public Habit getHabit(int index){
		return habits.get(index);
	}
	

	public ArrayList<Habit> getHabits(){
	    return habits;
    }
	
	public void viewReminders(){
		setVisible(false);
		ReminderSetter reminderSetter = new ReminderSetter(this);
		reminderSetter.setVisible(true);
	}
	
	public void setReminder(String habitName, int timeHour, int timeMin){
		System.out.println("Setting reminder for habit: " + habitName + " at: " + timeHour + ":" + timeMin);
		ReminderThread newThread = new ReminderThread(habitName, username, timeHour, timeMin);
		newThread.start();
		
	}

    public String getUsername(){return username;}

    public void viewLeaderboards(){
	    LeaderboardFrame lf = new LeaderboardFrame(this);
	    this.setVisible(false);
	    lf.setVisible(true);
    }
	
	public static void main(String[] args) {
		HabitTracker habitTracker = new HabitTracker();
	}
}
