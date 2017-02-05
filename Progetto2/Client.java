import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;


public class Client {
	private Socket socket;
	private final static int PORT=3000;
	private final static String IP="127.0.0.1";
	private PrintWriter out;
	public ClientGui finestra;
	
	Client(){
		try{
			this.socket=new Socket(IP,PORT);
			this.out=new PrintWriter(this.socket.getOutputStream(),true);
		}catch(Exception e){
			System.err.println("Errore apertura socket");
		}
		String username=JOptionPane.showInputDialog("inserisci username");
		out.println(username);
		this.finestra=new ClientGui(out);
	}
}
