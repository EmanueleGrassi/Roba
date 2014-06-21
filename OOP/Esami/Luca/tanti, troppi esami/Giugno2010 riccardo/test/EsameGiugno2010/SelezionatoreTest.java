package EsameGiugno2010;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import EsameGiugno2012.Autore;
import EsameGiugno2012.Libro;
import EsameGiugno2012.SelezionatoreAutoriGiovani;
import EsameGiugno2012.selezionatoreAutoriProlifici;

public class SelezionatoreTest {
private SelezionatoreAutoriGiovani sel;
private selezionatoreAutoriProlifici sel1;
private List<Libro> libri;
private Autore a1,a2,a3,a4,a5;
private Libro l1,l2,l3;
	@Before
	public void setUp() throws Exception {
		libri= new ArrayList<>();
		a1 = new Autore("Pino",1993);
		a2 = new Autore("Gianni",1989);
		a3 = new Autore("Suset",2011);
		a4 = new Autore("Simone",1990);
		a5 = new Autore("Luca",2011);
		l1 = new Libro("NOpe");
		l2 = new Libro("Set");
		l3 = new Libro("GUN");
		l1.addAutore(a1);
		l1.addAutore(a2);
		l2.addAutore(a1);
		l3.addAutore(a1);
		l3.addAutore(a2);
		l3.addAutore(a3);
		l3.addAutore(a4);
		l3.addAutore(a5);
		sel = new SelezionatoreAutoriGiovani();
		sel1 = new selezionatoreAutoriProlifici();
		libri.add(l1);
		libri.add(l2);
		libri.add(l3);
	}
	@Test
	public void testGiovani() {
		assertEquals(false,libri.isEmpty());
		assertEquals("",sel.eseguiSelezione(libri).toString());
	}
	
	@Test
	public void testProlifici() {
		assertEquals("",sel1.eseguiSelezione(libri).toString());
	}
}
