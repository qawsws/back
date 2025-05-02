package chapter16;

import java.util.Scanner;

public class Ex07_CatchThrowable {

	public static void myMethod1() {
		myMethod2();
	}
	public static void myMethod2() {
		Scanner sc = new Scanner(System.in);
//	    글자 입력시 예외
		int num1 = sc.nextInt();
//		0으로 나누었을때 예외
		int num2 = 10/num1;
		System.out.println(num2);
	}
	public static void myMethod3() {
		myMethod4();
	}
	public static void myMethod4() {
		Scanner sc = new Scanner(System.in);
//	    글자 입력시 예외
		int num1 = sc.nextInt();
//		0으로 나누었을때 예외
		int num2 = 10/num1;
		System.out.println(num2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			myMethod1();
//			위에서 예외가 발생하면 아래 코드는 실행되지 않음
			myMethod3();
//		Throwable : try에서 실행한 메서드에서 예외가 발생했을때 사용하는 예외클래스 
		}catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Good Bye~~!");
	}

}







