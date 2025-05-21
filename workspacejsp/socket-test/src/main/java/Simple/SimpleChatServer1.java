package Simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleChatServer1 {

    ServerSocket server;
    Socket client;
    BufferedReader br;
    BufferedReader keyReader;
    BufferedWriter bw;

    public void initServer() {
        try {
            System.out.println("실행 되었음.");
            server = new ServerSocket(8910);    // 포트 8901
            client = server.accept();
            System.out.println("✅ 클라이언트 연결됨.");

            // 클라이언트로부터 데이터 읽기
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // 클라이언트로 데이터 보내기
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            // 1) 클라이언트가 보낸 메시지 한 줄 읽기
            String clientMsg = br.readLine();
            System.out.println("수신 메시지: " + clientMsg);

            // 2) 서버 사용자 키보드 입력 받아서 클라이언트에 보내기
            keyReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("서버에서 보낼 메시지 입력: ");
            String serverMsg = keyReader.readLine();

            bw.write(serverMsg);
            bw.newLine();
            bw.flush();
            System.out.println("메시지 전송 완료");

            // 종료 - 스트림과 소켓 닫기
            bw.close();
            br.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimpleChatServer1();
    }

    public SimpleChatServer1() {
        initServer();
    }

}
