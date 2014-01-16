import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class socket_client {
public static void main(String args[]) {
	Socket s;
	try {
		

		
	while(true) {
		s=new Socket("127.0.0.1",2500);
		InputStreamReader is=new InputStreamReader(s.getInputStream());
		
		BufferedReader br=new BufferedReader(is);
		
		
	System.out.println("From Server: "+br.readLine());
	s=new Socket("127.0.0.1",2500);
	PrintWriter pw=new PrintWriter(s.getOutputStream());
	System.out.print("Client:");
	DataInputStream din=new DataInputStream(System.in);

	pw.write(din.readLine());
	pw.close();
	}

	}catch(Exception e) {
		System.out.print("Exception e"+e.getMessage());
	}

}
}
