package com.tresor.application.domain.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tresor.application.domain.carte.cellule.Cellule;

public class Carte {

	private List<Cellule> cells;
	private int sizeX;
	private int sizeY;

	public Carte(String line) {
		super();
		String[] splitted = line.split(" - ");
		int x = Integer.parseInt(splitted[1]);
		int y = Integer.parseInt(splitted[2]);
		processCells(x, y);

	}

	public Carte(int x, int y) {
		super();
		processCells(x, y);

	}

	private void processCells(int x, int y) {
		this.sizeX=x;
		this.sizeY=y;
		cells = new ArrayList<>();
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				cells.add(new Cellule(i, j));
			}

		}
	}

	public List<Cellule> getCells() {
		return cells;
	}

	public void setCells(List<Cellule> cells) {
		this.cells = cells;
	}

	public Cellule getCell(int posX, int posY) {
		Optional<Cellule> cellule = cells.stream().filter(c -> c.getPosX() == posX).filter(c -> c.getPosY() == posY)
				.findFirst();

		return cellule.orElse(null);
	}

	public void setCell(Cellule cellule) {
		Cellule toReplace = getCell(cellule.getPosX(), cellule.getPosY());
		int index = this.cells.indexOf(toReplace);
		this.cells.set(index, cellule);

	}

	@Override
	public String toString() {
		return "C - "+sizeX+" - "+sizeY;
	}

}
