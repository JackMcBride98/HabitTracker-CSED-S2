import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
// This panel is a template for a display for all habits. Currently it displays the name of the habit and a checkbox.
public class Habit extends JPanel implements ActionListener{

	private String name;
	private JLabel nameLabel;
	private JCheckBox checkBox;
	private JButton editButton;
	private HabitTracker habitTracker;

	// initialises everything.
	public Habit(String name, HabitTracker habitTracker) {
		this.name = name;
		this.habitTracker = habitTracker;
		add(nameLabel = new JLabel(name));
		add(checkBox = new JCheckBox());
		add(editButton = new JButton("Edit"));
		editButton.addActionListener(this);
	}
	
	//Accesors
	public boolean isCheckBoxTicked() {
		return checkBox.isSelected();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		nameLabel.setText(name);
	}

	// Creates a new edithabitpane when the edit button is pressed.
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new EditHabitPane(this, habitTracker);
	}
}
