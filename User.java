import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Habit> habits;
    private HabitTracker habitTracker;

    public User(String username, HabitTracker habitTracker){
        this.username = username;
        this.habitTracker = habitTracker;
        habits = new ArrayList<Habit>();
        loadData();
    }

    public User(String username, HabitTracker habitTracker,int look){
        this.username = username;
        this.habitTracker = habitTracker;
        habits = habitTracker.getHabits();
    }

    public void loadData(){
        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(username + ".txt"));
            String line;
            while ( (line = lineReader.readLine()) != null){
                habits.add(new Habit(line, username, habitTracker));
            }
            lineReader.close();
        } catch (FileNotFoundException e){
            return;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHabitsString(){
        ArrayList<String> theHabits = new ArrayList<String>();
        for (Habit h: habits){
            theHabits.add(h.getName());
        }
        return theHabits;
    }

    public ArrayList<Habit> getHabits(){
        return habits;
    }

}
