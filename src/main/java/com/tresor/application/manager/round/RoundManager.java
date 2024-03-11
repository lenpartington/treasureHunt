package com.tresor.application.manager.round;

import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.mouvement.MouvementManager;

public interface RoundManager {

	void run(DomainObjectManager domainObect);

	void setMouvementManager(MouvementManager mouvementManager);

	void setInputManager(InputManager inputManager);

}
