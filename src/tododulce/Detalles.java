package tododulce;

public class Detalles implements iBasica {

	private float cantidad;

	private Golosinas producto;

	/**
	 *
	 */
	public Detalles() {
	}

	/**
	 * @param cantidad
	 * @param producto
	 */
	public Detalles(float cantidad, Golosinas producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	/**
	 * @return el dato de cantidad
	 */
	public float getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad para cargar en cantidad
	 */
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return el dato de producto
	 */
	public Golosinas getProducto() {
		return producto;
	}

	/**
	 * @param producto para cargar en producto
	 */
	public void setProducto(Golosinas producto) {
		this.producto = producto;
	}

}
