package practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
			while(true) {
			String a = scanner.nextLine();
			
			if(a.equals("exit")) {
				System.out.println("종료합니다..");
				break;
			}
			
			StringTokenizer s = new StringTokenizer(a," ");
			int count = s.countTokens();
			
			System.out.println("어절 개수는 : " + count);
			
		}
			scanner.close();
	}
}



//package practice;
//
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class p2 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		
//			while(true) {
//			String a = scanner.nextLine();
//			
//			if(a.equals("exit")) {
//				System.out.println("종료합니다..");
//				break;
//			}
//			
//			StringTokenizer s = new StringTokenizer(a," ");
//			int count = s.countTokens();
//			
//			System.out.println("어절 개수는 : " + count);
//			
//		}
//			scanner.close();
//	}
//}
//
//
//
