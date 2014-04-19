package co.edu.uniquinido.logica;

public class Prueba {

	
	public static void main(String[] args) {
		
		
		String form="~((~((p)->(p)))<->(((r)V(s))&(t)))";
		String formula2="((p)&((~(r))V(s)))&((~(p))->(~(~(r))))";
		String formula3="(~((p)&(q)))→(p)";
		String formula="(p)&(q)";
		Formula f= new Formula(formula3);
		TablaVerdad t= new TablaVerdad(f);
		Nodo<String> a=null;
		
		t.llenarAtomos();
		
		try {
		 a=t.darArbol(formula3);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		t.solucionFormula();


		
	}

}
