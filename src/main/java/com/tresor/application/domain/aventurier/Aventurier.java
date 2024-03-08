package com.tresor.application.domain.aventurier;

import java.util.Objects;

import com.tresor.application.domain.carte.cellule.Cellule;

public class Aventurier {

	String nom;
	int posX;
	int posY;
	int nombreTresors;
	String orientation;
	Cellule target;
	String mouvement;

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

	@Override
	public String toString() {

		return "A - " + nom + " - " + posX + " - " + posY + " - " + orientation + " - " + mouvement;
	}

	public void executeInput(char action) {
		switch (action) {
		case 'A':
			System.out.println(nom+" avance");
			break;
		case 'G':
			System.out.println(nom+" se tourne vers la gauche");
			break;
		case 'D':
			System.out.println(nom+" se tourne vers la droite");
			break;
		default:
			System.out.println(nom +" ne fait rien");

		}

	}

}
