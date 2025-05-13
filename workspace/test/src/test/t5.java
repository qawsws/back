package test;

import java.util.HashMap;
import java.util.Scanner;

public class t5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나라 이름과 인구를 5개 입력하세요. (예: Korea 5000)");
		
		
		int i = 0;
		while (i < 5) {
			System.out.print("나라이름, 인구 >>");
			 String[] input = sc.nextLine().split(" ");
			map.put(input[0], Integer.parseInt(input[1]));
			i++;
		} 
		String minC = "";
		int mins = Integer.MAX_VALUE;
		for(String key : map.keySet()) {
			int all = map.get(key);
			if(all < mins) {
				mins = all;
				minC = key;
			}
			
		}
		System.out.println("제일 인구가 적은 나라는(" + minC+","+mins+")");
}
}