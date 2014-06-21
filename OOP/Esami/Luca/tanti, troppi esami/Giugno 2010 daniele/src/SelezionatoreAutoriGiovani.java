import java.util.ArrayList;
import java.util.List;


public class SelezionatoreAutoriGiovani implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> autoriGiovani = new ArrayList<>();
		for(Libro lib : libriInBiblioteca){
			for(Autore aut : lib.getAutori()){
				if(aut.getAnnoNascita()==this.getAnnoNascitaMax(libriInBiblioteca))
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
