package com.tresor.application.manager.turn;

import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.InputManager;

public class TourParTourParOrdreCreationTurnManagerImpl implements TurnManager{

	private InputManager inputManager;
	private DomainObjectManager domainObjects;
	private int tour;
	
	
	@Override
	public void run(InputManager inputManager, DomainObjectManager domainObjects) {
		this.domainObjects=domainObjects;
		this.inputManager=inputManager;
		
		
		

		
	}

}
