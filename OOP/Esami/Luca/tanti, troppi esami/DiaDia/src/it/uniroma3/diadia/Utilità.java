package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utilità {
	
	public static String printSet(Set<Attrezzo> set) {
		StringBuilder s = new StringBuilder();
		if (!set.isEmpty()) {
			s.append("{");
			Iterator<Attrezzo> iterator = set.iterator();
			while (iterator.hasNext()) {
				s.append(iterator.next().printNome());
				if (iterator.hasNext())
					s.append(", ");
			}
			s.append("}");
		} else
			s.append("nessun attrezzo.");
		return s.toString();
	}
	
	public static String printList(List<Attrezzo> list) {
		StringBuilder s = new StringBuilder();
		if (!list.isEmpty()) {
			s.append("[");
			Iterator<Attrezzo> i = list.iterator();
			while (i.hasNext()) {
				s.append(i.next().printNome());
				if (i.hasNext())
					s.append(", ");
			}
			s.append("]");
		} else
			s.append("nessun attrezzo.");
		return s.toString();
	}
	
	
	public static String printMap(Map<Integer,Set<Attrezzo>> map) {
		StringBuilder s = new StringBuilder();
		Iterator<Integer> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			int i = iterator.next().intValue();
			s.append("(" + i + ", ");
			s.append(printSet(map.get(i)));
			s.append(" )");
			if (iterator.hasNext())
				s.append(", ");
		}
		
		if (s.toString().isEmpty())
			s.append("nessun attrezzo.");
		
		return s.toString();
	}
	
}
