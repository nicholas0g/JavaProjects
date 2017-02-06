import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ServerGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -794069632850951928L;
	JButton start=new JButton("start");
	JButton stop=new JButton("stop");
	ServerGui(){
		super();
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(start);
		this.getContentPane().add(stop);
		this.stop.setEnabled(false);
		ServerListener azione=new ServerListener(new Server(),this);
		this.start.addActionListener(azione);
		this.stop.addActionListener(azione);
		this.start.setActionCommand("start");
		this.stop.setActionCommand("stop");
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
