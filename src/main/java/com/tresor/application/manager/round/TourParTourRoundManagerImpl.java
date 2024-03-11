package com.tresor.application.manager.round;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.Input;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.mouvement.MouvementManager;

public class TourParTourRoundManagerImpl implements RoundManager {

	private InputManager inputManager;
	private DomainObjectManager domainObjects;
	private MouvementManager mouvementManager;
	private int tour = 0;

	public void run(DomainObjectManager domainObjects) {
		this.domainObjects = domainObjects;

		System.out.println("Debut des tours...");

		while (!isFinished()) {
			tour++;
			System.out.println("Tour " + tour);
			for (Aventurier aventurier : domainObjects.getAventuriers()) {

				playActionAventurier(domainObjects, aventurier);
			}

		}
		System.out.println("Tours terminés");
	}

	private void playActionAventurier(DomainObjectManager domainObjects, Aventurier aventurier) {
		Input input = inputManager.getInput(aventurier);
		if (input != null) {
			mouvementManager.processInput(input, domainObjects, aventurier);
		}
	}

	private boolean isFinished() {
		return domainObjects.getAventuriers().stream().allMatch(c -> inputManager.isFinished(c));
	}

	@Override
	public void setMouvementManager(MouvementManager mouvementManager) {
		this.mouvementManager = mouvementManager;
	}

	@Override
	public void setInputManager(InputManager inputManager) {
		this.inputManager = inputManager;

	}

}
