package tododulce;

import funciones.Funciones;

public class Golosinas implements Comparable<Golosinas>{

	private float precio;

	private int codigo;

	private String descripcion;

	private String[] sabores = new String[3];

	
	public Golosinas() {
	}

	/**
	 * @param precio
	 * @param codigo
	 * @param descripcion
	 * @param sabores
	 */
	public Golosinas(float precio, int codigo, String descripcion, String[] sabores) {
		this.precio = precio;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sabores = sabores;
	}

	/**
	 * @return el dato de precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio para cargar en precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return el dato de codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo para cargar en codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return el dato de descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion para cargar en descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el dato de sabores
	 */
	public String[] getSabores() {
		return sabores;
	}

	/**
	 * @param sabores para cargar en sabores
	 */
	public void setSabores(String[] sabores) {
		this.sabores = sabores;
	}

	public boolean listar_sabores() {

		if (sabores.length == 0) {
			System.out.println("No hay sabores registrados.");
			return false;
		} else {
			if (Funciones.pedirBooleano("Desea ver un listado de los sabores? s/n", "s", "n")) {

				int i = 0;
				for (String sabor : sabores) {
					System.out.print(i + " - ");
					System.out.println(sabor);
					i++;
				}
			}
			return true;
		}
	}

	public void eitar_sabor(int index) {
		if (Funciones.pedirBooleano("Desea modificat el sabor " + sabores[index] + "? s/n", "s", "n")) {
			sabores[index] = Funciones.pedirString("Ingrese el sabor");

		}
	}

	public void add_sabor() {
//		if (Funciones.pedirBooleano("Desea agregar un sabor? s/n", "s", "n")) {

		for (int i = 0; i < sabores.length; i++) {
			if (sabores[i] == null) {
				sabores[i] = Funciones.pedirString("Ingrese el sabor");
				break;

			}
		}

	}

	@Override
	public int compareTo(Golosinas o) {
		if(precio == o.getPrecio()) {
			return 0;
		}
		if(precio < o.getPrecio()) {
			return 1;
		}
		else {
			return -1;
		}
	}


}
