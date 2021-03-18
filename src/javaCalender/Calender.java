package javaCalender;

public class Calender {
	
	private static int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
		System.out.println(" 일   월   화   수   목   금   토");
		System.out.println("---------------------");
		
		int weekday = getWeekday(year, month, 1);
		
		//print blank space
		for(int i=0; i<weekday; i++) {
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
		//기준날짜의 요일을 알아낸다 1970년 1월 1일은 목요일
		int syear = 1970;
		final int STANDARD_WEEKDAY = 3;
		
		int count = 0;
		
		for(int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		for(int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		count += day;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	//simple test code here
		public static void main(String[] args) {
			Calender cal = new Calender();
			System.out.println(cal.getWeekday(1970, 1, 1) == 3);
			System.out.println(cal.getWeekday(1971, 1, 1) == 4);
			System.out.println(cal.getWeekday(1972, 1, 1) == 5);
			System.out.println(cal.getWeekday(1973, 1, 1) == 0);
			System.out.println(cal.getWeekday(1974, 1, 1) == 1);

		}
	
}
