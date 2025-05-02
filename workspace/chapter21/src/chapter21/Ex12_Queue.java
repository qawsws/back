package chapter21;

import java.util.LinkedList;
import java.util.Queue;

public class Ex12_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Queue 자료구조 선언
		Queue<String> que = new LinkedList<>();
//		offer() : 데이터 추가 메서드
		que.offer("A");
		que.offer("B");
		que.offer("C");
//		size() : 저장된 데이터 개수 출력
		System.out.println(que.size()); // 3
//		que.peek() : 데이터를 출력
		System.out.println("next :"+que.peek());
//		que.poll() : 데이터를 출력한 후 삭제
		System.out.println(que.poll());
		System.out.println(que.size()); // 2
		
		System.out.println("next :"+que.peek());
		System.out.println(que.poll());
		System.out.println(que.size());
		
		System.out.println("next :"+que.peek());
		System.out.println(que.poll());
		System.out.println(que.size());
		
		
	}

}












