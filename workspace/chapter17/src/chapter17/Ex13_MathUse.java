package chapter17;

public class Ex13_MathUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("4의 제곱근 : " + Math.sqrt(4));
		System.out.println("log2(8) : " + baseLog(8,2));
		System.out.println("2의 3승 : " + Math.pow(2,3));
		System.out.println();
		
		System.out.println("원주율: " + 	Math.PI);
		System.out.println("파이에 대한 Degree: " +Math.toDegrees(Math.PI));
		System.out.println("2파이에 대한 Degree :" + Math.toDegrees(Math.PI));
		System.out.println();
		
		double radius45 = Math.toRadians(45);
		
		System.out.println("싸인 45: " + Math.sin(radius45));
		System.out.println("코싸인 45: " + Math.cos(radius45));
		System.out.println("탄젠트 45: " + Math.tan(radius45));
		
	}
	public static double baseLog(double x, double base) {
		return Math.log(x) / Math.log(base);
	}

}
