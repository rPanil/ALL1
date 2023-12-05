import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket servers = new ServerSocket(4999);
		Socket s = new Socket();
		s = servers.accept();
		System.out.println("client connected");
		PrintWriter sender = new PrintWriter(s.getOutputStream());
		sender.println("Client------Server Connection established!");
		sender.flush();
		InputStreamReader is = new InputStreamReader(s.getInputStream());
		BufferedReader br = new BufferedReader(is);
		String str = br.readLine();
		double degrees = Float.parseFloat(str);

		double radian = degrees * (3.14) / (double) 180.0;
		System.out.println("Value Entered: " + degrees);
		System.out.println("Value of " + degrees + " in radian is " + radian);

	}

}
// javac Server.java
// java Server