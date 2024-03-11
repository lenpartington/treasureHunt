package com.tresor.application.domain.aventurier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
	
	
	@Test
	public void testAventurierEquals() {
		String line = "A - Lara - 1 - 1 - S - AADADAGGA";
		Aventurier result = new Aventurier(line);
		Aventurier expected = new Aventurier("Lara",1,1,"S","AADADAGGA");
		assertTrue(expected.equals(result));
		assertEquals(expected.hashCode(),result.hashCode());
		
	}
	@Test
	public void testAventurierNotEquals() {
		String line = "A - Lara - 1 - 1 - S - AADADAGGA";
		Aventurier result = new Aventurier(line);
		Aventurier expected = new Aventurier("Lara",1,2,"S","AADADAGGA");
		assertFalse(expected.equals(result));
		assertNotEquals(expected.hashCode(),result.hashCode());
		
	}
}
