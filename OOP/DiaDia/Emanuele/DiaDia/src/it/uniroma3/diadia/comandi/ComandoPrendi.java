package it.uniroma3.diadia.comandi;



import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends Comando {

	String oggettoDaPrendere;
	
	/*
	 * se è stato inserito un parametro corretto questo metodo prende l'oggetto
	 * @see it.uniroma3.diadia.comandi.Comando#esegui(it.uniroma3.diadia.Partita)
	 */
	public void esegui(Partita partita) {
		if(oggettoDaPrendere==null)
			 System.out.println("Quale attrezzo vuoi prendere?");
		Attrezzo[] temp = partita.getStanzaCorrente().getAttrezzi();
		for (Attrezzo a : temp){
			if (a != null)
				if (a.getNome().equals(oggettoDaPrendere)){
					partita.getGiocatore().getBorsa().addAttrezzo(a);
					partita.getStanzaCorrente().removeAttrezzo(a);
					System.out.println("Oggetto messo nella borsa. Cosa vuoi fare ora?");
					return;
				}
		}
		System.out.println("Oggetto non raccolto. Cosa vuoi fare ora?");
	}
	
	@Override
	public void setParametro(String parametro) {
		this.oggettoDaPrendere = parametro;
	}

	@Override
	public String getParametro() {
		return this.oggettoDaPrendere;
	}

	public String getNome() {
		return "questo è il comando prendi";
	}
}
