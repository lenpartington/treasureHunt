package com.tresor.aventurier;

import java.util.Objects;

import com.tresor.carte.cellule.Cellule;

public class Aventurier {

	
	String nom;
	int posX;
	int posY;
	int nombreTresors;
	String orientation;
	Cellule target;
	String mouvement ;
	
	
	
	
	
	public Aventurier(String line) {
		super();
		String[] splitted = line.split(" - ");
		String nom = splitted[1];
		int x = Integer.valueOf(splitted[2]);
		int y = Integer.valueOf(splitted[3]);
		String orientation = splitted[4];
		String mouvement = splitted[5];
		processCells(nom,x, y,orientation,mouvement);
	
	}

	

	public Aventurier(String nom, int x, int y, String orientation,String mouvement) {
		super();
		processCells(nom,x, y,orientation,mouvement);
	}



	private void processCells(String nom, int x, int y, String orientation,String mouvement) {
		this.nom=nom;
		this.posX=x;
		this.posY=y;
		this.orientation=orientation;
		this.mouvement=mouvement;
		
		
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



	public int getNombreTresors() {
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
		return "Aventurier [nom=" + nom + ", posX=" + posX + ", posY=" + posY + ", nombreTresors=" + nombreTresors
				+ ", orientation=" + orientation + ", target=" + target + ", mouvement=" + mouvement + "]";
	}






	






	





	
	
	
}
