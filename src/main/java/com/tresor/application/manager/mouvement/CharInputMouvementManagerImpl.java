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

	protected void processMouvementG(Aventurier aventurier) {
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

	protected void processMouvementD(Aventurier aventurier) {
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

		validateTarget(domainObject, aventurier, target);

	}

	private void validateTarget(DomainObjectManager domainObject, Aventurier aventurier, Cellule target) {
		if (isMouvementBloqued(domainObject, target)) {
			System.out.println(aventurier.getNom() + " ne peut pas avancer");
			return;
		}

		aventurierAvance(aventurier, target);

		checkIfCaseTresor(domainObject, aventurier, target);

	}

	private void checkIfCaseTresor(DomainObjectManager domainObject, Aventurier aventurier, Cellule target) {
		if ("T".equals(target.getType()) && target.getNombreTresor() > 0) {
			ramasseTresor(aventurier, target);
			if (target.getNombreTresor() == 0) {
				caseTresorDevientPlaine(domainObject, target);
			}
		}
	}

	private void caseTresorDevientPlaine(DomainObjectManager domainObject, Cellule target) {
		target = new Cellule(target.getPosX(), target.getPosY());
		domainObject.getCarte().setCell(target);
	}

	private void ramasseTresor(Aventurier aventurier, Cellule target) {
		System.out.println(aventurier.getNom() + " ramasse un tresor");
		target.setNombreTresor(target.getNombreTresor() - 1);
		aventurier.setNombreTresors(aventurier.getNombreTresors() + 1);
	}

	private void aventurierAvance(Aventurier aventurier, Cellule target) {
		aventurier.setPosX(target.getPosX());
		aventurier.setPosY(target.getPosY());
		System.out.println(aventurier.getNom() + " avance");
	}

	private boolean isMouvementBloqued(DomainObjectManager domainObject, Cellule target) {

		if (target == null) {
			System.out.println("Bord de carte atteint : on passe pas");
			return true;
		} else if ("M".equals(target.getType())) {
			System.out.println("Montagne dit : on ne passe pas");
			return true;
		}
		return hasAventurier(domainObject, target);
	}

	private Cellule getTargetCellule(DomainObjectManager domainObject, Aventurier aventurier) {
		String orientation = aventurier.getOrientation();
		Orientation orientationTarget = Orientation.getOrientation(orientation);

		int posX = aventurier.getPosX() + orientationTarget.getPosX();
		int posY = aventurier.getPosY() + orientationTarget.getPosY();

		Carte carte = domainObject.getCarte();
		return carte.getCell(posX, posY);

	}

	private boolean hasAventurier(DomainObjectManager domainObject, Cellule target) {
		Optional<Aventurier> dejaOccupe = domainObject.getAventuriers().stream()
				.filter(a -> a.getPosX() == target.getPosX()).filter(a -> a.getPosY() == target.getPosY()).findAny();

		if (dejaOccupe.isPresent()) {
			System.out.println(dejaOccupe.get().getNom() + " dit : on ne passe pas");
			return true;
		}
		return false;
	}

}
