package esame2010;

import java.util.*;
import java.util.Map.Entry;

public class SelezionatoreAutoriProlifici implements Selezionatore {

	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> res = new ArrayList<Autore>();
		if (libriInBiblioteca != null) {
			Map<Autore, Set<Libro>> autore2libri = new HashMap<>();
			for (Libro libro : libriInBiblioteca) {
				if (libro != null) {
					Set<Autore> temp = libro.getAutori();
					for (Autore autor : temp) {
						if (autore2libri.containsKey(autor)) {
							Set<Libro> autorelibro = autore2libri.get(autor);
							autorelibro.add(libro);
						} else {
							Set<Libro> autorelibro = new HashSet<>();
							autorelibro.add(libro);
							autore2libri.put(autor, autorelibro);
						}
					}
				}
			}
			int maxLibri = 0;
			for (Set<Libro> item : autore2libri.values()) {
				if (item.size() > maxLibri)
					maxLibri = item.size();
			}

			for (Entry<Autore, Set<Libro>> item : autore2libri.entrySet()) {
				if (item.getValue().size() == maxLibri)
					res.add(item.getKey());
			}
			Collections.sort(res);
		}
		return res;
	}
}
