/**
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Universidad del Quind�o (Armenia - Colombia)
 * Programa de Ingenier�a de Sistemas y Computaci�n
 *
 * Asignatura: 
 * Aplicacion: 
 * @author Johan Sebastian Quintero
 * @author Universidad del Quindio
 * @vesion 1.0
 * 22/04/2014
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package co.edu.uniquinido.logica;

/**
 * Clase que implementa MetodosPredicados.java
 */
public class MetodosPredicados {
	
	/**
	 * Determina si un car�cter es una letra
	 * @param caracter - Car�cter que se va a analizar - caracter!=null,
	 * @return true o false seg�n el car�cter sea una letra  o no
	 */
	public static boolean esAtomo(char caracter){
		return ( caracter >= 'a' && caracter <= 'z');
	}
	public static boolean esConjuncion(String conector){
		return conector.equals(Constantes.CONJUNCION)||conector.equals(Constantes.CONJUNCION2);
	}
	public static boolean esDisjuncion(String conector){
		return conector.equals(Constantes.DISYUNCION);
	}
	
	public static boolean esCondicional(String conector){
		return conector.equals(Constantes.CONDICIONAL);
	}
	public static boolean esBicondicional(String conector){
		return conector.equals(Constantes.BICONDICIONAL);
	}
	public static boolean esNegacion(String conector){
		return conector.equals(Constantes.NEGADO)||conector.equals(Constantes.NEGADO2);
	}
	
	public static boolean esOperador(String conector){
		return esConjuncion(conector) ||
			   esDisjuncion(conector) ||
			   esNegacion(conector)   ||
			   esCondicional(conector)||
			   esBicondicional(conector);
	}
}
