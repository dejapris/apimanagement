package fr.tm.ima.digitaltour.api.service;

import java.util.Arrays;

import fr.tm.ima.digitaltour.api.model.Color;

/**
 * Classe Service singleton
 * @author fb
 *
 */
public class ColorService {

	private static final int maxcol = 12;
	private static final int maxrow = 12;
	
	private int[] tab = new int[maxcol*maxrow];
	
	/**
	 * constructeur
	 */
	private ColorService() {
		Arrays.fill(tab, 0); // initialisation avec vide
		
	}
	
	/** Holder */
	private static class ColorServiceHolder
	{		
		/** Instance unique non préinitialisée */
		private final static ColorService instance = new ColorService();
	}	
	
	public static ColorService getInstance(){
		return ColorServiceHolder.instance;
	}
	
	/**
	 * Ajoute une couleur dans le tableau des couleurs
	 * @param col
	 */
	public void addColor(Color col){
		this.tab[col.col+(col.row * ColorService.maxrow)] = col.color;
	}
	
	/**
	 * Renvoit l'ensemble du tableau
	 * @return
	 */
	public int[] getTab(){
		return tab;
	}
	
}
