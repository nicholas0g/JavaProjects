import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable {
	public ServerSocket serversocket;
	public Socket socket;
	final static int PORT=3000;
	
	public void run() {
		try {
			this.serversocket=new ServerSocket(PORT);
		while(true){
			this.socket=this.serversocket.accept();
			ConnectionHandler ch=new ConnectionHandler(socket);
			Thread t=new Thread(ch);
			t.start();
		}	
		}catch(Exception e){
			this.stopServer();
		}
	}
		
	
	final void stopServer(){
		try {
			this.serversocket.close();
			this.socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
