package com.tresor.carte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.tresor.carte.cellule.Cellule;

public class CarteTest {

	
	
	
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
	
	@Test
	public void getCell() {
		String cLine = "C - 3 - 2";
		Carte carte = new Carte(cLine);
		
		assertNotNull(carte);
		assertEquals(6, carte.getCells().size());
		Cellule result = carte.getCell(1, 1);
		Cellule expected = new Cellule(1 , 1);
		assertEquals(expected, result);
	}
}
