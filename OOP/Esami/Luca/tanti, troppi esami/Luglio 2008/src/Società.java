import java.util.*;
public abstract class SocietÓ implements Comparable<Consorzio> {
	private int annoDiCostituzione;
	private String nazione;
	private String nome;
	private Set<Dipendente> dipendenti;

	public SocietÓ(int annoDiCostituzione, String nazione, String nome) {
		this.annoDiCostituzione = annoDiCostituzione;
		this.nazione = nazione;
		this.nome = nome;
		this.dipendenti = new HashSet<Dipendente>();
	}

	public int getAnnoDiCostituzione() {
		return this.annoDiCostituzione;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void aggiungiDipendente(Dipendente dipendente) {
		this.dipendenti.add(dipendente);
	}

	public String getNome() {
		return this.nome;
	}

	public int compareTo(Impresa that) {
		return this.getNome().compareTo(that.getNome());
	}

	public int getNumeroDipendenti() {
		// scrivere il codice di questo metodo (vedi DOMANDA 2)
		return dipendenti.size();
	}
	public Map<String, List<SocietÓ>> nazione2consorziate()
	{
		List<SocietÓ> listaSocietÓ = new LinkedList<SocietÓ>();
		listaSocietÓ.add(this);
		Map<String, List<SocietÓ>> res = new HashMap<String, List<SocietÓ>>();
		res.put(nazione, listaSocietÓ);
		return res;
	}

	@Override
	public int compareTo(Consorzio that) {
		return	this.getNome().compareTo(that.getNome()); 
	}
	@Override
	public String toString()
	{
		return this.getNome()+' ';
	}
}
