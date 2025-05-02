package chapter21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex15_HashMapKeySet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("홍길동", 20);
		map.put("전우치", 25);
		map.put("손오공", 27);
		
//		keySet() : Map에 들어있는 모든 key를 Set자료구조로 출력하는 메서드
		Set<String> ks = map.keySet();
		
//		keySet은 Set자료구조로 만들었기 때문에 인덱스는 사용할 수 없음
		for(String s : map.keySet()) {
			System.out.print(s + ":");
			System.out.print(map.get(s).toString() + "\t");
		}
		System.out.println();
		
		for(Iterator<String> itr=ks.iterator(); itr.hasNext();) {
			System.out.print(map.get(itr.next()).toString()+"\t");
		}
		System.out.println();
		
	}

}










