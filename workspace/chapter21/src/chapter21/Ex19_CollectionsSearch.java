package chapter21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex19_CollectionsSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("전우치");
		list.add("손오공");
		Collections.sort(list);
		System.out.println(list);
		int idx1 = Collections.binarySearch(list, "손오공");
		System.out.println("손오공의 인덱스값: " + idx1);
		int idx2 = Collections.binarySearch(list, "멀린");
		System.out.println("멀린 데이터가 없을 경우: " + idx2);
		
		Map<String,Integer> map = new HashMap<>();
		map.put("홍길동",1);
		map.put("전우치",2);
		map.put("손오공",3);
		System.out.println(map.get("홍길동"));
		
	}

}








