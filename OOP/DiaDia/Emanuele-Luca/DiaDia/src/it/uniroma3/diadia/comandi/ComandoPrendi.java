package it.uniroma3.diadia.comandi;



import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends Comando {

	String oggettoDaPrendere;
	
	/*
	 * se è stato inserito un parametro corretto questo metodo prende l'oggetto
	 * @see it.uniroma3.diadia.comandi.Comando#esegui(it.uniroma3.diadia.Partita)
	 */
	public String esegui(Partita partita) {
		String s = "";
		if(this.oggettoDaPrendere==null) {
			 s = "Quale attrezzo vuoi prendere?";
			 return s;
		}
		Attrezzo[] temp = partita.getStanzaCorrente().getAttrezzi();
		for (Attrezzo a : temp){
			if (a != null)
				if (a.getNome().equals(this.oggettoDaPrendere)){
					if (partita.getGiocatore().getBorsa().addAttrezzo(a)) {
						partita.getStanzaCorrente().removeAttrezzo(a);
						s = "Oggetto messo nella borsa. Cosa vuoi fare ora?";
					}
					else {
						s = "Oggetto non raccolto. Cosa vuoi fare ora?";
					}
				}
		}
		return s = (s == "") ? "Oggetto non trovato!" : s;
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
