package practice;

import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2. 정수를 10개 입력받아 배열에 저장한 후, 배열을 검색하여 3의 배수만 골라 출력하는 프
//		로그램을 작성하라. [목적-배열과 반복문 연습] [난이도 하] 
//		정수 10개 입력>>2 44 77 6 8 9 12 88 100 2323 
//		6 9 12
		Scanner sc = new Scanner(System.in);
		int[] intArr = new int[10];
		System.out.print("정수 10개 입력>>");
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		
		for(int i=0; i<intArr.length; i++) {
			if(intArr[i]%3 == 0)
				System.out.print(intArr[i] + " "); 
		}
	}

}
