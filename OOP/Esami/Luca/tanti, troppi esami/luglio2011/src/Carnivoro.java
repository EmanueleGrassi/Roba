

import java.util.List;

public class Carnivoro extends Animale {
	private static int FORZA_CARNIVORO = 5;

	public Carnivoro(){
		this(FORZA_CARNIVORO);	
	}
	
	private Carnivoro(int forza)
	{
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
		Animale vittima = cercaVittimaAnimale(territorio);
		if (vittima != null) 
		{		
			this.incrementaCibo(1);
			territorio.rimuoviAnimale(vittima);
			nuovaPosizione = vittima.getPosizione();
		}
		else 
		{
			this.incrementaCibo(-1);
			nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		}
		if (nuovaPosizione!=null)
			territorio.sposta(this, nuovaPosizione);
		this.incrementaAnni();
	}


	private Carnivoro cercaVittimaAnimale(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) 
		{
			if(territorio.getAnimale(p) instanceof Carnivoro)
			{
				Carnivoro a = (Carnivoro) territorio.getAnimale(p);
				if ((a!=null) && (this.getForza()>a.getForza())) 
					return a;
			}
		}
		return null;
	}

	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(getPosizione());
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Carnivoro figlio = this.creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}

	public Carnivoro creaFiglio() 
	{
		return new Carnivoro();
	}
	public boolean equals(Object o)
	{
		Carnivoro temp = (Carnivoro)o;
		if(getAnni()==temp.getAnni() && getForza()==temp.getForza() && 
			getPosizione().equals(temp.getPosizione()) && getlivelloCibo() == temp.getlivelloCibo()  )
			return true;
		else
			return false;
	}
}

