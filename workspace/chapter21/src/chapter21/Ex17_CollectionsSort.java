package chapter21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLength implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
}

public class Ex17_CollectionsSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("홍길동","전우치","손오공","멀린");
		list = new ArrayList<>(list);
		
		System.out.println(list);
		
//		리스트 정렬
//		sort(리스트변수) : 오름차순 정렬,직접만든 클래스는 Comparable을 상속받아야 사용가능
		Collections.sort(list);
		System.out.println(list);
		
//		sort(리스트변수, Collections.reverseOrder()) : 내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
//		sort(리스트변수, 직접만든 Comparator클래스): 정렬방식을 직접 설정
		Collections.sort(list, new StringLength());
		System.out.println(list);
		
		
//		sort(리스트변수,람다식으로 만든 Comparator클래스) : 정렬방식을 직접 설정
		Collections.sort(list, (a,b) -> b.length()-a.length());
		System.out.println(list);
	}

}









