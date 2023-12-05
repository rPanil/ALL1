import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 4999);
		InputStreamReader is = new InputStreamReader(s.getInputStream());
		BufferedReader br = new BufferedReader(is);
		String str = br.readLine();
		System.out.println(str);
		System.out.println("Enter value in Degrees: ");
		Scanner sc = new Scanner(System.in);
		int x;
		x = sc.nextInt();
		PrintWriter sender = new PrintWriter(s.getOutputStream());
		sender.println(x);
		System.out.println("Converted to radian at server side.............");
		sender.flush();

	}

}
// javac Client.java
// java Client