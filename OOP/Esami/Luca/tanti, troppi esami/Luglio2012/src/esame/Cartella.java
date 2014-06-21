package esame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cartella extends Archivio {
	private Set<Archivio> documenti;
		
	public Cartella(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		this.setNome(nome);
		this.setDataCreazione(dataCreazione);
		this.setPermessi(new HashMap<String, PermessoAccesso>());
		this.getPermessi().put(permessoAccesso.getNome(), permessoAccesso);
		this.documenti = new HashSet<Archivio>();
	}

	@Override
	public int getDimensione() {
		int dimensioni = 0;
		for (Archivio a : this.documenti) 
			dimensioni += a.getDimensione();
		return dimensioni;
	}
	
	public boolean addDocumento(Archivio archivio) {
		return this.documenti.add(archivio);
	}
	
	@Override
	public Set<Archivio> getContenuto() {
		return this.documenti;
	}
}
