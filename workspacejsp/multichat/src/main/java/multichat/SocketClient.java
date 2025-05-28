package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.json.JSONObject;

public class SocketClient {

	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIp;
	String chatName;
	
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress info = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = info.getHostString();
			receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//메소드: 연결 종료
	public void close() {
		try { 
			socket.close();
		} catch(Exception e) {}
	}
	
	public void receive() {
		
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {
					String receiveJson = dis.readUTF();
					JSONObject jsonObj = new JSONObject(receiveJson);
					
					String cmd = jsonObj.getString("cmd");
					if (cmd.equals("incoming")) {
						this.chatName = jsonObj.getString("data");
						chatServer.sendToAll(SocketClient.this, chatName +"님 들어왔어요!");
						chatServer.addSocketClient(this);
					}else if(cmd.equals("message")){
						String message = jsonObj.getString("data");
						chatServer.sendToAll(SocketClient.this,message);
					}else {
						//error
					}
				}
			} catch (IOException e) {
				// TODO 연결 끊어지면 발생. 누가 나갔는지 처리, chatRoom 처리.
				chatServer.sendToAll(SocketClient.this,chatName + "가 나갔어요.");
				chatServer.removeSocketClient(SocketClient.this);
			}
		});
		
	}
	
	
	
	

}
