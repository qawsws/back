package chapter21;

import java.util.Set;
import java.util.TreeSet;

public class Ex08_TreeSet {
	public static void main(String [] args) {
		Set<String> tree = new TreeSet<>();
//		문자 : ㄱ~ㅎ
//		숫자 : 0~99999
		tree.add("홍길동");
		tree.add("전우치");
		tree.add("손오공");
		tree.add("멀린");
		tree.add("홍길동");
		tree.add("가");
		tree.add("나");
		tree.add("다");
		tree.add("1");
		tree.add("10");
		tree.add("apple");
		tree.add("orange");
		
		for(String t : tree) {
			System.out.print(t+"\t");
		}
		System.out.println();
		
		Set<Integer> tree2 = new TreeSet<>();
		tree2.add(6);
		tree2.add(2);
		tree2.add(7);
		tree2.add(1);
		tree2.add(4);
		tree2.add(8);
		tree2.add(3);
		tree2.add(5);
		for(int t : tree2) {
			System.out.print(t+"\t");
		}
		System.out.println();
	}
}









