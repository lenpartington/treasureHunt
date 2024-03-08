package com.tresor.application.manager.domain;

import java.util.ArrayList;
import java.util.List;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.carte.Carte;

public class ClassicDomainManagerImpl implements DomainObjectManager{

	
	List<Aventurier> aventuriers=new ArrayList<>();
	Carte carte;
	
	public List<Aventurier> getAventuriers() {
		return aventuriers;
	}
	public void setAventuriers(List<Aventurier> aventuriers) {
		this.aventuriers = aventuriers;
	}
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	
	
}
