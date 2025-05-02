package ifpractice1;

import java.util.Scanner;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		한 층의 높이가 5m일 때, 건물이 몇 층인지 입력받아 높이를 출력하라. [난이도 하] 
//				몇 층인지 입력하세요>>155 
//				775m 입니다. 
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 층인지 입력하세요>>");
		int a = 5;
		int b = sc.nextInt();
		System.out.println((a*b)+"m 입니다");
	}
	

}
