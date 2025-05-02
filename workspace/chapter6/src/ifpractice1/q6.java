package ifpractice1;

import java.util.Scanner;

public class q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("돈의 액수를 입력하세요>>");	
		int money = sc.nextInt();
		int a = money/50000;
		int a1 = money%50000;
		
		int b = a1/10000;
		int b1 =a1%10000;
		
		int c = b1/1000;
		int c1 = b1%1000;
		
		int d = c1/500;
		int d1 = c1%500;
		
		int e = d1/100;
		int e1 = d1%100;
		
		int f = e1/10;
		int f1 = e1%10;
		
		int g = f1/1;
		
		System.out.println("오만원"+a+"개");
		System.out.println("만원"+b+"개");
		System.out.println("천원"+c+"개");
		System.out.println("500원"+d+"개");
		System.out.println("100원"+e+"개");
		System.out.println("10원"+f+"개");
		System.out.println("1원"+g+"개");
		}

}
