import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class ClientListener implements ActionListener{
	Scanner in;
	PrintWriter aut;
	ClientGui finestra;
	ClientListener(ClientGui finestra,Scanner in,PrintWriter aut){
		super();
		this.finestra=finestra;
		this.in=in;
		this.aut=aut;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		aut.println(this.finestra.nome.getText());
		aut.println(this.finestra.cognome.getText());
		this.finestra.nome.setText("");
		this.finestra.cognome.setText("");
		aut.println(this.finestra.lettere.getSelectedIndex());
		aut.println(this.finestra.numeri.getSelectedIndex());
		while(true){
			JOptionPane.showMessageDialog(null, in.nextLine());
		}
	}

}
