//자바 빈즈 규약
//1. 꼭 패키지 안에 생성 해야한다
package common;

public class Person {
//  2.변수 설정시 반드시 private으로 설정
	private String name;
	private int age;
//	3. 기본 생성자를 반드시 작성한다.
	public Person() {}
	public Person(String  name,int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
//	4.멤버변수의 getter/setter를 반드시 작성한다.
//	5.Getter/Setter는 public으로 설정한다.
//	실수하지 않도록 자동완성으로 작성할것 : source탭에서 Generate Getter and Setter 기능
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
