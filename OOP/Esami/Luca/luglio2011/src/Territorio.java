

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
	private Map<Posizione, Animale> posizione2Animale;	

	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2Animale = new HashMap<Posizione, Animale>();
		this.popolaTerritorio();
	}
	
	public Animale getAnimale(Posizione posizione){
		return posizione2Animale.get(posizione);
	}
	public void rimuoviAnimale(Animale anim) {
		this.posizione2Animale.remove(anim.getPosizione());
	}
	public void setAnimale(Animale anim, Posizione posizione) 
	{
		if (this.posizione2Animale.containsKey(posizione)==false)
		{				
			this.posizione2Animale.put(posizione, anim);	
			anim.setPosizione(posizione);
		} 
	}
	
	/*Set<Posizione> posizioniErbivoriVecchi()
	{
		Collection<Erbivoro> t = getErbivori();
		//crea una lista set
		Set<Posizione> res = new HashSet<Posizione>();
		for(Erbivoro item : t)
		{
			if(item.getAnni()==4)//età massima, a 5 anni muoiono
				res.add(item.getPosizione());//aggiungi la posizione al coso da tornare
		}
		return res;
	}*/
	Set<Posizione> posizioniAnimaliVecchi()
	{
		Set<Posizione> res = new HashSet<Posizione>();
		for(Animale item : getAnimali())
		{
			if(item.getAnni()==4)//età massima, a 5 anni muoiono
				res.add(item.getPosizione());
		}
		return res;
	}
	
	/*public Map<Integer, Set<Erbivoro>> anno2erbivori()
	{
		Map<Integer, Set<Erbivoro>> res = new HashMap<Integer, Set<Erbivoro>>();
		for(Erbivoro item:posizione2erbivoro.values())
		{
			if(res.containsKey(item.getAnni())==false)
			{
				Set<Erbivoro> temp = new HashSet<Erbivoro>();
				temp.add(item);
				res.put(item.getAnni(), temp);
			}
			else
			{
				Set<Erbivoro> temp = res.get(item.getAnni());
				temp.add(item);
			}				
		}
		return res;
	}*/
	
	public Map<Integer, Set<Animale>> anno2Animali()
	{
		Map<Integer, Set<Animale>> res = new HashMap<Integer, Set<Animale>>();
		for(Animale item:posizione2Animale.values())
		{
			if(res.containsKey(item.getAnni())==false)
			{
				Set<Animale> temp = new HashSet<Animale>();
				temp.add(item);
				res.put(item.getAnni(), temp);
			}
			else
			{
				Set<Animale> temp = res.get(item.getAnni());
				temp.add(item);
			}				
		}
		return res;
	}
	
	public Collection<Animale> getAnimali(){
		return this.posizione2Animale.values();
	}
	
	public void sposta(Animale anim, Posizione nuovaPosizione) {
		this.rimuoviAnimale(anim);
		this.setAnimale(anim, nuovaPosizione);		
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
			if ((this.getAnimale(posizione)==null))
				return true;
			else
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
			if (this.isLibera(posizione)) 
			{
				Animale nuovoAnimale;
				if(Math.random() < PROBABILITA_CARNIVORO) 
					nuovoAnimale = new Carnivoro();
				else 
					nuovoAnimale = new Erbivoro();
				
				this.setAnimale(nuovoAnimale, posizione);
				numeroAnimali++;
			}
		}
	}
}
