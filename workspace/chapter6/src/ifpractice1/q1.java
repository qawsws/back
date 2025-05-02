package ifpractice1;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		두 정수를 입력하세요>>10 20
//		10+20은 30
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요>>");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a+"+"+b+"은 "+(a+b));
	}


}
