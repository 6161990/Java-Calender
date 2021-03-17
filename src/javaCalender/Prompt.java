package javaCalender;

import java.util.Scanner;

public class Prompt {
	
	public int parseDay(String str_weekday) {
		if( str_weekday.equals("일")) return 0;
		else if( str_weekday.equals("월")) return 1;
		else if( str_weekday.equals("화")) return 2;
		else if( str_weekday.equals("수")) return 3;
		else if( str_weekday.equals("목")) return 4;
		else if( str_weekday.equals("금")) return 5;
		else if( str_weekday.equals("토")) return 6;
		else return 0;
	}

	private final static String YEAR ="year>";
	private final static String MONTH ="month>";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = -1;
		int year = -1;
		
		
		while(true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.println(YEAR);
			year = scanner.nextInt();
			if(year == -1)
				break;
			
			System.out.println("달을 입력하세요.");
			System.out.println(MONTH);
			month = scanner.nextInt();
			
		
			if(month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			cal.printCalender(year, month);
		}
		
		System.out.println("Bye~");
		scanner.close();
		
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
		
		
		
		
		
		
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		/*방법 1
		System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
		System.out.printf("%d월은 %d일까지 있습니다.\n", month, maxDays[month -1]);
		*/
		
		
		//방법 2 (메소드를 만들고 난 후)
		/*System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		int month = scanner.nextInt();
		
		System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		
		cal.printSampleCalender();*/
		
		
		//반복해서 입력받기
		/*Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();

		System.out.println("반복횟수를 입력하세요.");
		int repeat = scanner.nextInt();
		
		for(int i=0; i<repeat; i++) {
			System.out.println("달을 입력하세요.");
			int month = scanner.nextInt();
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		}
		
		System.out.println("Bye~");*/
		
		
		//프롬포트
		/*String PROMPT ="cal>";
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		System.out.println("반복횟수를 입력하세요.");
		int repeat = scanner.nextInt();
		
		for(int i = 0; i<repeat; i++) {
			System.out.println("달을 입력하세요.");
			System.out.println(PROMPT);
			int month = scanner.nextInt();
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		}

		System.out.println("Bye~");*/

		
		//반복조건 -1일 때 종료하기(break), 12이상이 일때 다른 입력값 계속해서 받기 (continue)
		/*String PROMPT ="cal>";
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		while(true) {
			System.out.println("달을 입력하세요.");
			System.out.println(PROMPT);
			int month = scanner.nextInt();
			if(month == -1) {
				break;
			}
			if(month > 12) {
				System.out.println("달은 12월까지 존재합니다.");
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		}
		
		System.out.println("Bye~");
		scanner.close();
		*/
		
	
		
	}


}
