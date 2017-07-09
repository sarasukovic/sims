package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import electricalElements.Inductor;
import electricalElements.Resistor;
import paket.Editor;
import paket.Element;

// Bojana Ivanovic sw5/2015

public class TestClass {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// checkId proverava da li je atribut id null
	@Test
	public void testCheckId() {
		Editor e = new Editor();
		Element res = new Resistor("images/resistor.png");
		assertTrue("Vraca true jer je null, nema id", e.checkId(res));
		
		Element ind = new Inductor("images/inductor.png");
		ind.setId("L5");
		assertFalse("Vraca false jer postoji id", e.checkId(ind));
	}

	// checkParam proverava da li je atribut param null
	@Test
	public void testCheckParam() {
		Element e = new Resistor("images/resistor.png");
		Editor editor = new Editor();
		assertTrue("Vraca true jer nema parametara", editor.checkParam(e));
		
		Element ind = new Inductor("images/inductor.png");
		((Inductor) ind).setInductance(50);
		assertFalse("Vraca false, postoje parametri", editor.checkParam(ind));
	}
	


}
