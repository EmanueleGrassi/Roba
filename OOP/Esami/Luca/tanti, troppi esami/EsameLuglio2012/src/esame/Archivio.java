package esame;

import java.util.*;

public abstract class Archivio {
	private String nome;
	private String dataCreazione;
	private Map<String, PermessoAccesso> permessi;
	public Archivio(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		this.nome = nome;
		this.dataCreazione = dataCreazione;
		this.permessi = new HashMap<String, PermessoAccesso>();
		this.permessi.put(permessoAccesso.getNome(), permessoAccesso);
	}
	public String getDataCreazione() {
		return this.dataCreazione;
	}

	public String getNome() {
		return this.nome;
	}

	public PermessoAccesso getPermessoAccesso(String nomePermesso) {
		return this.permessi.get(nomePermesso);
	}
	public abstract int getDimensione();
	public abstract List<Archivio> archiviCreatiIl(String data);
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
}
