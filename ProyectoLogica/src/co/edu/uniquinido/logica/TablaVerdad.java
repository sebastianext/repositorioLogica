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
	private ArrayList<SubFormula> solocionesAtomos;

	public TablaVerdad(Formula f){
		formula=f;
		subFormulas= new ArrayList<SubFormula>();
		formulaNodo= new Nodo<String>();
		formula.buscarTokens();
		calcularCombinaciones();
		solocionesAtomos= new ArrayList<SubFormula>();
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

	public Nodo<String> darArbol(String formula) throws Exception
	{
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

		//		ordenarSubformulas();
		return formulaNodo;
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

				String str=vector[j].getIzq().getSubFormula()+vector[j].getConector()+vector[j].getDer().getSubFormula();
				str=str.replace("null","");
				String str1=vector[j+1].getIzq().getSubFormula()+vector[j+1].getConector()+vector[j+1].getDer().getSubFormula();
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
		System.out.println(subformula.getIzq().getSubFormula()+subformula.getConector()+subformula.getDer().getSubFormula());
		subFormulas.add(subformula);
	}

	public void solucionFormula(){
		for (SubFormula subFormula : subFormulas) {
			ArrayList<String> solucionPrincipal= new ArrayList<String>();
			String conector=subFormula.getConector();
			if (conector!=null) {
				if (esConjuncion(conector)) {
					String iz=subFormula.getIzq().getSubFormula();
					ArrayList<String> soluciones=buscarSoluciones(iz);
					String der=subFormula.getDer().getSubFormula();
					ArrayList<String> soluciones2=buscarSoluciones(der);
					for (int i = 0; i < combinaciones; i++) {
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
			}
		}
	}

	public void asignadoSolucionSubformula(String formula,ArrayList<String> soluciones){
		for (int i = 0; i < subFormulas.size(); i++) {
			if (formula.equals(subFormulas.get(i).getIzq().getSubFormula()))
				subFormulas.get(i).getIzq().setSoluciones(soluciones);

			
				if (subFormulas.get(i).getDer()!=null&&
					formula.equals(subFormulas.get(i).getDer().getSubFormula())) 
					subFormulas.get(i).getDer().setSoluciones(soluciones);
			}
	}

	public ArrayList<String> buscarSoluciones(String subformula){
		for (SubFormula subFormula : subFormulas) {
			if (subformula.equals(subFormula.getIzq().getSubFormula()))
				return subFormula.getIzq().getSoluciones();
		}
		return null;
	}

	public void llenarAtomos(){
		ArrayList<Atomo> atomos=formula.getAtomos();
		//		String vector[]= new String[3];
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
				solocionesAtomos.add(new SubFormula(null,  new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
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
				solocionesAtomos.add(new SubFormula(null,  new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
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
				solocionesAtomos.add(new SubFormula(null,  new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
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
				solocionesAtomos.add(new SubFormula(null,  new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
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
				solocionesAtomos.add(new SubFormula(null,  new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			case 6:
				for (int i = 0; i < combinaciones; i++) {
					if (i%2==0) 
						soluciones.add("V");
					else
						soluciones.add("F");
				}
				solocionesAtomos.add(new SubFormula(null,  new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				subFormulas.add(new SubFormula(null, new SubFormulaIzquierda(atomo.getLexema(), soluciones), null));
				break;
			default:
				break;

			}
		}
	}


	public boolean esConjuncion(String conector){
		return conector.equals(Constantes.CONJUNCION)||conector.equals(Constantes.CONJUNCION2);
	}

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

	/**
	 * Metodo que permite obtener solocionesAtomos
	 * @return el solocionesAtomos
	 */
	public ArrayList<SubFormula> getSolocionesAtomos() {
		return solocionesAtomos;
	}

	/**
	 * Metodo que permite asignar solocionesAtomos.
	 * @param solocionesAtomos: el solocionesAtomos a asignar.
	 */
	public void setSolocionesAtomos(ArrayList<SubFormula> solocionesAtomos) {
		this.solocionesAtomos = solocionesAtomos;
	}

}
