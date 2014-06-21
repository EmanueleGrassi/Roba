package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  Paolo Merialdo
 * @see Stanza
 * @version 0.1
 *
 */
public class Attrezzo {
   private String nome;
   private int peso;

  /**
   * Crea un attrezzo
   * @param nome il nome che identifica l'attrezzo
   * @param peso il peso dell'attrezzo
   */
   public Attrezzo(String nome, int peso) {
      this.peso = peso;
      this.nome = nome;
   }

  /**
   * Restituisce il nome identificatore dell'attrezzo
   * @return il nome identificatore dell'attrezzo
   */
   public String getNome() {
      return this.nome;
   }

  /**
   * Restituisce il peso dell'attrezzo
   * @return il peso dell'attrezzo
   */
   public int getPeso() {
      return this.peso;
   }
   
   public void setPeso(int peso) {
	   this.peso = peso;
   }

   /**
	* Restituisce una rappresentazione stringa di questo attrezzo
	* @return la rappresentazione stringa
	*/
   public String toString() {
		  return this.getNome()+" ("+this.getPeso()+"kg)";
	   }
   
   public String printNome() {
		return this.nome;
	}
   
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + peso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attrezzo other = (Attrezzo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}
}
