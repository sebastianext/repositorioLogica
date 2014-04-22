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
	public Nodo<String> darArbol(String formula) throws Exception
	{
		subFormulas.add(new SubFormula(null,new SubFormulaIzquierda(formula, null),null));
		String []division = descomposicionFormula(formula);
		if (division[0].length()!=1||division[1]!=null||division[2]!=null) {
			formarSubformulas(division);
		}
		formulaNodo.setInformacion(division[1]);
		formulaNodo.setIzquierdo(new Nodo<String>());
		formulaNodo.getIzquierdo().setInformacion((isRecursivo(division[0],formulaNodo.getIzquierdo())));

		if(division[2] != null)
		{
			formulaNodo.setDerecho(new Nodo<String>());
			formulaNodo.getDerecho().setInformacion(isRecursivo(division[2],formulaNodo.getDerecho()));
		}

		ordenarSubformulas();
		return formulaNodo;
	}
	public String[] descomposicionFormula(String formula){

		String []vector= new String[3];
		if (formula.length()==1) {
			vector[0] = formula;
		}else {
			if (MetodosPredicados.esNegacion(String.valueOf(formula.charAt(0)))) {
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
		try {

			String []division = descomposicionFormula(formula);
			if (division[0].length()!=1||division[1]!=null||division[2]!=null) {
				formarSubformulas(division);
			}
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
		catch (Exception e) {
			throw new Excepcion("No es una formula bien formada, Faltan parentesis. Verifique la expresion ingresada.");
		}
	}

	public void ordenarSubformulas(){

		SubFormula []vector=new SubFormula[subFormulas.size()];
		for (int k = 0; k < vector.length; k++) {
			vector[k]=subFormulas.get(k);
		}
		int i, j;
		SubFormula sub;
		for(i=0;i<vector.length-1;i++){
			for(j=0;j<vector.length-i-1;j++){

				String str=null;
				if (vector[j].getDer()!=null) {
					str=vector[j].getIzq().getSubFormula()+vector[j].getConector()+vector[j].getDer().getSubFormula();

				}else {
					str=vector[j].getIzq().getSubFormula()+vector[j].getConector();
				}
				String str1=null;
				if (vector[j+1].getDer()!=null) {
					str1=vector[j+1].getIzq().getSubFormula()+vector[j+1].getConector()+vector[j+1].getDer().getSubFormula();

				}else {
					str1=vector[j+1].getIzq().getSubFormula()+vector[j+1].getConector();
				}
				str=str.replace("null","");
				str1=str1.replace("null","");
				int actual=str.length();
				int actual1=str1.length();

				if (actual1<actual) {
					sub=vector[j+1];
					vector[j+1]=vector[j];
					vector[j]=sub;
				}		
			}
		}
		subFormulas.removeAll(subFormulas);
		for (int k = 0; k < vector.length; k++) {
			subFormulas.add(vector[k]);
		}
	}

	public void formarSubformulas(String []vector){
		String der=vector[2];
		String izq=vector[0];
		String conector=vector[1]; 
		SubFormulaDerecha subDerecha= new SubFormulaDerecha(der, null);
		SubFormulaIzquierda subIzq = new SubFormulaIzquierda(izq, null);
		SubFormula subformula= new SubFormula(subDerecha, subIzq, conector);
		subFormulas.add(subformula);
	}

	public void solucionFormula(){
		for (SubFormula subFormula : subFormulas) {
			ArrayList<String> solucionPrincipal= new ArrayList<String>();
			String conector=subFormula.getConector();
			if (conector!=null) {
				if (MetodosPredicados.esConjuncion(conector)) {
					String iz=subFormula.getIzq().getSubFormula();
					ArrayList<String> soluciones=buscarSoluciones(iz);
					String der=subFormula.getDer().getSubFormula();
					ArrayList<String> soluciones2=buscarSoluciones(der);
					for(int i = 0; i < combinaciones; i++) {
						if (soluciones.get(i).equals("V") &&
								soluciones2.get(i).equals("V")) {
							solucionPrincipal.add("V");
						}else {
							solucionPrincipal.add("F");
						}

					}
					String formandoFormula="("+iz+")"+conector+"("+der+")";
					asignadoSolucionSubformula(formandoFormula, solucionPrincipal);
				}
				if (MetodosPredicados.esDisjuncion(conector)) {
					String iz=subFormula.getIzq().getSubFormula();
					ArrayList<String> soluciones=buscarSoluciones(iz);
					String der=subFormula.getDer().getSubFormula();
					ArrayList<String> soluciones2=buscarSoluciones(der);
					for(int i = 0; i < combinaciones; i++) {
						if (soluciones.get(i).equals("V") || soluciones2.get(i).equals("V")) {
							solucionPrincipal.add("V");
						}else {
							solucionPrincipal.add("F");
						}
					}
					String formandoFormula="("+iz+")"+conector+"("+der+")";
					asignadoSolucionSubformula(formandoFormula, solucionPrincipal);
				}
				if (MetodosPredicados.esCondicional(conector)) {
					String iz=subFormula.getIzq().getSubFormula();
					ArrayList<String> soluciones=buscarSoluciones(iz);
					String der=subFormula.getDer().getSubFormula();
					ArrayList<String> soluciones2=buscarSoluciones(der);
					for(int i = 0; i < combinaciones; i++) {
						if (soluciones.get(i).equals("V") && soluciones2.get(i).equals("F")) {
							solucionPrincipal.add("F");
						}else {
							solucionPrincipal.add("V");
						}
					}
					String formandoFormula="("+iz+")"+conector+"("+der+")";
					asignadoSolucionSubformula(formandoFormula, solucionPrincipal);
				}
				if (MetodosPredicados.esBicondicional(conector)) {
					String iz=subFormula.getIzq().getSubFormula();
					ArrayList<String> soluciones=buscarSoluciones(iz);
					String der=subFormula.getDer().getSubFormula();
					ArrayList<String> soluciones2=buscarSoluciones(der);
					for(int i = 0; i < combinaciones; i++) {
						if (soluciones.get(i).equals("V") && soluciones2.get(i).equals("V")||
								soluciones.get(i).equals("F") && soluciones2.get(i).equals("F")) {
							solucionPrincipal.add("V");
						}else {
							solucionPrincipal.add("F");
						}
					}
					String formandoFormula="("+iz+")"+conector+"("+der+")";
					asignadoSolucionSubformula(formandoFormula, solucionPrincipal);
				}
				if (MetodosPredicados.esNegacion(conector)) {
					String iz=subFormula.getIzq().getSubFormula();
					ArrayList<String> soluciones=buscarSoluciones(iz);

					for(int i = 0; i < combinaciones; i++) {
						if (soluciones.get(i).equals("V")) {
							solucionPrincipal.add("F");
						}else {
							solucionPrincipal.add("V");
						}
					}
					String formandoFormula=conector+"("+iz+")";
					asignadoSolucionSubformula(formandoFormula, solucionPrincipal);
				}
			}
		}
	}

	public void asignadoSolucionSubformula(String formula,ArrayList<String> soluciones){
		for (int i = 0; i < subFormulas.size(); i++) {
			if (formula.equals(subFormulas.get(i).getIzq().getSubFormula()))
				subFormulas.get(i).getIzq().setSoluciones(soluciones);

			if (subFormulas.get(i).getDer()!=null&&formula.equals(subFormulas.get(i).getDer().getSubFormula())) 
				subFormulas.get(i).getDer().setSoluciones(soluciones);
		}
	}

	public ArrayList<String> buscarSoluciones(String subformula){
		for (SubFormula subFormula : subFormulas) {
			if (subformula.equals(subFormula.getIzq().getSubFormula()))
				return subFormula.getIzq().getSoluciones();
			if (subFormula.getDer()!=null && subformula.equals(subFormula.getDer().getSubFormula()))
				return subFormula.getDer().getSoluciones();
		}
		return null;
	}

	public void llenarAtomos(){
		ArrayList<Atomo> atomos=formula.getAtomos();
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
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			case 2:
				double c=combinaciones*0.125;
				while(c<=combinaciones/4){
					for (int i = 0; i < combinaciones/4; i++) {
						soluciones.add("V");
					}
					for (int i = 0; i < combinaciones/4; i++) {
						soluciones.add("F");
					}
					c*=2;
				}
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones),null));
				break;
			case 3:

				double d=combinaciones*0.0125;
				while(d<=combinaciones/8){
					for (int i = 0; i < combinaciones/8; i++) {
						soluciones.add("V");
					}
					for (int i = 0; i < combinaciones/8; i++) {
						soluciones.add("F");
					}
					d*=2;
				}
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			case 4:
				double e=combinaciones*0.000125;
				while(e<=combinaciones/16){
					for (int i = 0; i < combinaciones/16; i++) {
						soluciones.add("V");
					}
					for (int i = 0; i < combinaciones/16; i++) {
						soluciones.add("F");
					}
					e*=2;
				}
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			case 5:
				double f=combinaciones*0.000000125;
				while(f<=combinaciones/32){
					for (int i = 0; i < combinaciones/32; i++) {
						soluciones.add("V");
					}
					for (int i = 0; i < combinaciones/32; i++) {
						soluciones.add("F");
					}
					f*=2;
				}
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			case 6:
				for (int i = 0; i < combinaciones; i++) {
					if (i%2==0) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			default:
				break;

			}
		}
	}

	public ArrayList<Object> filtrarSubformulas(){

		int n=subFormulas.size();
		//		String vectoAtomos[]= new String[n];
		ArrayList<Object> subConSoluciones= new ArrayList<Object>();
		for (int i = 0; i <n; i++) {
			SubFormulaIzquierda sI=subFormulas.get(i).getIzq();
			SubFormulaDerecha sD=subFormulas.get(i).getDer();
			if (sI!=null && sI.getSoluciones()!=null) {
				subConSoluciones.add(sI);
			}
			if (sD!=null && sD.getSoluciones()!=null) {
				subConSoluciones.add(sD);
			}
		}
		return subConSoluciones;
	}
	
	public String[] llenarCabecera(){
		ArrayList<Object> formulas=filtrarSubformulas();
		String vector[]= new String[formulas.size()];
		for (int i = 0; i < formulas.size(); i++) {

			if (formulas.get(i) instanceof SubFormulaIzquierda) {
				vector[i]=((SubFormulaIzquierda) formulas.get(i)).getSubFormula();
			}
			else {
				vector[i]=((SubFormulaDerecha) formulas.get(i)).getSubFormula();
			}
		}
		return vector;
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

	/**
	 * Metodo que permite obtener subFormulas
	 * @return el subFormulas
	 */
	public ArrayList<SubFormula> getSubFormulas() {
		return subFormulas;
	}

	/**
	 * Metodo que permite asignar subFormulas.
	 * @param subFormulas: el subFormulas a asignar.
	 */
	public void setSubFormulas(ArrayList<SubFormula> subFormulas) {
		this.subFormulas = subFormulas;
	}
}
