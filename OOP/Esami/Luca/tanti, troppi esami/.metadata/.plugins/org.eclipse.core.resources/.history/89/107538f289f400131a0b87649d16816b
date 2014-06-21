package esame2010;

import java.util.*;

public class Biblioteca {
	private Map<String, Libro> codice2libro;

	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}

	public void addLibro(String codice, Libro libro) {
		this.codice2libro.put(codice, libro);
	}

	public List<Autore> autoriGiovani() {
		SelezioneAutoriGiovani sel = new SelezioneAutoriGiovani();
		return sel.eseguiSelezione((List<Libro>) codice2libro.values());
	}

	public List<Autore> seleziona(Selezionatore selezionatore) {
		return selezionatore.eseguiSelezione((List<Libro>) new ArrayList<Libro>(codice2libro.values()));
	}

	public Map<Autore, Set<Libro>> autore2libri() 
	{
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>();
		for(Libro libro : codice2libro.values())
		{
			if(libro!=null)
			{
				Set<Autore> temp =  libro.getAutori();
				for(Autore autor : temp)
				{
					if(autor!=null)
					{
						if(autore2libri.containsKey(autor))
						{
							Set<Libro> autorelibro= autore2libri.get(autor);
							autorelibro.add(libro);
						}
						else
						{
							Set<Libro> autorelibro = new HashSet<>();
							autorelibro.add(libro);
							autore2libri.put(autor, autorelibro);
						}
					}
				}
			}
			
		}		
		return autore2libri;
	}
}


