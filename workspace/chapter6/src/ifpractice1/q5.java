package ifpractice1;

import java.util.Scanner;

public class q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("논리 연산을 입력하세요>>true or false");
		
		boolean a = sc.nextBoolean();  
		String op = sc.next();   
		boolean b = sc.nextBoolean();
		switch(op){	
		case "AND":
			System.out.println(a&&b); //
			break;
		case "or":
			System.out.println(a||b);
			break;
		}
	
	}

}
