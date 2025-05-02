package chapter6;

public class Ex01_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if(조건식) {
//			실행할 코드;
//			실행할 코드;
//		}else if(조건식) {
//			실행할 코드;
//		}else {
//			실행할 코드;
//		}
		int money = 500000000;
		if(money >= 3800) {
			System.out.println("택시를 탑니다.");
		}else if(money >= 1500) {
			System.out.println("버스를 탑니다");
		}else if(money >= 1000) {
			System.out.println("전동킥보드를 탑니다.");
		}else {
			System.out.println("걸어갑니다.");
		}
	}

}
