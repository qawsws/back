package practice1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. 1~100까지의 숫자중 3의 배수를 리스트에 저장하라
		List<Integer> numList = new LinkedList<Integer>();
//		int[] numArr = new int[1000];
		for(int i=3; i<=100; i+=3) {
//			오토 박싱 : int를 integer로 변환
			numList.add(i);
//			오토 언박싱 : Integer를 int로 변환
			int a = numList.get(0);
		}
		for(Integer i: numList) {
			System.out.print(i+" ");
		}
		System.out.println();
//		2. 1900년도 부터 2025년 까지의 윤년을 리스트에 저장하라
		List<Integer> yearList = new ArrayList<>();
		for(int i=1900; i<=2025; i++) {
			if(i%400==0 || (i%100!=0 && i%4==0)) {
				yearList.add(i);
			}
		}
		for(Integer i: yearList) {
			System.out.print(i+" ");
		}
	}

}








