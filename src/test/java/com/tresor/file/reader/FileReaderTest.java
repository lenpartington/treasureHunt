package com.tresor.file.reader;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class FileReaderTest {
	

	@Test
	public void readFile() {
		FileReader reader = new FileReader("carte_vide.txt");
		List<String> lines = reader.readFile();
		
		assertEquals("#commentaire", lines.get(0));
		assertEquals("C - 3 - 4", lines.get(1));		
		
		
		
	}
}
