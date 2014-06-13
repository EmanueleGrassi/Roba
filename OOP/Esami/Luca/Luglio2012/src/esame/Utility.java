package esame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utility {
	public static Map<Utente, List<Documento>> utente2docs(List<Documento> docs, String nomePermesso) {
		Map<Utente, List<Documento>> map = new HashMap<>();
		for (Documento d : docs) {
			if (d.getPermessoAccesso(nomePermesso)!=null) {
				Set<Utente> utenti = d.getPermessi().get(nomePermesso).getUtenti();
				for (Utente u : utenti) {
					if (!map.containsKey(u)) {
						List<Documento> temp = new ArrayList<>();
						temp.add(d);
						map.put(u, temp);
					}
					else {
						map.get(u).add(d);
					}
				}
			}
		}
		return map;
	}
}
