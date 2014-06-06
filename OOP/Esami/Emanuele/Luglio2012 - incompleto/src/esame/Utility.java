package esame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Utility {

	public static Map<Utente, List<Documento>> utente2docs(List<Documento> docs, String nomePermesso) {
		Utente utente = new Utente("Francesco");
		Map<Utente, List<Documento>> map = new HashMap<>();
		List<Documento> list = new ArrayList<>();
		map.put(utente, list);
		Iterator<Documento> iterator = docs.iterator();
		while (iterator.hasNext()) {
			Documento doc = iterator.next();
			if (GestoreAccessi.haPermesso(utente, doc, nomePermesso)) {
				list.add(doc);
			}
		}
		return map;
	}

}
