package chapter2;

public class EX01_VariableType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바 스크립트의 경우 모든 변수의 앞에 let을 사용
		// 자바의 경우 변수 선언시 자료형 맞춰 다 다른 자료형 타입을 사용해야함
		
		// 정수 숫자 자료형
		//byte : -128 ~ +127
		byte b = 127;
		//short : -32,768 ~ + 32,767
		short s = 32767;
		//int : 2,147,483,648 ~ +2,147,483,647
		int i = 2147483647;
		//long :-9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807
		// long자료형의 경우 뒤에 영어 L을 붙여야 에러가 발생하지 않음		
		long l = 9223372036854775807L;
		// byte, short는 거의 쓰이지 않고 기본은 int로 사용하고	
		// 21보다 큰 값을 저장하는 경우에는 long을 사용합니다.
		
		// 문자 자료형	
		// char : 한글자만 저장할 수 있는 자료형, 작은 따옴표로 감싸서 사용
		char c = 'A';
		System.out.println(c);
		c = 124; //아스키코드, 유니코드로 저장 가능 
		System.out.println(c);
		// String : 여러 글자를 저장할 수 있는 자료형
		// 첫글자가 대문자인 이유 : 위에서 사용한 소문자 자료형들은 기본자료형
		// 첫글자가 대문자인 경우에는 클래스 자료형이라고 합니다.
		String str = "안녕하시요";
		// 클래스 자료형의 경우 . 을 이용하여 여러가지 가능을 사용 가능
		System.out.println(str.length()); // str 변수의 글자 수 출력
		// 기본 자료형에 해당하는 클래스 자료형이 모두 있음
		Byte by = 'a';
		Short sh = 35;
		Integer in = 21; //int만 클래스 자료형에 이름이 다르다.
		Long lo = 98L;
		Float fl = 3.14F;
		
		// 실수 자료형 : 소수점을 저장하는 자료형
        float f = 3.14F; // 소수점 아래 7자리까지
        double d = 3.14; // 소수점 아래 15자리
        // 컴퓨터는 소수점 계산이 정확하지 않음
        double num1 = 1.0000001;
        System.out.println(num1);
        double num2 = 2.0000001;
        System.out.println(num2);
        double result = num1 + num2;
        System.out.println(result);
        
	}

}
