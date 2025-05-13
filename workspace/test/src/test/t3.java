package test;

import java.util.HashMap;
import java.util.Scanner;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer>map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("<<통장 관리 프로그램입니다.>>");
		
		while(true) {
			System.out.print("이름과 금액입력>>");
			String str = sc.nextLine();
			
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			
			 String[] parts = str.split(" ");
	         String name = parts[0];
	         int amount = Integer.parseInt(parts[1]);
	            
			
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + amount);
            } else {
            	map.put(name, amount);
            }

            for (String key : map.keySet()) {
                System.out.print("(" + key + ">" + map.get(key) + "원)");
            }
            System.out.println(); 
        }

		}
		
	}


