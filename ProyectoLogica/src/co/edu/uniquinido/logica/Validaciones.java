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
 * 22/04/2014
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package co.edu.uniquinido.logica;

/**
 * Clase que implementa Validaciones.java
 */
public class Validaciones {

	private String formula;

	/**
	 * Metodo Costructor que inicializa las variables
	 * @param formula
	 */
	public Validaciones(String formula) {
		super();
		this.formula = formula;
	}

	public void validarParantesis()throws Excepcion{
		int con=0;
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i)=='(' )
				con++;
			if (formula.charAt(i)==')' )
				con--;
		}
		if (con!=0) 
			throw new Excepcion("No es una formula bien formada, Faltan parentesis. Verifique la expresion ingresada.");
		
	}
	public int darConectorPrincipal(){

		if (MetodosPredicados.esNegacion(String.valueOf(formula.charAt(0)))) {
			return 0;
		}else {
			int con=0;
			for (int i = 0; i < formula.length(); i++) {
				if (formula.charAt(i)=='(' )
					con++;
				if (formula.charAt(i)==')' )
					con--;
				if (con==0){
					con=i;
					break;
				}
			}
			return con;
		}
	}

	public void validarOperadoresSeguidos()throws Excepcion{

		for (int i = 0; i < formula.length(); i++) {
			if (MetodosPredicados.esOperador(String.valueOf(formula.charAt(i)))&&
				MetodosPredicados.esOperador(String.valueOf(formula.charAt(i+1))))
				throw new Excepcion("Hay operadores seguidos, verifique la expresion ingresada.");
		}
		
	}

	public void validarAtomosSeguidos()throws Excepcion{

		for (int i = 0; i < formula.length(); i++) {
			if (MetodosPredicados.esAtomo(formula.charAt(i))&&
				MetodosPredicados.esAtomo(formula.charAt(i+1)))
				throw new Excepcion("Hay atomos seguidos, verifique la expresion ingresada.");
		}
		
	}

	public void validarExpresion()throws Excepcion{
		formula=formula.trim();
		if (formula.equals("")) {
			throw new Excepcion("El campo esta vacio, debe ingresar una formula valida.");
		}
		for (int i = 0; i < formula.length(); i++) {
			if (Character.isDigit(formula.charAt(i))) {
				throw new Excepcion("No se permiten el ingreso de numeros, debe ingresar una formula valida.");
			}
		}
		validarAtomosSeguidos();
		validarParantesis();
		validarOperadoresSeguidos();
	}

















}
