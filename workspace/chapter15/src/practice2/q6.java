package practice2;

import java.util.Arrays;

public class q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		6. 배열을 사용하여 다음의 숫자를 정렬하라. 정렬방법은 선택정렬, 삽입정렬, 버블정렬을 수행하라.
//		 15, 7, 2, 9, 10, 12, 17, 11, 20, 5
//		선택정렬
//		int[] a = {5,3,8,1,2,7};
//		int tempValue, tempJ = 0;
//		for(int i=0; i< a.length; i++) {
////			MAX_VALUE상수 : int에 저장할 수 있는 가장 큰값 2147483647
//			//임시로 가장 큰값을 저장하고 
//			//첫번째 반복 이후에는 배열에서 가장 작은값이 저장됨
//			int min = Integer.MAX_VALUE;
////			j~i까지 반복
//			for(int j=i; j< a.length; j++) {
////				a[j]가 min에 있는 값보다 작으면 
//				if(a[j] < min) {
////					min에 a[j]를 저장
//					min = a[j];
////					tempJ에 가장 작은값이 있는 배열의 위치값(인덱스)을 저장
//					tempJ = j;
//				}
//			}
////			반복시작될때의 값을 tempValue에 저장
//			tempValue = a[i];
////			반복이시작될때의 배열에 가장 작은값을 저장
//			a[i] = a[tempJ];
////			가장 작은값이 있던 배열에 반복이 시작될때의 값을 저장
//			a[tempJ] = tempValue;
//		}
//		System.out.println(Arrays.toString(a));
		
		// 삽입정렬
		int[] a = {5,3,8,1,2,7};
		int target, tempValue = 0;
		for(int i=1; i<a.length; i++) {
			tempValue = a[i];
			target = i-1; 
			while(target >= 0 && a[target] > tempValue) {
				a[target+1] = a[target];
				target--;
			}
			a[target+1]=tempValue;
		}
		System.out.println(Arrays.toString(a));
		
	}

}






