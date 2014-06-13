package esame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Archivio {
	private String dataCreazione;
	private String nome;
	private Map<String, PermessoAccesso> permessi;
	
	public abstract int getDimensione();
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Map<String, PermessoAccesso> getPermessi() {
		return permessi;
	}

	public void setPermessi(Map<String, PermessoAccesso> permessi) {
		this.permessi = permessi;
	}
	
	public PermessoAccesso getPermessoAccesso(String nomePermesso) {
		return this.getPermessi().get(nomePermesso);
	}
	
	public Set<Archivio> getContenuto() {
		return null;
	}
	
	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> list = new ArrayList<>();
		supp(data, list);
		return list;
	}

	private void supp(String data, List<Archivio> list) {
		if (this.getContenuto() == null) {
			if (this.getDataCreazione().equals(data))
				list.add(this);
		}
		else {
			for (Archivio a : this.getContenuto())
				a.supp(data, list);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCreazione == null) ? 0 : dataCreazione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((permessi == null) ? 0 : permessi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Archivio other = (Archivio) obj;
		if (dataCreazione == null) {
			if (other.dataCreazione != null)
				return false;
		} else if (!dataCreazione.equals(other.dataCreazione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permessi == null) {
			if (other.permessi != null)
				return false;
		} else if (!permessi.equals(other.permessi))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
