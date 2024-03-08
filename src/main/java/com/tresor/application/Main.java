package com.tresor.application;

import com.tresor.application.dataLayer.DataReader;
import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.manager.carte.ClassicMapManagerImpl;
import com.tresor.application.manager.carte.MapManager;
import com.tresor.application.manager.input.FromAventurierInputManagerImpl;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.turn.TourParTourParOrdreCreationTurnManagerImpl;
import com.tresor.application.manager.turn.TurnManager;

public class Main {

	public static void main(String[] args) {
		String fileName="carte.txt";
		
		DataReader dataReader = new FileReader(fileName);
		
		MapManager mapManager = new ClassicMapManagerImpl();
		
		TurnManager turnManager = new TourParTourParOrdreCreationTurnManagerImpl();
		
		InputManager inputManager = new FromAventurierInputManagerImpl();
		
		
	}

}
