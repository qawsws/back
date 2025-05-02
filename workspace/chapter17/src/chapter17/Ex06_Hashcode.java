package chapter17;

class Car{
	Long id;
	String name;
	@Override
	public int hashCode() {
		return id.intValue();
	}
	@Override
	public String toString() {
		return id.toString();
	}
	@Override
	public boolean equals(Object obj) {
		return id.hashCode() == id.hashCode();
	}
}

public class Ex06_Hashcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		car1.id = 1L;
		Car car2 = new Car();
		car2.id = 1L;
//		hashCode() : 메모리주소를 10진법으로 반환
		System.out.println(car1.hashCode());
//		toString() : 제일 뒤에 16진법 메모리주소를 반환
		System.out.println(car1);
		System.out.println(car2.hashCode());
		System.out.println(car2);
		
		System.out.println(car1 == car2);
		System.out.println(car1.equals(car2));
	}

}











