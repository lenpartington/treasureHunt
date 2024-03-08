package com.tresor.application.domain.carte.cellule;

public class CelluleMontagne extends Cellule{

	public CelluleMontagne(int x, int y) {
		super(x, y);
		this.setType("M");
	}

	public CelluleMontagne(String line) {
		super();
		String[] splitted = line.split(" - ");
		this.setPosX(Integer.valueOf(splitted[1]));
		this.setPosY(Integer.valueOf(splitted[2]));
		this.setType("M");
	}

	
	
	
}
