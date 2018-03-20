import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EditHabitPane extends JDialog{

	private Habit habit;
	private HabitTracker habitTracker;
	private JLabel editText;
	private JButton deleteButton;
	private JButton editButton;
	private JTextField editTextField;
	
	// initialises all the components
	public EditHabitPane(Habit habit, HabitTracker habitTracker) {
		this.habit = habit;
		this.habitTracker = habitTracker;
		editText = new JLabel("Enter new Habit Name:");
		deleteButton = new JButton("Delete");
		// this sets what the delete button should do when pressed.
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habitTracker.deleteHabit(habit);
				dispose();
			}
		});
		editButton = new JButton("Enter");
		// this sets what the edit button should do when pressed.
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !editTextField.getText().equals("")) {
					habit.setName(editTextField.getText());
					habitTracker.update();
					dispose();
				}
			}
		});
		editTextField = new JTextField(15);
		editTextField.setText(habit.getName());
		editTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ( editTextField.getText().length() > 20) {
					e.consume();
				}
			}
		});
		setLayout(new FlowLayout());
		setTitle("Edit Habit");
		add(editText);
		add(editTextField);
		add(editButton);
		add(deleteButton);
		pack();
		setVisible(true);
	}
}
