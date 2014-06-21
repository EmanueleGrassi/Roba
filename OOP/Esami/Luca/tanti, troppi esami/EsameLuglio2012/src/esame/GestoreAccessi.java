package esame;

public class GestoreAccessi {
	
	static public boolean haPermesso(Utente utente, Archivio doc, String nomePermesso) {
		return (doc.getPermessoAccesso(nomePermesso).haPermesso(utente));
	}		
}
