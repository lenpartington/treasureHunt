package com.tresor.application.manager.mouvement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tresor.application.domain.aventurier.Aventurier;
import com.tresor.application.manager.input.CharInput;
import com.tresor.application.manager.input.Input;

public class CharInputMouvementManagerImplTest {

	@Test
	public void testProcessOrientation() {
		Aventurier lara = new Aventurier("Lara", 0, 0, "N", "GGGGDDDD");
		MouvementManager mouvementManager = new CharInputMouvementManagerImpl();
		Input input = new CharInput('G');
		mouvementManager.processInput(input, null, lara);
		assertEquals("O", lara.getOrientation());
		mouvementManager.processInput(input, null, lara);
		assertEquals("S", lara.getOrientation());
		mouvementManager.processInput(input, null, lara);
		assertEquals("E", lara.getOrientation());
		mouvementManager.processInput(input, null, lara);
		assertEquals("N", lara.getOrientation());
		
		input = new CharInput('D');
		mouvementManager.processInput(input, null, lara);
		assertEquals("E", lara.getOrientation());
		mouvementManager.processInput(input, null, lara);
		assertEquals("S", lara.getOrientation());
		mouvementManager.processInput(input, null, lara);
		assertEquals("O", lara.getOrientation());
		mouvementManager.processInput(input, null, lara);
		assertEquals("N", lara.getOrientation());
		
	}

}
