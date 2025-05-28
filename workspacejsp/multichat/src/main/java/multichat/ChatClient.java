package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {

	DataInputStream dis;
	DataOutputStream dos;
	Socket socket;
	String chatName;
	
	public void connect() throws IOException {
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");		
	}
	
	
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}
	
	public void receive() {
		
		Thread thread = new Thread(() -> {
			try {
				while (true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp + "> " + message);
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);
			}
		});
		
		thread.start();
		
	}
	
	
	public static void main(String[] args) {
		try {
			ChatClient cc = new ChatClient();
			cc.connect();
			Scanner scanner = new Scanner(System.in);
			System.out.println("대화명 입력: ");
			cc.chatName =scanner.nextLine();
			//대화명 처리 부분.
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("cmd", "incoming");
			jsonObj.put("data", cc.chatName);
			cc.send(jsonObj.toString());
			
			cc.receive();
			
			
			System.out.println("--------------------------------------------------");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅를 종료하려면 q를 입력하고 Enter");
			System.out.println("--------------------------------------------------");
			
			while (true) {
				String message =scanner.nextLine();
				
				if (message.equals("q")) {
					break;
				}else {
					//message 전달.
					jsonObj = new JSONObject();
					jsonObj.put("cmd", "message");
					jsonObj.put("data", message);
					cc.send(jsonObj.toString());
				}
			}
			
			scanner.close();
			cc.socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
		
		
	}

}
