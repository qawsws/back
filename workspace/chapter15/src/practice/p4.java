package practice;

import java.util.Arrays;
import java.util.Scanner;

public class p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] intArr = new int[10];

		System.out.println("정수 10개 입력>>");
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr.length - 1; j++) {
				if (intArr[j] > intArr[j + 1]) {
					int num = intArr[j];
					intArr[j] = intArr[j + 1];
					intArr[j + 1] = num;
				}
				
			}
		}

		System.out.println(Arrays.toString(intArr));
	}

}
