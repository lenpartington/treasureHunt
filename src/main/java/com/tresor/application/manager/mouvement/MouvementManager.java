package com.tresor.application.manager.mouvement;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.Input;

public interface MouvementManager {

	void processInput(Input input, DomainObjectManager domainObjects, Aventurier aventurier);

}
