package com.tresor.application.manager;

import org.junit.Test;

import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.manager.carte.ClassicMapManagerImpl;
import com.tresor.application.manager.input.FromAventurierInputManagerImpl;
import com.tresor.application.manager.turn.TourParTourParOrdreCreationTurnManagerImpl;

public class ApplicationManagerTest {

	
	@Test
	public void run() {
		
		ApplicationManager am = new ApplicationManager();
		am.setDataReader(new FileReader("carte2Aventuriers.txt"));
		am.setMapManager(new ClassicMapManagerImpl());
		am.setTurnManager(new TourParTourParOrdreCreationTurnManagerImpl());
		am.setInputManager(new FromAventurierInputManagerImpl());
		
		
		am.run();
	}
	
}
