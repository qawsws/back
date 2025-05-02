package chapter11;

class Cat{
	static int a = 5;
	int num = 3;
	
	void printValue(int num) {
		this.num = num;
		System.out.println("num:"+this.num);
		System.out.println("a:"+a);
	}
}
public class Ex01_GlobalVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 5;
		int num2 = 2;
		System.out.println(num1 + "," + num2);
		
		Cat cat1 = new Cat();
		cat1.num = 1;
		cat1.a = 10;
		cat1.printValue(20);
		System.out.println(cat1.num);
		System.out.println(cat1.a);
		
		Cat cat2 = new Cat();
		cat2.num = 2;
		cat2.a = 11;
		cat2.printValue(10);
		System.out.println(cat2.num);
		System.out.println(cat2.a);
		
//		static 변수는 모든 인스턴스가 같은 값을 공유한다
//		전역변수: 어떤 곳에서도 사용할 수 있는 변수
		cat2.a=50;
		Cat cat3 = new Cat();
		System.out.println("cat1.a= "+cat1.a);
		System.out.println("cat2.a= "+cat2.a);
		System.out.println("cat3.a= "+cat3.a);
		System.out.println("cat3.a= "+Cat.a);
	}

}
