package chapter11;

public class Ex03_Utilmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalculator calc1 = new MyCalculator();
		int num1 = calc1.adder(1,2);
		System.out.println(num1);
		
//		자주 사용하는 기능의 경우 static으로 작성하여 빠르게 처리할 수 있음
		int num2 = MyCalculator.adder(2,3);
//		system이 대표적인 static 사용방식
		System.out.println(num2);
//		math도 static으로 사용
		System.out.println(Math.random());
	}

}
