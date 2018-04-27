import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Random;



public class ReminderThread extends Thread{
	
	private String name; //name of the habit
	private int timeHour; //integer 0-24 representing hour
	private int timeMin;
	private String username;
	Calendar cal = Calendar.getInstance();
	
	public ReminderThread(String name, String username, int timeHour, int timeMin){
		this.name = name;
		this.timeHour = timeHour;
		this.timeMin = timeMin;
		this.username = username;
	}
	
	public void run(){
		
		
		while(true){
			//Check if system time is one of times in array. if it is and reminder not yet displayed then do so.
			int currentHour = convertTime();
			cal = Calendar.getInstance();
			System.out.println("Checking time: " + currentHour + ":" + cal.get(Calendar.MINUTE));
			if ((timeHour == currentHour) && (cal.get(Calendar.MINUTE) == timeMin)){
				System.out.println("Reminded!");
				remind();
			} else{
				System.out.println("Time incorrect, sleeping for a minute");
			}
			
			try{
				Thread.sleep(60000); // check again in a minute
			} catch(InterruptedException e){
				System.out.println("Thread interrupted");
			}
			
		}
		
	}
	
	 public void remind(){
		 
		 
		String[] messages = new String[]{"Hey! Don't forget to " + name  , "Message from past " + username + ": " + name + "right now!" , "Emergency!! " + name + " immediately!!", 
		"Quick! If you want to live, " + name, "You should really " + name, username +  ", didn't you say you would ", username + ", it's time to " + name};
		 
		Random rand = new Random();
		int n = rand.nextInt(messages.length);
        
				

		
		
		JOptionPane.showMessageDialog(null, messages[n], "Reminder!", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Dont forget, you want to: " + name, "Reminder for: " + name, JOptionPane.INFORMATION_MESSAGE);
    }
	
	public int convertTime(){
		//convert am pm nonsense to 24 format
		int newTime = 0;
		;
		
		
		if (cal.get(Calendar.AM_PM) == 0){
			//am
			newTime = cal.get(Calendar.HOUR);
		} else{
			//pm
			newTime = cal.get(Calendar.HOUR) + 12;
		}
		
		System.out.println("New time = " + newTime);
		return newTime;
		
		
	}
	
}