import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class testfile {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter scrivi=new PrintWriter("ciao1.txt");
		scrivi.write("caccaaaa");
		scrivi.close();

	}

}
