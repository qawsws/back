package chapter16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04_CatchConcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			int num1 = sc.nextInt();
			int num2 = 10/ num1;
			System.out.println(num2);
	}
//		or기호를 이용하여 여러가지 예외를 동시 처리할 수 있음1
		catch(ArithmeticException | InputMismatchException e) {
//			e 변수의 내용 : 어떤 예외가 발생했는지의 정보
			System.out.println("예외 발생");
//			예외 이름,예외 발생시의 매시지, 어디서 발생했는지의 코드 위치
			e.printStackTrace();
//			예외 발생시의 메시지만 반환하는 메서드
			System.out.println("에러 메시지"+e.getMessage());
		}
//		Exception e : 모든 예외를 의미
		catch(Exception e) {
			System.out.println("위에서 작성하지 않은 모든 예외를 처리");
		}
		System.out.println("Good bye");

}
}