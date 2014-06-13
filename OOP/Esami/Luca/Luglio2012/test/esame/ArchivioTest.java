package esame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArchivioTest {

	Cartella a;
	Documento jolly;
	
	@Before
	public void setUp() throws Exception {
		PermessoAccesso pa = new PermessoAccesso("admin");
		a = new Cartella("root", "12nj3", pa);
		Cartella b = new Cartella("costi","123", pa);
		Documento special = new Documento("spec",2,"123", pa);
		Documento speciale = new Documento("spec2",2,"123", pa);
		a.addDocumento(speciale);
		b.addDocumento(special);
		a.addDocumento(b);
		jolly = new Documento("jolly", 1, "123", pa);
		a.addDocumento(jolly);
		jolly = new Documento("jolly2", 1, "234", pa);
		a.addDocumento(jolly);		
	}

	@Test
	public void testArchiviCreatiIl() {
		assertEquals("", a.archiviCreatiIl("123").toString());
	}

}
