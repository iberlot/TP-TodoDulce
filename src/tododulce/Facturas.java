package tododulce;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;

import funciones.Funciones;

/**
 * Clase de Facturas
 *
 * @author IVANB
 * @since 11 mar. 2020
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public abstract class Facturas implements iBasica {

	/**
	 * Fecha de emicion de las facturas
	 */
	protected Calendar fechaEmision;

	/**
	 * Cantidad de dias para el vencimiento de las facturas.
	 */
	protected static int diasVto;

	/**
	 * Sucursal con la que se factura, de aca se saca la primer parte del numero de
	 * factura
	 */
	protected Sucursales sucursal;

	/**
	 * Numero de la factura.
	 */
	protected long numero;

	/**
	 * Array con los items vendidos en las facturas.
	 */
	protected ArrayList<Detalles> detalles = new ArrayList<Detalles>();

	/**
	 * Pasajero que realizo la compra
	 */
	protected Clientes cliente;

	/**
	 * Informacion del pago de las factura
	 */
	protected Pagos pago;

	/**
	 * Nombre de la tienda que realia la venta y que se muestra en la factura
	 * impresa.
	 */
	protected static final String nombreTienda = "TodoDulce";

	/**
	 * Constructor de la clase
	 */
	public Facturas() {

	}

	/**
	 * @param fechaEmision
	 * @param sucursal
	 * @param numero
	 * @param detalles
	 * @param cliente
	 * @param pago
	 */
	public Facturas(Calendar fechaEmision, Sucursales sucursal, long numero, ArrayList<Detalles> detalles,
			Clientes cliente) {
		super();
		this.fechaEmision = fechaEmision;
		this.sucursal = sucursal;
		this.numero = numero;
		this.detalles = detalles;
		this.cliente = cliente;
	}

	/**
	 * @param fechaEmision
	 * @param sucursal
	 * @param numero
	 * @param detalles
	 * @param cliente
	 * @param pago
	 */
	public Facturas(Calendar fechaEmision, Sucursales sucursal, long numero, ArrayList<Detalles> detalles,
			Clientes cliente, Pagos pago) {
		super();
		this.fechaEmision = fechaEmision;
		this.sucursal = sucursal;
		this.numero = numero;
		this.detalles = detalles;
		this.cliente = cliente;
		this.pago = pago;
	}

	@Override
	abstract public String toString();

	/**
	 * @return el String con el numero de la factura formateado
	 */
	@SuppressWarnings("resource")
	public String retornarNumeroFactura() {

		String numeroFactura;

		Formatter num = new Formatter();
		num.format("%08d", this.numero);

		Formatter centro = new Formatter();
		centro.format("%04d", sucursal.getCodigo());

		numeroFactura = centro + "-" + num;

		return numeroFactura;

	}

	public abstract float calcularTotal();

	public void mostrarFactura() {
	}

	public Calendar calcularVto() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void mostrarDetalle() {
	}

	/**
	 * @return the fechaEmision
	 */
	public Calendar getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(Calendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the diasVto
	 */
	public static int getDiasVto() {
		return diasVto;
	}

	/**
	 * @param diasVto the diasVto to set
	 */
	public static void setDiasVto(int diasVto) {
		Facturas.diasVto = diasVto;
	}

	/**
	 * @return the sucursal
	 */
	public Sucursales getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the numero
	 */
	public long getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(long numero) {
		this.numero = numero;
	}

	/**
	 * @return the cliente
	 */
	public Clientes getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the pago
	 */
	public Pagos getPago() {
		return pago;
	}

	/**
	 * @param pago the pago to set
	 */
	public void setPago(Pagos pago) {
		this.pago = pago;
	}

	/**
	 * @return el dato de detalles
	 */
	public ArrayList<Detalles> getDetalles() {
		return detalles;
	}

	/**
	 * @param detalles para cargar en detalles
	 */
	public void setDetalles(ArrayList<Detalles> detalles) {
		this.detalles = detalles;
	}

	public void registrar_pago() throws Exception {
		if (this.getPago() == null) {
			this.pago = new Pagos();
			this.pago.regis_pago();
		} else {
			this.pago.modificar_pago();
		}
	}

	public boolean tieneGolo(Golosinas golo) {
		for (Detalles detalles2 : detalles) {
			if (golo.getDescripcion().equalsIgnoreCase(detalles2.getProducto().getDescripcion())) {
				return true;
			}
		}
		return false;

	}
}
