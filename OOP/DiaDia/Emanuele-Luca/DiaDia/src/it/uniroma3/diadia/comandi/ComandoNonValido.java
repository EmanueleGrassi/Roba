package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends Comando {

	private static final String DEFAULT = "Comando non valido";
	private String parametro;
	
	public String esegui(Partita partita) {
		String s = (parametro == null) ? DEFAULT : this.parametro;
		return s;
	}

	public String getNome() {
		return "questo è un comando non valido";
	}
	
	@Override
	public void setParametro(String param) {
		this.parametro = param;
	}
}
