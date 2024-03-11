package com.tresor.application.manager;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.dataLayer.file.ResultFileWriter;
import com.tresor.application.manager.input.FromAventurierInputManagerImpl;
import com.tresor.application.manager.mapping.ClassicObjectMapperImpl;
import com.tresor.application.manager.mouvement.CharInputMouvementManagerImpl;
import com.tresor.application.manager.round.TourParTourRoundManagerImpl;

public class ApplicationManagerTest {

	
	@Test
	public void run() {
		String filename="carte.txt";
		String startFilePath = Paths.get("src/main/resources",filename).toFile().getAbsolutePath();
		

		ApplicationManager am = new ApplicationManager();
		FileReader fr = new FileReader(startFilePath);
		am.setDataReader(fr);
		am.setMapManager(new ClassicObjectMapperImpl());
		am.setTurnManager(new TourParTourRoundManagerImpl());
		am.getTurnManager().setInputManager(new FromAventurierInputManagerImpl() );
		am.getTurnManager().setMouvementManager(new CharInputMouvementManagerImpl());
		am.setDataWriter(new ResultFileWriter(filename));
		am.run();
		
		String endFilePath = Paths.get("target","test-classes/result_carte.txt").toFile().getAbsolutePath();
		System.out.println("URI = "+Paths.get("target","test-classes/result_carte.txt").toFile().toURI());
		fr = new FileReader(endFilePath);
		List<String> lines = fr.readData();
		System.out.println(lines.size());
		assertEquals("C - 3 - 4", lines.get(0));
		assertEquals("M - 1 - 0",lines.get(1));
		assertEquals("M - 2 - 1",lines.get(2));
		System.out.println(lines.get(3));
		String tresor = "# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}";
		assertEquals(tresor,lines.get(3));
		assertEquals("T - 1 - 3 - 2",lines.get(4));
		String aventurier = "# {A comme Aventurier} - {Nom de l'aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}";
		assertEquals(aventurier,lines.get(5));
		assertEquals("A - Lara - 0 - 3 - S - 3",lines.get(6));
	}
	
}
