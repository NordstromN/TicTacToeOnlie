package model;

import model.TicTacToeModelInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TicTacToeModelServer extends Thread {
	private Socket socket;
	private TicTacToeModelInterface model;

	public TicTacToeModelServer(Socket socket, TicTacToeModelInterface model) {
		System.out.println("New Model Server");
		this.socket = socket;
		this.model = model;
	}

	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

			while (true) {
				String echoString = input.readLine();
				System.out.println("Received Command: " + echoString);
				if (echoString.equals("exit")) {
					break;
				} else if (echoString.equals("setBoard")) {
					model.setBoard();
				} else if (echoString.substring(0, 2).equals("PM")) {
					int x = Integer.parseInt(echoString.substring(2, 3));
					int y = Integer.parseInt(echoString.substring(3, 4));
					if (model.placeMark(x, y)) {
						output.println("TRUE");
					} else {
						output.println("FALSE");
					}
				} else if (echoString.equals("WC")) {
					if (model.winCheck()) {
						output.println("TRUE");
					} else {
						output.println("FALSE");
					}
				} else if (echoString.equals("SM")) {
					char mark = model.setMark();
					output.println(mark);
				} else if (echoString.equals("CT")) {
					char mark = model.changeToken();
					output.println(mark);
				} else if (echoString.substring(0, 2).equals("GM")) {
					int x = Integer.parseInt(echoString.substring(2, 3));
					int y = Integer.parseInt(echoString.substring(3, 4));
					char mark = model.getMark(x, y);
					output.println(mark);
				}

				try {
					Thread.sleep(100);

				} catch (InterruptedException e) {
					System.out.println("Thread Interrupted");
				}
				// output.println(echoString);
			}

		} catch (IOException e) {
			System.out.println("Opps: " + e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// Oh, well...
			}
		}
	}

}
