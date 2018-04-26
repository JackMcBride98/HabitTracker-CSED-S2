import java.io.*;
import java.util.ArrayList;

public class CreateData {

    private ArrayList<Habit> habits;
    private File userFile;
    private HabitTracker ht;

    public static void main(String[] args){
        CreateData d = new CreateData();
    }

    public void createUser(String username){
        System.out.println();
    }

    public void saveData(){
        try {
            PrintWriter lineWriter = new PrintWriter(new FileWriter("BEN.txt"));
            if (!habits.isEmpty()) {
                for (Habit h : habits) {
                    h.saveData();
                    lineWriter.println(h.getName());
                }
                lineWriter.close();
            }
            else{
                lineWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CreateData(){
        userFile = new File("BEN.txt");
        habits = new ArrayList<Habit>();
        ht = new HabitTracker(0);
        Habit newHabit = new Habit("test2", "BEN", ht);
        ArrayList<Date> habitHistory = new ArrayList<Date>();
        ArrayList<Date> habitHistory2 = new ArrayList<Date>();
        Date a = new Date(23,4, 2018);
        Date b = new Date(22,4,2018);
        habitHistory.add(a);
        habitHistory.add(b);
        newHabit.setHistory(habitHistory);
        Habit newHabit2 = new Habit("test3","BEN",ht);
        newHabit.setDateCreated(new Date(20,4,2018));
        Date c = new Date(23,4,2018);
        Date d = new Date(22, 4, 2018);
        Date e = new Date(21,4,2018);
        habitHistory2.add(c);
        habitHistory2.add(d);
        habitHistory2.add(e);
        newHabit2.setDateCreated(new Date(21,4,2018));
        newHabit2.setHistory(habitHistory2);
        habits.add(newHabit);
        habits.add(newHabit2);
        saveData();
    }
}
