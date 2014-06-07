package parco;

public class Erbivoro {
	private static int FORZA_ERBIVORO = 2;
	private int anni;
	private int forza;
	private Posizione posizione;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;
	private int livelloCibo;

	public Erbivoro(){
		this(FORZA_ERBIVORO);	
	}
	
	private Erbivoro(int forza){
		this.forza = forza;
		this.livelloCibo = 2;
		this.anni = 0;
	}

	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviErbivoro(this);
			return;
		}
		this.riproduci(territorio);

		Posizione nuovaPosizione;
		nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			this.incrementaCibo(1);
			territorio.sposta(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.incrementaAnni();
	}
	
	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(this.posizione);
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Erbivoro figlio = this.creaFiglio();
			territorio.setErbivoro(figlio, posizioneFiglio);
		}
	}

	public Erbivoro creaFiglio() {
		return new Erbivoro();
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
		this.anni ++;
	}
	
	public void incrementaCibo(int cibo){
		this.livelloCibo+=cibo;
	}
}

