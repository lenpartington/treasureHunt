package com.tresor.application.domain.carte;

import java.util.Objects;

public class Cellule {

	private int posX;
	private int posY;
	private String type = "";
	private int nombreTresor=0;
	public Cellule(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	protected Cellule() {
		// TODO Auto-generated constructor stub
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

	


	public void setType(String type) {
		this.type=type;
		
	}

	public String getType() {
		return type;
	}
	public int getNombreTresor() {
		return nombreTresor;
	}

	public void setNombreTresor(int nombreTresor) {
		this.nombreTresor = nombreTresor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(posX, posY, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		return posX == other.posX && posY == other.posY && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Cellule [posX=" + posX + ", posY=" + posY + ", type=" + type + "]";
	}



}
