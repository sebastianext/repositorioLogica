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

/**
 * Clase que implementa TablaVerdad.java
 */
public class TablaVerdad {
	
	private int combinaciones;
	private int filas;
	private int columnas;
	private Formula formula;
	
	/**
	 * Metodo que permite obtener combinaciones
	 * @return el combinaciones
	 */
	public int getCombinaciones() {
		return combinaciones;
	}
	/**
	 * Metodo que permite asignar combinaciones.
	 * @param combinaciones: el combinaciones a asignar.
	 */
	public void setCombinaciones(int combinaciones) {
		this.combinaciones = combinaciones;
	}
	/**
	 * Metodo que permite obtener filas
	 * @return el filas
	 */
	public int getFilas() {
		return filas;
	}
	/**
	 * Metodo que permite asignar filas.
	 * @param filas: el filas a asignar.
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}
	/**
	 * Metodo que permite obtener columnas
	 * @return el columnas
	 */
	public int getColumnas() {
		return columnas;
	}
	/**
	 * Metodo que permite asignar columnas.
	 * @param columnas: el columnas a asignar.
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	/**
	 * Metodo que permite obtener formula
	 * @return el formula
	 */
	public Formula getFormula() {
		return formula;
	}
	/**
	 * Metodo que permite asignar formula.
	 * @param formula: el formula a asignar.
	 */
	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
	
	

}
