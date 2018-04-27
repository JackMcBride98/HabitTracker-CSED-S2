import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class EditFeature extends JFrame{

	private Habit habit;
	private HabitTracker habitTracker;
	
	JFrame frame = new JFrame();
    JButton deleteButton = new JButton("Delete habit.");
    JLabel label = new JLabel("Change Habit Name:");
    JButton changeName = new JButton("Change Name");
	
	public EditFeature(String name, Habit habit, HabitTracker habitTracker) {
		this.habitTracker = habitTracker;
		this.habit=habit;
	    JTextField input = new JTextField(habit.getName());
		
	    deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteHabit(habit.getName());
			}
		});
	    
	    changeName.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		changeName(input.getText());
	    	}
	    });
	    
	    input.setColumns(20);
	    
		frame.setTitle("Edit");
		frame.setLayout(new BorderLayout(13,13));
		frame.add(changeName, BorderLayout.EAST);
		frame.add(label, BorderLayout.NORTH);
		frame.add(deleteButton,BorderLayout.SOUTH);
		frame.add(input, BorderLayout.WEST);
		frame.pack();
		frame.setVisible(true);
	    
		
	}
	
	public void deleteHabit(String habitName) {
		frame.dispose();
		habitTracker.getHabits().remove(habit); // new
        habit.hideDetails();
        habitTracker.getDailyChecklistPanel().updateHabits(habitTracker.getHabits());
		habit.deleteName();
		habitTracker.revalidate();
		habitTracker.repaint();
	}
	
	public void changeName(String name) {
		habit.deleteFile();
		habit.setName(name);
		habit.refreshLabel(name);
		frame.dispose();
		habit.hideDetails();
		habitTracker.revalidate();
		habitTracker.repaint();
	}
}
	
