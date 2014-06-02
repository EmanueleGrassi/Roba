package esame2010;
import java.util.*;

public class SelezioneAutoriGiovani implements Selezionatore
{
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca)
	{		
		int piùGiovane=0;
		for(Libro item : libriInBiblioteca)
		{
			Set<Autore> temp =  item.getAutori();
			for(Autore aut : temp)
			{
				if(aut.getAnnoNascita()>=piùGiovane)
					piùGiovane=aut.getAnnoNascita();
			}
		}
		
		List<Autore> res = new ArrayList<Autore>();
		for(Libro item : libriInBiblioteca)
		{
			Set<Autore> temp =  item.getAutori();
			for(Autore aut : temp)
			{
				if(aut.getAnnoNascita()==piùGiovane)
				{
					res.add(aut);
				}
			}
		}		
		return res;
	}
}
