package parco;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Territorio {
	private static final int NUM_INIZIALE_ANIMALI = 2200;
	private static final double PROBABILITA_CARNIVORO = 0.2;

	private int dimensione;	
	private Map<Posizione, Erbivoro> posizione2erbivoro;	
	private Map<Posizione, Carnivoro> posizione2carnivoro;	

	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2erbivoro = new HashMap<Posizione, Erbivoro>();
		this.posizione2carnivoro = new HashMap<Posizione, Carnivoro>();
		this.popolaTerritorio();
	}
	
	public Erbivoro getErbivoro(Posizione posizione){
		return posizione2erbivoro.get(posizione);
	}

	public Carnivoro getCarnivoro(Posizione posizione){
		return posizione2carnivoro.get(posizione);
	}

	public void rimuoviErbivoro(Erbivoro erbivoro) {
		this.posizione2erbivoro.remove(erbivoro.getPosizione());
	}

	public void rimuoviCarnivoro(Carnivoro carnivoro) {
		this.posizione2carnivoro.remove(carnivoro.getPosizione());
	}

	public void setErbivoro(Erbivoro erbivoro, Posizione posizione) {
		if (this.getErbivoro(posizione)==null){
			this.posizione2erbivoro.put(posizione, erbivoro);
			erbivoro.setPosizione(posizione);
		} 
	}

	public void setCarnivoro(Carnivoro carnivoro, Posizione posizione) {
		if (this.getCarnivoro(posizione)==null){
			this.posizione2carnivoro.put(posizione, carnivoro);
			carnivoro.setPosizione(posizione);
		} 
	}
	
	public Collection<Erbivoro> getErbivori(){
		return this.posizione2erbivoro.values();
	}

	public Collection<Carnivoro> getCarnivori(){
		return this.posizione2carnivoro.values();
	}
	
	public void sposta(Erbivoro erbivoro, Posizione nuovaPosizione) {
		this.rimuoviErbivoro(erbivoro);
		this.setErbivoro(erbivoro, nuovaPosizione);		
	}	

	public void sposta(Carnivoro carnivoro, Posizione nuovaPosizione) {
		this.rimuoviCarnivoro(carnivoro);
		this.setCarnivoro(carnivoro, nuovaPosizione);		
	}	
	
	public List<Posizione> adiacenti(Posizione posizione) {
		List<Posizione> adiacenti = new LinkedList<Posizione>();
		int x = posizione.getX();
		int y = posizione.getY();
		
		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				adiacenti.add(new Posizione(x+i, y+j));
				}
			}
		Iterator<Posizione> it = adiacenti.iterator();
		while(it.hasNext()){
			Posizione p = it.next();
			if ((p.getX()<0) || (p.getX()>=this.dimensione) || (p.getY()<0) || 
					(p.getY()>=this.dimensione) || (p.equals(posizione)))
				it.remove();
		}
		Collections.shuffle(adiacenti);
		return adiacenti;
	} 
	
	public Posizione posizioneLiberaVicino(Posizione posizione) {
		for(Posizione p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean isLibera(Posizione posizione) {
			if ((this.getErbivoro(posizione)==null) &&
					(this.getCarnivoro(posizione)==null)) {
				return true;
			} else
		return false;
	}

	public int getDimensione() {
		return this.dimensione;
	}
	
	private void popolaTerritorio(){

		int numeroAnimali = 0;

		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*this.dimensione);
			int y = (int)(Math.random()*this.dimensione);
			Posizione posizione = new Posizione(x, y);
			if (this.isLibera(posizione)) {
				if(Math.random() < PROBABILITA_CARNIVORO) {
					Carnivoro nuovoAnimale = new Carnivoro();
					this.setCarnivoro(nuovoAnimale, posizione);
				} else {
					Erbivoro nuovoAnimale = new Erbivoro();
					this.setErbivoro(nuovoAnimale, posizione);
				}
				numeroAnimali++;
			}
		}
	}
	
	public Set<Posizione> posizioniErbivoriVecchi() {
		Set<Posizione> set = new HashSet<>();
		Set<Posizione> erbivori = this.posizione2erbivoro.keySet();
		Iterator<Posizione> iterator = erbivori.iterator();
		while (iterator.hasNext()) {
			Posizione p = iterator.next();
			Erbivoro e = this.posizione2erbivoro.get(p);
			if (e.getAnni() == 4) {
				set.add(p);
			}
		}
		return set;
	}
	
	public Map<Integer, Set<Erbivoro>> anno2erbivori() {
		Map<Integer, Set<Erbivoro>> map = new HashMap<>();
		Set<Erbivoro> setErbivori = (Set<Erbivoro>) this.posizione2erbivoro.values();
		Iterator<Erbivoro> iter = setErbivori.iterator();
		while (iter.hasNext()) {
			Erbivoro e = iter.next();
			int eta = e.getAnni();
			if (!map.containsKey(eta)) {
				Set<Erbivoro> temp = new HashSet<>();
				temp.add(e);
				map.put(eta, temp);
			} else {
				map.get(eta).add(e);
			}
		}
		return map;
	}
}
