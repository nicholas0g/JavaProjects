import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable{
	public ServerSocket serversocket;
	public Socket socket;
	private final int PORT=3000;
	private MappaPosti posti;
	Server(){
		this.posti=new MappaPosti();
	}
	@Override
	public void run() {
		try{
			this.serversocket=new ServerSocket(PORT);
			while(true){
				this.socket=serversocket.accept();
				ConnectionHandler ch=new ConnectionHandler(this.socket,this.posti);
				Thread t=new Thread(ch);
				t.start();
			}
		}catch(Exception e){
			System.err.println("Errore run server");
		}
		
	}
	public void stopServer(){
		try {
			this.socket.close();
			this.serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	}

}
