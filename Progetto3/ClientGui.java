import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ClientGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -219572314407263788L;
	String[] lettera={"A","B","C","D","E","F"};
	public JComboBox<String> lettere=new JComboBox<String>(lettera);
	public JComboBox<String> numeri;
	public JTextField nome=new JTextField(30);
	public JTextField cognome=new JTextField(30);
	public JButton invia=new JButton("invia");
	
	ClientGui(Scanner in, PrintWriter out){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		String[] numero=new String[20];
		for(int i=0;i<20;i++)numero[i]=i+1+"";
		this.numeri=new JComboBox<String>(numero);
		this.getContentPane().setLayout(new FlowLayout());
		this.setVisible(true);
		this.nome.setToolTipText("nome");
		this.cognome.setToolTipText("cognome");
		JPanel n=new JPanel();
		n.setLayout(new BorderLayout());
		JPanel c=new JPanel();
		c.setLayout(new BorderLayout());
		JLabel nn=new JLabel("nome:");
		JLabel cc=new JLabel("cognome:");
		n.add(nn,BorderLayout.NORTH);
		n.add(nome,BorderLayout.SOUTH);
		c.add(cc,BorderLayout.NORTH);
		c.add(cognome,BorderLayout.SOUTH);
		this.getContentPane().add(n);
		this.getContentPane().add(c);
		this.getContentPane().add(this.lettere);
		this.getContentPane().add(this.numeri);
		this.getContentPane().add(invia);
		this.pack();
		ClientListener azione=new ClientListener(this,in,out);
		this.invia.addActionListener(azione);
		
		
	}
}
