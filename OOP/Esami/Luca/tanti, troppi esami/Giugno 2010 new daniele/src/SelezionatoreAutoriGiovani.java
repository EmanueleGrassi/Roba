import java.util.ArrayList;
import java.util.List;


public class SelezionatoreAutoriGiovani implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> autoriGiovani = new ArrayList<>();
		int max = this.getAnnoNascitaMax(libriInBiblioteca);
		for(Libro lib : libriInBiblioteca){
			for(Autore aut : lib.getAutori()){
				if(aut.getAnnoNascita()==max)
					if(!autoriGiovani.contains(aut))
						autoriGiovani.add(aut);
			}
		}
		return autoriGiovani;
	}
	
	private int getAnnoNascitaMax(List<Libro> lista){
		int max=0;
		for(Libro lib : lista){
			for(Autore aut : lib.getAutori()){
				if(aut.getAnnoNascita()>max)
					max=aut.getAnnoNascita();
			}
		}
		return max;
	}

}
