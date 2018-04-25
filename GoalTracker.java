//class for tracking goals for a paticular habit, created on goal creation

import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;

public class GoalTracker{
	private Habit habit;
	private int completion;
	private float goal;
	private ArrayList<Date> history;
	//goal eg to complete 80% of this habit.
	public GoalTracker(Habit habit, float goal){
		this.habit = habit;	
		this.goal = goal;
		this.history = habit.getHistory();
	}

	public void checkProgress(){
		//look at days completed. compare goal to % of days completed.
		//goal = habit.getGoal();
		completion = getCompletion();
		
	}
	
	public int getCompletion(){
		//history is arraylist of dates which habit was completed on.
		float completeCount = history.size();
		System.out.println("Goal is: " + goal + ", completed: " + completeCount);
		float completion;
		//goal is int 1-100 representing %of days completed habit
		//eg if select mon tues wed when create habit, and set goal to be fraction of this eg 2/3. smart algorithm to do this?
		
		completion =  (completeCount/goal);
		System.out.println("Completion = " + completion);
		return (int)(completion * 100);
		
	}
	
}