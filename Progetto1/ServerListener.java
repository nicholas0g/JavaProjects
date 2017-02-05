import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ServerListener implements ActionListener {
	private Server server;
	private Thread thread;
	final ServerGui finestra;
	ServerListener(ServerGui finestra,Server server){
		super();
		this.finestra=finestra;
		this.server=server;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("start")){
			this.finestra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.finestra.start.setEnabled(false);
			this.finestra.stop.setEnabled(true);
			System.out.println("server avviato");
			this.thread =new Thread(this.server);
			this.thread.start();
			
		}
		if(arg0.getActionCommand().equals("stop")){
			this.finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.finestra.stop.setEnabled(false);
			this.finestra.start.setEnabled(true);
			System.out.println("Server stoppato");
			this.server.stopServer();
			try {
				this.thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
