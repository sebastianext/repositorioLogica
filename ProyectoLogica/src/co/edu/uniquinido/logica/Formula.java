/**
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Universidad del Quindío (Armenia - Colombia)
 * Programa de Ingeniería de Sistemas y Computación
 *
 * Asignatura: 
 * Aplicacion: 
 * @author Johan Sebastian Quintero
 * @author Universidad del Quindio
 * @vesion 1.0
 * 23/03/2014
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package co.edu.uniquinido.logica;

import java.util.ArrayList;

/**
 * Clase que implementa Formula.java
 */
public class Formula {

	private String formula;
	private ArrayList<Atomo> atomos;
	private ArrayList<Conector> conectores;

	public Formula(String formula){
		this.formula=formula;
		atomos= new ArrayList<Atomo>();
		conectores= new ArrayList<Conector>();
	}

	public Formula() {
		
	}
	
	public void buscarTokens(){

		for (int i = 0; i < formula.length(); i++) {

			char token=formula.charAt(i);

			if (esAtomo(token)) {
				if (!buscarAtomo(token)) {
					atomos.add(new Atomo(String.valueOf(token),i));
				}
			}else {
				String conector= extraerConector(formula,i);
				if (conector!=null) {
					conectores.add(new Conector(conector, i));
				}
			}
		}
	}

	
	public boolean buscarAtomo(char letra){
		for (int i = 0; i < atomos.size(); i++) {
			if (atomos.get(i).getLexema().equals(String.valueOf(letra))) {
				return true;
			}
		}
		return false;
	}

	public String extraerConector(String formula, int indice){

		if( !esSimbolo(formula.charAt(indice)) )
			return null;

		// Halla el índice del siguiente lexema
		int indiceSiguiente=indice;

		String conector="";
		if( indiceSiguiente<formula.length( ) && formula.charAt(indiceSiguiente)=='<' ){
			indiceSiguiente++;
			if ( indiceSiguiente<formula.length( ) && formula.charAt(indiceSiguiente)=='-' ) {
				indiceSiguiente++;
				if ( indiceSiguiente<formula.length( ) && formula.charAt(indiceSiguiente)=='>' ) {
					conector=formula.substring(indice, indiceSiguiente+1);
				}
			}
		}
		if (indiceSiguiente<formula.length( ) && formula.charAt(indiceSiguiente)=='-') {
			indiceSiguiente++;
			if ( indiceSiguiente<formula.length( ) && formula.charAt(indiceSiguiente)=='>' ) {
				conector=formula.substring(indice, indiceSiguiente+1);
			}
		}
		if (esConector(formula.charAt(indiceSiguiente))) {
			conector=formula.substring(indice, indiceSiguiente+1);
		}
		return conector;
	}

	/**
	 * Determina si un carácter es un simbolo
	 * @param caracter - Carácter que se va a analizar - caracter!=null,
	 * @return true o false según el carácter sea un simbolo  o no
	 */
	private boolean esSimbolo(char caracter){
		return esConector(caracter) || caracter == '-' || caracter == '<';
	}
	/**
	 * Determina si un carácter es una Conector
	 * @param caracter - Carácter que se va a analizar - caracter!=null,
	 * @return true o false según el carácter sea un conector  o no
	 */
	private boolean esConector(char caracter){
		return caracter == '&' || caracter == 'V' || caracter == '~';
	}



	/**
	 * Determina si un carácter es una letra
	 * @param caracter - Carácter que se va a analizar - caracter!=null,
	 * @return true o false según el carácter sea una letra  o no
	 */
	private boolean esAtomo(char caracter){
		return ( caracter >= 'a' && caracter <= 'z');
	}

	/**
	 * Metodo que permite obtener formula
	 * @return el formula
	 */
	public String getFormula() {
		return formula;
	}
	/**
	 * Metodo que permite asignar formula.
	 * @param formula: el formula a asignar.
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	/**
	 * Metodo que permite obtener atomos
	 * @return el atomos
	 */
	public ArrayList<Atomo> getAtomos() {
		return atomos;
	}
	/**
	 * Metodo que permite asignar atomos.
	 * @param atomos: el atomos a asignar.
	 */
	public void setAtomos(ArrayList<Atomo> atomos) {
		this.atomos = atomos;
	}
	/**
	 * Metodo que permite obtener conectores
	 * @return el conectores
	 */
	public ArrayList<Conector> getConectores() {
		return conectores;
	}
	/**
	 * Metodo que permite asignar conectores.
	 * @param conectores: el conectores a asignar.
	 */
	public void setConectores(ArrayList<Conector> conectores) {
		this.conectores = conectores;
	}



}
