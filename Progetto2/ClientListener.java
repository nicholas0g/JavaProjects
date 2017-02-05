import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;


public class ClientListener implements ActionListener {
	final ClientGui finestra;
	final PrintWriter aut;
	ClientListener(ClientGui finestra,PrintWriter aut){
		super();
		this.finestra=finestra;
		this.aut=aut;
	}
	public void actionPerformed(ActionEvent arg0) {
		this.aut.println(this.finestra.stringa.getText());
		this.finestra.stringa.setText("");
	}
	
}
