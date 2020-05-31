package tododulce;

import funciones.Funciones;

public class Depositos implements iBasica {

	private String nombre;

	private Domicilios domicilio;

	private boolean propio;

	/**
	 *
	 */
	public Depositos() {
		this.domicilio = new Domicilios();
	}

	/**
	 * @param nombre
	 * @param propio
	 */
	public Depositos(String nombre, boolean propio) {
		
		this.domicilio = new Domicilios();
		this.nombre = nombre;
		this.propio = propio;
	}

	/**
	 * @param nombre
	 * @param domicilio
	 * @param propio
	 */
	public Depositos(String nombre, Domicilios domicilio, boolean propio) {
		this.domicilio = new Domicilios();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.propio = propio;
	}

	@Override
	public String toString() {
		return "Deposito: " + getNombre() + " - Propio: " + ((isPropio()) ? "si" : "no") + "\n" + getDomicilio();
	}

	/**
	 * Pide y setea los datos del deposito.
	 */
	public void nuevo_deposito() {
		this.domicilio.nueva_direccion();
		this.setNombre(Funciones.pedirString("Ingrese el nombre del deposito"));
		this.setPropio(Funciones.pedirBooleano("Es un deposito propio? s/n ", "s", "n"));
	}

	/**
	 * Funcion que pregunta por los distintos datos del deposito y permite
	 * modificarlos.
	 */
	public void modificarDeposito() {

		if (Funciones.pedirBooleano("Desea modificar el domicilio? s/n", "s", "n")) {
			this.getDomicilio().editar_domicilio();
		}
		if (Funciones.pedirBooleano("Desea modificar el nombre del deposito? s/n", "s", "n")) {
			this.setNombre(Funciones.pedirString("Ingrese el nombre del deposito"));
		}
		if (Funciones.pedirBooleano("Desea modificar la propiedad del deposito? s/n", "s", "n")) {
			this.setPropio(Funciones.pedirBooleano("Es un deposito propio? s/n ", "s", "n"));
		}
	}

	/**
	 * @return el dato de nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre para cargar en nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el dato de domicilio
	 */
	public Domicilios getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio para cargar en domicilio
	 */
	public void setDomicilio(Domicilios domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return el dato de propio
	 */
	public boolean isPropio() {
		return propio;
	}

	/**
	 * @param propio para cargar en propio
	 */
	public void setPropio(boolean propio) {
		this.propio = propio;
	}

}
