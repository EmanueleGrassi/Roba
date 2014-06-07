package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private Partita partita;
    private Labirinto labirinto;
    private InterfacciaUtenteConsole inUtente;
    
    public DiaDia() {
    	this.partita = new Partita();
    	labirinto = this.partita.getLabirinto();
    	inUtente = new InterfacciaUtenteConsole();
    }

	public void gioca() {
		String istruzione;
		inUtente.mostraMessaggio(labirinto.getMessaggioBenvenuto());
	    		
		do		
			istruzione = inUtente.prendiIstruzione();
		while (!processaIstruzione(istruzione));
	}   
    
        
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		inUtente.mostraMessaggio(comandoDaEseguire.esegui(this.partita));
		if (this.partita.vinta())
			inUtente.mostraMessaggio("Hai vinto!");
		if (!this.partita.getGiocatore().giocatoreIsVivo())
			inUtente.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}