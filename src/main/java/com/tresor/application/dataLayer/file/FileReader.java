package com.tresor.application.dataLayer.file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.tresor.application.dataLayer.DataReader;

public class FileReader implements DataReader {
	private String fileName = "carte.txt";

	public List<String> readFile() {
		URI uri = null;
		List<String> lines = new ArrayList<String>();
		try {
			uri = ClassLoader.getSystemResource(fileName).toURI();
			lines = Files.readAllLines(Paths.get(uri));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return lines;
	}

	public FileReader(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<String> readData() {
		
		return readFile();
	}
	
	
}
