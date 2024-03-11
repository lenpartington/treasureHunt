package com.tresor.application.dataLayer.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.tresor.application.dataLayer.DataReader;

public class FileReader implements DataReader {
	private String fileName ;

	public List<String> readData() {
		URI uri = null;
		System.out.println("reading file :"+fileName);
		List<String> lines = new ArrayList<>();
		try {
			uri = new File(fileName).toURI();
			lines = Files.readAllLines(Paths.get(uri));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	public FileReader(String fileName) {
		super();
		this.fileName = fileName;
	}

	
	
	
}
