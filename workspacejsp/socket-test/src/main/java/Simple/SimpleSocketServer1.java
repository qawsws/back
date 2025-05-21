package Simple;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer1 {

	public static void main(String[] args) {
		ServerSocket serversocket;
		
		try {
			serversocket = new ServerSocket(8888);
			System.out.println("접속했음.");
			Socket clientsocket = serversocket.accept();
			System.out.println("accept!!!.");
			BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println("수신 메시지: "+ line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
