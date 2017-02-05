import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Client {
	private Socket socket;
	private static int PORT=3000;
	private static String IP=JOptionPane.showInputDialog("inserisci ip");
	private Scanner in;
	private PrintWriter out;
	private ClientGui finestra;
	Client(){
		try {
			this.socket=new Socket(IP,PORT);
			this.in=new Scanner(this.socket.getInputStream());
			this.out=new PrintWriter(this.socket.getOutputStream(),true);
		}catch(Exception e){}
		String username=JOptionPane.showInputDialog("inserisci username");
		this.out.println(username);
		this.finestra=new ClientGui(in,out);
		while(true){
			try {
				Thread.sleep(2000);
				String line=in.nextLine();
				this.finestra.ricevuti.setText(this.finestra.ricevuti.getText()+"\n"+line);
			} catch (Exception e) {
				System.err.println("errore connessione");
			}
		}
		
	}
	
}
