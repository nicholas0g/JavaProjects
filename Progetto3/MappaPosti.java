import java.util.HashMap;
import java.util.Map;


public class MappaPosti {
	private Map<String,String> posti;
	
	MappaPosti(){
		this.posti=new HashMap<String,String>();
	}
	public String getPrenotazione(String posto){
		return this.posti.get(posto);
	}
	public synchronized boolean prenota(String posto,String persona){
		if(this.posti.get(posto)==null){
			this.posti.put(posto, persona);
			return true;
		}
		else return false;
	}
	
}
