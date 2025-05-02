package chapter6;

import java.util.Scanner;

public class EX05_whlie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		while : 반복횟수가 정해져있지 않은 경우 사용하는 반복문
//		초기값;
//		while(조건식) {
//			증감식;
//			실행할 코드;
//		}
		int start = 0;
		while(start < 10) {
//			start++;
			start = start + 1;
			System.out.println(start+"번 실행했습니다.");
		}
//		do while문 : 실행문을 위에 조건식을 아래에 적는 방식
//		특징 : 조건식이 false더라도 반드시 한번은 실행됨
		int start2 = 0;
		do {
			System.out.println(start2+"번 실행했습니다.");
			start2++;
		}while(start2<-1); //몰라
//		사용자 입력을 받아야하는 경우
//		1. 로그인 : 아이디와 비밀번호를 입력받아 맞으면 반복이 끝나고 틀리면 계속 반복
//		2. 가위바위보에서 이길때까지 실행해야하는 경우
		
//		while 무한 반복
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("가위,바위,보 중에 입력해주세여");
			System.out.println("게임을 종료하려면 종료 혹은 q라고 입력해주세요.");
			String inputStr = sc.next();
			if(inputStr.equals("종료") || inputStr.equals("q")) {
				System.out.println("게임이 종료 되었스빈다.");
				break; 
			}
			System.out.println("아직 가위바위보 로직을 작성중 입니다.");
		}
		
	}

}
