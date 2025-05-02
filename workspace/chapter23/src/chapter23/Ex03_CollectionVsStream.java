package chapter23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex03_CollectionVsStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,3,2,4};
//		ArrayList 컬렉션을 이용하여 저장할 공간을 생성
		List<Integer> list = new ArrayList<>();
//		list에 홀수만 저장하는 반복문
		for(int i : arr) {
			if(i%2 == 1) {
				list.add(i);
			}
		}
//		list 데이터를 오름차순으로 정렬
		Collections.sort(list);
//		list 데이터를 출력
		for(int i:list) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		//Stream을 이용하는 방식
		Arrays.stream(arr)	//stream생성
		.filter(n->n%2==1) // 홀수만 저장하는 반복문을 filter로 실행 : 중간연산
		.sorted() // list데이터를 오름차순으로 정렬 sorted()로 실행 : 중간연산
		.forEach(n->System.out.print(n+"\t")); // list 데이터를 출력
		System.out.println();
	}

}








