package main;

import java.util.ArrayList;
import java.util.List;

public class SelezionatoreAutoriGiovani implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> list = new ArrayList<>();
		for(Libro l : libriInBiblioteca) {
			for (Autore a : l.getAutori()) {
				if (a.getAnnoNascita() > 1993) {
					list.add(a);
				}
			}
		}
		return list;
	}

}
