package esame2010;

import java.util.*;

public class SelezioneAutoriGiovani implements Selezionatore {
	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		int AnnoNascitapi�Giovane = 0;
		for (Libro item : libriInBiblioteca) {
			for (Autore aut : item.getAutori()) {
				if (aut.getAnnoNascita() >= AnnoNascitapi�Giovane)
					AnnoNascitapi�Giovane = aut.getAnnoNascita();
			}
		}
		List<Autore> res = new ArrayList<Autore>();
		for (Libro item : libriInBiblioteca) {
			for (Autore aut : item.getAutori()) {
				if (aut.getAnnoNascita() == AnnoNascitapi�Giovane && res.contains(aut)==false) {
					res.add(aut);
				}
			}
		}
		return res;
	}
}
