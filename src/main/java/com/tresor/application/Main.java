package com.tresor.application;

import com.tresor.application.dataLayer.DataReader;
import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.manager.ApplicationManager;
import com.tresor.application.manager.input.FromAventurierInputManagerImpl;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.mapping.ClassicObjectMapperImpl;
import com.tresor.application.manager.mapping.ObjectMapper;
import com.tresor.application.manager.mouvement.CharInputMouvementManagerImpl;
import com.tresor.application.manager.mouvement.MouvementManager;
import com.tresor.application.manager.turn.TourParTourTurnManagerImpl;
import com.tresor.application.manager.turn.TurnManager;

public class Main {

	public static void main(String[] args) {
		String fileName="carte.txt";
		
		DataReader dataReader = new FileReader(fileName);
		ObjectMapper mapManager = new ClassicObjectMapperImpl();
		InputManager inputManager = new FromAventurierInputManagerImpl();
		MouvementManager mouvementManager = new CharInputMouvementManagerImpl();
		TurnManager turnManager = new TourParTourTurnManagerImpl();
		turnManager.setMouvementManager(mouvementManager);
		turnManager.setInputManager(inputManager);
		
		
		ApplicationManager app = new ApplicationManager();
		app.setDataReader(dataReader);
		app.setMapManager(mapManager);
		app.setTurnManager(turnManager);
		
		
	}

}
