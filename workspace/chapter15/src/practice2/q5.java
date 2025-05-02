package practice2;

import java.util.Random;

public class q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArr = new int[10];
		
		for(int i = 0 ; i < 10; i++) {
			int random = (int) (Math.random()*100) + 1;
			intArr[i] = random;
			
			if(random % 3 == 0) {
			System.out.println(random);
			
			}
		}
	}
}




//package practice2;
//
//import java.util.Arrays;
//
//public class Q5 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		 5. 크기가 10인 배열을 작성하고 Math.random()함수를 사용하여 1~100사이의 숫자를 랜덤하게 생성하
////		 고 생성된 숫자가 3의 배수인 것만 배열에 저장하는 프로그램을 작성하라. (단 배열의 각 요소는 서로 
////		 다른 값만 저장되도록 한다.) 
//		int[] intArr = new int[10];
//		int count = 0;
//		while(count<10) {
//			int randomValue = (int)(Math.random()*100)+1;
//			
//			if(randomValue%3 != 0) {
//				continue;
//			}
//			
//			boolean flag = false;
//			for(int i=0; i<intArr.length; i++) {
//				if(randomValue == intArr[i]) {
//					flag = true;
//					break;
//				}
//			}
//			if(!flag) {
//				intArr[count] = randomValue;
//				count++;
//			}
//		}
//		System.out.println(Arrays.toString(intArr));
		
		
//		int[] intArr = new int[10];
//		for(int i=0; i<intArr.length; i++) {
//			int randomValue = (int) ((Math.random()*100+1));
//			if(randomValue%3==0) {
////				중복값을 확인하는 boolean 변수
//				boolean flag = false;
//				for(int j=0; j<=i; j++) {
//					if(randomValue == intArr[j]) {
//						flag = true;
//					}
//				}
////				중복이 없는 경우 randomValue를 저장
//				if(!flag) {
//					intArr[i] = randomValue;
//				}else {
//					i--;
//				}
//				
//			}else {
//				i--;
//			}
//		}
//		System.out.println(Arrays.toString(intArr));
	//}

//}













