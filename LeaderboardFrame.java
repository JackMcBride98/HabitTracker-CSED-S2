import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


//Allows you to select a habit and it will order all users,
public class LeaderboardFrame extends JFrame {

    private HabitTracker habitTracker;
    private User currentUser;
    private ArrayList<User> users;
    private JComboBox<String> usersHabits;
    private JComboBox<String> compareChoice;
    private JPanel leaderboard;
    private JPanel options;
    private JLabel[] labels;

    public LeaderboardFrame(HabitTracker habitTracker){
        this.habitTracker = habitTracker;
        users = new ArrayList<User>();
        loadUsers();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                habitTracker.setVisible(true);
            }
        });
        String[] someHabits = new String[currentUser.getHabitsString().size()];
        usersHabits = new JComboBox<String>(currentUser.getHabitsString().toArray(someHabits));
        usersHabits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLeaderBoard();
            }
        });
        compareChoice = new JComboBox<String>(new String[] {"Days Completed","Percentage","Streak"});
        compareChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLeaderBoard();
            }
        });
        options = new JPanel();
        options.add(compareChoice);
        options.add(usersHabits);
        add(options, BorderLayout.PAGE_START);
        leaderboard = new JPanel(new GridLayout(0,3));
        createLeaderBoard();
        pack();
    }

    public void loadUsers(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;
            currentUser = new User(habitTracker.getUsername(), habitTracker,1);
            while ((line = reader.readLine())!=null){
                if ( !line.equals(currentUser)) {
                    users.add(new User(line, habitTracker));
                }
            }
        } catch (Exception e){

        }
    }

    public void createLeaderBoard(){
        labels = new JLabel[3*users.size()+3];
        labels[0] = new JLabel("#");
        labels[1] = new JLabel("Username");
        labels[2] = new JLabel("Score");
        leaderboard.add(labels[0]);
        leaderboard.add(labels[1]);
        leaderboard.add(labels[2]);
        for (int i = 3; i < 3*users.size(); i++){
            labels[i] = new JLabel(Integer.toString(i));
            leaderboard.add(labels[i]);
        }
        add(leaderboard, BorderLayout.CENTER);
        updateLeaderBoard();
    }

    public void updateLeaderBoard(){
        String habitName = (String) usersHabits.getSelectedItem();
        String comparison = (String) compareChoice.getSelectedItem();
        leaderboard.removeAll();
        leaderboard.add(labels[0]);
        leaderboard.add(labels[1]);
        labels[2].setText(comparison);
        leaderboard.add(labels[2]);
        ArrayList<Habit> toSort = new ArrayList<Habit>();
        for (User user: users){
            ArrayList<Habit> userHabits = user.getHabits();
            for (Habit h: userHabits){
                if (h.getName().equals(habitName)){
                    toSort.add(h);
                }
            }
        }
        //sort them
        sortHabits(toSort, comparison);
        //then for each one in order, add the username and the score
        for (int i = 0; i < toSort.size(); i++){
            labels[(3*i)+3].setText(Integer.toString(i+1));
            leaderboard.add(labels[(3*i)+3]);
            labels[(3*i)+4].setText(toSort.get(i).getUsername());
            leaderboard.add(labels[(3*i)+4]);
            if (comparison.equals("Days Completed")){
                labels[(3*i)+5].setText(Integer.toString(toSort.get(i).getHistory().size()));
            }
            if (comparison.equals("Percentage")) {
                labels[(3*i)+5].setText(Integer.toString(toSort.get(i).getPercentage()));
            }
            if (comparison.equals("Streak")) {
                labels[(3*i)+5].setText(Integer.toString(toSort.get(i).getStreak()));
            }
            leaderboard.add(labels[(3*i)+5]);
        }
        leaderboard.revalidate();
        leaderboard.repaint();
        revalidate();
    }

    public void sortHabits(ArrayList<Habit> toSort, String by){
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < toSort.size()-1; i++) {
                if (by.equals("Days Completed")) {
                    if (toSort.get(i).getHistory().size() > toSort.get(i + 1).getHistory().size()) {
                        Collections.swap(toSort, i, i + 1);
                        swapped = true;
                    }
                }
                if (by.equals("Percentage")) {
                    if (toSort.get(i).getPercentage() > toSort.get(i+1).getPercentage()){
                        Collections.swap(toSort, i, i +1);
                        swapped = true;
                    }
                }
                if (by.equals("Streak")) {
                    if (toSort.get(i).getStreak() > toSort.get(i+1).getStreak()){
                        Collections.swap(toSort,i,i+1);
                        swapped = true;
                    }
                }
            }
        } while (swapped);
    }
}
