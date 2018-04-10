import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private HabitTracker habitTracker;
	private JLabel usernameLabel;
	private JTextField usernameField;
	
	public LoginPanel(HabitTracker habitTracker) {
		this.habitTracker = habitTracker;
		usernameLabel = new JLabel("Enter Username");
		usernameField = new JTextField(30);
		usernameField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!usernameField.getText().equals("")) {
					habitTracker.userLogin(usernameField.getText());
				}
			}
		});
		usernameField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ( usernameField.getText().length() > 15) {
					e.consume();
				}
				if ( e.getKeyCode() == KeyEvent.VK_ENTER){
					habitTracker.userLogin(usernameField.getText());
				}
			}
		});
		add(usernameLabel);
		add(usernameField);
	}
}
