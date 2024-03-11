package com.tresor.application.dataLayer.file;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.tresor.application.dataLayer.file.FileReader;

public class FileReaderTest {
	

	@Test
	public void readFile() {
		String filename="carte.txt";
		String startFilePath = Paths.get("src/main/resources",filename).toFile().getAbsolutePath();
		FileReader reader = new FileReader(startFilePath);
		List<String> lines = reader.readData();
		
		assertEquals("#commentaire", lines.get(0));
		assertEquals("C - 3 - 4", lines.get(1));		
		
		
		
	}
}
