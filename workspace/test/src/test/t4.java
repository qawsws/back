package test;

import java.util.HashMap;
import java.util.Scanner;


public class t4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("밀키스", 700);
		map.put("코카콜라", 800);
		map.put("펩시", 1000);
		map.put("칠성사이다", 1200);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("밀키스,코카콜라,펩시,칠성사이다 있습니다.");
		while (true) {
			System.out.print("선택 >>");
			String str = sc.nextLine();
		
			
			if(str.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}else if(map.containsKey(str)) {
				System.out.println(str+"는"+map.get(str)+"원 입니다");
			}
				
			}
				
		}
		}
	


