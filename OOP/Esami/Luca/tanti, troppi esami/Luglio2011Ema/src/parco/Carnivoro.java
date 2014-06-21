package parco;

import java.util.List;

public class Carnivoro {
	private static int FORZA_CARNIVORO = 5;
	private int anni;
	private int forza;
	private Posizione posizione;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;
	private int livelloCibo;

	public Carnivoro(){
		this(FORZA_CARNIVORO);	
	}
	
	private Carnivoro(int forza){
		this.forza = forza;
		this.livelloCibo = 2;
		this.anni = 0;
	}

	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviCarnivoro(this);
			return;
		}
		this.riproduci(territorio);	
		
		Posizione nuovaPosizione;
		Erbivoro vittimaErbivoro;
		vittimaErbivoro = cercaVittimaErbivoro(territorio);
		if (vittimaErbivoro != null) {		
			this.incrementaCibo(1);
			territorio.rimuoviErbivoro(vittimaErbivoro);
			nuovaPosizione = vittimaErbivoro.getPosizione();
		} else {
			Carnivoro vittimaCarnivoro;
			vittimaCarnivoro = cercaVittimaCarnivoro(territorio);
			if (vittimaCarnivoro != null) {		
				this.incrementaCibo(1);
				territorio.rimuoviCarnivoro(vittimaCarnivoro);
				nuovaPosizione = vittimaCarnivoro.getPosizione();
			} else {
				this.incrementaCibo(-1);
				nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
			}
		}
		if (nuovaPosizione!=null){
			territorio.sposta(this, nuovaPosizione);
		}		
		this.incrementaAnni();
	}

	private Erbivoro cercaVittimaErbivoro(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) {
			Erbivoro a = territorio.getErbivoro(p);
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	private Carnivoro cercaVittimaCarnivoro(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) {
			Carnivoro a = territorio.getCarnivoro(p);
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(this.posizione);
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Carnivoro figlio = this.creaFiglio();
			territorio.setCarnivoro(figlio, posizioneFiglio);
		}
	}

	public Carnivoro creaFiglio() {
		return new Carnivoro();
	}

	public void setPosizione(Posizione posizione){
		this.posizione = posizione;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	public int getForza() {
		return this.forza;
	}
	
	public int getAnni() {
		return this.anni;
	}
	
	public boolean isMorto(){
		return (this.livelloCibo==0)||(this.anni==5);
	}
	
	public void incrementaAnni(){
		this.anni++;
	}
	
	public void incrementaCibo(int cibo){
		this.livelloCibo+=cibo;
	}	
}

