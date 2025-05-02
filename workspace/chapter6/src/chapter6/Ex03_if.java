package chapter6;

public class Ex03_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		switch(변수) {
//			case 비교값 :
//				실행할 코드;
//				break;
//			case 비교값 :
//				실행할 코드;
//				break;
//			default : 
//				실행할 코드;
//		}
		
		int n=4;
		switch(n%3) {
		case 1:
			System.out.println("나머지가 1");
			break;
		case 2:
			System.out.println("나머지가 2");
			break;
		default :
			System.out.println("나머지가 0");
		
		}

//		banana, apple, totato, mango, melon, carrot
//		위의 과일과 야채 중에 banana,apple,mango,melon이라면 과일이라고 출력
//		totato, carrot이라면 야채라고 출력해보자
		
		String f = "totato";
		switch(f) {
		case "banana":
		case "apple":
		case "mango":
		case "melon":
			System.out.println("과일");
			break;
		case "totato":
		case "carrot":
			System.out.println("야채");
			break;
		default :
			System.out.println("없음");
		}
		
		
		
//		월별 날짜 출력하기
//		1,3,5,7,8,10,12 월은 31일
//		4,6,9,11 월은 30일
//		2 월은 28일
//		을 출력하는 switch문을 작성해보자
		int month = 10;
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31일입니다");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30일입니다");
			break;
		default :
			System.out.println("28일입니다");
				
		}
	}

}
