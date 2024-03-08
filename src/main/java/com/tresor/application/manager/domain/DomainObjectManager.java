package com.tresor.application.manager.domain;

import java.util.List;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.carte.Carte;

public interface DomainObjectManager {

	
	
	void setCarte(Carte carte);

	Carte getCarte();

	List<Aventurier> getAventuriers();

}
