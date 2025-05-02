package chapter24;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex10_BufferedWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "1동해물과 백두산이 마르고 닭도록";
		String str2 = "23하느님이 보우하사 우리나라 만세";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("text2.txt"))){
//			str1의 0번부터 글자수만큼 저장
			bw.write(str1, 0, str1.length());
			bw.newLine();// 엔터 저장
			bw.write(str2, 0 , str2.length());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}




