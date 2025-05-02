package chapter21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex04_Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sArr = {"홍길동","전우치","손오공","전우치"};
//		Arrays.asList 만든 ArrayList는 변경할 수 없음, 데이터 추가나 삭제가 안된다
		List<String> list = Arrays.asList("홍길동","전우치","손오공","전우치");
//		list.add("해리포터"); // asList만든 리스트는 변경이 불가능해 에러 발생
		list = new ArrayList<>(list);
		list.add("해리포터");
		
//				초기값                                   조건식            증감식 생략
		for(Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
			System.out.println(itr.next()+"\t");
		}
		System.out.println();
		
		list = new LinkedList<>(list);
		
		for(String s : list) {
			System.out.println(s+"\t");
		}
		System.out.println();
		
	}

}
