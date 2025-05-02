package chapter12_4;

//인터페이스
// 클래스 생성시의 구조(틀)을 정해놓은 인터페이스
// 메서드 이름과 호출 방식, 매개변수를 작성하며 실제 실행 코드는 없음.
interface Greet{
//	인터페이스의 경우 abstract를 적을 필요없이 추상 매서드를 생성할 수 있음.
	void greet();
}
interface Talk{
	void talk();
}
// 인터페이스 상속하기
// implements를 사용하여 인터페이스를 상속 받는다
// 클래스, 추상클래스와 다르게 여러 인터페이스 상속이 가능하다.
class Morning implements Greet, Talk{

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("날씨가 좋네요.");
	}

	@Override
	public void greet() {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요!");
	}
	
}

public class Ex01_Meet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Morning morning = new Morning();
		morning.greet();
		morning.talk();
	}

}
