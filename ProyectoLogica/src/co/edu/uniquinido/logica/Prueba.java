package co.edu.uniquinido.logica;

import java.util.ArrayList;
import java.util.Vector;

public class Prueba {

	
	public static void main(String[] args) {
		
		
		String form="~((~((p)->(p)))<->(((r)V(s))&(t)))";
		String formula="(p)&(q)";
		String formula2="((p)&((~(r))V(s)))&((~(p))->(~(~(r))))";
		
		String formula3="(~((p)&(q)))→(p)";
		String formula4="((~(p))&(~(q)))→((r)V(q))";
		String formula5="((p)&(q))→(~((~(p))V(~(q))))";
		String formula6="(¬(p))&(q)";
				
		
		Formula f= new Formula(formula4);
		TablaVerdad t= new TablaVerdad(f);
		Nodo<String> a=null;
		
		t.llenarAtomos();
		
		try {
		 a=t.darArbol(formula4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		t.solucionFormula();
		ArrayList<SubFormula> sub=t.getSubFormulas();
		String vec[]=t.llenarCabecera();


		
	}

}
