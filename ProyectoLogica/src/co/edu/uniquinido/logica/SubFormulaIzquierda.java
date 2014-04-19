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
 * 19/04/2014
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package co.edu.uniquinido.logica;

import java.util.ArrayList;

/**
 * Clase que implementa SubFormulaIzquierda.java
 */
public class SubFormulaIzquierda {
	
	private String subFormula;
	private ArrayList<String> soluciones;
	
	
	/**
	 * Metodo Costructor que inicializa las variables
	 * @param subFormula
	 * @param soluciones
	 */
	public SubFormulaIzquierda(String subFormula, ArrayList<String> soluciones) {
		super();
		this.subFormula = subFormula;
		this.soluciones = soluciones;
	}
	/**
	 * Metodo que permite obtener subFormula
	 * @return el subFormula
	 */
	public String getSubFormula() {
		return subFormula;
	}
	/**
	 * Metodo que permite asignar subFormula.
	 * @param subFormula: el subFormula a asignar.
	 */
	public void setSubFormula(String subFormula) {
		this.subFormula = subFormula;
	}
	/**
	 * Metodo que permite obtener soluciones
	 * @return el soluciones
	 */
	public ArrayList<String> getSoluciones() {
		return soluciones;
	}
	/**
	 * Metodo que permite asignar soluciones.
	 * @param soluciones: el soluciones a asignar.
	 */
	public void setSoluciones(ArrayList<String> soluciones) {
		this.soluciones = soluciones;
	}
	
	
	
}
