package com.tresor.application.manager.turn;

import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.mouvement.MouvementManager;

public interface TurnManager {

	void run(DomainObjectManager domainObect);

	void setMouvementManager(MouvementManager mouvementManager);

	void setInputManager(InputManager inputManager);

}
