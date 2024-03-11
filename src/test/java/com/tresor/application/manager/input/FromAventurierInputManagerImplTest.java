package com.tresor.application.manager.input;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tresor.application.domain.aventurier.Aventurier;

public class FromAventurierInputManagerImplTest {

	@Test
	public void testGetInput() {
		InputManager inputManager = new FromAventurierInputManagerImpl();
		Aventurier aventurier = new Aventurier("Indiana", 0, 0, "N", "");
		Input input = inputManager.getInput(aventurier);
		
		assertNull(input);
	}

}
