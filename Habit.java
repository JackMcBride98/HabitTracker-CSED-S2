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
	private Calendar dateCreated;
	private boolean[] days; 
	private ArrayList<Calendar> history;
	private HabitTracker habitTracker;
	
	private JLabel nameLabel;
	private JCheckBox checkBox;
	private JButton detailsButton;
	private JButton editButton;
	
	
	public Habit(String name, String username, HabitTracker habitTracker) {
		this.name = name;
		this.username = username;
		this.habitTracker = habitTracker;
		days = new boolean[7];
		data = new File(username + name + ".txt");
		loadData();
		nameLabel = new JLabel(name);
		checkBox = new JCheckBox();
		editButton = new JButton("Edit");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					history.add(Calendar.getInstance());
				}
				else {
					history.remove(history.size()-1);
				}
			}
		});
		detailsButton = new JButton("More Info*");
		detailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDetails();
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
	
	public void showDetails() {
		add(editButton);
		habitTracker.pack();
	}
	
	//loads in the stored habit data from file.
	public void loadData() {
		try {
			ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(data));
			days = (boolean[]) objectReader.readObject();
			history = (ArrayList<Calendar>) objectReader.readObject();
			dateCreated = history.get(0);
			objectReader.close();
		} catch (FileNotFoundException e) {
				dateCreated = Calendar.getInstance();
				days = new boolean[] {true,true,true,true,true,true,true};
				history = new ArrayList<Calendar>();
				history.add(dateCreated);
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
			objectWriter.writeObject(days);
			objectWriter.writeObject(history);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
