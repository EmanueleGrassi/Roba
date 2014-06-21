package test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import esame.Documento;
import esame.PermessoAccesso;
import esame.Utente;
import esame.Utility;

public class UtilityTest {
	List<Documento> docs, docsPrivate;
	Map<Utente, List<Documento>> test;
	PermessoAccesso permessoPublic = new PermessoAccesso("public");
	PermessoAccesso permessoPrivate = new PermessoAccesso("private");


	@Before
	public void setUp() throws Exception {
		docs = new ArrayList<Documento>();
		Utente marco = new Utente("Marco");
		Utente giovanni = new Utente("giovanni");
		Utente paolo = new Utente("paolo");
		
		permessoPublic.addUtente(marco);
		permessoPublic.addUtente(paolo);
		
		permessoPrivate.addUtente(giovanni);
		permessoPrivate.addUtente(paolo);

		
		docs.add(new Documento("helloWorld", 5, "13/06/2014", permessoPublic));
		docs.add( new Documento("test", 5, "24/05/2014", permessoPublic));
		docs.add( new Documento("libro", 5, "11/05/2014", permessoPublic));
		
		Documento d1p =  new Documento("esame", 5, "8/06/2014", permessoPrivate);
		Documento d2p =  new Documento("cose", 5, "6/05/2014", permessoPrivate);
		Documento d3p = new Documento("vacanza", 5, "5/06/2014", permessoPrivate);
		docsPrivate = new ArrayList<Documento>();
		docsPrivate.add(d1p);
		docsPrivate.add(d2p);
		docsPrivate.add(d3p);
		docs.addAll(docsPrivate);		
		
		test = new HashMap<Utente, List<Documento>>();
		test.put(paolo, docsPrivate);
		test.put(giovanni, docsPrivate);

	}

	@Test
	public void testutente2docsutente2docsTest() {
		assertEquals(test, Utility.utente2docs(docs, "private"));
	}
	@Test
	public void testutente2docsutente2docsPermessoNonEsistenteTest() {
		assertEquals(new HashMap<Utente, List<Documento>>(), Utility.utente2docs(docs, "protected"));
	}
	@Test
	public void testutente2docsutente2docsNullDocsTest() {
		assertEquals(new HashMap<Utente, List<Documento>>(), Utility.utente2docs(null, "protected"));
	}
}
