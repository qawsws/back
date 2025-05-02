package chapter12_3;
// 추상 클래스 : 추상 메서드가 존재하는 클래스를 의미
// 일반 메서드와 변수, 추상 메서드가 섞여서 작성됨
abstract class Unit {
	String name;
	int hp;
// 추상 메서드 : 구체적인 코드를 적지 않고 메서드의 이름 호출방식등만 작성한 메서드
	abstract void doMove();
//	구상 메서드 : 구체적인 코드를 작성한 메서드
	void printUnit() {
		System.out.println("이름:+name");
		System.out.println("HP:"+hp);
	}
}
//추상 클래스 사용방법
//추상 클래스 상속 후 추상메서드를 구현해야함
class Marine extends Unit{

	
//	추상메서드를 오버라이딩 하여 구체적인 코드를 작성해 구현함.
	@Override
	void doMove() {
		System.out.println("마린은 두발로 걸어 다닙니다.");
	}
	
}
class Zergling extends Unit{

	@Override
	void doMove() {
		// TODO Auto-generated method stub
		System.out.println("저글링은 네 발로 이동합니다.");
	}
	
}


public class MyStarcraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marine unit1 = new Marine();
		unit1.hp = 100;
		unit1.name = "마린";
		unit1.printUnit();
		unit1.doMove();
		
		System.out.println();
		
		Zergling unit2 = new Zergling();
		unit2.hp = 40;
		unit2.name = "저글링";
		unit2.printUnit();
		unit2.doMove();
		
	}

}

