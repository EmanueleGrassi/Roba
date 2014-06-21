package EsameGiugno2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Biblioteca {
	private Map<String, Libro> codice2libro;

	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}
	
	public void addLibro(String codice, Libro libro) {
		this.codice2libro.put(codice, libro);
	}
	
	public Map<Autore, Set<Libro>> autore2libri() {
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>();
		for(Libro libro : codice2libro.values())
			for(Autore autore : libro.getAutori())
				if(autore2libri.containsKey(autore)) {
					autore2libri.get(autore).add(libro);
				}
				else {
					Set<Libro> temp = new HashSet<>();
					temp.add(libro);
					autore2libri.put(autore, temp);
				}	
		return autore2libri;
	}
	
	List<Autore> seleziona(Selezionatore selezionatore) {
		return selezionatore.eseguiSelezione((ArrayList<Libro>)codice2libro.values());
	}
}