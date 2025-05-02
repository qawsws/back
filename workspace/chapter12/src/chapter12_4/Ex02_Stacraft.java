package chapter12_4;

//기본적으로 건물에 필요한 내용들
abstract class Building {
	int health;
	abstract void doBuild();
}
//특수한 부가 기능
interface Fly {
	void flyBuilding();
//	디폴트 메서드 : 인터페이스에 일반 메서드를 구현하는 기능
//	인터페이스에는 기본적으로 추상 메서드에서만 사용 사능했으나 메서드가 추가되었을때 수정이 힘듬
//	추상메서드를 추가하면 기존에 인터페이스를 사용하는 모든 클래스에서 에러가 발생함
//	추상메서드는 반드시 구현해야하지만 동일한 내용이라면 추가하는 것이 굉장히 비효율적
	default void downBuilding() {
		System.out.println("건물이 착지합니다.");
	}
	
}

class Barracks extends Building implements Fly {

	@Override
	void doBuild() {
		// TODO Auto-generated method stub
		System.out.println("인간형 유닛 생산 건물을 짓습니다.");
	}

	@Override
	public void flyBuilding() {
		// TODO Auto-generated method stub
		System.out.println("건물이 날아서 이동하게 합니다.");
	}

	void doMakeMarine() {
		System.out.println("종쏘는 유닛을 생산합니다.");
	}
}

class Factory extends Building implements Fly {

	@Override
	void doBuild() {
		// TODO Auto-generated method stub
		System.out.println("기갑형 유닛 생산 건물을 짓습니다.");
	}

	void doMakeTank() {
		System.out.println("탱크 유닛을 생산합니다.");
	}

	@Override
	public void flyBuilding() {
		// TODO Auto-generated method stub
		System.out.println("건물이 프로펠러로 날아서 이동하게 됩니다");
	}
}

class Bunker extends Building {

	@Override
	void doBuild() {
		// TODO Auto-generated method stub
		System.out.println("인간형 유닛이 숨을 건물을 짓습니다.");
	}

	void doDefense() {
		System.out.println("숨은 유닛을 적의 공격으로부터 보호합니다.");
	}
}

public class Ex02_Stacraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Barracks barracks = new Barracks();
		barracks.doBuild();
		barracks.doMakeMarine();
		barracks.flyBuilding();
		barracks.downBuilding();
		
		Factory factory =new Factory();
		factory.doBuild();
		factory.doMakeTank();
		factory.flyBuilding();
		factory.downBuilding();
		
		Bunker bunker = new Bunker();
		bunker.doBuild();
		bunker.doDefense();
	
	}

}
