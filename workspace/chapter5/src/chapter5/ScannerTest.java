package chapter5;

// import : 특정 기능을 사용하기 위해 클래스를 추가
// import 단축기 : ctrl + shift + o
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스캐너 클래스 선언 부분
//		// System.in : 콘솔창에 입력한 내용을 읽는 스캐너로 설정
		Scanner sc = new Scanner(System.in);
//		//nextInt() : 콘솔창에서 입력한 숫자를 num1에 저장한다
//		System.out.println("숫자를 1 2 3 이렇게 입력하고 엔터를 입력하세요.");
//		//공백을 이용하여 여러개의 변수에 한번에 값을 저장할 수 있음
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int num3 = sc.nextInt();
//		System.out.println("num1의 값: "+num1);
//		System.out.println("num2의 값: "+num2);
//		System.out.println("num3의 값: "+num3);
		
		//next() : 콘솔창에서 입력한 문자열을 String자료형에 저장하는 메서드
		System.out.println("홍길동 전우치 손오공 이렇게 입력해 보세요.");
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();
		System.out.println("str1의 값: "+ str1);
		System.out.println("str2의 값: "+ str2);
		System.out.println("str3의 값: "+ str3);

//		nextLine() : 공백과 상관없이 엔터키를 입력하기 전 모든 문자열을 저장
		String str6 = sc.next(); // 123을 저장하고 엔터가 남아있는 상태
		sc.nextLine(); // 엔터를 출력
		String str4 = sc.nextLine(); // 새롭게 문자를 저장
		String str5 = sc.nextLine();
		System.out.println(str6);
		System.out.println(str4);
		System.out.println(str5);
	}

}
