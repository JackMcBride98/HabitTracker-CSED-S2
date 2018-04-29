import javafx.scene.paint.Color;

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
	
	private String username;
	private Date dateCreated;
	private boolean[] days; 
	private ArrayList<Date> history;
	private HabitTracker habitTracker;
	private HabitHistoryPanel hhp;
	private String category;

	private JLabel toDoToday;
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
	private int goal; //% completion.
	private GoalTracker goalTracker;
	private JLabel goalLabel;
	
	public Habit(String name, String username, HabitTracker habitTracker) {
		this.name = name;
		this.username = username;
		this.habitTracker = habitTracker;
		detailsShow = false;
		days = new boolean[7];
		loadData();
        hhp = new HabitHistoryPanel(this);
		nameLabel = new JLabel(name);
		checkBox = new JCheckBox();
        if ( !days[new Date().getDayOfWeek()-1]){
            setOpaque(true);
            setBackground(java.awt.Color.gray);
            checkBox.setOpaque(true);
            checkBox.setBackground(java.awt.Color.gray);

        }
		streaks = new JLabel();
		percentage = new JLabel();
		Date today = new Date();
        for ( Date date: history){
            if ( date.getYear() == today.getYear() && date.getMonth() == today.getMonth() && date.getDay() == today.getDay()){
                checkBox.setSelected(true);
                if ( days[new Date().getDayOfWeek()-1]){
                    setOpaque(true);
                    setBackground(java.awt.Color.gray);
                    checkBox.setOpaque(true);
                    checkBox.setBackground(java.awt.Color.gray);
                }
            }
        }
		
		editButton = new JButton("Edit");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Date currentDate = new Date();
				 Date toRemove;
				if(!checkBox.isSelected()) {
				    history.removeIf(date -> date.getYear() == currentDate.getYear() && date.getMonth() == currentDate.getMonth() && date.getDay() == currentDate.getDay());
				    if ( days[new Date().getDayOfWeek()-1]){
                        setOpaque(false);
                        repaint();
                        //setBackground(java.awt.Color.gray);
                        checkBox.setOpaque(false);
                    }
                }
				else {
				    if ( days[new Date().getDayOfWeek()-1]){
                        setOpaque(true);
                        setBackground(java.awt.Color.gray);
                        repaint();
                        checkBox.setOpaque(true);
                        checkBox.setBackground(java.awt.Color.gray);
                    }
					history.add(currentDate);
				}
				hhp.update(history);
				updateStreak();
				updatePercentage();
				//habitTracker.revalidate();
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

	public void setDateCreated(Date dateCreated){
	    this.dateCreated = dateCreated;
    }

	public ArrayList<Date> getHistory(){
	    return history;
    }

    public void setHistory(ArrayList<Date> history){
	    this.history = history;
    }

	public void showDetails() {
		//MAY HAVE TO FIDDLE
		
		add(editButton);
		add(hhp);
		updateStreak();
		add(streaks);
		updatePercentage();
		add(percentage);
		detailsButton.setText("Hide Info");
		//habitTracker.revalidate();
		if (hasGoal){
			System.out.println("Displaying goal status");
			goalLabel = new JLabel("You have completed " + goalTracker.getCompletion() + "% of your goal!");
			add(goalLabel);
		}else
		{
			System.out.println("NOP");
		}
		
		//habitTracker.revalidate();
		habitTracker.pack();
	}

	public void updateStreak(){
        streaks.setText("Streak: " + getStreak() + ".  ");
        //revalidate();
    }

	public int getStreak(){
        int streak = 0;
        Date currentDate = new Date();
		Date testDate = new Date(dateCreated.getDay(), dateCreated.getMonth(), dateCreated.getYear());
		testDate.decrementDay();
		boolean completed;
        do {
			testDate.incrementDay();
            if ( days[testDate.getDayOfWeek()-1]){
				completed = false;
                for ( Date d: history){
                    if ( d.isEqual(testDate)){
                        streak++;
						completed = true;
                    }
                }
				if (!completed){
					streak = 0;
				}
            }
        } while ( !testDate.isEqual(currentDate) );
        return streak;
    }

    public void updatePercentage(){
        percentage.setText("Percentage Complete: " + getPercentage() + "%. ");
        //revalidate();
    }

    public int getPercentage(){
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
	        return 0;
        }
        else{
	        float percent = (float)completed / total *100;
            return (int) percent;
        }
    }

	public void hideDetails(){
		//DONT MAKE A GOAL WHILE MORE DETAILS IS OPEN
	    remove(editButton);
	    remove(hhp);
		if(hasGoal){
			remove(goalLabel);
		}
		remove(streaks);
	    remove(percentage);
	    detailsButton.setText("More Info");
	    habitTracker.revalidate();
    }
	
	public void setDays(boolean[] days){
		this.days = days;
	}
	
	//new
	public boolean getDay(int day){
		if (days[day] == true){
			return true;
		}
		return false;
	
	}
	
	public void setCategory(String cat){
		category = cat;
		//System.out.println("Category is: " + cat);
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
        File habitFile = new File(username + name + ".txt");
		habitFile.delete();
        habitTracker.revalidate();
	}
	
	public void refreshLabel(String name) {
		nameLabel.setText(name);
		revalidate();
	}

	
	//loads in the stored habit data from file.
	public void loadData() {
		try {
			ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(username + name + ".txt"));
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
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(new File(username + name + ".txt")));
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
	
	public int getGoal(){
		return goal;
	}
	
	public boolean hasGoal(){
		return hasGoal;
	}
	
	public void setName(String newName){
		name = newName;
	}

	public String getUsername(){return username;}
	
	public void deleteFile(){
		File oldFile = new File(username + name + ".txt");
		oldFile.delete();
	}
	
	public void setHasGoal(boolean bool){
		hasGoal = bool;
		System.out.println("hasGoal is undoubtedly " + bool);
	}
	
	public void setGoal(int val){
		//System.out.println("Val = " + val);
		hasGoal = true;
		goal = val;
		goalTracker = new GoalTracker(this, goal);
		System.out.println("Goal Set!");
	}
	
	public GoalTracker getGoalTracker(){
		return goalTracker;
	}
	
	public void setBackground(){
		  if ( !days[new Date().getDayOfWeek()-1]){
            setOpaque(true);
            setBackground(java.awt.Color.gray);
            checkBox.setOpaque(true);
            checkBox.setBackground(java.awt.Color.gray);

        }
	}
}
