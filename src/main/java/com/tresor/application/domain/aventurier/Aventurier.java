package com.tresor.application.domain.aventurier;

import java.util.Objects;

import com.tresor.application.domain.carte.cellule.Cellule;
import com.tresor.application.manager.input.InputManager;
import com.tresor.application.manager.mouvement.MouvementManager;

public class Aventurier {

	String nom;
	int posX;
	int posY;
	int nombreTresors;
	String orientation;
	Cellule target;
	String mouvement;
	MouvementManager mouvementManager;
	InputManager inputManager;

	public Aventurier(String line) {
		super();
		String[] splitted = line.split(" - ");
		this.nom = splitted[1];
		this.posX = Integer.parseInt(splitted[2]);
		this.posY = Integer.parseInt(splitted[3]);
		this.orientation = splitted[4];
		this.mouvement = splitted[5];

	}

	public Aventurier(String nom, int x, int y, String orientation, String mouvement) {
		super();
		this.nom = nom;
		this.posX = x;
		this.posY = y;
		this.orientation = orientation;
		this.mouvement = mouvement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mouvement, nom, orientation, posX, posY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aventurier other = (Aventurier) obj;
		return Objects.equals(mouvement, other.mouvement) && Objects.equals(nom, other.nom)
				&& Objects.equals(orientation, other.orientation) && posX == other.posX && posY == other.posY;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNombreTresor() {
		return nombreTresors;
	}

	public void setNombreTresors(int nombreTresors) {
		this.nombreTresors = nombreTresors;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Cellule getTarget() {
		return target;
	}

	public void setTarget(Cellule target) {
		this.target = target;
	}

	public String getMouvement() {
		return mouvement;
	}

	public void setMouvement(String mouvement) {
		this.mouvement = mouvement;
	}
	
	public MouvementManager getMouvementManager() {
		return mouvementManager;
	}

	public void setMouvementManager(MouvementManager mouvementManager) {
		this.mouvementManager = mouvementManager;
	}

	public InputManager getInputManager() {
		return inputManager;
	}

	public void setInputManager(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public int getNombreTresors() {
		return nombreTresors;
	}

	@Override
	public String toString() {
String mouvement = this.mouvement==""?"":" - "+this.mouvement;

		return "A - " + nom + " - " + posX + " - " + posY + " - " + orientation + mouvement+ " - "+nombreTresors;
	}

	
	

}
