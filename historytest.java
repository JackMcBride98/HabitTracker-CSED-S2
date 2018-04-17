import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class historytest {

    public static void main(String[] args){
        System.out.println(Calendar.getInstance().get(Calendar.MONTH));
    }

    public void loadData() {
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream("jack1.txt"));
            ArrayList<Object> objects = (ArrayList<Object>) objectReader.readObject();
            boolean[] days =  (boolean[]) objects.get(0);
            ArrayList<Date> history = (ArrayList<Date> )objects.get(1);
            Date dateCreated = (Date) objects.get(2);
            objectReader.close();
            System.out.println(dateCreated.getDay() + "." + dateCreated.getMonth() + "." + dateCreated.getYear());
            for ( Date d: history){
                System.out.println(d.getDay() + "." + d.getMonth() + "." + d.getYear());
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
