package com.tresor.application.manager.mouvement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.carte.Carte;
import com.tresor.application.domain.carte.cellule.CelluleMontagne;
import com.tresor.application.domain.carte.cellule.CelluleTresor;
import com.tresor.application.manager.domain.ClassicDomainManagerImpl;
import com.tresor.application.manager.domain.DomainObjectManager;

public class MouvementTest {

	
	
	
	@Test
	public void test_mouvement() {
		Carte carte = new Carte("C - 3 - 3");
		
//		for (Cellule c : carte.getCells()) {
//			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
//		}
		CelluleMontagne montagne = new CelluleMontagne("M - 0 - 0");
		carte.setCell(montagne);
		assertEquals(9,carte.getCells().size());
		
		
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		
		DomainObjectManager domain=new ClassicDomainManagerImpl();
		domain.setCarte(carte);
		CharInputMouvementManagerImpl mouvementManager =new CharInputMouvementManagerImpl () ;
		mouvementManager.processMouvementA(domain, lara);
		assertEquals(1,lara.getPosX());
		assertEquals(2,lara.getPosY());
		
		
	}
	
	@Test
	public void test_mouvement_out_of_map() {
		Carte carte = new Carte("C - 3 - 2");
		
//		for (Cellule c : carte.getCells()) {
//			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
//		}
		
		assertEquals(6,carte.getCells().size());
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		DomainObjectManager domain=new ClassicDomainManagerImpl();
		domain.setCarte(carte);
		CharInputMouvementManagerImpl mouvementManager =new CharInputMouvementManagerImpl () ;
		mouvementManager.processMouvementA(domain, lara);
		assertEquals(1,lara.getPosX());
		assertEquals(1,lara.getPosY());
		
		
	}
	
	@Test
	public void test_mouvement_mountagne() {
		Carte carte = new Carte("C - 3 - 3");
		
//		for (Cellule c : carte.getCells()) {
//			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
//		}
		
		assertEquals(9,carte.getCells().size());
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		CelluleMontagne montagne = new CelluleMontagne("M - 1 - 2");
		carte.setCell(montagne);
		
		DomainObjectManager domain=new ClassicDomainManagerImpl();
		domain.setCarte(carte);
		CharInputMouvementManagerImpl mouvementManager =new CharInputMouvementManagerImpl () ;
		mouvementManager.processMouvementA(domain, lara);
		
		assertEquals(1,lara.getPosX());
		assertEquals(1,lara.getPosY());
		
		
	}
	
	@Test
	public void test_aventurier_tresor() {
		Carte carte = new Carte("C - 3 - 3");
		
//		for (Cellule c : carte.getCells()) {
//			System.out.println("cell x:"+c.getPosX()+", y:"+c.getPosY());
//		}
		assertEquals(9,carte.getCells().size());
		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		assertEquals("A", lara.getMouvement());
		CelluleTresor tresor = new CelluleTresor("T - 1 - 2 - 2");
		carte.setCell(tresor);
		
		DomainObjectManager domain=new ClassicDomainManagerImpl();
		domain.setCarte(carte);
		CharInputMouvementManagerImpl mouvementManager =new CharInputMouvementManagerImpl () ;
		mouvementManager.processMouvementA(domain, lara);
		
		assertEquals(1,lara.getPosX());
		assertEquals(2,lara.getPosY());
		assertEquals(1,carte.getCell(1, 2).getNombreTresor());
		assertEquals(1,lara.getNombreTresor());
		
	}
	

	@Test
	public void test_aventurier_aventurier() {
		Carte carte = new Carte("C - 3 - 3");

		Aventurier lara = new Aventurier("A - Lara - 1 - 1 - S - A");
		Aventurier indiana = new Aventurier("A - Indiana - 1 - 2 - S - A");
		
		DomainObjectManager domain=new ClassicDomainManagerImpl();
		domain.setCarte(carte);
		domain.getAventuriers().add(indiana);
		domain.getAventuriers().add(lara);
		
		CharInputMouvementManagerImpl mouvementManager =new CharInputMouvementManagerImpl () ;
		mouvementManager.processMouvementA(domain, lara);
		
		assertEquals(1,lara.getPosX());
		assertEquals(1,lara.getPosY());
		
	}
	
}
