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
import java.util.Vector;

/**
 * Clase que implementa TablaVerdad.java
 */
public class TablaVerdad {

	private int combinaciones;
	private int filas;
	private int columnas;
	private Formula formula;
	private ArrayList<SubFormula> subFormulas;
	private Nodo<String> formulaNodo;

	public TablaVerdad(Formula f){
		formula=f;
		subFormulas= new ArrayList<SubFormula>();
		formulaNodo= new Nodo<String>();
		formula.buscarTokens();
		calcularCombinaciones();
		
	}

	public void calcularCombinaciones(){
		combinaciones=(int)Math.pow(2, formula.getAtomos().size());
	}
	public String[] descomposicionFormula(String formula){

		String []vector= new String[3];
		if (formula.length()==1) {
			vector[0] = formula;
		}else {
			if (formula.charAt(0)=='~') {
				vector[1]=String.valueOf(formula.charAt(0));
				vector[0]=formula.substring(2, formula.length()-1);
			}else{
				int con=0;
				for (int i = 0; i < formula.length(); i++) {
					if (formula.charAt(i)=='('){
						con++;
					}if (formula.charAt(i)==')'){
						con--;
					}if (con==0){
						vector[0] = formula.substring(1, i);
						vector[1] = String.valueOf(formula.charAt(i+1));
						vector[2] = formula.substring(i+3, formula.length()-1);
						break;
					}
				}
			}
		}
		return vector;
	}

	private String isRecursivo(String formula, Nodo<String> nodo) throws Exception
	{
		String []division = descomposicionFormula(formula);
		formarSubformulas(division);
		if(division[1]==null){
			return division[0];
		}

		nodo.setIzquierdo(new Nodo<String>());
		nodo.getIzquierdo().setInformacion(isRecursivo(division[0], nodo.getIzquierdo()));

		if(division[2] != null){
			nodo.setDerecho(new Nodo<String>());
			nodo.getDerecho().setInformacion(isRecursivo(division[2],  nodo.getDerecho()));
		}
		return division[1];
	}

	public Nodo<String> darArbol(String formula) throws Exception
	{
		String []division = descomposicionFormula(formula);
		formarSubformulas(division);
		formulaNodo.setInformacion(division[1]);
		formulaNodo.setIzquierdo(new Nodo<String>());
		formulaNodo.getIzquierdo().setInformacion((isRecursivo(division[0],formulaNodo.getIzquierdo())));

		if(division[2] != null)
		{
			formulaNodo.setDerecho(new Nodo<String>());
			formulaNodo.getDerecho().setInformacion(isRecursivo(division[2],formulaNodo.getDerecho()));
		}
		return formulaNodo;
	}


	public void formarSubformulas(String []vector){

		String der=vector[2];
		String izq=vector[0];
		String conector=vector[1];
		SubFormula subformula= new SubFormula(der, izq, conector);
		System.out.println(subformula.getIzq()+subformula.getConector()+subformula.getDer());
		subFormulas.add(subformula);
	}

	public void solucionFormula(){
		for (SubFormula subFormula : subFormulas) {
			String conector=subFormula.getConector();
			if (esConjuncion(conector)) {
				String iz=subFormula.getIzq();
				iz
				String der=subFormula.getDer();
			}
		}
	}
	
	public void buscarSolucionesIz(String iz){
		
		for (SubFormula subFormula : subFormulas) {
			if (iz.equals(subFormula.getIzq())) {
				
			}
		}
	}
	public void llenarAtomos(){
		ArrayList<Atomo> atomos=formula.getAtomos();
		String vector[]= new String[3];
		int cont=0;

		for (Atomo atomo : atomos) {
			ArrayList<String> soluciones= new ArrayList<String>();
			
			cont++;
			switch (cont) {
			case 1:
				for (int i = 0; i < combinaciones/2; i++) {
					soluciones.add("V");
				}
				for (int i = 0; i < combinaciones/2; i++) {
					soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, atomo.getLexema(), null, soluciones));
				break;
			case 2:
				for (int i = 0; i < combinaciones; i++) {
					if (i<=15 || (i>=32 && i<=47)) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, atomo.getLexema(), null, soluciones));
				break;
				
			case 3:
				for (int i = 0; i < combinaciones; i++) {
					if (i<=7 || (i>=16 && i<=23)) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, atomo.getLexema(), null, soluciones));
				break;
			case 4:
				for (int i = 0; i < combinaciones; i++) {
					if (i<=3 || (i>=8 && i<=11)|| (i>=16 && i<=19)|| (i>=24 && i<=27)) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, atomo.getLexema(), null, soluciones));
				break;
			case 5:
				for (int i = 0; i < combinaciones; i++) {
					if (i<=1 || i==4 || i==5 || i==8 || i==9|| i==12 || i==13
							 || i==16|| i==17|| i==20|| i==21|| i==24|| i==25
							 || i==28|| i==29) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, atomo.getLexema(), null, soluciones));
				break;
			case 6:
				for (int i = 0; i < combinaciones; i++) {
					if (i%2==0) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, atomo.getLexema(), null, soluciones));
				break;
			default:
				break;

			}
		}
	}


	public boolean esConjuncion(String conector){
		return conector.equals(Constantes.CONJUNCION)||conector.equals(Constantes.CONJUNCION2);
	}












	/**
	 * recursivo
	 * Metodo que 
	 * @param formula
	 * @return
	 */
	//	public String descomposicionFormula(String formula){
	//
	//		if (formula.length()==1) {
	//			return null;
	//		}else{
	//			if (formula.charAt(0)=='~') {
	//				String subFormula=formula.substring(1, formula.length());
	//				subformulas.add(subFormula);
	//				descomposicionFormula(subFormula.substring(1,subFormula.length()-1));
	//			}else{
	//				int con=0;
	//				for (int i = 0; i < formula.length(); i++) {
	//					if (formula.charAt(i)=='(') {
	//						con++;
	//					}if (formula.charAt(i)==')') {
	//						con--;
	//					}if (con==0) {
	//						String conector=this.formula.extraerConector(formula, i+1);
	//						String subFormula=formula.substring(0,i+1);
	//						subformulas.add(subFormula);
	//						descomposicionFormula(subFormula.substring(1,subFormula.length()-1));
	//						return subFormula;
	//						//						if (conector.equals("<->")) {
	//						//							String subFormulaDer=formula.substring(i+3, formula.length()-1);
	//						//							subformulas.add(subFormulaDer);
	//						//							descomposicionFormula(subFormulaDer);
	//						//						}if (conector.equals("->")) {
	//						//							String subFormulaDer=formula.substring(i+2, formula.length()-1);
	//						//							subformulas.add(subFormulaDer);
	//						//							descomposicionFormula(subFormulaDer);
	//						//						}
	//					}
	//				}
	//			}
	//			return formula;
	//		}
	//
	//	}

	/**
	 * sirve
	 * Metodo que 
	 * @param formula
	 * @return
	 */
	//	public String descomposicionFormula(String formula){
	//
	//		if (formula.length()==1) {
	//			return formula;
	//		}else{
	//			if (formula.charAt(0)=='~') {
	//				String subFormula=formula.substring(1, formula.length());
	//				subformulas.add(subFormula);
	//				return descomposicionFormula(subFormula.substring(1,subFormula.length()-1));
	//			}else{
	//				int con=0;
	//				String subFormula="";
	//				for (int i = 0; i < formula.length(); i++) {
	//					if (formula.charAt(i)=='(') {
	//						con++;
	//					}if (formula.charAt(i)==')') {
	//						con--;
	//					}if (con==0) {
	//						String conector=this.formula.extraerConector(formula, i+1);
	//						if (conector!=null) {
	//
	//							subFormula=formula.substring(0,i+1);
	//							subformulas.add(subFormula);
	//							descomposicionFormula(subFormula.substring(1,subFormula.length()-1));
	//							descomposicionFormulaDer(formula);
	//						}
	//					}
	//				}
	//
	//				return subFormula;
	//			}
	//		}
	//	}

	//	public String descomposicionFormulaDer(String formula){
	//
	//		if (formula.length()==1) {
	//			return formula;
	//		}else{
	//			if (formula.charAt(0)=='~') {
	//				String subFormula=formula.substring(1, formula.length());
	//				subformulas.add(subFormula);
	//				return descomposicionFormula(subFormula.substring(1,subFormula.length()-1));
	//			}else{
	//				int con=0;
	//				String subFormula="";
	//				for (int i = 0; i < formula.length(); i++) {
	//					if (formula.charAt(i)=='(') {
	//						con++;
	//					}if (formula.charAt(i)==')') {
	//						con--;
	//					}if (con==0) {
	//						String conector=this.formula.extraerConector(formula, i+1);
	//						if (conector!=null) {
	//							if (conector.equals("<->")) {
	//								String subFormulaDer=formula.substring(i+3, formula.length()-1);
	//								subformulas.add(subFormulaDer);
	//								descomposicionFormulaDer(subFormulaDer);
	//							}if (conector.equals("->")) {
	//								String subFormulaDer=formula.substring(i+2, formula.length()-1);
	//								subformulas.add(subFormulaDer);
	//								descomposicionFormulaDer(subFormulaDer);
	//							}if (conector.equals("&")||conector.equals("V")) {
	//								String subFormulaDer=formula.substring(i+2, formula.length());
	//								subformulas.add(subFormulaDer);
	//								descomposicionFormulaDer(formula.substring(i+3, formula.length()-1));
	//							}
	//						}
	//
	//					}
	//				}
	//
	//				return subFormula;
	//			}
	//		}
	//	}













	public void recorrerFormulas(){
		for (int i = 0; i < subFormulas.size(); i++) {
			System.out.println(subFormulas.get(i));
		}
	}


















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
