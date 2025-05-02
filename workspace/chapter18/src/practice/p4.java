package practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		
		StringTokenizer s = new StringTokenizer(a,"+");
		
		int sum = 0;
		int count = s.countTokens();
		for(int i =0; i < count; i++){
			String str = s.nextToken();
			
			str = str.trim();
			System.out.println(str);
			
			int num = Integer.parseInt(str);
			sum += num;
		}
		System.out.println(sum);
		
		
		}
	}


//package practice;
//
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class p4 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Scanner scanner = new Scanner(System.in);
//		String a = scanner.nextLine();
//		
//		StringTokenizer s = new StringTokenizer(a,"+");
//		
//		int sum = 0;
//		int count = s.countTokens();
//		for(int i =0; i < count; i++){
//			String str = s.nextToken();
//			
//			str = str.trim();
//			System.out.println(str);
//			
//			int num = Integer.parseInt(str);
//			sum += num;
//		}
//		System.out.println(sum);
//		
//		
//		}
//	}


