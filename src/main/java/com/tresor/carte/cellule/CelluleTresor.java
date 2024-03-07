package com.tresor.carte.cellule;

public class CelluleTresor extends Cellule {

	private int nombreTresor;

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

	public int getNombreTresor() {
		return nombreTresor;
	}

	public void setNombreTresor(int nombreTresor) {
		this.nombreTresor = nombreTresor;
	}

}
