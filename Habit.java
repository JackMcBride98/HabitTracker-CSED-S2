import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
// This panel is a template for a display for all habits. Currently it displays the name of the habit and a checkbox.
public class Habit extends JPanel {

	private String name;
	private JLabel nameLabel;
	private JCheckBox checkBox;
	
	public Habit(String name) {
		this.name = name;
		add(nameLabel = new JLabel(name));
		add(checkBox = new JCheckBox());
	}
	
	public boolean isCheckBoxTicked() {
		return checkBox.isSelected();
	}
}
