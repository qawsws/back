package chapter24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_FileWrite3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try-with-resource문 : try(close() 해야하는 클래스를 선언)
//		try문을 사용할때 close()를 자동으로 실행해 주는 기능
		try(OutputStream out = new FileOutputStream("data.txt");){
			out.write(151);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}









