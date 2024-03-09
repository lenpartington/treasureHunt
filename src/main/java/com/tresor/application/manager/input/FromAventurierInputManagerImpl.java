package com.tresor.application.manager.input;

import com.tresor.application.domain.aventurier.Aventurier;

public class FromAventurierInputManagerImpl implements InputManager {



	@Override
	public Input getInput(Aventurier aventurier) {
		if (aventurier.getMouvement().equals("")) {
			System.out.println( aventurier.getNom()+" ne bouge pas");
			return null;

		} else {
			return retrieveInput(aventurier);
			
		}
	}

	private Input retrieveInput(Aventurier aventurier) {
		char action = aventurier.getMouvement().charAt(0);
		System.out.println(aventurier.getNom() + " fait " + action);
		
		String nouveauMouvement = aventurier.getMouvement().substring(1);
		aventurier.setMouvement(nouveauMouvement);
		
		System.out.println(aventurier.toString());
		return new CharInput(action);
	}

	@Override
	public boolean isFinished(Aventurier aventurier) {
		if (aventurier.getMouvement().equals("")) {
			//System.out.println("aventurier : " + aventurier.getNom()+" a fini");
			return true;

		} 
		return false;
	}

	

}
