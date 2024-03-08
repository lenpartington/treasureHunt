package com.tresor.application.domain.carte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tresor.application.domain.carte.cellule.CelluleTresor;

public class CelluleTresorTest {

	
	
	
	
	
	@Test
	public void createTresor() {
		String tresorLine="T - 0 - 3 - 2";	
		CelluleTresor ctresor = new CelluleTresor(tresorLine);
			assertEquals("T", ctresor.getType());
			assertEquals(2, ctresor.getNombreTresor());
	}
	
	
}
