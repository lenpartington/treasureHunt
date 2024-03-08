package com.tresor.file.reader;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ResultFileWriterTest {

	@Test
	public void writeFile() {
		final String fileNameResult = "carte_result.txt";
		FileReader reader = new FileReader("carte_vide.txt");
		List<String> data = reader.readFile();
		ResultFileWriter writer = new ResultFileWriter(fileNameResult);
		writer.writeFile(data);
		reader = new FileReader(fileNameResult);
		List<String> lines = reader.readFile();
		assertEquals("#commentaire", lines.get(0));
		assertEquals("C - 3 - 4", lines.get(1)); 

	}
}
