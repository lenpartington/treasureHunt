package com.tresor.aventurier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tresor.application.MouvementManager;
import com.tresor.carte.Carte;
import com.tresor.carte.cellule.Cellule;

public class MouvementTest {

	
	
	
	@Test
	public void test_mouvement() {
		Carte carte = new Carte("C - 3 - 3");
		
		for (Cellule c : carte.getCells()) {
			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
		}
		carte.setMontagne("M - 0 - 0");
		assertEquals(9,carte.getCells().size());
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		MouvementManager.processMouvementA(carte, lara);
		assertEquals(1,lara.posX);
		assertEquals(2,lara.posY);
		
		
	}
	
	@Test
	public void test_mouvement_out_of_map() {
		Carte carte = new Carte("C - 3 - 2");
		
		for (Cellule c : carte.getCells()) {
			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
		}
		
		assertEquals(6,carte.getCells().size());
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		MouvementManager.processMouvementA(carte, lara);
		assertEquals(1,lara.posX);
		assertEquals(1,lara.posY);
		
		
	}
	
	@Test
	public void test_mouvement_mountagne() {
		Carte carte = new Carte("C - 3 - 3");
		
		for (Cellule c : carte.getCells()) {
			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
		}
		
		assertEquals(9,carte.getCells().size());
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		carte.setMontagne("M - 1 - 2");
		
		
		MouvementManager.processMouvementA(carte, lara);
		assertEquals(1,lara.posX);
		assertEquals(1,lara.posY);
		
		
	}
	
	
}
