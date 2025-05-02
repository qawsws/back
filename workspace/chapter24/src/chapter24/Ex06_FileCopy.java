package chapter24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.Instant;

public class Ex06_FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "./src/chapter24/bg.jpg";
		String dst = "bg copy.jpg";
		try (InputStream in = new FileInputStream(src); 
				OutputStream out = new FileOutputStream(dst)) {
//			byte자료형의 배열을 선언
			byte[] buf = new byte[1024];
			int len;
			
			Instant start = Instant.now();
			
			while (true) {
//						read(바이트배열) : 바이트배열의 크기만큼 읽음
				len = in.read(buf);
				if (len == -1) {
					break;
				}
//				    저장할 데이터   시작인덱스   실제 출력할 데이터
				out.write(buf,    0,           len);
			}
			Instant end = Instant.now();
			System.out.println("복사에 걸린 시간: " + Duration.between(start, end).toMillis());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}