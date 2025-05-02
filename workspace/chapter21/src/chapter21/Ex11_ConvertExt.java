package chapter21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Ex11_ConvertExt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Arrays.asList 변경할 수 없는 리스트 생성
		List<String> fixedSizeList = Arrays.asList("홍길동","전우치","전우치","손오공");
//		변경가능한 list생성
		ArrayList<String> list = new ArrayList<>(fixedSizeList);
//		리스트 안에
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
//		list를 hashset으로 변경하여 중복 데이터를 제거
		HashSet<String> set = new HashSet<>(list);
		
		list = new ArrayList<>(set);
		
		for(String s : list)
			System.out.print(s.toString() + '\t');
		System.out.println();
	}

}
