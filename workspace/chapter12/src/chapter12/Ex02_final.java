package chapter12;

// 클래스 선언시 사용하는 final => 상속할 수 없는 클래스 선언으로 변경됨
//final class Unit{
//	
//}
// final class인 unit은 상속할 수 없음 => 에러 발생
//class Marine extends Unit{
//	
//}

class Unit{
//	메서드 작성시의 final => 오버라이딩 할 수 없는 메서드 선언
	final void doMove(){
		System.out.println("이동합니다.");
	}
}
class Marine extends Unit{
//	Unit의 doMove는 final로 작성되었기 때문에 오버라이딩이 불가능함
//	@Override
//	void doMove() {
//		
//	}
}

public class Ex02_final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		변수 선언시 사용하는 final => 상수 선언으로 변경됨
		final int MAX_NUM = 10;
		
	}

}
