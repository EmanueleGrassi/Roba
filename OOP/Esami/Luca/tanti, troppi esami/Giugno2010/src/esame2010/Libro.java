package esame2010;
import java.util.*;

public class Libro {
	private Set<Autore> autori;
	private String titolo;

	public Libro(String titolo) 
	{
		this.titolo = titolo;
		this.autori = new HashSet<Autore>();
	}
	public Libro(String titolo, Autore aut) 
	{
		this.titolo = titolo;
		this.autori = new HashSet<Autore>();
		addAutore(aut);
	}

	public void addAutore(Autore autore) 
	{
		if(autori.contains(autore)==false)
			this.autori.add(autore);
	}

	public Set<Autore> getAutori() {
		return Collections.unmodifiableSet(this.autori);
	}

	public String getTitolo() {
		return this.titolo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autori == null) ? 0 : autori.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
		Libro other = (Libro) obj;
		if (autori == null) {
			if (other.autori != null)
				return false;
		} else if (!autori.equals(other.autori))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}
}
