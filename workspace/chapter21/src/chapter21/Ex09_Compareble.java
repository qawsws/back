package chapter21;

import java.util.Set;
import java.util.TreeSet;

class Student3 implements Comparable<Student3>{
	private String name;
	private int age;
	public Student3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + "," + age;
	}
	@Override
	public int compareTo(Student3 o) {
//		return this.age - o.age; //나이 오름차순 정렬
//		return o.age - this.age; //나이 내림차순 정렬
//		return this.name.compareTo(o.name); // 이름 오름차순 정렬
		return o.name.compareTo(this.name); // 이름 오름차순 정렬
	}
	
	
}

public class Ex09_Compareble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student3> tree = new TreeSet<>();
		tree.add(new Student3("홍길동",30));
		tree.add(new Student3("전우치",40));
		tree.add(new Student3("손오공",20));
		for(Student3 s : tree) {
			System.out.println(s);
		}
	}

}










