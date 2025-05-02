package chapter23;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex01_Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		스트림에 사용할 배열 선언
		int[] arr = {1,2,3,4,5};
//		스트림 생성
		IntStream stm1 = Arrays.stream(arr);
//		중간연산중 하나인 filter를 실행
//		filter(매개변수->조건식) : 조건식에서 true가 나오는 데이터만 스트림에 저장
//		filter는 중간 연산이기 때문에 데이터 저장 후 스트림을 반환
//		1,3,5 가 저장되어있는 스트림이 생성됨
		IntStream stm2 = stm1.filter(n -> n%2 ==1);
//		최종연산 : 메서드에 맞는 결과값을 출력
//		sum() : 스트림안에 있는 데이터를 모두 더하여 총합을 출력
		int sum = stm2.sum();
		System.out.println(sum);
		
//		파이프라인 : .을 이용하여 메서드의 실행을 계속해서 하는 방식
		int sum2 =  Arrays.stream(arr) //intStream에 1,2,3,4,5
				.filter(n -> n%2 ==1) //intStream에 1,3,5
				.sum();  // 1+3+5 = 9
		System.out.println("파이프라인으로 실행한 결과: "+sum2);
	}

}
