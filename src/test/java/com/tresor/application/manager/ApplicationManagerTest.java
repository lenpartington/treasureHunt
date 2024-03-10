package com.tresor.application.manager;

import org.junit.Test;

import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.dataLayer.file.ResultFileWriter;
import com.tresor.application.manager.carte.ClassicMapManagerImpl;
import com.tresor.application.manager.input.FromAventurierInputManagerImpl;
import com.tresor.application.manager.mouvement.CharInputMouvementManagerImpl;
import com.tresor.application.manager.turn.TourParTourTurnManagerImpl;

public class ApplicationManagerTest {

	
	@Test
	public void run() {
		String filename="carte.txt";
		ApplicationManager am = new ApplicationManager();
		am.setDataReader(new FileReader(filename));
		am.setMapManager(new ClassicMapManagerImpl());
		am.setTurnManager(new TourParTourTurnManagerImpl());
		am.getTurnManager().setInputManager(new FromAventurierInputManagerImpl() );
		am.getTurnManager().setMouvementManager(new CharInputMouvementManagerImpl());
		am.setDataWriter(new ResultFileWriter(filename));
		am.run();
		
		
	}
	
}
