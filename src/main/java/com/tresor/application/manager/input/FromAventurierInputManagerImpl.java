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
		
		retireInputDeLaListe(aventurier);
		
		System.out.println(aventurier.toString());
		return new CharInput(action);
	}

	private void retireInputDeLaListe(Aventurier aventurier) {
		String nouveauMouvement = aventurier.getMouvement().substring(1);
		aventurier.setMouvement(nouveauMouvement);
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
