package chapter24;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex09_FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Reader in = new FileReader("text.txt")){
			int ch;
			while(true) {
//				파일의 텍스트를 한글자씩 저장
				ch = in.read();
//				-1은 글자가 없을때 출력되는 값
				if(ch == -1) {
					break;
				}
//				읽은 글자를 출력하는 부분
				System.out.print((char)ch);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}







