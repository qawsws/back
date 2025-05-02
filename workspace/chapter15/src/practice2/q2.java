package practice2;

import java.util.Random;
import java.util.Scanner;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println(" 1-99까지 정수를 입력하시오.>>");
		String str = sc.next();
		int n = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '3' || ch == '6' || ch == '9') {
				if (n > 0) {
					System.out.println("짝");
				}else {
					System.out.print("박수짝");
					n++;
				}
				
			} 
		}

	}

}

//
//package practice2;
//
//import java.util.Scanner;
//
//public class Q2 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		2. 임의의 숫자를 입력하여 369게임을 간단하게 작성. 1-99까지 정수를 입력하고 3,6,9 중 하나가 있는 
////		경우 ‘박수짝’을 출력하고, 두 개 있는 경우 ‘박수짝짝’을 출력하는 프로그램을 작성하라.
//		Scanner sc = new Scanner(System.in);
//		System.out.print("1-99까지 정수를 입력>>");
//		String str = sc.next();
//		int count = 0;
//		for(int i=0; i<str.length(); i++) {
//			char c = str.charAt(i);
//			if(c=='3' || c=='6' || c=='9') {
//				if(count>0) {
//					System.out.print("짝");
//				}else {
//					System.out.print("박수짝");
//					count++;
//				}
//				
//			}
//		}
//		
//	}
//
//}
//
//
//
//



