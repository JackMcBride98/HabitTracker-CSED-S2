import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MonthPanel extends JPanel {

    private int daysInMonth;
    private JLabel[] days;
    private Date dateCreated;
    private Date currentDate;
    private ArrayList<Date> history;
	private Border createBorder;

    public MonthPanel(ArrayList<Date> history, Date dateCreated){
        this.history = history;
        this.dateCreated = dateCreated;
        currentDate = new Date();
		createBorder = new LineBorder(Color.BLACK,2);
        setLayout(new GridLayout(0,7));
        days = new JLabel[31];
        createDayLabels();
        addDayLabels();
        colourDays();
        if ( history != null) {
            for (Date date : history) {
                if (date.getMonth() == currentDate.getMonth()) {
                    days[date.getDay() - 1].setBackground(Color.green);
                    days[date.getDay() - 1].setOpaque(true);
                }
            }
        }
    }

    public void removeDayLabels(){
        for(int i = 0; i < daysInMonth; i++){
            remove(days[i]);
        }
    }

    public void addDayLabels(){
        daysInMonth = currentDate.getDaysInMonth();
        for (int i = 0; i < daysInMonth; i++) {
            add(days[i]);
        }
        revalidate();
        repaint();
    }

    public void createDayLabels(){
        for (int i = 0; i < 31; i++){
            days[i] = new JLabel(Integer.toString(i+1));
        }
    }

    public void colourDays(){
        for (int i = 0; i < 31; i++){
            days[i].setBackground(Color.white);
            days[i].setOpaque(true);
        }
        if ( history != null) {
            for (Date date : history) {
                if (date.getMonth() == currentDate.getMonth() && date.getYear() == currentDate.getYear() ) {
                    days[date.getDay() - 1].setBackground(Color.green);
                    days[date.getDay() - 1].setOpaque(true);
                }
            }
        }
        if ( dateCreated.getMonth() == currentDate.getMonth()) {
            days[dateCreated.getDay() - 1].setBorder(createBorder);
        }
    }

    public void monthUp(){
        removeDayLabels();
        currentDate.incrementMonth();
        addDayLabels();
        colourDays();
        revalidate();
    }

    public void monthDown(){
        removeDayLabels();
        currentDate.decrementMonth();
        addDayLabels();
        colourDays();
        revalidate();
    }
	
	public void update(ArrayList<Date> history){
        this.history = history;
        colourDays();
        revalidate();
    }
}
