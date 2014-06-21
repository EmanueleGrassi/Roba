package main;

import java.util.*;

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
		for (Libro l : this.codice2libro.values()) {
			for (Autore a : l.getAutori()) {
				if (autore2libri.containsKey(a)) {
					autore2libri.get(a).add(l);
				} else {
					Set<Libro> temp = new HashSet<>();
					temp.add(l);
					autore2libri.put(a, temp);
				}
			}
		}
		return autore2libri;
	}

	public List<Autore> seleziona(Selezionatore selezionatore) {
		return null;
	}

}
