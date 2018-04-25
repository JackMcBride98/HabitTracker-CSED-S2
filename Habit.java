import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Habit extends JPanel {
	private String name;
	private File data;
	private String username;
	private Date dateCreated;
	private boolean[] days; 
	private ArrayList<Date> history;
	private HabitTracker habitTracker;
	private HabitHistoryPanel hhp;
	private String category;
	
	private JLabel nameLabel;
	private JCheckBox checkBox;
	private JButton detailsButton;
	private JButton editButton;
	private Boolean detailsShow;
	private ChooseDetailsFrame chooseDetailsFrame;
	private JLabel streaks;
	private JLabel percentage;
	
	private boolean hasGoal; // open details.. if(goal) "no goal set" else display details?
	private int goalType; //1 = daily, 2 = weekly, 3 = monthly
	private int goalFrequency; //How many times to be completed
	
	
	public Habit(String name, String username, HabitTracker habitTracker) {
		this.name = name;
		this.username = username;
		this.habitTracker = habitTracker;
		detailsShow = false;
		days = new boolean[7];
		data = new File(username + name + ".txt");
		loadData();
        hhp = new HabitHistoryPanel(this);
		nameLabel = new JLabel(name);
		checkBox = new JCheckBox();
		streaks = new JLabel();
		percentage = new JLabel();
		Date today = new Date();
        for ( Date date: history){
            if ( date.getYear() == today.getYear() && date.getMonth() == today.getMonth() && date.getDay() == today.getDay()){
                checkBox.setSelected(true);
            }
        }
		editButton = new JButton("Edit");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Date currentDate = new Date();
                Date toRemove;
				if(!checkBox.isSelected()) {
				    history.removeIf(date -> date.getYear() == currentDate.getYear() && date.getMonth() == currentDate.getMonth() && date.getDay() == currentDate.getDay());
                }
				else {
					history.add(currentDate);
				}
				hhp.update(history);
				updateStreak();
				updatePercentage();
				habitTracker.revalidate();
			}
		});
		detailsButton = new JButton("More Info*");
		detailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if ( !detailsShow){
                    showDetails();
                    detailsShow = true;
                }
                else {
			        hideDetails();
			        detailsShow = false;
                }

			}
		});
		
			editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editFeature();
			}
		});
		
		add(nameLabel);
		add(checkBox);
		add(detailsButton);
		
		

	}

	public boolean[] getDays(){
		return days;
	}

	public String getName(){
		return name;
	}
	
	public void editFeature() {
		EditFeature edit = new EditFeature(name, this, habitTracker);
	}

	public Date getDateCreated(){return dateCreated;}

	public ArrayList<Date> getHistory(){
	    return history;
    }

	public void showDetails() {
		add(editButton);
		add(hhp);
		updateStreak();
		add(streaks);
		updatePercentage();
		add(percentage);
		detailsButton.setText("Hide Info");
		habitTracker.revalidate();
		habitTracker.pack();
	}

	public void updateStreak(){
        int streak = 0;
        Date testDate = new Date();
        while ( !testDate.isEqual(dateCreated)){
            if ( days[testDate.getDayOfWeek()-1]){
                for ( Date d: history){
                    if ( d.isEqual(testDate)){
                        streak++;
                    }
                }
            }
            testDate.decrementDay();
        }
        if ( days[testDate.getDayOfWeek()-1]){
            for ( Date d: history){
                if ( d.isEqual(testDate)){
                    streak++;
                }
            }
        }
        streaks.setText("Streak: " + streak);
        revalidate();
    }

    public void updatePercentage(){
	    Date testDate = new Date();
	    int completed = 0;
	    int total = 0;
	    while ( !testDate.isEqual(dateCreated)) {
	        if ( days[testDate.getDayOfWeek()-1]){
	            total++;
	            for ( Date d: history){
	                if ( d.isEqual(testDate)){
	                    completed++;
                    }
                }
            }
            testDate.decrementDay();
        }
        if ( days[testDate.getDayOfWeek()-1]){
            total++;
            for ( Date d: history){
                if ( d.isEqual(testDate)){
                    completed++;
                }
            }
        }
	    if ( total == 0){
	        percentage.setText("Percentage Complete : 0%");
        }
        else{
	        float percent = (float)completed / total;
            percentage.setText("Percentage Complete: " + percent*100 + "%");
        }
        revalidate();
    }

	public void hideDetails(){
	    remove(editButton);
	    remove(hhp);
	    remove(streaks);
	    remove(percentage);
	    detailsButton.setText("More Info");
	    habitTracker.revalidate();
	    habitTracker.pack();
    }
	
	public void setDays(boolean[] days){
		this.days = days;
	}
	
	public void setCategory(String cat){
		category = cat;
		System.out.println("Category is: " + cat);
	}
	
	public String getCategory(){
		return category;
	}
	
	public void deleteName() {

		this.name = "";
		this.remove(checkBox);
		this.remove(editButton);
		this.remove(nameLabel);
		if ( detailsShow){
		    remove(hhp);
        }
        remove(detailsButton);
        data.delete();
        habitTracker.revalidate();
        habitTracker.pack();
	}
	
	public void refreshLabel(String name) {
		nameLabel.setText(name);
		habitTracker.pack();
	}

	
	//loads in the stored habit data from file.
	public void loadData() {
		try {
			ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(data));
			ArrayList<Object> objects = (ArrayList<Object>) objectReader.readObject();
			days =  (boolean[]) objects.get(0);
			history = (ArrayList<Date> )objects.get(1);
			dateCreated = (Date) objects.get(2);
			objectReader.close();
		} catch (FileNotFoundException e) {
				dateCreated = new Date();
				days = new boolean[] {true,true,true,true,true,true,true};
				history = new ArrayList<Date>();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//saves the habit data to file.
	public void saveData() {
		try {
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(data));
			ArrayList<Object> objects = new ArrayList<Object>();
			objects.add(days);
			objects.add(history);
			objects.add(dateCreated);
            objectWriter.writeObject(objects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Accessors and mutators for goal variables
	public int getGoalType(){
		return goalType;
	}
	
	public void setGoalType(int type){
		goalType = type;
	}
	
	public int getGoalFrequency(){
		return goalFrequency;
	}
	
	public void setGoalFrequency(int freq){
		goalFrequency = freq;
	}

	public void setHistory(ArrayList<Date> history){
	    this.history = history;
    }

    public void setDateCreated(Date dateCreated){
	    this.dateCreated = dateCreated;
    }
}
