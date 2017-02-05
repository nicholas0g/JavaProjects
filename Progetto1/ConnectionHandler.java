import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ConnectionHandler implements Runnable{
	final Server server;
	private Scanner in;
	private PrintWriter out;
	private Socket socket;
	private String utente;
	ConnectionHandler(Socket socket,Server server){
		this.server=server;
		this.socket=socket;
		try{
			this.in=new Scanner(socket.getInputStream());
		}catch(Exception e){System.out.println(e.getMessage());}
		try{
			this.out=new PrintWriter(socket.getOutputStream(),true);
		}catch(Exception b){System.out.println(b.getMessage());}
		
		
	}
	@Override
	public void run() {
		this.utente=this.in.nextLine();
		for(ConnectionHandler ch:this.server.getHandlers()){
			ch.out.println("L'utente "+ this.utente + " è connesso");
		}
		String messaggio;
		while(true){
			messaggio=this.in.nextLine();
			for(ConnectionHandler kk:this.server.getHandlers()){
				kk.out.println(this.utente + ": "+messaggio);
			}	
		}
		
	}
	
	final void stopConnectionHandler(){
		this.in.close();
		this.out.close();
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
