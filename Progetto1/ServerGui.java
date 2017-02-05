import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ServerGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1744566928942139213L;
	final JButton start=new JButton("start");
	final JButton stop=new JButton("stop");
	ServerGui(){
		super("interfaccia server");
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(start);
		this.getContentPane().add(stop);
		this.pack();
		Server server=new Server();
		ServerListener azione=new ServerListener(this,server);
		this.start.setActionCommand("start");
		this.stop.setActionCommand("stop");
		this.start.addActionListener(azione);
		this.stop.addActionListener(azione);
		this.setVisible(true);
		this.stop.setEnabled(false);
		
	}
}
