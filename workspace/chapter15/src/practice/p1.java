package practice;

import java.util.Scanner;

public class p1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("알파벳 한 문자를 입력하세요>>");
		
		String s = sc.next(); // 문자열로 읽음 
		char c = s.charAt(0); // 문자열의 첫 번째 문자 
		
		for (char i = 'a'; i <= c; i++) {  //아스키코드 97~101번
			for (char j = i; j <= c; j++) {       
                System.out.print(j);
            }
            System.out.println();
		}
	}

}
