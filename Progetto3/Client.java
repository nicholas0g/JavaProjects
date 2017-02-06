import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	Socket socket;
	final static int port=3000;
	final static String IP="127.0.0.1";
	public Scanner in;
	public PrintWriter out;
	public ClientGui finestra;
	
	Client(){
		try {
			this.socket=new Socket(IP,port);
			this.out=new PrintWriter(this.socket.getOutputStream(),true);
			this.in=new Scanner(this.socket.getInputStream());
			this.finestra=new ClientGui(in,out);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
