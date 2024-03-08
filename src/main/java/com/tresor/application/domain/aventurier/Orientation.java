package com.tresor.application.domain.aventurier;

import java.util.Objects;

public class Orientation {

	int posX;
	int posY;

	public Orientation(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	public static Orientation getOrientation(String target){
	
		int x=0;
		int y=0;
		
		switch(target) {
		
		case "N":
			x=0;
			y=-1;
			break;
		case "S":
			x=0;
			y=1;
			break;
		case "O":
			x=-1;
			y=0;
			break;
		case "E":
			x=1;
			y=0;
			break;
					
		}
		
		
		return new Orientation(x,y);
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
		Orientation other = (Orientation) obj;
		return posX == other.posX && posY == other.posY;
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
	
	
}
