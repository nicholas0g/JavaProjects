import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ConnectionHandler implements Runnable {
	MappaPosti posti;
	Socket socket;
	PrintWriter out;
	Scanner in;
	
	ConnectionHandler(Socket socket, MappaPosti posti){
		super();
		this.socket=socket;
		this.posti=posti;
	}
	
	@Override
	public void run() {
		try{
			in=new Scanner(this.socket.getInputStream());
			out=new PrintWriter(this.socket.getOutputStream(),true);
			String nome=in.nextLine();
			String cognome=in.nextLine();
			String fila=in.nextLine();
			String numero=in.nextLine();
			System.out.println("Ricevuto: "+nome+" "+cognome+" "+fila+numero);
			if(nome==null||cognome==null)out.println("Nome o cognome non valido");
			else{
				String persona=nome+" "+cognome;
				String posto=fila+numero;
				boolean prenotazione=this.posti.prenota(posto, persona);
				if(prenotazione)out.println("Prenotazione effettuata");
				else out.println("Prenotazione fallita, posto già occupato");
			}
			this.in.close();
			this.out.close();
			this.socket.close();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}
}
