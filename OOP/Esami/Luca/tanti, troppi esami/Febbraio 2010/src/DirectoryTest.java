import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class DirectoryTest {
	Directory dir;

	@Before
	public void setUp() throws Exception {
		dir = new Directory("casa", new Utente("Luca"));
	}

	@Test
	public void testConcediPermesso() {

		dir.concediPermesso(new Permesso("lettura"), new Utente("marco"));
		assertTrue(dir.haIlPermesso(new Permesso("lettura"),
				new Utente("marco")));
	}
	@Test
	public void testConcediPermessoNull() {

		dir.concediPermesso(null, new Utente("marco"));
		assertFalse(dir.haIlPermesso(new Permesso("lettura"), new Utente(
				"marco")));
	}
	@Test
	public void testConcediPermessoMultipli() {

		dir.concediPermesso(new Permesso("lettura"), new Utente("marco"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("marco"));
		dir.concediPermesso(new Permesso("eliminazione"), new Utente("marco"));

		assertTrue(dir.haIlPermesso(new Permesso("lettura"),
				new Utente("marco")));
		assertTrue(dir.haIlPermesso(new Permesso("scrittura"), new Utente(
				"marco")));
		assertTrue(dir.haIlPermesso(new Permesso("eliminazione"), new Utente(
				"marco")));
	}

	@Test
	public void testPermessiDi() {
		List<Permesso> pp = new LinkedList<>();
		pp.add(new Permesso("lettura"));
		pp.add(new Permesso("scrittura"));
		dir.concediPermesso(new Permesso("lettura"), new Utente("marco"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("Giovanni"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("marco"));		
		assertEquals(pp, dir.permessiDi(new Utente("marco")));
	}
	@Test
	public void testPermessiDiNull() {
		List<Permesso> pp = new LinkedList<>();
		dir.concediPermesso(new Permesso("lettura"), new Utente("marco"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("marco"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("Giovanni"));
		assertEquals(pp, dir.permessiDi(null));
	}
	@Test
	public void testPermessiDiNoPermessi() {
		List<Permesso> pp = new LinkedList<>();
		dir.concediPermesso(new Permesso("lettura"), new Utente("marco"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("Giovanni"));
		dir.concediPermesso(new Permesso("scrittura"), new Utente("marco"));
		assertEquals(pp, dir.permessiDi(new Utente("Aldo")));
	}

}
