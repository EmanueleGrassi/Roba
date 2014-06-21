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
		return this.seleziona(new SelezionatoreAutoriGiovani());
	}
	
	public Map<Autore, Set<Libro>> autore2libri() { 
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>(); 
		Set<Libro> temp;
		for (Libro lib : codice2libro.values()){
			for(Autore aut : lib.getAutori()){
				if(autore2libri.containsKey(aut)){
					temp = autore2libri.get(aut);
					temp.add(lib);
				}
				else{
					temp = new HashSet<>();
					temp.add(lib);
					autore2libri.put(aut, temp);
				}
			}
		}
		return autore2libri; 
	} 

	public List<Autore> seleziona(Selezionatore selezionatore){
		return selezionatore.eseguiSelezione((List<Libro>) codice2libro.values());
	}

} 
