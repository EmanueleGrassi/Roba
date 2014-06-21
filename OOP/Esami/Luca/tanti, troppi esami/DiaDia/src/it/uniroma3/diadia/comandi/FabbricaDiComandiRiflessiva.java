package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();// seconda parola: eventuale parametro
		try {
			StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
			nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
			nomeClasse.append(nomeComando.substring(1));
			comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
			comando.setParametro(parametro);
		} catch (Exception | NoClassDefFoundError e) {
			comando = new ComandoNonValido();
			comando.setParametro("Comando inesistente");
		}
		scannerDiParole.close();
		return comando;
	}
}