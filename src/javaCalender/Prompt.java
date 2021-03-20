package javaCalender;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+---------------------+");
		System.out.println("| 1. 일정 등록   ");
		System.out.println("| 2. 일정 검색   ");
		System.out.println("| 3. 달력 보기   ");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+---------------------+");
	}
	/**
	 * 
	 * @param week
	 *            요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		switch(week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;		
		}
	}

	private final static String YEAR ="year>";
	private final static String MONTH ="month>";
	
	public void runPrompt() throws ParseException {
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
	
		
		boolean isLoop = true; //while을 빠져나오기 위한 문 
		while (isLoop) {
			System.out.println("명령하세요! [1, 2, 3, h, q]");
			String cmd = scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;  
				break;		
			}
		}
		
		System.out.println("Good Bye!");
		scanner.close();
		
	}
	private void cmdCal(Scanner s, Calender c) {
		
		int month = 1;
		int year = 2017;
		
		System.out.println("년도를 입력하세요.(exit: -1)");
		System.out.println(YEAR);
		year = s.nextInt();
		
		System.out.println("달을 입력하세요.");
		System.out.println(MONTH);
		month = s.nextInt();
		
	
		if(month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다");
			return;
		}
		c.printCalender(year, month);
	}
	private void cmdSearch(Scanner s, Calender c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd)");
		String date = s.next();
		PlanItem plan;
		plan = c.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
	}



	private void cmdRegister(Scanner s, Calender c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요(yyyy-mm-dd)");
		String date = s.next(); // 입력 후 enter키를 치면, 처음 next"메뉴를 선택해주세요" 계속 출력됨.
		String text = "";
	    System.out.println("일정을 입력해 주세요.(끝문자 = ;)");
	    String word;
		while(!(word = s.next()).endsWith(";")) {
			text += word +" ";
		}
		word = word.replace(";", "");
		text += word;
		c.registerPlan(date, text);
	}
	public static void main(String[] args) throws ParseException {
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
