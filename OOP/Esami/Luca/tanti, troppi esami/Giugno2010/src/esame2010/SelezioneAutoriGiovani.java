package esame2010;

import java.util.*;

public class SelezioneAutoriGiovani implements Selezionatore {
	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		int AnnoNascitapiłGiovane = 0;
		for (Libro item : libriInBiblioteca) {
			for (Autore aut : item.getAutori()) {
				if (aut.getAnnoNascita() >= AnnoNascitapiłGiovane)
					AnnoNascitapiłGiovane = aut.getAnnoNascita();
			}
		}
		List<Autore> res = new ArrayList<Autore>();
		for (Libro item : libriInBiblioteca) {
			for (Autore aut : item.getAutori()) {
				if (aut.getAnnoNascita() == AnnoNascitapiłGiovane && res.contains(aut)==false) {
					res.add(aut);
				}
			}
		}
		return res;
	}
}
