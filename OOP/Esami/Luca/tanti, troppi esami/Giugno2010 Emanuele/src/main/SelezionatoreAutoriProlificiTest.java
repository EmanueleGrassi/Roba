package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class SelezionatoreAutoriProlificiTest {

	List<Libro> list;
	SelezionatoreAutoriProlifici sel;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<>();
		Libro l = new Libro("Basi di dati");
		Autore a = new Autore("Azteni", 1);
		l.addAutore(a);
		a = new Autore("Torlone",1);
		l.addAutore(a);
		list.add(l);
		l = new Libro("Fondamenti di informatica");
		a = new Autore("Cabibbo", 1);
		l.addAutore(a);
		list.add(l);
		l = new Libro("Analisi del sw");
		l.addAutore(a);
		list.add(l);
		l = new Libro("Teoria delle basi di dati");
		a = new Autore("Azteni", 1);
		l.addAutore(a);
		list.add(l);
		sel = new SelezionatoreAutoriProlifici();
	}

	@Test
	public void test() {
		assertEquals("[Azteni, Cabibbo]", sel.eseguiSelezione(list).toString());
	}

}
