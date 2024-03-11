package com.tresor.application.manager.carte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.domain.carte.cellule.CelluleMontagne;
import com.tresor.application.domain.carte.cellule.CelluleTresor;
import com.tresor.application.manager.domain.DomainObjectManager;

public class ClassicMapManagerImplTest {

	
	
	@Test
	public void createDomainTest() {
		String filename="carte.txt";
		String startFilePath = Paths.get("src/main/resources",filename).toFile().getAbsolutePath();
		FileReader reader = new FileReader(startFilePath);
		List<String> lines = reader.readData();
		ClassicMapManagerImpl classicMapManger= new ClassicMapManagerImpl();
		DomainObjectManager dom = classicMapManger.createDomain(lines);
		assertTrue(dom!=null);
		
		assertTrue(dom.getCarte()!=null);
		CelluleMontagne montagne = new CelluleMontagne(1,0);
		assertEquals(montagne,dom.getCarte().getCell(1, 0));
		
		CelluleTresor tresor = new CelluleTresor(0, 3);
		assertEquals(tresor,dom.getCarte().getCell(0, 3));
		
	}
	
	
	
}
