package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class Utilit‡Test {

	private Attrezzo chiave, lanterna, osso;
	private Set<Attrezzo> setVuoto, setPieno;
	private List<Attrezzo> listVuota, listPiena;
	private Map<Integer, Set<Attrezzo>> mapVuota, mapPiena;
	
	@Before
	public void setUp() throws Exception {
		this.chiave = new Attrezzo("chiave", 1);
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		
		this.setVuoto = new HashSet<Attrezzo>();
		this.setPieno = new HashSet<Attrezzo>();
		this.setPieno.add(chiave);
		this.setPieno.add(lanterna);
		
		this.listVuota = new ArrayList<Attrezzo>();
		this.listPiena = new ArrayList<Attrezzo>();
		this.listPiena.add(chiave);
		this.listPiena.add(lanterna);
		
		this.mapVuota = new HashMap<Integer, Set<Attrezzo>>();
		this.mapPiena = new HashMap<Integer, Set<Attrezzo>>();
		
		Set<Attrezzo> tmp;
		Set<Attrezzo> attrezzi = new HashSet<Attrezzo>();
		attrezzi.add(chiave);
		attrezzi.add(lanterna);
		attrezzi.add(osso);
		
		for (Attrezzo attr : attrezzi) {
			tmp = this.mapPiena.get(attr.getPeso());
			if (tmp == null)
				tmp = new HashSet<Attrezzo>();
			tmp.add(attr);
			this.mapPiena.put(attr.getPeso(), tmp);
		}
		
	}

	@Test
	public void testPrintSetVuoto() {
		assertEquals("nessun attrezzo.", Utilit‡.printSet(this.setVuoto));
	}
	
	@Test
	public void testPrintSetPieno1() {
		assertEquals("{chiave, lanterna}", Utilit‡.printSet(this.setPieno));
	}
	
	@Test
	public void testPrintSetPieno2() {
		assertNotEquals("nessun attrezzo.", Utilit‡.printSet(this.setPieno));
	}

	@Test
	public void testPrintListVuota() {
		assertEquals("nessun attrezzo.", Utilit‡.printList(this.listVuota));
	}

	@Test
	public void testPrintListPiena1() {
		assertEquals("[chiave, lanterna]", Utilit‡.printList(this.listPiena));
	}
	
	@Test
	public void testPrintListPiena2() {
		assertNotEquals("nessun attrezzo.", Utilit‡.printList(this.listPiena));
	}
	
	@Test
	public void testPrintMapVuota() {
		assertEquals("nessun attrezzo.", Utilit‡.printMap(this.mapVuota));
	}
	
	@Test
	public void testPrintMapPiena1() {
		assertEquals("(1, {chiave, osso} ), (3, {lanterna} )", Utilit‡.printMap(this.mapPiena));
	}
	
	@Test
	public void testPrintMapPiena2() {
		assertNotEquals("nessun attrezzo.", Utilit‡.printMap(this.mapPiena));
	}

}
