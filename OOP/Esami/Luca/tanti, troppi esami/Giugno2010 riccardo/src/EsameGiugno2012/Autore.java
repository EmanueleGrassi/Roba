package EsameGiugno2012;

import java.util.HashSet;
import java.util.Set;

public class Autore implements Comparable<Autore>{
    private int annoNascita;
    private String nome;
    private Set<Libro> libriScritti;
    
    public Autore(String nome, int annoNascita) {
         this.nome = nome;
         this.annoNascita = annoNascita;
         this.setLibriScritti(new HashSet<>());
    }
    
    public String getNome() {
         return this.nome;
    }
    
    public int getAnnoNascita() {
         return this.annoNascita;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annoNascita;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Autore other = (Autore) obj;
		if (annoNascita != other.annoNascita)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome : "+this.getNome()+" Anno nascita :"+this.getAnnoNascita();
	}

	@Override
	public int compareTo(Autore that) {
		return this.getAnnoNascita() - that.getAnnoNascita();
	}

	public Set<Libro> getLibriScritti() {
		return libriScritti;
	}

	public void setLibriScritti(Set<Libro> libriScritti) {
		this.libriScritti = libriScritti;
	}
	
	public boolean addLibro(Libro libro) {
		return this.libriScritti.add(libro);
	}
}