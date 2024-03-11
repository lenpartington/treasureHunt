package com.tresor.application.dataLayer.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.tresor.application.dataLayer.DataWriter;

public class ResultFileWriter implements DataWriter {
	private String fileName;

	public void writeData(List<String> lines) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = null;
		BufferedWriter bfw = null;
		FileWriter fw = null;
		try {

			file = new File(classLoader.getResource(".").getFile() + "result_" + fileName);
			fw = new FileWriter(file,StandardCharsets.UTF_8);
			bfw = new BufferedWriter(fw);
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
				if(fw!=null) {
					fw.close();
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
