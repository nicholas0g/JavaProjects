import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ServerListener implements ActionListener {
	final ServerGui finestra;
	final Server server;
	public Thread thread;
	ServerListener(ServerGui finestra,Server server){
		super();
		this.finestra=finestra;
		this.server=server;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("start")){
			this.finestra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.finestra.start.setEnabled(false);
			this.finestra.stop.setEnabled(true);
			this.thread=new Thread(server);
			this.thread.start();
			System.out.println("Server Avviato");
			
		}
		if(arg0.getActionCommand().equals("stop")){
			try{
				this.server.stopServer();
				this.thread.join();
			}catch(InterruptedException e){
				System.err.println("Errore chiusura");
			}
			System.out.println("Server chiuso");
			this.finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.finestra.stop.setEnabled(false);
			this.finestra.start.setEnabled(true);
		}
	}
}
