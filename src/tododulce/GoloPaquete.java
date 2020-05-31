package tododulce;

import funciones.Funciones;

public class GoloPaquete extends Golosinas {

	private Depositos[] deposito;

	private boolean oferta = false;

	/**
	 *
	 */
	public GoloPaquete() {
		this.deposito = new Depositos[20];
	}

	/**
	 * @param oferta
	 */
	public GoloPaquete(boolean oferta) {
		super();
		this.oferta = oferta;
	}

	/**
	 * @param deposito
	 * @param oferta
	 */
	public GoloPaquete(Depositos[] deposito, boolean oferta) {
		super();
		this.deposito = deposito;
		this.oferta = oferta;
	}

	/**
	 * @param precio
	 * @param codigo
	 * @param descripcion
	 * @param sabores
	 */
	public GoloPaquete(float precio, int codigo, String descripcion, String[] sabores, Depositos[] deposito,
			boolean oferta) {
		super();
		this.precio = precio;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sabores = sabores;
		this.deposito = deposito;
		this.oferta = oferta;
	}

	@Override
	public String toString() {
		String str = this.codigo + " - " + this.descripcion + " Precio: " + this.precio + "\nSabores: ";

		for (String string : sabores) {
			str = str + string + " ";
		}
		str = " \n Depositos con existencias\n";
		for (Depositos depo : this.deposito) {
			str = str + depo.getNombre() + "\n";
		}
		if (this.oferta == true) {
			str = "El producto esta en oferta";
		}

		return str;
	}

	/**
	 * @return el dato de deposito
	 */
	public Depositos[] getDeposito() {
		return deposito;
	}

	/**
	 * @param deposito para cargar en deposito
	 */
	public void setDeposito(Depositos[] deposito) {
		this.deposito = deposito;
	}

	/**
	 * Agrega el deposito pasado por parametro en la primer posicion disponible del
	 * array de depositos de la golosina.
	 * 
	 * @param depo
	 */
	public void addDeposito(Depositos depo) {

		for (int i = 0; i < deposito.length; i++) {
			if (deposito[i] == null) {
				deposito[i] = depo;
				break;

			}
		}

	}

	/**
	 * @return el dato de oferta
	 */
	public boolean isOferta() {
		return oferta;
	}

	/**
	 * @param oferta para cargar en oferta
	 */
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

}
