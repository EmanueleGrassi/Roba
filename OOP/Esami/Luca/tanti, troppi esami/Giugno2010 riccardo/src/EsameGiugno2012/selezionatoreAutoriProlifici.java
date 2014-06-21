package EsameGiugno2012;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class selezionatoreAutoriProlifici implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> ris = new LinkedList<>();
		int numMax = 0;
		for(Libro l : libriInBiblioteca) {
			int tempNumMax = Collections.max(l.getAutori(),new Comparator<Autore>() {
				@Override
				public int compare(Autore a1,Autore a2) {
					return a1.getLibriScritti().size() - a2.getLibriScritti().size();
				}
			}).getLibriScritti().size();
			if(tempNumMax > numMax)
				numMax = tempNumMax;
		}
		for(Libro l : libriInBiblioteca) {
			for(Autore a : l.getAutori()) {
				if(a.getLibriScritti().size() == numMax)
					if(!(ris.contains(a)))
					ris.add(a);
			}
		}
		return ris;
	}
}
