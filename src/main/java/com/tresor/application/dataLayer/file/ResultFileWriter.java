package com.tresor.application.dataLayer.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.tresor.application.dataLayer.DataWriter;

public class ResultFileWriter implements DataWriter {
	private String fileName;

	public void writeData(List<String> lines) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = null;
		BufferedWriter bfw = null;
		Writer writer = null;
		try {

			file = new File(classLoader.getResource(".").getFile() + "result_" + fileName);
			writer = new OutputStreamWriter(new FileOutputStream(file),StandardCharsets.UTF_8);
			bfw = new BufferedWriter(writer);
			System.out.println("writing file :"+file.getAbsolutePath());
			for (String line : lines) {

				bfw.write(line);
				bfw.newLine();

			}
			bfw.flush();
			bfw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bfw != null) {
					bfw.close();
				}
				if(writer!=null) {
					writer.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ResultFileWriter(String fileName) {
		super();
		this.fileName = fileName;
	}

}
