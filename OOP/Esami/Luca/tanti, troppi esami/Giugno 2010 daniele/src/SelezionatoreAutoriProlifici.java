import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SelezionatoreAutoriProlifici implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> autoriProlifici = new ArrayList<>();
		for(Libro lib : libriInBiblioteca){
			for(Autore aut : lib.getAutori()){
				if(aut.getAnnoNascita()==this.getMaxLibri(libriInBiblioteca))
					if(!autoriProlifici.contains(aut))
						autoriProlifici.add(aut);
			}
		}
		return autoriProlifici;
	}
	
	private Map<Autore, Set<Libro>> autore2libri(List<Libro> libriInBiblioteca) { 
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>(); 
		Set<Libro> temp;
		for (Libro lib : libriInBiblioteca){
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
	
	private int getMaxLibri(List<Libro> lista){
		int max=0;
		for(Set<Libro> lib : this.autore2libri(lista).values()){
			if(lib.size()>max)
				max = lib.size();
		}
		return max;
	}

}
