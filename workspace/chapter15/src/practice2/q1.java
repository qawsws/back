package practice2;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] intArr = new int[10];
		
		System.out.println("돈의 액수를 입력하세요>>");	
		for(int i=0; i <intArr.length; i++) {
			intArr[i] = sc.nextInt();
			int a = intArr[i]/50000;
			int a1 = intArr[i]%50000;
			
			int b = a1/10000;
			int b1 =a1%10000;

			int c = b1/5000;
			int c1 =b1%5000;
			
			int d = c1/1000;
			int d1 = c1%1000;
			
			int e = d1/500;
			int e1 = d1%500;
			
			int f = e1/100;
			int f1 = e1%100;

			int g = f1/50;
			int g1 = f1%50;
			
			int h = g1/10;
			int h1 = g1%10;
			
			int k = h1/1;
			
			System.out.println("50000원"+a+"개");
			System.out.println("10000원"+b+"개");
			System.out.println("5000원"+c+"개");
			System.out.println("1000원"+d+"개");
			System.out.println("500원"+e+"개");
			System.out.println("100원"+f+"개");
			System.out.println("50원"+g+"개");
			System.out.println("10원"+h+"개");
			System.out.println("1원"+i+"개");
			}

	}

		
	}

//package practice2;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Q1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		1. 지불할 금액을 정수로 입력 받아 화폐단위가 각각 몇 개씩 필요한지 출력하는 프로그램을 작성하시
////		오. 입력은 최소 10만원 단위로 입력, 화폐단위는 50000, 10000, 5000, 1000, 500, 100, 50, 10,  5, 1 
////		10 가지이며, 가능한 큰 화폐단위로 지불, 입력이 236873이면 50000원권 4매, 10000원권 3매, 5000원권 1
////		매, 1000원권 1매, 500원 1매, 100원권 3매, 50원권 1매, 10원권 2매, 5원권 0매, 1원권 3개로 출력하라.
////		단 화폐단위는 배열에 저장한다
//		Scanner sc = new Scanner(System.in);
//		System.out.print("금액을 입력해주세요>>");
//		int money = sc.nextInt();
//		int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10,  5, 1};
//		int[] result = new int[10];
//		for(int i=0; i<moneyType.length; i++) {
//			result[i] = money/moneyType[i]; // 1
//			money = money%moneyType[i];
//		}
//		System.out.println(Arrays.toString(result));
//		for(int i=0; i<result.length; i++) {
//			System.out.print(moneyType[i]+"원권 "+result[i]+"매, ");
//		}
//		
//	}
//
//}





