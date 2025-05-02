package chapter11;

import java.util.Random;

public class Ex02_Preload {
//	static은 프로그램 실행시 모두 로드되기 때문에
//	main보다 먼저 실행됨
	static int num;
	static {
		Random rand = new Random();
		num = rand.nextInt(100);
	}
//	static 사용시의 단점
//	1. 프로그램이 켜질때 시간이 오래걸림
//	2. 스태틱영역의 메모리는 프로그램이 꺼질때까지 지워지지 않기 때문에
//	메모리 사용이 비효율적
//	3. 객체지향 프로그래밍 원칙에 위배된다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(num);
	}

}
