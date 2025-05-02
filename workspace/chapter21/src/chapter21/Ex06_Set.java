package chapter21;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex06_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set으로 자료형을 설정하면 Set을 상속받는 클래스를 모두 저장할 수 있다.
		Set<String> set = new HashSet<>();
//		실행결과 : orange banana apple
//		중복이 제거되고 저장된 순서가 아닌 다른 순서로 출력
		set.add("orange");
//		hashCode() : 객체를 숫자로 변환하여 반환, orange를 hashCode로 변환하면 -1008851410
//		hashCode가 같으면 중복 데이터로 취급한다.
		System.out.println("orange".hashCode());
		set.add("apple");
//		93029210
		System.out.println("apple".hashCode());
		set.add("apple");
		System.out.println("apple".hashCode());
		set.add("banana");
//		-1396355227
		System.out.println("banana".hashCode());
//		set.get(인덱스) 사용할 수 없음
//		Set의 경우 인덱스가 존재하지 않기 때문에

		System.out.println("객체 수: "+set.size());
//		인덱스를 이용한 출력이 불가능하기 때문에 iterator나 foreach문으로 출력해야함
		for(Iterator<String> itr=set.iterator(); itr.hasNext();) {
			System.out.print(itr.next()+"\t");
		}
		
		System.out.println();
//		remove(데이터) : 인덱스가 없기 때문에 데이터를 기준으로 삭제
		set.remove("banana");
		
		for(String s:set) {
			System.out.print(s + "\t");
		}
		System.out.println();
	}

}








