package com.tresor.carte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CarteCreationTest {

	
	
	
	@Test
	public void creationCarte() {
		
		Carte carte = new Carte(3,2);
		
		assertEquals(6, carte.getCells().size());
		
	}
	
	
	
	
	@Test
	public void creationCarteWithString() {
		
		String cLine = "C - 3 - 2";
		Carte carte = new Carte(cLine);
		
		assertNotNull(carte);
		assertEquals(6, carte.getCells().size());
		
	}
}
