package EsameGiugno2012;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SelezionatoreAutoriGiovani implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> ris = new LinkedList<>();
		int annoMin = 0;
		for(Libro l : libriInBiblioteca) {
			int annoMinTemp = Collections.max(l.getAutori()).getAnnoNascita();
			if(annoMinTemp > annoMin)
				annoMin = annoMinTemp;
		}
		for(Libro l : libriInBiblioteca) {
			for(Autore a : l.getAutori())
				if(a.getAnnoNascita() == annoMin)
					ris.add(a);
		}
		return ris;
	}
	
	public List<Autore> eseguiSelezioneMia(List<Libro> libriInBiblioteca) {
		List<Autore> ris = new LinkedList<>();
		for(Libro a : libriInBiblioteca)
			for(Autore x : a.getAutori())
				ris.add(x);
		Collections.sort(ris,new Comparator<Autore>() {
			public int compare(Autore a1,Autore a2) {
				return a1.getAnnoNascita() - a2.getAnnoNascita();
			}
		});
		return ris;
	}
}
