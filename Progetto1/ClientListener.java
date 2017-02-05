import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;


public class ClientListener implements ActionListener {
	final ClientGui finestra;
	private PrintWriter out;
	ClientListener(ClientGui finestra,PrintWriter out){
		super();
		this.finestra=finestra;
		this.out=out;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("invia")){
			this.out.println(this.finestra.frase.getText());
			this.finestra.frase.setText("");
		}
		
	}
	

}
