package chapter21;

import java.util.HashMap;

class Student5 {
	int studno;
	String name;
	String id;
	int grade;
}

public class Ex14_HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map은 키와 value값을 가진 자료구조
//		key : value를 꺼내기위해 사용하는 id, Primay Key의 데이터를 설정하는 경우가 많음
//		value : 데이터, 테이블에 들어있는 데이터를 객체로 만들어 저장
		HashMap<String, String> map = new HashMap<>();
//		put(key, value) : 데이터 추가 메서드
		map.put("홍길동", "010-1234-1443");
		map.put("전우치", "010-4321-1446");
		map.put("손오공", "010-9876-1443");
//		get(key) : value를 출력하는 메서드
		System.out.println("홍길동:" + map.get("홍길동"));
		System.out.println("전우치:" + map.get("전우치"));
		System.out.println("손오공:" + map.get("손오공"));
		System.out.println();
		
//		remove(key) : 해당하는 key를 찾아서 데이터를 삭제
		map.remove("손오공");
//		get실행시 삭제된 데이터는 null을 반환
		System.out.println("손오공 :" + map.get("손오공"));
		
//		PK를 검색해서 데이터를 출력하는 경우가 가장 많기 때문에
//		PK를 기준으로 검색하는 속도를 Map을 사용하면 훨씬 빠르게 검색 가능
//		데이터의 추가 삭제가 빠르다
//		       PK:studno
		HashMap<Integer, Student5> studMap = new HashMap<>(); 
		
	}

}







