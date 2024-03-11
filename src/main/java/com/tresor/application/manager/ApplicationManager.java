package com.tresor.application.manager;

import java.util.List;

import com.tresor.application.dataLayer.DataReader;
import com.tresor.application.dataLayer.DataWriter;
import com.tresor.application.manager.domain.DomainObjectManager;
import com.tresor.application.manager.mapping.ObjectMapper;
import com.tresor.application.manager.round.RoundManager;

public class ApplicationManager {

	private DataReader dataReader;
	private DataWriter dataWriter;
	private ObjectMapper objectMapper;
	private RoundManager roundManager;

	public void run() {
		List<String> data = dataReader.readData();
		DomainObjectManager domainObjects = objectMapper.createDomain(data);

		roundManager.run(domainObjects);
		
		dataWriter.writeData(objectMapper.domainToString(domainObjects));
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

	public ObjectMapper getMapManager() {
		return objectMapper;
	}

	public void setMapManager(ObjectMapper mapManager) {
		this.objectMapper = mapManager;
	}

	public RoundManager getRoundManager() {
		return roundManager;
	}

	public void setRoundManager(RoundManager turnManager) {
		this.roundManager = turnManager;
	}

	

}
