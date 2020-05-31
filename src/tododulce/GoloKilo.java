package tododulce;

import java.util.Arrays;

public class GoloKilo extends Golosinas {

	private float descuento;

	/**
	 *
	 */
	public GoloKilo() {
		super();
	}

	/**
	 * @param descuento
	 */
	public GoloKilo(float descuento) {
		super();
		this.descuento = descuento;
	}

	/**
	 * @param precio
	 * @param codigo
	 * @param descripcion
	 * @param sabores
	 */
	public GoloKilo(float precio, int codigo, String descripcion, String[] sabores) {
		super();
		this.precio = precio;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sabores = sabores;
	}

	/**
	 * @param precio
	 * @param codigo
	 * @param descripcion
	 * @param sabores
	 */
	public GoloKilo(float precio, int codigo, String descripcion, String[] sabores, float descuento) {
		super();
		this.precio = precio;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sabores = sabores;
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		String str = this.codigo + " - " + this.descripcion + " Precio: " + this.precio + "\nSabores: ";

		for (String string : sabores) {
			str = str + string + " ";
		}

		if (this.descuento > 0) {
			str = "El producto tiene un descuento de: " + this.descuento;
		}

		return str;
	}

	/**
	 * @return el dato de descuento
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento para cargar en descuento
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

}
