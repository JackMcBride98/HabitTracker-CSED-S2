import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HabitTracker extends JFrame implements ActionListener{
	
	private JPanel addHabitPanel;
	private JButton addHabitButton;
	private JTextField addHabitTextField;
	private ArrayList<Habit> habits;
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private String username;

	
	// The constructor initialises the fields, sets up and orders the components, then loads the habits an displays everything and sets it up so that when closed the habits will be saved.
	public HabitTracker() {
		habits = new ArrayList<Habit>();
		setLayout(new FlowLayout());
		setTitle("Habit Tracker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addHabitTextField = new JTextField(30);
		addHabitTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ( addHabitTextField.getText().length() > 20) {
					e.consume();
				}
			}
		});
		addHabitButton = new JButton("Add Habit");
		addHabitButton.addActionListener(this);
		addHabitPanel = new JPanel();
		addHabitPanel.add(addHabitTextField);
		addHabitPanel.add(addHabitButton);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveHabits();
			}
		});	
		usernameLabel = new JLabel("Username");
		usernameTextField = new JTextField(30);
		usernameTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ( addHabitTextField.getText().length() > 20) {
					e.consume();
				}
			}
		});
		usernameTextField.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				username = usernameTextField.getText();
				setTitle("Habit Tracker - " + username);
				closeLoginInterface();
				openMainInterface();
			}
		});
		openLoginInterface();
 	}
	
	public void openLoginInterface() {
		add(usernameLabel);
		add(usernameTextField);
		pack();
		setVisible(true);
	}
	
	public void closeLoginInterface() {
		remove(usernameLabel);
		remove(usernameTextField);
	}
	
	public void openMainInterface() {
		add(addHabitPanel);
		loadHabits();
		displayHabits();
		pack();
		setVisible(true);
	}
	
	// This deletes a specified habit and then updates the display.
	public void deleteHabit(Habit h) {
		removeHabits();
		habits.remove(h);
		displayHabits();
	}

	// this saves the habits to the file.
	public void saveHabits() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(username + "Data.txt"));
			for(Habit h: habits) {
				pw.println(h.getName());
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// this makes the habits visible by adding them to the frame and then packing the frame.
	public void displayHabits() {
		for(Habit h: habits) {
			add(h);
		}
		pack();
	}
	
	// this makes the habits invisible by removing them from the frame and then packing the frame.
	public void removeHabits() {
		for (Habit h: habits) {
			remove(h);
		}
		pack();
	}
	
	// this just updates the habits, for example if the name of a habit is changed.
	public void update() {
		removeHabits();
		displayHabits();
		pack();
	}
	
	// this loads the habits from file into the habits array list.
	public void loadHabits() {
		try {
			FileReader fileReader = new FileReader(username + "Data.txt");
			BufferedReader br = new BufferedReader(fileReader);
			String savedHabit;
			while( (savedHabit = br.readLine()) != null ) {
				habits.add(new Habit(savedHabit,this));
			}
			br.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			File newUserFile = new File(username + "Data.txt");
			try {
				newUserFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException er) {
			er.printStackTrace();
		}
	}
	
	// this method is called whenever the add a habit button is pressed and it creates a new habit with the text given and then makes it visible.
	@Override
	public void actionPerformed(ActionEvent e ) {
		if (!addHabitTextField.getText().equals("")) {
			Habit newHabit;
			habits.add(newHabit = new Habit(addHabitTextField.getText(), this));
			addHabitTextField.setText("");
			add(newHabit);
			saveHabits();
			pack();
		}
	}
	
	// main method simply makes a habit tracker.
	public static void main(String[] args) {
		HabitTracker habitTracker = new HabitTracker();
	}
}
