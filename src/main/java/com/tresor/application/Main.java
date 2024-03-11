package com.tresor.application;

import java.nio.file.Paths;

import com.tresor.application.dataLayer.DataReader;
import com.tresor.application.dataLayer.DataWriter;
import com.tresor.application.dataLayer.file.FileReader;
import com.tresor.application.dataLayer.file.ResultFileWriter;
import com.tresor.application.manager.ApplicationManager;
import com.tresor.application.manager.input.FromAventurierInputManagerImpl;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.mapping.ClassicObjectMapperImpl;
import com.tresor.application.manager.mapping.ObjectMapper;
import com.tresor.application.manager.mouvement.CharInputMouvementManagerImpl;
import com.tresor.application.manager.mouvement.MouvementManager;
import com.tresor.application.manager.round.TourParTourRoundManagerImpl;
import com.tresor.application.manager.round.RoundManager;

public class Main {

	public static void main(String[] args) {
		String filename="carte.txt";
		runMadreDeDios(filename);
		
	}

	private static void runMadreDeDios(String filename) {
		System.out.println("Madre de dios starting...");
		String startFilePath = Paths.get("src/main/resources",filename).toFile().getAbsolutePath();
		
		DataReader dataReader = new FileReader(startFilePath);
		DataWriter dataWriter = new ResultFileWriter(filename);
		
		ObjectMapper mapManager = new ClassicObjectMapperImpl();
		InputManager inputManager = new FromAventurierInputManagerImpl();
		MouvementManager mouvementManager = new CharInputMouvementManagerImpl();
		RoundManager roundManager = new TourParTourRoundManagerImpl();
		roundManager.setMouvementManager(mouvementManager);
		roundManager.setInputManager(inputManager);
		
		
		ApplicationManager app = new ApplicationManager();
		app.setDataReader(dataReader);
		app.setDataWriter(dataWriter);
		app.setObjectMapper(mapManager);
		app.setRoundManager(roundManager);
		app.run();
	}

}
