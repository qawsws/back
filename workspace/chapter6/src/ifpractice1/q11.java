package ifpractice1;

import java.util.Scanner;

public class q11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		가위바위보 게임 만들기
		Scanner sc = new Scanner(System.in);
		System.out.println("가위, 바위, 보 중에 입력해주세요>>");
		String player = sc.next();
//		0~2 사이의 랜덤 숫자를 저장
		int computer = (int)(Math.random()*3);
		int playernum = 0;
		if(player.equals("가위")){
			playernum = 0;
		}else if(player.equals("바위")) {
			playernum = 1;
		}else if(player.equals("보")){
			playernum = 2;
		} 
		
		
		if (playernum == computer) {
            System.out.println("비겼습니다");
        } else if (playernum==0 && computer == 2 
        		||playernum==1 && computer == 0
        		||playernum==2 && computer ==1 ) {
            System.out.println("이겼습니다");
        } else {
            System.out.println("졌습니다");
        }
	}
}
	
