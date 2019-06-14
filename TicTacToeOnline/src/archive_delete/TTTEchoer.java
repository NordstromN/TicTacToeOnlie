package archive_delete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TTTEchoer extends Thread {
	private Socket socket;
	
	public TTTEchoer(Socket socket) {
		this.socket = socket;
	}
	
	
	public void run() {
		try {
			BufferedReader input = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String echoString = input.readLine();
				System.out.println("Received Client Input: " + echoString);
				if(echoString.equals("exit")) {
					break;
				}
				
			try {
				Thread.sleep(50);
				
				
			}catch(InterruptedException e) {
				System.out.println("Thread Interrupted");
			
			}
				
				output.println(echoString);
				
			}
			
		} catch(IOException e) {
			System.out.println("Opps: " +e.getMessage());
			
		} finally {
			try {
				socket.close();
			} catch(IOException e) {
				//Oh, well...
			}
		}
	}
}
