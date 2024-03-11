package com.tresor.application.manager.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.carte.Carte;
import com.tresor.application.domain.carte.cellule.Cellule;
import com.tresor.application.domain.carte.cellule.CelluleMontagne;
import com.tresor.application.domain.carte.cellule.CelluleTresor;
import com.tresor.application.manager.domain.ClassicDomainManagerImpl;
import com.tresor.application.manager.domain.DomainObjectManager;

public class ClassicMapManagerImpl implements MapManager {

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

	@Override
	public List<String> domainToString(DomainObjectManager domainObjects) {
		List<String> results = new ArrayList<>();
		Carte carte = domainObjects.getCarte();
		results.add(carte.toString());
		
		List<Cellule>montagnes = carte.getCells().stream()
		.filter(c-> "M".equals(c.getType()))
		.collect(Collectors.toList());
		
		for (Cellule montagne : montagnes) {
			results.add(montagne.toString());	
		}
		
		
		List<Cellule>tresors = carte.getCells().stream()
				.filter(c-> "T".equals(c.getType()))
				.collect(Collectors.toList());
				
				for (Cellule tresor : tresors) {
					results.add("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors \nrestants}");
					results.add(tresor.toString());	
				}
				
		List<Aventurier> aventuriers = domainObjects.getAventuriers();
		for (Aventurier aventurier: aventuriers) {
			results.add("# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe \nvertical} - {Orientation} - {Nb. trésors ramassés}");
			String adventurer = "A - "+aventurier.getNom()+" - "+aventurier.getPosX()+" - "+aventurier.getPosY()+" - "+aventurier.getOrientation()+ " - "+aventurier.getNombreTresors() ;
			results.add(adventurer);
		}
		
		
		
		
		return results;
	}

}
