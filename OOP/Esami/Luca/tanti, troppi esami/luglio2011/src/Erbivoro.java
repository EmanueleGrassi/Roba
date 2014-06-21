

public class Erbivoro extends Animale{
	private static int FORZA_ERBIVORO = 2;

	public Erbivoro(){
		this(FORZA_ERBIVORO);	
	}	
	private Erbivoro(int forza){
		super(forza);
	}

	@Override
	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
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
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(getPosizione());
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Erbivoro figlio = this.creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}

	public Erbivoro creaFiglio() {
		return new Erbivoro();
	}

	public boolean equals(Object o)
	{
		Erbivoro temp = (Erbivoro)o;
		if(getAnni()==temp.getAnni() && getForza()==temp.getForza() && 
			getPosizione().equals(temp.getPosizione()) && getlivelloCibo() == temp.getlivelloCibo()  )
			return true;
		else
			return false;
	}	
}

