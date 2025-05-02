package chapter21;

import java.util.HashSet;

class Student{
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + ":" + age;
	}
	
//	@Override
//	public int hashCode() {
//		int num = age%3;
//		System.out.println(num);
//		return num;
//	}
	
	@Override
	public int hashCode() {
//		java.util.Objects.hash(가변인수) : 가변인수를 기준으로 HashCode를 생성
		int num = java.util.Objects.hash(name, age);
		System.out.println(num);
		return num;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("비교를 합니다.");
		if(obj.hashCode() == this.hashCode()) {
//		if(age == ((Student)obj).age){
			return true;
		}else {
			return false;
		}
	}
}

public class Ex07_HashSetEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Student> set = new HashSet<>();
//		equals를 오버라이드 하여 나이를 같으면 같은데이터 나이가 다르면 다른데이터로 설정
		set.add(new Student("홍길동",20));
//		나이가 같기때문에 전우치는 저장되지 않음
		set.add(new Student("전우치",20));
//		나이가 다르기 때문에 저장함
		set.add(new Student("홍길동",25));
		System.out.println("객체 수: "+set.size());
		for(Student s : set) {
			System.out.print(s.toString() + "\t");
		}
		System.out.println();
		
	}

}









