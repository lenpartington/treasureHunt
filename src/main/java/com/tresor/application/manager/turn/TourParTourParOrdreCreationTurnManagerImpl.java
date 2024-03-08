package com.tresor.application.manager.turn;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.InputManager;

public class TourParTourParOrdreCreationTurnManagerImpl implements TurnManager {

	private InputManager inputManager;
	private DomainObjectManager domainObjects;
	private int tour = 0;

	private boolean isFinished;
	
	@Override
	public void run(InputManager inputManager, DomainObjectManager domainObjects) {
		this.domainObjects = domainObjects;
		this.inputManager = inputManager;

		turn();

	}

	private void turn() {
		System.out.println("Debut des tours...");
		
		while (!isFinished()) {
			tour++;
			System.out.println("Tour " + tour);
			for (Aventurier aventurier : domainObjects.getAventuriers()) {

				inputManager.getInput(aventurier);

			}

		}
		System.out.println("Tours terminés");
	}

	private boolean isFinished() {
		return domainObjects.getAventuriers().stream()
		.allMatch(c -> inputManager.isFinished(c));
	}
}
