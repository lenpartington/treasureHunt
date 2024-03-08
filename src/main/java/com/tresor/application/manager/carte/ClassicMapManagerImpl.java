package com.tresor.application.manager.carte;

import java.util.List;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.carte.Carte;
import com.tresor.application.domain.carte.cellule.CelluleMontagne;
import com.tresor.application.domain.carte.cellule.CelluleTresor;
import com.tresor.application.manager.domain.ClassicDomainManagerImpl;
import com.tresor.application.manager.domain.DomainObjectManager;

public class ClassicMapManagerImpl implements MapManager {

	@Override
	public DomainObjectManager createDomain(List<String> data) {
		DomainObjectManager dom = new ClassicDomainManagerImpl();
		
		Carte carte = null;
		

		for (String line : data) {

			if ('C' == line.charAt(0)) {
				System.out.println("Creation de la carte...");
				carte = new Carte(line);
				System.out.println(carte.toString());
				dom.setCarte(carte);
			}
			if ('M' == line.charAt(0)) {
				System.out.println("Ajout de montagne...");
				CelluleMontagne montagne = new CelluleMontagne(line);
				System.out.println(montagne.toString());
				carte.setCell(montagne);
			}
			if ('T' == line.charAt(0)) {
				System.out.println("Ajout de tresor...");
				CelluleTresor tresor = new CelluleTresor(line);
				System.out.println(tresor.toString());
				carte.setCell(tresor);
			}

			
			if('A'==line.charAt(0)) {
				System.out.println("Creation d'aventurier...");
				Aventurier aventurier = new Aventurier(line);
				System.out.println(aventurier.toString());
				dom.getAventuriers().add(aventurier);	
			}
			
			
		}
		return dom;
	}

}
