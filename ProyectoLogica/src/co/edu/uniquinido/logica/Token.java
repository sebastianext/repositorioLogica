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
 * Clase que implementa Token.java
 */
public class Token {

	
	private String lexema;
	private int indice;
	
	/**
	 * Metodo Costructor que inicializa las variables
	 * @param lexema
	 * @param indice
	 */
	public Token(String lexema, int indice) {
		super();
		this.lexema = lexema;
		this.indice = indice;
	}

	/**
	 * Metodo que permite obtener lexema
	 * @return el lexema
	 */
	public String getLexema() {
		return lexema;
	}

	/**
	 * Metodo que permite asignar lexema.
	 * @param lexema: el lexema a asignar.
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	/**
	 * Metodo que permite obtener indice
	 * @return el indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * Metodo que permite asignar indice.
	 * @param indice: el indice a asignar.
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	
	
}
