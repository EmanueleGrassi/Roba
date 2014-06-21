package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends Comando {

	private String parametro;
	
	@Override
	public String esegui(Partita partita) {
		String s = "";
		if (this.parametro != null) {
			if (partita.getStanzaCorrente().getPersonaggio() != null) {
				Attrezzo regalo = partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro);
				if (regalo != null) 
					return partita.getStanzaCorrente().getPersonaggio().riceviRegalo(regalo, partita);
				else
					s = "Non hai questo oggetto in borsa";
			}
			else
				s = "Non c'è nessun personaggio a cui regalare questo oggetto!";
		}
		else 
			s = "Indicare quale oggetto si vuole regalare";
		return s;
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getNome() {
		return "Questo è il comando regala";
	}

}
