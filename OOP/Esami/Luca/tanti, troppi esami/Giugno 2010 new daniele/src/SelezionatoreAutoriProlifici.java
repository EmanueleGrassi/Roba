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
		int max=0;
		Map<Autore, Set<Libro>> autore2libri = this.autore2libri(libriInBiblioteca);
		for(Set<Libro> lib : autore2libri.values()){
			if(lib.size()>max)
				max = lib.size();
		}
		for(Autore aut : autore2libri.keySet()){
			if(autore2libri.get(aut).size()==max)
				autoriProlifici.add(aut);
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


}
