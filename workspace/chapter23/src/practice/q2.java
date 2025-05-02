package practice;

import java.util.Arrays;
import java.util.List;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.리스트의 숫자 합계 출력하기 결과값 : 15
		List<Integer> number = Arrays.asList(1,2,3,4,5);
		Integer sum = number.stream()
				.reduce(0,(a,b)-> a+b);
		System.out.println(sum);
		
		//2. 문자열 연결해서 출력하기, 결과 :JavaStreamApi
		String[] strArr = {"Java","Stream","Api"};
		String sum2 = Arrays.stream(strArr)
                .reduce("", (a,b)-> a+b);  
        System.out.println(sum2);  
		//3.리스트의 숫자를 모두 곱한 값 출력하기, 결과 : 750
		List<Integer> numList = Arrays.asList(5,10,15);
		Integer sum3 = numList.stream()
				.reduce(1,(a,b)-> a*b);
		System.out.println(sum3);
	}

}
