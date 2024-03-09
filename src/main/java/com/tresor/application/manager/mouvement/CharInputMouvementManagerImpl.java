package com.tresor.application.manager.mouvement;

import java.util.Optional;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.domain.aventurier.Orientation;
import com.tresor.application.domain.carte.Carte;
import com.tresor.application.domain.carte.cellule.Cellule;
import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.input.CharInput;
import com.tresor.application.manager.input.Input;

public class CharInputMouvementManagerImpl implements MouvementManager {

	public void processInput(Input input, DomainObjectManager domainObjects, Aventurier aventurier) {
		CharInput charInput = (CharInput) input;
		switch (charInput.getInput()) {
		case 'A':
			processMouvementA(domainObjects, aventurier);
			break;
		case 'G':
			processMouvementG(aventurier);
			break;
		case 'D':
			processMouvementD(aventurier);
			break;
		default:
			System.out.println(aventurier.getNom() + " ne fait rien");

		}
	}

	private void processMouvementG(Aventurier aventurier) {
		System.out.println(aventurier.getNom() + " se tourne vers la gauche");
		switch (aventurier.getOrientation()) {
		case "N":
			aventurier.setOrientation("O");
			break;
		case "O":
			aventurier.setOrientation("S");
			break;

		case "S":
			aventurier.setOrientation("E");
			break;
		case "E":
			aventurier.setOrientation("N");
			break;
		default:
			break;
		}
	}

	private void processMouvementD(Aventurier aventurier) {
		System.out.println(aventurier.getNom() + " se tourne vers la droite");
		switch (aventurier.getOrientation()) {
		case "N":
			aventurier.setOrientation("E");
			break;
		case "E":
			aventurier.setOrientation("S");
			break;

		case "S":
			aventurier.setOrientation("O");
			break;
		case "O":
			aventurier.setOrientation("N");
			break;
		default:
			break;
		}

	}

	void processMouvementA(DomainObjectManager domainObject, Aventurier aventurier) {

		Cellule target = getTargetCellule(domainObject, aventurier);

		if (target != null && target.getType() != "M") {
			aventurier.setPosX(target.getPosX());
			aventurier.setPosY(target.getPosY());
			if (target.getType() == "T" && target.getNombreTresor() > 0) {
				System.out.println(aventurier.getNom() + " ramasse un tresor");
				target.setNombreTresor(target.getNombreTresor() - 1);
				aventurier.setNombreTresors(aventurier.getNombreTresor() + 1);
			}
			System.out.println(aventurier.getNom() + " avance");

		} else {
			System.out.println(aventurier.getNom() + " ne peut pas avancer");

		}

	}

	private Cellule getTargetCellule(DomainObjectManager domainObject, Aventurier aventurier) {
		String orientation = aventurier.getOrientation();
		Orientation orientationTarget = Orientation.getOrientation(orientation);

		int posX = aventurier.getPosX() + orientationTarget.getPosX();
		int posY = aventurier.getPosY() + orientationTarget.getPosY();

		Optional<Aventurier> dejaOccupe = domainObject.getAventuriers().stream().filter(a -> a.getPosX() == posX)
				.filter(a -> a.getPosY() == posY).findAny();

		if (dejaOccupe.isPresent()) {
			System.out.println(dejaOccupe.get().getNom() + " dit non");
			return null;
		}

		Carte carte = domainObject.getCarte();
		return carte.getCell(posX, posY);

	}

}
