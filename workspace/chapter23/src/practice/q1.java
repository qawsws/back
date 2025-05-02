package practice;

import java.util.Arrays;
import java.util.List;

class Customer {
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getname() {
		return name;
	}

	public int getage() {
		return age;
	}
}

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.아래의 정수리스트에서 양수만 출력하도록 스트림을 작성하자
		List<Integer> numbers = Arrays.asList(-3, -1, 0, 2, 5, -10, 7);
		numbers.stream()		
		.filter(number -> number > 0)
		.forEach(number->System.out.print(number + " "));
		System.out.println();
		// 2. 아래의 리스트에서 문자열의 길이를 출력하는 스트림을 작성하자.
		List<String> strings = Arrays.asList("java", "HTML", "CSS", "JavaScript");
		strings.stream()	
		.map(str ->str.length())
		.forEach(len -> System.out.print(len+ " "));
		System.out.println();
		// 3. 아래의 문장을 공백을 기준으로 나누고 각 단어의 길이를 출력하는 프로그램을 작성하자
		String sentence = "The quick Brown Fox";
		
		String[] strgg = sentence.split(" ");
		Arrays.stream(strgg)
		.map(str1 -> str1.length())
		.forEach(len -> System.out.print(len+" "));
		System.out.println();
		// 4. 고객 정보가 담긴 리스트가 있습니다. 각 고객은 이름(String)과 나이(int)를 
//		갖고 있습니다. 다음 조건에 따라 고객 이름 목록을 출력하는 프로그램을 작성하세요.
//		고객 중 20세 이상인 사람들만 필터링합니다.
//		이름을 알파벳 순으로 정렬합니다.
//		이름을 대문자로 변환하여 출력합니다.
		List<Customer> customers = Arrays.asList(
			    new Customer("alice", 22),
			    new Customer("bob", 17),
			    new Customer("charlie", 25),
			    new Customer("david", 19),
			    new Customer("eve", 30));
		
			    customers.stream()
			    .filter(a -> a.getage() > 20)
			    .map(a -> a.getname().toUpperCase())
			    .sorted() 
			    .forEach(result -> System.out.println(result));
	

	}
}









//
//package practice;
//
//import java.util.Arrays;
//import java.util.List;
//
//class Customer {
//    private String name;
//    private int age;
//    
//    public Customer(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    public String getName() {
//    	return name;
//    }
//    public int getAge() {
//    	return age;
//    }
//}
//
//public class Q1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		// 1.아래의 정수리스트에서 양수만 출력하도록 스트림을 작성하자
//		List<Integer> numbers = Arrays.asList(-3, -1, 0, 2, 5, -10, 7);
//		numbers.stream()
//		.filter(n -> n>0) // 2,5,7
//		.forEach(n -> System.out.print(n+" "));
//		
//		System.out.println();
//		
//		// 2. 아래의 리스트에서 문자열의 길이를 출력하는 스트림을 작성하자.
//		List<String> strings = Arrays.asList("java", "HTML","CSS","JavaScript");
//		strings.stream()
//		.forEach(s -> System.out.print(s.length()+" "));
//		
//		System.out.println();
//		
//		// 3. 아래의 문장을 공백을 기준으로 나누고 각 단어의 길이를 출력하는 프로그램을 작성하자
//		String sentence = "The quick Brown Fox";
//		String[] stringArr = sentence.split(" ");
//		Arrays.stream(stringArr)
//		.forEach(s -> System.out.print(s.length()+" "));
//		
//		System.out.println();
//		// 4. 고객 정보가 담긴 리스트가 있습니다. 각 고객은 이름(String)과 나이(int)를 
////		갖고 있습니다. 다음 조건에 따라 고객 이름 목록을 출력하는 프로그램을 작성하세요.
////		고객 중 20세 이상인 사람들만 필터링합니다.
////		이름을 알파벳 순으로 정렬합니다.
////		이름을 대문자로 변환하여 출력합니다.
//		List<Customer> customers = Arrays.asList(
//				new Customer("charlie", 25),
//				new Customer("eve", 30),
//			    new Customer("bob", 17),
//			    new Customer("david", 19),
//			    new Customer("alice", 22)
//			);
//		customers.stream()
////		20살 이상인 데이터를 필터링
//		.filter(n -> n.getAge()>=20)
////		이름을 기준으로 정렬
//		.sorted((s1,s2)->s1.getName().compareTo(s2.getName()))
////		이름을 대문자로 설정
//		.map(n -> n.getName().toUpperCase())
////		출력
//		.forEach(n->System.out.print(n+" "));
//		
//		System.out.println();
//		
//		customers.stream()
////		20살 이상인 데이터를 필터링
//		.filter(n -> n.getAge()>=20)
////		이름을 대문자로 설정
//		.map(n -> n.getName().toUpperCase())
////		이름을 기준으로 정렬
//		.sorted()
////		출력
//		.forEach(n->System.out.print(n+" "));
//	}
//
//}
//
//
//
//



