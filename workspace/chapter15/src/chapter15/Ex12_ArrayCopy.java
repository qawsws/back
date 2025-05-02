package chapter15;

import java.util.Arrays;

public class Ex12_ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = new int[10];
		int[] arr2 = new int[8];
		
//		arr1의 모든 데이터를 3으로 설정
//		Arrays.fill(arr1,3);
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = i+10;
		}
//		arr1의 0번째 데이터 부터 복사하여 arr2의 3번째부터 4개의 데이터를 붙여넣기
		System.arraycopy(arr1,0, arr2, 3,4);
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
//		copyOfRange : arr2의 2번째 부터 5번째 위치까지 복사하여 저장
		int[] arr3 = Arrays.copyOfRange(arr2, 2, 5);
		for(int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
//		배열 복사시 메서드가 필요한 이유
//		배열은 객체이기 때문에 그냥 대입하면 
//		메모리주소만 저장하고 데이터는 둘다 똑같이 사용하게됨
		
//		새로운 배열 생성
		int[] arr4 = {1,2,3,4};
//		배열을 다른 배열에 대입
		int[] arr5 = arr4;
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
//		각각의 배열에 데이터를 변경
		arr4[0] = 1000;
		arr5[3] = 2000;
//		1000,2,3,4
		System.out.println(Arrays.toString(arr4));
//		1,2,3,2000
		System.out.println(Arrays.toString(arr5));
		
//		String의 경우 대입하여도 메모리 주소를 복사하는게 아닌 데이터를 복사
		String a = "a";
		String b = a;
		System.out.println(a);
		System.out.println(b);
		b = "b";
		System.out.println(a);
		System.out.println(b);
		
	}

}










