package testt;

import java.util.Random;
import java.util.Scanner;

public class o1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int random = (int)(Math.random() * 100) +1;
		int num = 0;
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===숫자맞축기 게임을 시작합니다.===");
		System.out.println("컴퓨터가 숫자를 생각했습니다.");
		if(random%2==1) {
			System.out.println("힌트는 홀수입니다.");
		}else {
			System.out.println("힌트는 짝수입니다.");
		}
		
		while(true) {
		System.out.print("1~100 사이의 값을 입력 >>");
		num = sc.nextInt();
		count++;
		
		if(num < random) {
			System.out.println("더 큰 수입니다.");
		}else if(num > random) {
			System.out.println("더 작은 수입니다.");
		}else {
			System.out.println(count+"회 만에 맞췄습니다.");
			 break;
		}
	}

		System.out.println("===게임을 종료합니다.===");
				
	}

}
