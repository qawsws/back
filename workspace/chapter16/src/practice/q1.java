package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class q1 {
	// TODO Auto-generated method stub
//	가위바위보 게임 만들기
//	try catch를 이용하여 문자 입력시 
//	1~3사이의 숫자를 입력해주세요

//	8.조건문과 반복문을 이용하여 가위바위보 게임을 만들어보세요. 
//	5번을 이겼을 경우 게임이 끝나게 되며 한번 가위바위보를 실행할 때마다 사
//	람과 컴퓨터의 가위바위보 내용 승패, 승리 횟수,패배 횟수를 출력합니다. 
//	  static Scanner sc = new Scanner(System.in);
//
//
//	public static void myMethod1() {
//		myMethod2();
//	}
//	public static void myMethod2() {
//		Scanner sc = new Scanner(System.in);
//		int win = 0;
//		int lose = 0;
//		int tie = 0;
//		while(win<=5) {
//			System.out.println("가위(1),바위(2),보(3)중에 선택해주세요>>");
//			int player = sc.nextInt();
//			int computer = (int)(Math.random()*3)+1;
//			int result  = player - computer;
//			if(result == 0) {
//				System.out.println("플레이어"+player+"vs"+computer+":컴퓨터 비김");
//				tie++;
//			}else if(result == -2 || result ==1) {
//				System.out.println("플레이어"+player+"vs"+computer+":컴퓨터 승리");
//				win++;
//			}else if(result == -1 || result ==2) {
//				System.out.println("플레이어"+player+"vs"+computer+":컴퓨터 패배");
//				lose++;
//			}
//			System.out.println("승리:" + win + "/5, 패배:" + lose + ", 비김:" + tie);
//			
//		}
//		System.out.println("가위바위보가 종료되었습니다.");
//	}
//	public static String checkNum(int num) {
//		String result = "";
//		if(num==1) {
//			result = "가위";
//		}else if(num == 2) {
//			result = "바위";
//		}else {
//			result = "보";
//		}
//		return result;
//	}
//
//	public static void main(String[] args) {
//		try {
//			myMethod1();
//			myMethod2();
//		}catch(Throwable e) {
//			e.printStackTrace();
//			sc.nextLine();
//		}
//		System.out.println("숫자 입력주세요");
//	}
//
//}
//
		public static void main(String[] args) {
			// TODO Auto-generated method stub
//			가위바위보 게임 만들기
//			try catch를 이용하여 문자 입력시 
//			1~3사이의 숫자를 입력해주세요

//			8.조건문과 반복문을 이용하여 가위바위보 게임을 만들어보세요. 
//			5번을 이겼을 경우 게임이 끝나게 되며 한번 가위바위보를 실행할 때마다 사
//			람과 컴퓨터의 가위바위보 내용 승패, 승리 횟수,패배 횟수를 출력합니다. 
			Scanner sc = new Scanner(System.in);
			int win = 0;
			int lose = 0;
			int tie = 0;
			while (win < 5) {
				try {
					System.out.println("가위(1), 바위(2), 보(3) 중에 선택해주세요>>");
					int player = sc.nextInt();
					if(player<1 || player>3) {
						System.out.println("1~3사이의 숫자를 입력해주세요\n");
						continue;
					}
					int computer = (int) (Math.random() * 3) + 1;
					int result = player - computer;

					String resultStr = "";
					if (result == 0) {
						resultStr = "비김";
						tie++;
					} else if (result == -2 || result == 1) {
						resultStr = "승리";
						win++;
					} else if (result == -1 || result == 2) {
						resultStr = "패배";
						lose++;
					}
					System.out.println("플레이어:" + checkNum(player) + "vs" + checkNum(computer) + ":컴퓨터 " + resultStr);
					System.out.println("승리:" + win + "/5 , 패배:" + lose + " , 비김:" + tie);
				} catch (Exception e) {
					System.out.println("1~3사이의 숫자를 입력해주세요\n");
//					무한반복 발생을 예방
					sc.nextLine();
				}
			}
			System.out.println("가위바위보가 종료되었습니다.");
		}

		public static String checkNum(int num) {
			String result = "";
			if (num == 1) {
				result = "가위";
			} else if (num == 2) {
				result = "바위";
			} else {
				result = "보";
			}
			return result;
		}
	}


	
