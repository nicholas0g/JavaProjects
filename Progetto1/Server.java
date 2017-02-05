import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;


public class Server implements Runnable{
	private ServerSocket serversocket;
	private final static int PORT=3000;
	private HashSet<ConnectionHandler> handlers=new HashSet<ConnectionHandler>();
	private HashSet<Thread> threads=new HashSet<Thread>();
	@Override
	public void run() {
	try {
		this.serversocket=new ServerSocket(PORT);	
		while(true){
			Socket socket=serversocket.accept();
			ConnectionHandler ch=new ConnectionHandler(socket,this);
			this.handlers.add(ch);
			Thread t= new Thread(ch);
			this.threads.add(t);
			t.start();
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
			try{
				stopServer();
			}catch(Exception d){
					System.out.println(d.getMessage());
				}
			}
		}
	

	final void stopServer(){
		for(ConnectionHandler ch:handlers){
			ch.stopConnectionHandler();
		}
		for(Thread t:threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.handlers.clear();
		this.threads.clear();
		try {
			this.serversocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public HashSet<ConnectionHandler> getHandlers() {
		return handlers;
	}

	public HashSet<Thread> getThreads() {
		return threads;
	}
}
