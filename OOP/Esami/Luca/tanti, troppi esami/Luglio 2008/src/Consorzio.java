import java.util.*;
import java.util.Map.Entry;

public class Consorzio extends Societ� {

	private Map<String, Societ�> imprese;

	public Consorzio(int annoCostituzione, String nazione, String nome) {
		super(annoCostituzione, nazione, nome);
		this.imprese = new HashMap<String, Societ�>();
	}

	public void aggiungiConsorziata(Societ� nuovaConsorziata) {
		/* scrivere il codice di questo metodo (vedi DOMANDA 1) */
		imprese.put(nuovaConsorziata.getNome(), nuovaConsorziata);
	}

	@Override
	public int getNumeroDipendenti() {
		// scrivere il codice di questo metodo (vedi DOMANDA 2)
		int numeroDipendentiConsorziate = 0;
		for (Societ� consorziata : imprese.values())
			numeroDipendentiConsorziate += consorziata.getNumeroDipendenti();
		return super.getNumeroDipendenti() + numeroDipendentiConsorziate;
	}
	
	public Map<String, List<Societ�>> nazione2consorziate() {
		Map<String, List<Societ�>> res = super.nazione2consorziate();
		for (Societ� consorziate : imprese.values()) {
			Map<String, List<Societ�>> add2res = consorziate.nazione2consorziate();
			for (Entry<String, List<Societ�>> consorziate2add : add2res.entrySet()) {
				if (res.containsKey(consorziate2add.getKey())) {
					List<Societ�> tmp = res.get(consorziate2add.getKey());
					tmp.addAll(consorziate2add.getValue());					
				}
				else {
					List<Societ�> tmp = new LinkedList<>();
					tmp.addAll(consorziate2add.getValue());	
					res.put(consorziate2add.getKey(), tmp);
				}
			}
		}
		return res;
	}
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString()+' ');
		/*for(Societ� soc : imprese.values())
			str.append(soc.toString());*/
		return str.toString();
	}
}
