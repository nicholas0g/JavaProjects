import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ServerListener implements ActionListener {
	public ServerGui finestra;
	public Server server;
	public Thread thread;
	ServerListener(Server server,ServerGui finestra){
		super();
		this.server=server;
		this.finestra=finestra;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("start")){
			this.finestra.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.finestra.start.setEnabled(false);
			this.finestra.stop.setEnabled(true);
			this.thread=new Thread(this.server);
			this.thread.start();
		}
		if(arg0.getActionCommand().equals("stop")){
			this.finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.finestra.start.setEnabled(true);
			this.finestra.stop.setEnabled(false);
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
