package com.tresor.carte.cellule;

import java.util.Objects;

public class Cellule {

	private int posX;
	private int posY;
	private String type = "";

	public Cellule(int x, int y) {
		this.posX = x;
		this.posY = y;
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

	@Override
	public int hashCode() {
		return Objects.hash(posX, posY);
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
		return posX == other.posX && posY == other.posY;
	}

	@Override
	public String toString() {
		return "Cellule [posX=" + posX + ", posY=" + posY + "]";
	}

}
