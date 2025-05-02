package chapter17;

class Book{
	String name;
	String author;
	
	@Override
	public String toString() {
		return this.name + ","+this.author;
	}
}

public class Ex02__toString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		자바의 기본 클래스
//		java.lang : 기본 클래스들이 들어있는 패키지명
//		Object : 최상위 클래스로 기본 매서드를 제공
		Ex02__toString ex02 = new Ex02__toString();
//		인스턴스 ex02를 print, println에서 실행하면 자동으로 toString을 실행함
		System.out.println(ex02);
//		toString 메서드를 오버라이딩하여 내용을 변경하지 않으면 아해의 내용이 출력
//		패키지명.클래스명@16진수메모리주소
		System.out.println(ex02.toString());
//		Object는 모든 클래스가 상속받고 있으며
//		직접 만든 클래스의 경우에도 컴파일시 상속을 추가해줌
//		Object에 있는 모든 메서드는 어떤 클래스던 사용 가능
		Object obj = new Object();
		
		String name = "홍길동";
//		String 클래스의 경우 toString을 문자열을 출력하도록 오버라이딩한 상태
		System.out.println(name);
		System.out.println(name.toString());
		
		Book book1 = new Book();
		book1.name = "자바 프로그래밍";
		book1.author = "이재환";
		System.out.println(book1.toString());
		System.out.println(book1);
		}
	

}
