package co.edu.uniquinido.logica;

public class Prueba {

	
	public static void main(String[] args) {
		
		
		String formula="(~p&~q)->(rVq)";
		Formula f= new Formula(formula);
		TablaVerdad t= new TablaVerdad(f);
		f.buscarTokens();
		t.calcularCombinaciones(); 
		
		int combinaciones= t.getCombinaciones();
		int conectores= f.getConectores().size();
		int atomos= f.getAtomos().size();
		
		int columnas= atomos+conectores;
		
		System.out.println("La formula es : "+formula);
		System.err.println("tiene "+atomos+" atomos");
		
		System.out.println("tiene "+conectores+" conectores");
		System.out.println("tiene "+combinaciones+" combinaciones");
		System.out.println("y tiene "+columnas+" columnas");
		
		
	}

}
