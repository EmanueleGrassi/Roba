package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelezionatoreAutoriProlifici implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		Map<Autore, Integer> map = new HashMap<>();
		for (Libro l : libriInBiblioteca) {
			for (Autore a : l.getAutori()) {
				if (map.containsKey(a)) {
					int numLibri = map.get(a);
					numLibri++;
					map.put(a, Integer.valueOf(numLibri));
				} else {
					map.put(a, Integer.valueOf(0));
				}
			}
		}
		
		int max = Collections.max(map.values());
		
		List<Autore> list = new ArrayList<Autore>();
		
		for (Autore a : map.keySet()) {
			if (map.get(a) == max) 
				list.add(a);
		}
		
		return list;
	}

}
