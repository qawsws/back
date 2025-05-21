package Simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleChatClient1 {

    Socket socket;
    BufferedReader keyReader;
    BufferedWriter bw;
    BufferedReader socReader;

    public void initClient() {
        try {
            socket = new Socket("localhost", 8910);
            System.out.println("연결되었음.");

            // 키보드로 입력받기
            keyReader = new BufferedReader(new InputStreamReader(System.in));
            // 서버로 쓰기 스트림
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 서버에서 읽기 스트림
            socReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("글자 쓰시오: ");
            String input = keyReader.readLine();

            // 서버로 메시지 보내기
            bw.write(input);
            bw.newLine();
            bw.flush();

            // 서버가 보낸 응답 한 줄 읽기
            String line = socReader.readLine();
            System.out.println("서버에서 오는 수신 메시지: " + line);

            // 종료 - 스트림과 소켓 닫기
            bw.close();
            socReader.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient1();
    }

    public SimpleChatClient1() {
        initClient();
    }

}
