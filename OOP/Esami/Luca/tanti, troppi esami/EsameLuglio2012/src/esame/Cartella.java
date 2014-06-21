package esame;

import java.util.*;
public class Cartella extends Archivio {
	
	private Set<Archivio> documenti;
		
	public Cartella(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome,dataCreazione, permessoAccesso);
		this.documenti = new HashSet<Archivio>();
	}	
	@Override
	public int getDimensione() {
		int dimensioni = 0;
		for(Archivio item : this.documenti)
		{
			dimensioni+=item.getDimensione();
		}
		return dimensioni;
	}
	public boolean addDocumento(Archivio documento) {
		return this.documenti.add(documento);
	}
			
	@Override
	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> res = new ArrayList<Archivio>();	
		for(Archivio item : documenti)
		{			
			res.addAll(item.archiviCreatiIl(data));
		}
		return res;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((documenti == null) ? 0 : documenti.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartella other = (Cartella) obj;
		if (documenti == null) {
			if (other.documenti != null)
				return false;
		} else if (!documenti.equals(other.documenti))
			return false;
		return true;
	}
}
