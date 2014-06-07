package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String attrezzoPerSbloccare;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoPerSbloccare) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoPerSbloccare = attrezzoPerSbloccare;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(this.attrezzoPerSbloccare))
			return null;
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
        return this.toString();
    }
	
	@Override
	public String toString() {
		String s = new String();
    	s += this.getNome();
    	s += "\nUscite: ";
    	for (String direzione : this.getDirezioni())
    		if (direzione!=null) {
    			if (!this.hasAttrezzo(attrezzoPerSbloccare)) {   //se non ho l'attrezzo
    				if(!direzione.equals(this.direzioneBloccata))  //blocca una direzione
    					s += " " + direzione;
    			}
    			else {  //altrimenti
    				s += " " + direzione;
    			}
    		}
    			
    	s += "\nAttrezzi nella stanza: ";
    	
    	for (Attrezzo attrezzo : this.getAttrezzi()) 
    		if (attrezzo != null)
    			s += attrezzo.toString()+" ";
    	
    	if (!this.hasAttrezzo(attrezzoPerSbloccare))
    		s += "\nMa potrebbero esserci altre uscite nascoste...chissà";
    	
    	return s;
	}
	
}
