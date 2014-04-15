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
	
	private String der;
	private String izq;
	private String conector;
	private ArrayList<String> soluciones;
	/**
	 * Metodo Costructor que inicializa las variables
	 * @param der
	 * @param izq
	 * @param conector
	 * @param soluciones
	 */
	public SubFormula(String der, String izq, String conector,ArrayList<String> soluciones) {
		super();
		this.der = der;
		this.izq = izq;
		this.conector = conector;
		this.soluciones=soluciones;
	}
	
	/**
	 * Metodo Costructor que inicializa las variables
	 * @param der
	 * @param izq
	 * @param conector
	 * @param soluciones
	 */
	public SubFormula(String der, String izq, String conector) {
		super();
		this.der = der;
		this.izq = izq;
		this.conector = conector;
		soluciones = new ArrayList<String>();
	}
	/**
	 * Metodo que permite obtener der
	 * @return el der
	 */
	public String getDer() {
		return der;
	}
	/**
	 * Metodo que permite asignar der.
	 * @param der: el der a asignar.
	 */
	public void setDer(String der) {
		this.der = der;
	}
	/**
	 * Metodo que permite obtener izq
	 * @return el izq
	 */
	public String getIzq() {
		return izq;
	}
	/**
	 * Metodo que permite asignar izq.
	 * @param izq: el izq a asignar.
	 */
	public void setIzq(String izq) {
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
