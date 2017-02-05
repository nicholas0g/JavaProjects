import java.awt.FlowLayout;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class ClientGui  extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JButton invia=new JButton("invia");
	final JTextField stringa=new JTextField(30);
	
	ClientGui(PrintWriter out){
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(stringa);
		this.getContentPane().add(invia);
		this.pack();
		this.setVisible(true);
		ClientListener azione=new ClientListener(this,out);
		this.invia.addActionListener(azione);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	

}
