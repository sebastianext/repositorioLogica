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
 * 14/04/2014
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package co.edu.uniquinido.logica;

import java.util.ArrayList;

/**
 * Clase que implementa SubFormula.java
 */
public class SubFormula {
	
	private SubFormulaDerecha der;
	private SubFormulaIzquierda izq;
	private String conector;
	/**
	 * Metodo Costructor que inicializa las variables
	 * @param der
	 * @param izq
	 * @param conector
	 * @param soluciones
	 */
	public SubFormula(SubFormulaDerecha der, SubFormulaIzquierda izq, String conector) {
		super();
		this.der = der;
		this.izq = izq;
		this.conector = conector;
		
	}
	
	
	
	
	/**
	 * Metodo que permite obtener der
	 * @return el der
	 */
	public SubFormulaDerecha getDer() {
		return der;
	}

	/**
	 * Metodo que permite asignar der.
	 * @param der: el der a asignar.
	 */
	public void setDer(SubFormulaDerecha der) {
		this.der = der;
	}

	/**
	 * Metodo que permite obtener izq
	 * @return el izq
	 */
	public SubFormulaIzquierda getIzq() {
		return izq;
	}

	/**
	 * Metodo que permite asignar izq.
	 * @param izq: el izq a asignar.
	 */
	public void setIzq(SubFormulaIzquierda izq) {
		this.izq = izq;
	}

	/**
	 * Metodo que permite obtener conector
	 * @return el conector
	 */
	public String getConector() {
		return conector;
	}
	/**
	 * Metodo que permite asignar conector.
	 * @param conector: el conector a asignar.
	 */
	public void setConector(String conector) {
		this.conector = conector;
	}
}
