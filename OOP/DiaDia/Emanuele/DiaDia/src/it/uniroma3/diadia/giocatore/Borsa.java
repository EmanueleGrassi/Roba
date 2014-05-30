package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Utilità;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		int ind = this.attrezzi.indexOf(new Attrezzo(nomeAttrezzo, 1));
		if (ind > -1)
			return this.attrezzi.get(ind);
		else
			return null;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;
	}

	public int getnumAttrezzi() {
		return this.attrezzi.size();
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo temp = this.getAttrezzo(nomeAttrezzo);
		if (temp != null){
			this.attrezzi.remove(new Attrezzo(nomeAttrezzo,1));
		}
		return temp;
		
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa: (" + this.getPeso() + "kg/"
					+ this.getPesoMax() + "kg)\n");
			s.append(Utilità.printList(this.attrezzi));
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		Collections.sort(this.attrezzi, new Comparator<Attrezzo>(){

			@Override
			public int compare(Attrezzo arg0, Attrezzo arg1) {
				Integer i0 = arg0.getPeso();
				Integer i1 = arg1.getPeso();
				if (i0.compareTo(i1) == 0)
					return arg0.getNome().compareTo(arg1.getNome());
				return i0.compareTo(i1);
			}
		});
		return this.attrezzi;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerNome() {
		Collections.sort(this.attrezzi, new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo o1, Attrezzo o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		return this.attrezzi;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		
		Set<Attrezzo> tmp;
		Map<Integer,Set<Attrezzo>> map = new HashMap<Integer, Set<Attrezzo>>();
		
		for (Attrezzo attr : this.attrezzi) {
			tmp = map.get(attr.getPeso());
			if (tmp == null)
				tmp = new HashSet<Attrezzo>();
			tmp.add(attr);
			map.put(attr.getPeso(), tmp);
		}
		
		return map;
	}
	
	public String printContenutoOrdinatoPerPeso() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa: [");
			Iterator<Attrezzo> i = this.getContenutoOrdinatoPerPeso().iterator();
			while (i.hasNext()) {
				s.append(i.next().printNome());
				if (i.hasNext())
					s.append(", ");
			}
			s.append("]");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}	
}
