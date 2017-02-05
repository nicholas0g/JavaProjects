import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class ConnectionHandler implements Runnable{
	private Socket socket;
	private PrintWriter autf;
	private PrintWriter autf1;
	private Scanner in;
	ConnectionHandler(Socket socket){
		super();
		this.socket=socket;
	}
	@Override
	public void run() {
		try{
			in = new Scanner(socket.getInputStream());
			String user=in.nextLine();
			File file=new File(user+".txt");
			if(!(file.exists())){
				file.createNewFile();
				autf = new PrintWriter(file);
				while(true){
					String messaggio=in.nextLine();
					autf.println(messaggio);
					autf.flush();
				}
			}
			else{
				autf1 = new PrintWriter(new FileWriter(file,true));
				while(true){
					String messaggio=in.nextLine();
					autf1.println(messaggio);
					autf1.flush();
				}
			}
		}catch (Exception e){
			System.err.println("Errore file-connessione interrotta");
		}
		
	}
	
}
	

