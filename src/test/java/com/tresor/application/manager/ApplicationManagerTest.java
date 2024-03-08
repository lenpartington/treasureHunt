package com.tresor.application.manager;

import org.junit.Test;

import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.manager.carte.ClassicMapManagerImpl;

public class ApplicationManagerTest {

	
	@Test
	public void run() {
		
		ApplicationManager am = new ApplicationManager();
		am.setDataReader(new FileReader("carte.txt"));
		am.setMapManager(new ClassicMapManagerImpl());
		
		
		
		am.run();
	}
	
}
