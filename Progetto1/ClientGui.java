import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6664721391685573155L;
	final JButton invia=new JButton ("invia");
	final JTextField frase=new JTextField(40);
	final JPanel sotto=new JPanel();
	final JTextArea ricevuti=new JTextArea(10,50);
	
	ClientGui(Scanner in,PrintWriter out){
		super("Interfaccia Cleint");
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(ricevuti,BorderLayout.NORTH);
		this.sotto.setLayout(new FlowLayout());
		this.sotto.add(frase);
		this.sotto.add(invia);
		ClientListener azione=new ClientListener(this,out);
		invia.setActionCommand("invia");
		invia.addActionListener(azione);
		this.getContentPane().add(sotto,BorderLayout.SOUTH);
		this.pack();
		this.ricevuti.setEditable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
