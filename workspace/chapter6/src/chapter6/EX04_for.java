package chapter6;

public class EX04_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for : 반복문, 정해져있는 횟수만큼 반복할때 사용하는 반복문
//		     1      2     4      
//		for(초기값; 조건식; 증감식;) {
//		      3
//			실행할 코드;
//		}
//		int total = 0;
//		for(int i = 1; i<=10; i++) {
//			System.out.println(i+"번 실행했습니다.");
//			total = total + i;
////			total+=i;
//		}
//		System.out.println("1~10까지 모두 더한 값은 "+total+"입니다");
		
//		for문을 이용하여 5단 출력하기
		int dan = 5;
		for(int i = 1; i<=9; i++) {
			System.out.println(dan + "*"+i+"="+(dan*i));
		}
//		5단의 i가 짝수인 값만 출력하기
//		if문으로 확인하기 때문에 반복횟수가 9회
		for(int i = 1; i<=9; i++) {
			if(i%2==0)
			System.out.println(dan + "*"+i+"="+(dan*i));
		}
//		증감식에 2씩 더하기 때문에 반복횟수가 4회
		for(int i = 1; i<=9; i=i+2) {
			System.out.println(dan + "*"+i+"="+(dan*i));
		}
//		2~9단까지 출력하기 다시알아복기	
		for(int i = 2; i <= 9; i++) {
			for(int j =1; j<=9; j++) {
				if(j>5) {
					break;
				}
				if(j%3==0) {
					continue;
				}
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
	}

}
