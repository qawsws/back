package Simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleSocketClient1 {

	public static void main(String[] args) {
		Socket soc;
		try {
			soc = new Socket("localhost", 8090);
			System.out.println("연결되었음.");
			PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
			out.println("Hello Server!!!");
			
			soc.close();
			out.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
