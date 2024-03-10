package com.tresor.application.manager;

import java.util.List;

import com.tresor.application.dataLayer.DataReader;
import com.tresor.application.dataLayer.DataWriter;
import com.tresor.application.manager.carte.MapManager;
import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.turn.TurnManager;

public class ApplicationManager {

	public DataReader dataReader;
	public DataWriter dataWriter;
	public MapManager mapManager;
	public TurnManager turnManager;

	public void run() {
		List<String> data = dataReader.readData();
		DomainObjectManager domainObjects = mapManager.createDomain(data);

		turnManager.run(domainObjects);
		
		dataWriter.writeData(mapManager.domainToString(domainObjects));
	}

	public DataReader getDataReader() {
		return dataReader;
	}

	public void setDataReader(DataReader dataReader) {
		this.dataReader = dataReader;
	}

	public DataWriter getDataWriter() {
		return dataWriter;
	}

	public void setDataWriter(DataWriter dataWriter) {
		this.dataWriter = dataWriter;
	}

	public MapManager getMapManager() {
		return mapManager;
	}

	public void setMapManager(MapManager mapManager) {
		this.mapManager = mapManager;
	}

	public TurnManager getTurnManager() {
		return turnManager;
	}

	public void setTurnManager(TurnManager turnManager) {
		this.turnManager = turnManager;
	}

	

}
