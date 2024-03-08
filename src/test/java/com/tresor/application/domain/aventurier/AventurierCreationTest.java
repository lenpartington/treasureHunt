package com.tresor.application.domain.aventurier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tresor.application.domain.aventurier.Aventurier;

public class AventurierCreationTest {

	
	@Test
	public void createAventurier() {
		String line = "A - Lara - 1 - 1 - S - AADADAGGA";
		Aventurier result = new Aventurier(line);
		Aventurier expected = new Aventurier("Lara",1,1,"S","AADADAGGA");
		assertEquals(expected, result);
		
		
	}
}
