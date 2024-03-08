package com.tresor.application.manager;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.aventurier.Orientation;
import com.tresor.application.domain.carte.Carte;
import com.tresor.application.domain.carte.Cellule;

public class MouvementManager {

	public static void processMouvementA(Carte carte,Aventurier aventurier) {
		String orientation = aventurier.getOrientation();
		Orientation orientationTarget=Orientation.getOrientation(orientation);
		
		int posX = aventurier.getPosX()+orientationTarget.getPosX();
		int posY = aventurier.getPosY()+orientationTarget.getPosY();
		
		
		Cellule target = carte.getCell(posX, posY);
		System.out.println(target);
		System.out.println(aventurier);
		
		
		if(target!=null&&target.getType()!="M") {
			aventurier.setPosX(target.getPosX());
			aventurier.setPosY(target.getPosY());
			if(target.getType()=="T"&&target.getNombreTresor()>0) {
				target.setNombreTresor(target.getNombreTresor()-1);
				aventurier.setNombreTresors(aventurier.getNombreTresor()+1);
			}
		}
		
		
		
	}
	
	
}
