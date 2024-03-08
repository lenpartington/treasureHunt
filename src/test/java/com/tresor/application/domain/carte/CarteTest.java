package com.tresor.application.domain.carte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.tresor.application.domain.carte.cellule.Cellule;
import com.tresor.application.domain.carte.cellule.CelluleMontagne;
import com.tresor.application.domain.carte.cellule.CelluleTresor;

public class CarteTest {

	@Test
	public void creationCarte() {

		Carte carte = new Carte(3, 2);

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
		Cellule expected = new Cellule(1, 1);
		assertEquals(expected, result);
	}

	@Test
	public void setMontagne() {
		Carte carte = new Carte("C - 3 - 2");

//		for (Cellule c : carte.getCells()) {
//			System.out.println("cell x:" + c.getPosX() + ", y:" + c.getPosY());
//		}

		assertEquals(6, carte.getCells().size());
		CelluleMontagne montagne = new CelluleMontagne("M - 1 - 0");

		carte.setCell(montagne);
		CelluleMontagne expected = new CelluleMontagne(1, 0);
		assertEquals(expected, carte.getCell(1, 0));

	}

	

	@Test
	public void carte_with_tresor() {
		Carte carte = new Carte("C - 3 - 2");

//		for (Cellule c : carte.getCells()) {
//			System.out.println("cell x:" + c.getPosX() + ", y:" + c.getPosY() +" , type:"+c.getType());
//		}

		assertEquals(6, carte.getCells().size());
		CelluleTresor tresor = new CelluleTresor("T - 1 - 0 - 2");
		carte.setCell(tresor);
		CelluleTresor expected = new CelluleTresor(1, 0);
		expected.setNombreTresor(2);
		assertEquals(expected, carte.getCell(1, 0));
		assertEquals(2, carte.getCell(1, 0).getNombreTresor());
	

	}

}
