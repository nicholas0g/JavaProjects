import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ServerGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JButton start=new JButton("start");
	final JButton stop=new JButton("stop");
	ServerGui(){
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(start);
		this.getContentPane().add(stop);
		this.pack();
		this.setVisible(true);
		this.stop.setEnabled(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ServerListener azione=new ServerListener(this,new Server());
		this.start.addActionListener(azione);
		this.stop.addActionListener(azione);
		this.start.setActionCommand("start");
		this.stop.setActionCommand("stop");
	}
}
