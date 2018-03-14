import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HabitTracker extends JFrame implements ActionListener{
	
	private JPanel addHabitPanel;
	private JButton addHabitButton;
	private JTextField addHabitTextField;
	private ArrayList<Habit> habits;
	
	
	public HabitTracker() {
		habits = new ArrayList<Habit>();
		setLayout(new FlowLayout());
		setTitle("Habit Tracker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addHabitTextField = new JTextField(30);
		addHabitButton = new JButton("Add Habit");
		addHabitButton.addActionListener(this);
		addHabitPanel = new JPanel();
		addHabitPanel.add(addHabitTextField);
		addHabitPanel.add(addHabitButton);
		add(addHabitPanel);
		loadHabits();
		displayHabits();
		pack();
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveHabits();
			}
		});	
 	}

	public void saveHabits() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Data.txt"));
			for(Habit h: habits) {
				pw.println(h.getName());
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(String habit) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("Data.txt"));
			pw.println(habit);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void displayHabits() {
		for(Habit h: habits) {
			add(h);
		}
	}
	
	public void loadHabits() {
		try {
			FileReader fileReader = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fileReader);
			String savedHabit;
			while( (savedHabit = br.readLine()) != null ) {
				habits.add(new Habit(savedHabit));
			}
			br.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException er) {
			er.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e ) {
		if (addHabitTextField.getText() != null) {
			Habit newHabit;
			habits.add(newHabit = new Habit(addHabitTextField.getText()));
			addHabitTextField.setText("");
			add(newHabit);
			pack();
		}
	}
	
	public static void main(String[] args) {
		HabitTracker habitTracker = new HabitTracker();
	}
}

