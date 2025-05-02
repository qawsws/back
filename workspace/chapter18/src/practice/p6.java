package practice;

import java.util.Random;
import java.util.Scanner;

public class p6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("가위(1), 바위(2), 보(3), 끝내기(4)>>1");
			int player = sc.nextInt();
			if(player==4) {
				System.out.println("게임을 종료합니다");
				break;
			}
			int computer = (int)(Math.random()*3+1);
			Random r = new Random();
			computer = r.nextInt(2)+1;
			
			int result = player-computer;
			if(result == 0) {
				System.out.println("비겼습니다");
			}else if(result == -2 || result == 1) {
				System.out.println("사용자가 이겼씁니다");
			}else {
				System.out.println("사용자가 졌씁니다");
			}
		}
	}

}
