package com.tresor.application.domain.carte.cellule;

public class CelluleTresor extends Cellule {

	

	public CelluleTresor(int x, int y) {
		super(x, y);
		this.setType("T");
	}

	public CelluleTresor(String tresorLine) {
		super();
		String[] splitted = tresorLine.split(" - ");
		this.setPosX(Integer.valueOf(splitted[1]));
		this.setPosY(Integer.valueOf(splitted[2]));
		this.setNombreTresor(Integer.valueOf(splitted[3]));
		this.setType("T");
	}

	@Override
	public String toString() {
		return super.toString()+" - "+getNombreTresor();
	}

	

}
