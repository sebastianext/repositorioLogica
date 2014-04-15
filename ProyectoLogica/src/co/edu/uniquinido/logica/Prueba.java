package co.edu.uniquinido.logica;

public class Prueba {

	
	public static void main(String[] args) {
		
		
		String form="~((~((p)->(p)))<->(((r)V(s))&(t)))";
		String formula2="((p)&((~(r))V(s)))&((~(p))->(~(~(r))))";
		String formula3="(~((p)&(q)))→(p)";
		String formula="pqrtsz";
		Formula f= new Formula(formula);
		TablaVerdad t= new TablaVerdad(f);
		Nodo<String> a=null;
		
		t.llenarAtomos();
//		try {
//		 a=t.darArbol(formula);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		f.buscarTokens();
//		t.calcularCombinaciones(); 
//		
//		int combinaciones= t.getCombinaciones();
//		int conectores= f.getConectores().size();
//		int atomos= f.getAtomos().size();
//		
//		int columnas= atomos+conectores;
//		
//		System.out.println("La formula es : "+formula);
//		System.err.println("tiene "+atomos+" atomos");
//		
//		System.out.println("tiene "+conectores+" conectores");
//		System.out.println("tiene "+combinaciones+" combinaciones");
//		System.out.println("y tiene "+columnas+" columnas");
		
//		 String s=t.descomposicionFormula(formula);
		 
//		t.recorrerFormulas();
		
//		System.out.println(s);
		
	}

}
