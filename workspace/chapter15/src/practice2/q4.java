package practice2;

import java.util.Scanner;

public class q4 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("알파벳 한 문자를 입력하세요>>");
		
		String s = sc.next(); // 문자열로 읽음 
		char c = s.charAt(0); // 문자열의 첫 번째 문자 
		
		for (char i = c; i >= 'a'; i--) { 
			for (char j = 'a'; j <= i; j++) {       
                System.out.print(j);
            }
            System.out.println();
		}
	}

}

//
//package practice2;
//
//import java.util.Scanner;
//
//public class Q4 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		4.  소문자 알파벳을 하나 입력받아서 다음과 같은 결과가 나타나도록 코드를 작성하시오.
////		소문자 알파벳 하나를 입력하시오>> e
////		 abcde
////		 abcd
////		 abc
////		 ab
////		 a
//		Scanner sc = new Scanner(System.in);
//		System.out.print("소문자 알파벳 하나를 입력하시오>>");
//		char ch = sc.next().charAt(0);
//		for(char i=ch; i>='a';i--) {
//			for(char j='a'; j<=i; j++ ) {
//				System.out.print(j);
//			}
//			System.out.println();
//		}
//	}
//
//}
//
//
//
//
//
//
//
//
//



