package ifpractice1;

import java.util.Scanner;

public class q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("커피 주문하세요>>");	
		String coffee = sc.next();
        int cup = sc.nextInt();
        
        int price = 0;
        
        if(coffee.equals("에스프레소")) {
        	price = 2000;
        } else if (coffee.equals("아메리카노")) {
            price = 2500;
        } else if (coffee.equals("카푸치노")) {
            price = 3000;
        } else if (coffee.equals("카페라떼")) {
            price = 3500;
        } else {
            System.out.println("메뉴에 없는 음료입니다.");
            return;
        }
            System.out.println((price*cup) + "원입니다.");
	

	}
}

//Scanner sc = new Scanner(System.in);
//System.out.print("커피 주문하세요>>");
//String coffee = sc.next();
//int count = sc.nextInt();
//String str = "원 입니다.";
////(1) if문을 활용하라.
//if(coffee.equals("에스프레소")) {
//	System.out.println((count*2000)+str);
//}else if(coffee.equals("아메리카노")) {
//	System.out.println((count*2500)+str);
//}else if(coffee.equals("카푸치노")) {
//	System.out.println((count*3000)+str);
//}else if(coffee.equals("카페라떼")) {
//	System.out.println((count*3500)+str);
//}else {
//	System.out.println("에스프레서,아메리카노,카푸치노,카페라떼 중에 선택해주세요.");
//}
////(2) switch문을 활용하라. 
//switch(coffee) {
//case "에스프레소":
//	System.out.println((count*2000)+str);
//	break;
//case "아메리카노":
//	System.out.println((count*2500)+str);
//	break;
//case "카푸치노":
//	System.out.println((count*3000)+str);
//	break;
//case "카페라떼":
//	System.out.println((count*3500)+str);
//	break;
//default : 
//	System.out.println("에스프레서,아메리카노,카푸치노,카페라떼 중에 선택해주세요.");
//}
//
//}
//
//}
