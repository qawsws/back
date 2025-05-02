package chapter15;

import java.util.Arrays;

public class Ex13_ArrayEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
//		equals : 데이터가 같은지 확인하는 메서드
//		배열의 경우 배열의 길이 및 데이터가 같은지 확인
		boolean bCheck = Arrays.equals(arr1, arr2);
		System.out.println(bCheck);
		
		int[] arr3 = {1,2,3,4,5};
		int[] arr4 = {1,2,3,4,5};
		bCheck = Arrays.equals(arr1, arr2);
		System.out.println(bCheck);
//		==으로 비교하며 메모리 주소를 비교하기 떄문에 false가  출력됨
//		메모리주소 비교
//		equals 데이터와 길이 비교
		System.out.println(arr3 == arr4);
	}

}
