package practice;

interface AdderInterface {
	int add(int x, int y);

	int add(int n);
}

class MyAdder implements AdderInterface {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub

		return x + y;
	}

	@Override
	public int add(int n) {
		// TODO Auto-generated method stub
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}
}

public class MyAdderUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyAdder adder = new MyAdder();
		System.out.println(adder.add(5, 10));
		System.out.println(adder.add(10));
	}

}
