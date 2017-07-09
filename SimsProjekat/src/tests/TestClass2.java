package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import electricalElements.Resistor;
import paket.Editor;
import paket.Element;

public class TestClass2 {
	//Sara Sukovic sw4

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

	@Test
	public void testCheckPosition() {
		Editor ed = new Editor();
		Element e1 = new Resistor("images/resistor.png");
		e1.setX(60);
		e1.setY(60);
		e1.rect.x=30;
		e1.rect.y=30;
		ed.panel.getElements().add(e1);
		
		Element e2 = new Resistor("images/resistor.png");
		e2.setX(300);
		e2.setY(300);
		e2.rect.x=270;
		e2.rect.y=270;
		ed.panel.getElements().add(e2);
		
		Element e3 = new Resistor("images/resistor.png");
		e3.setX(200);
		e3.setY(200);
		e3.rect.x=170;
		e3.rect.y=170;
		ed.panel.getElements().add(e3);
		
		
		//element koji se ubacuje na panel preko drugog, funkcija bi trebalo da vrati false
		Element e4 = new Resistor("images/resistor.png");
		e4.setX(201);
		e4.setY(201);
		e4.rect.x=171;
		e4.rect.y=171;
		ed.panel.getElements().add(e4);
		
		assertTrue("Vraca true jer se novi element poreklapa sa elementom na panelu", ed.checkPosition(e4) );
		
		
		//element koji se ubacuje na panel i ne poklapa se, funkcija bi trebalo da vrati true
		Element e5 = new Resistor("images/resistor.png");
		e5.setX(400);
		e5.setY(400);
		e5.rect.x=370;
		e5.rect.y=370;
		ed.panel.getElements().add(e5);
		
		assertFalse("Vraca false jer se novi element ne poreklapa sa ostalima", ed.checkPosition(e5) );
		
	}

	@Test
	public void testCheckPositionMove() {
	
		Editor ed = new Editor();
		Element e1 = new Resistor("images/resistor.png");
		e1.setX(60);
		e1.setY(60);
		e1.rect.x=30;
		e1.rect.y=30;
		ed.panel.getElements().add(e1);
		
		Element e2 = new Resistor("images/resistor.png");
		e2.setX(300);
		e2.setY(300);
		e2.rect.x=270;
		e2.rect.y=270;
		ed.panel.getElements().add(e2);
		
		Element e3 = new Resistor("images/resistor.png");
		e3.setX(200);
		e3.setY(200);
		e3.rect.x=170;
		e3.rect.y=170;
		ed.panel.getElements().add(e3);
		
		
		//element se pomerio preko drugog, funkcija bi trebalo da vrati false
		Element e4 = new Resistor("images/resistor.png");
		e4.setX(201);
		e4.setY(201);
		e4.rect.x=170;
		e4.rect.y=170;
		ed.panel.getElements().add(e4);
		
		assertTrue("Vraca true jer se novi element poreklapa sa elementom na panelu", ed.checkPositionMove(e4) );
		
		
		//element se pomerio i ne poklapa se, funkcija bi trebalo da vrati true
		Element e5 = new Resistor("images/resistor.png");
		e5.setX(400);
		e5.setY(400);
		e5.rect.x=370;
		e5.rect.y=370;
		ed.panel.getElements().add(e5);
		
		
		assertFalse("Vraca false jer se novi element ne poreklapa sa ostalima", ed.checkPositionMove(e5) );
		
	
	}

}
