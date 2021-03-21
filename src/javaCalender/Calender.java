package javaCalender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calender {
	
	private static int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static final String SAVE_FILE = "calender.dat";

	private HashMap <Date, PlanItem> planMap;
	
	public Calender() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if(!f.exists())
			return;
		try {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String[] words = line.split(","); 
				String date = words[0];
				String detail = words[1].replaceAll("\"", "");
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}	
	public void registerPlan(String strDate, String plan)  {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item  = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
		
	}
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 !=0 || year % 400 == 0)){
		 return true;
		 }else {
		 return false;
	    }
	}
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}else {
		    return MAX_DAYS[month];
		}
	}
	public void printCalender(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n",year,month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("-----------------------");
		
		int weekday = getWeekday(year, month, 1);
		
		//print blank space
		for(int i=0; i < weekday; i++) {
			System.out.print("   ");
		}
		
		int maxDay = getMaxDaysOfMonth(year, month);
		
		// print first line (confirm back days) 
		int count = 7- weekday;
		for(int i = 1; i<=count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		//print from second line to last
		int delim = (count < 7)? count : 0;
		count++; 
		
		for(int i=count; i<=maxDay; i++) {
			System.out.printf("%3d", i);  //해당 자리에 들어올 int가 총 세자리를 차지함.
			if(i % 7 == delim) {
				System.out.println();
			}
	    }
		System.out.println();
		System.out.println();
	
	}
	
	private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4;
		
		int count = 0;
		
		for (int i= syear; i < year; i++) {
			int delta = isLeapYear(i)? 366: 365;
			count += delta;
		}
		
		for(int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year,i);
			count += delta;
		}
		
		count += day -1 ;
				
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
		//simple test code here
		public static void main(String[] args) throws ParseException {
			Calender cal = new Calender();
			System.out.println(cal.getWeekday(1970, 1, 1));
			System.out.println(cal.getWeekday(1971, 1, 1));
			System.out.println(cal.getWeekday(1972, 1, 1));
			System.out.println(cal.getWeekday(1973, 1, 1));
			System.out.println(cal.getWeekday(1974, 1, 1));

			
		}
	
}
