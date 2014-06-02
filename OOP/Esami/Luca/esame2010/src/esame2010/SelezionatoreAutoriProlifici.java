package esame2010;
import java.util.*;

public class SelezionatoreAutoriProlifici implements Selezionatore
{
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca)
	{		
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>();
		ValueComparator bvc =  new ValueComparator(autore2libri);
        TreeMap<Autore, Set<Libro>> sorted_map = new TreeMap<Autore, Set<Libro>>(bvc);
		for(Libro libro : libriInBiblioteca)
		{
			Set<Autore> temp =  libro.getAutori();
			for(Autore autor : temp)
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
		List<Autore> res = new ArrayList<Autore>();
		res.addAll(sorted_map.keySet());
		
		return res;
	}
}

class ValueComparator implements Comparator<Autore> 
{

	Map<Autore, Set<Libro>> base;
    public ValueComparator(Map<Autore, Set<Libro>> base) 
    {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(Autore a, Autore b) 
    {
        if (base.get(a).size() >= base.get(b).size()) 
        {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
