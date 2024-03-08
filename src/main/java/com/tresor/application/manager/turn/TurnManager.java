package com.tresor.application.manager.turn;

import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.InputManager;

public interface TurnManager {

	void run(InputManager inputManager, DomainObjectManager domainObjects);

}
