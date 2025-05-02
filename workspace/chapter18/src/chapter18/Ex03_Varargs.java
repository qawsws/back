package chapter18;

public class Ex03_Varargs {
//									String 가변 인수 설정
	public static void helloEverybody(String... vargs) {
		// TODO Auto-generated method stub
		for (String s : vargs)
			System.out.print(s + '\t');
		System.out.println();
	}

	public static void main(String[] args)
	{
		helloEverybody("홍길동");
		helloEverybody("홍길동","전우치");
		helloEverybody("홍길동","전우치","손오공");
	}
}
