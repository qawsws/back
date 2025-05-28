package multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;




public class ChatServer {
	
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	ServerSocket serversoket;
	Map<String, SocketClient> chatRoom = new HashMap<String, SocketClient>();
	
	public void serverStart() throws IOException {
		serversoket = new ServerSocket(50001);
		
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					Socket socket = serversoket.accept();
					SocketClient sc = new SocketClient(ChatServer.this, socket);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
	
	public void addSocketClient(SocketClient sc) {
		String key = sc.chatName +"@"+ sc.clientIp;
		chatRoom.put(key, sc);
		System.out.println("입장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n"); //현재 서버에 몇명이 들어왔는지 표시
	}
	
	public void removeSocketClient(SocketClient sc) {
		String key = sc.chatName +"@"+ sc.clientIp;
		chatRoom.remove(key);
		System.out.println("나감: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}
	
	
	public void serverStop() {
		try {
			serversoket.close();
			threadPool.shutdown();

//			Collection<SocketClient> cr = chatRoom.values();
//			for (SocketClient socketClient : cr) {
//				socketClient.socket.close();
//			}
			chatRoom.values().stream().forEach(sc -> sc.close());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println( "[서버] 종료됨 ");
	}
	
	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values();
		
		for (SocketClient sc : socketClients) {
//			if (sc == sender) {
//				continue;
//			}
			sc.send(json);
		}
		
	}
	

	public static void main(String[] args) {
		
		try {
			ChatServer cs = new ChatServer();
			cs.serverStart();
			
			System.out.println("----------------------------------------------------");
			System.out.println("서버를 종료하려면 q를 입력하고 Enter.");
			System.out.println("----------------------------------------------------");
			
			Scanner scanner = new Scanner(System.in);
			
			while (true) {
				if (scanner.nextLine().equals("q")) {
					break;
				}
			}
			
			scanner.close();
			cs.serverStop();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
