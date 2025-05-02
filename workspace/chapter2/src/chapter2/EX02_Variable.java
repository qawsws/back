package chapter2;

public class EX02_Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 변수 선언하기
		// 자료형 변수이름 = 자료형에 맞는 값;
		int number = 10;
		System.out.println(number);
		number = 20;
		System.out.println(number);
		String str = "안녕하세요";
		//String str = "이이이이";
		//변수 선언시의 주의점
		// 1. 변수이름은 중복될 수 없음
		// 2. 카멜표기법을 사용하여 변수명을 작성하기 firstName
		// 3. 변수명만 보고도 의미가 통하도록 작성하기
		// 4. 예약어(자료형,조건문,반복문) 변수이름으로 사용할 수 없음
		
		// 상수 선언하기
		//상수 : 한번 데이터를 저장하면 더 이상 바꿀 수 없는 저장공간
		//상수 선언과 값 대입을 동시에 설정하기
		final int MAX_NUM = 10;
		//MAX_NUM = 20;  값을 변경할 수 없음
		
		//상수 선언과 대입을 따로 실행하기
		final int MIN_NUM; // 상수의 선언만 실행
		MIN_NUM = 6; // 값을 대입한 적이 없기 때문에 실행 가능
		//MAX_NUM = 3; 위에서 값을 대입했기 떄문에 변경할 수 없음
		//상수 사용시 주의점
		// 1. 한번 대입을 하면 두번째 대입은 불가능(값 변경 불가능)
		// 2. 언더스코어 표기법으로 상수 이름 설정(MAX_NUM,FIRST_NAME)
		// 3. 변수명만 보고도 의미가 통하도록 작성하기
		// 4. 예약어(자료형 int,조건문 if,반복문 for) 변수이름으로 사용할 수 없음
		
		// 자동 형 변환 : 자료형이 자동으로 변경되어 저장되는 것
		// 숫자를 직접적으로 적으면 모두 int타입으로 만들어지고 byte에 저장시 byte타입으로 자동 형 변환이 이루어짐
		// byte = int
		byte a = 127;
		//byte a = 128; 에러발생 : int인 128데이터는 byte의 범위를 넘기 때문에
		long c = 1;
		// long c = 2147483648; 숫자는 int형이기 때문에 int의 범위에 맞게 사용해야 에러가 발생하지 않음
		long e = 2147483648L; // 숫자 뒤에 L을 붙이면 long타입으로 변경됨
		
		// 실수를 적으면 double이 기본 자료형
		float f = 3.14f;
		double d =3.14;
		
		// 연산시의 자동 형 변환
		int num1 = 10;
		byte num2 = 20;
		//             int + byte
		//byte result1 = num1 + num2; // int보다 작은 byte타입으로는 자동 형 변환이 불가능
		int result2 = num1+num2; // byte타입을 자동 형 변환으로 int변경 후 저장
		
		// 수동 형 변환(cast) : (자료형)변수명
		byte result3 = (byte)(num1+num2);
		
		//산술 연산자 : +,-,*,/,%
		//대입 연산자 : = , +=, -=, *=, /=
		//비교 연산자 : ==, !=, <, <=, >, >=
		//논리 연산자 : &&(and) , ||(or), !(not)
		//삼항연산자 : 조건식 ? true : false
		
		
		
		
		
	}
	
	

}
