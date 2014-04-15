package co.edu.uniquinido.logica;



public class Nodo<T> {

	/**
	 * Declaracion de atributos
	 */
	private String  informacion; 
	private Nodo<T>  izquierdo;         
	private Nodo<T>  derecho;        

	/**
	 * Metodo constructor de la clase nodo  
	 * @param caracter un número
	 */
	public Nodo( String caracter ) {
		this( caracter, null, null );
	}

	/**
	 *Crea un nodo con referencia a la izquierda y derecha 
	 * @param caracter el número
	 * @param izquierdo Referencia a la izquierda
	 * @param derecho Referencia a la derecha
	 */
	public Nodo( String caracter, Nodo<T> izquierdo, Nodo<T> derecho ) {
		this.informacion  = caracter;
		this.izquierdo     = izquierdo;
		this.derecho    = derecho;

	}

	public Nodo() {}

	/**
	 * metodo para determinar si un nodo es hoja,
	 * es decir, no tiene hijos.
	 * @return true o false
	 */
	public boolean esHoja() {
		return (izquierdo==null && derecho==null);
	}

	/**
	 * Permite devolver la informacion
	 * @return La informacion
	 */
	public String getInformacion() {
		return informacion;
	}

	/**
	 * Permite fijar la informacion
	 * @param informacion
	 */
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	/**
	 * Permite obtener la referencia a la izquierda
	 * @return El nodo de la izquierda
	 */
	public Nodo<T> getIzquierdo() {
		return izquierdo;
	}

	/**
	 * Permite fijar la referencia a la izquierda
	 * @return El nodo de la izquierda
	 */
	public void setIzquierdo(Nodo<T> izquierdo) {
		this.izquierdo = izquierdo;
	}

	/**
	 * Permite obtener la referencia a la derecha
	 * @return El nodo de la derecha
	 */
	public Nodo<T> getDerecho() {
		return derecho;
	}

	/**
	 * Permite fijar la referencia a la drecha
	 * @param derecho El nodo de la derecha
	 */
	public void setDerecho(Nodo<T> derecho) {
		this.derecho = derecho;
	}
}