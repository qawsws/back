package practice2;

public class q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		3. 다음 그림과 같이 위쪽과 왼쪽 숫자를 곱한 곱셈표를 출력하는 프로그램을 작성하시오
//		   | 1  2  3  4  5  6  7  8  9
//		---+------------------------
//		 1 | 1  2  3  4  5  6  7  8  9
//		 2 | 2  4  6  8 10 12 14 16 18
//		 3 | 3  6  9 12 15 18 21 24 27
//		             ~
//		 9 | 9 18 27 36 45 54 63 72 81
		
		System.out.println("   | 1  2  3  4  5  6  7  8  9");
		System.out.println("---+------------------------");
		for(int i=1; i<=9; i++) {
			System.out.print(" "+i+" | ");
			for(int j=1; j<=9; j++) {
				System.out.print(i*j);
				if((i*j)>=10) {
					System.out.print(" ");
				}else {
					System.out.print("  ");
				}
				
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




