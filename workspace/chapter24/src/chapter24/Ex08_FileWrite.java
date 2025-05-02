package chapter24;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex08_FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Writer out = new FileWriter("text.txt")){
//			대문자 알파벳을 int로 저장하면 알파벳이 저장됨
			for(int ch=(int)'A'; ch<(int)('Z'+1); ch++) {
				out.write(ch);
			}
//			13,10을 저장하면 엔터를 저장함
			out.write(13);
			out.write(10);
//			소문자 알파벳을 int로 저장하면 알파벳으로 저장됨
			for(int ch=(int)'A'+32; ch<(int)('Z'+1+32); ch++) {
				out.write(ch);
			}
			
			out.write(13);
			out.write(10);
			
//			문자열을 직접 저장하는 방식
			out.write("동해물과 백두산이 마르고 닳도록");
//			\r\n을 저장하면 엔터가 저장됨
			out.write("\r\n");
			out.write("하느님이 보우하사 우리나라 만세");
			out.write("\r\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}








