package esame;

import java.util.*;

public class Documento extends Archivio {
	private int dimensione;
	
	public Documento(String nome, int dimensione, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome,dataCreazione, permessoAccesso);
		this.dimensione = dimensione;
	}
	@Override
	public int getDimensione() {
		return this.dimensione;
	}	
	@Override
	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> res = new ArrayList<Archivio>();
		if(getDataCreazione().equals(data))
			res.add(this);
		return res;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dimensione;
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
		Documento other = (Documento) obj;
		if (dimensione != other.dimensione)
			return false;
		return true;
	}	
}
