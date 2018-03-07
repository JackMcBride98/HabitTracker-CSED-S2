import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// This handles the GUI aspect of the program.
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
		pack();
		setVisible(true);
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
