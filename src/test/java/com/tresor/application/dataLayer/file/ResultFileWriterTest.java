package com.tresor.application.dataLayer.file;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class ResultFileWriterTest {

	@Test
	public void writeFile() {
		String filename="carte_vide.txt";
		String startFilePath = Paths.get("src/test/resources",filename).toFile().getAbsolutePath();
		
		FileReader reader = new FileReader(startFilePath);
		List<String> data = reader.readData();

		ResultFileWriter writer = new ResultFileWriter(filename);
		writer.writeData(data);
		
		String fileNameResult="result_carte_vide.txt";
		String endFilePath = Paths.get("target","test-classes/"+fileNameResult).toFile().getAbsolutePath();
		
		reader = new FileReader(endFilePath);
		List<String> lines = reader.readData();
		assertEquals("#commentaire", lines.get(0));
		assertEquals("C - 3 - 4", lines.get(1)); 

	}
}
