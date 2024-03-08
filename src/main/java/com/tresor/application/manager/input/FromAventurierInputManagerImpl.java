package com.tresor.application.manager.input;

import java.util.List;

import com.tresor.application.domain.aventurier.Aventurier;

public class FromAventurierInputManagerImpl implements InputManager {



	@Override
	public boolean getInput(Aventurier aventurier) {
		if (aventurier.getMouvement().equals("")) {
			System.out.println( aventurier.getNom()+" ne bouge pas");
			return false;

		} else {
			excuteInput(aventurier);
			return true;
		}
	}

	private void excuteInput(Aventurier aventurier) {
		char action = aventurier.getMouvement().charAt(0);
		System.out.println(aventurier.getNom() + " fait " + action);
		aventurier.executeInput(action);
		String nouveauMouvement = aventurier.getMouvement().substring(1);
		aventurier.setMouvement(nouveauMouvement);
		
		System.out.println(aventurier.toString());
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
