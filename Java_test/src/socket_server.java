import java.io.BufferedReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class socket_server {
public static void main(String args[]) throws IOException {

//	
	
	ServerSocket sr=new ServerSocket(2500);
	while(true) {
		Socket s=sr.accept();
		PrintWriter pw=new PrintWriter(s.getOutputStream());
		System.out.print("Server:");
		DataInputStream din=new DataInputStream(System.in);
		pw.write(din.readLine());
		pw.close();
		
		
		s=sr.accept();

		InputStreamReader is=new InputStreamReader(s.getInputStream());
		BufferedReader br=new BufferedReader(is);
		System.out.println("From Client: "+br.readLine());
		
	}
	
	//}
}
}
