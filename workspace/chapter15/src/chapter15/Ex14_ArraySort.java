package chapter15;

import java.util.Arrays;
import java.util.Collections;

public class Ex14_ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1 = {1,3,2,4};
		Double[] arr2 = {4.4, 3.3, 2.2, 1.1};
		String[] arr3 = {"홍길동","전우치","손오공","멀린"};
//		int배열의 경우 오름차순밖에 실행할 수 없음
//		integer배열의 경우 오름차순, 내림차순 둘다 사용 가능
		
		Arrays.sort(arr1, Collections.reverseOrder());
//		double은 내림차순 불가, Double은 내림차순 가능
		Arrays.sort(arr2, Collections.reverseOrder());
		Arrays.sort(arr3, Collections.reverseOrder());
		
		for(int n : arr1)
			System.out.print(n + "\t");
		System.out.println();
		
		for(double d : arr2)
			System.out.print(d + "\t");
		System.out.println();
		
		for(String s : arr3)
			System.out.print (s + "\t");
		System.out.println();
	}

}
