package EsameGiugno2012;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Libro {
	
	  private Set<Autore> autori;
	  private String titolo;
	  
	  public Libro(String titolo) {
	       this.titolo = titolo;
	       this.autori = new HashSet<Autore>();
	  }
	  
	  public void addAutore(Autore autore) {
	       this.autori.add(autore);
	       autore.addLibro(this);
	  }
	  
	  public Set<Autore> getAutori() {
	       return Collections.unmodifiableSet(this.autori);
	  }
	  
	  public String getTitolo() {
	       return this.titolo;
	  }

	@Override
	public String toString() {
		return "Libro [autori=" + autori + ", titolo=" + titolo + "]";
	}
}
