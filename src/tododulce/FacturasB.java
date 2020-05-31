package tododulce;

import java.util.ArrayList;
import java.util.Calendar;

public class FacturasB extends Facturas {

	private static int cantidadGenerada;

	/**
	 * 
	 */
	public FacturasB() {
		super();
		cantidadGenerada++;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fechaEmision
	 * @param sucursal
	 * @param numero
	 * @param detalles
	 * @param cliente
	 */
	public FacturasB(Calendar fechaEmision, Sucursales sucursal, long numero, ArrayList<Detalles> detalles,
			Clientes cliente) {
		super(fechaEmision, sucursal, numero, detalles, cliente);

		cantidadGenerada++;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fechaEmision
	 * @param sucursal
	 * @param numero
	 * @param detalles
	 * @param cliente
	 * @param pago
	 */
	public FacturasB(Calendar fechaEmision, Sucursales sucursal, long numero, ArrayList<Detalles> detalles,
			Clientes cliente, Pagos pago) {
		super(fechaEmision, sucursal, numero, detalles, cliente, pago);

		cantidadGenerada++;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String fact = "\n\t\tB\n\nFanctua Nro: " + retornarNumeroFactura() + "\n";
		int i = 0;
		float total = 0;
		for (Detalles detalle : detalles) {

			float valor = (detalle.getProducto().getPrecio() * 21 / 100);
			if (detalle.getProducto() instanceof GoloPaquete
					&& ((GoloPaquete) detalle.getProducto()).isOferta() == true) {
				valor = valor / 2;
			} else if (detalle.getProducto() instanceof GoloKilo
					&& ((GoloKilo) detalle.getProducto()).getDescuento() > 0) {
				valor = valor - (valor * (((GoloKilo) detalle.getProducto()).getDescuento() / 100));
			}

			float parcial = valor * detalle.getCantidad();

			total += parcial;

			fact += String.format("%-5s%-5s%-30s%-10s%-10s\n", (i + 1), detalle.getCantidad(),
					detalle.getProducto().getDescripcion(), valor, parcial);
			// System.out.printf( "%-5s%-5s%-30s%-10d%-10d\n", i, detalle.getCantidad(),
			// detalle.getProducto().getDescripcion(),valor, parcial );
		}
		fact += "\n\nTotal:\t\t" + total;

		return fact;
	}

	public float calcularTotal() {
		float total = 0;
		for (Detalles detalle : detalles) {

			float valor = (detalle.getProducto().getPrecio() * 21 / 100);
			float parcial = valor * detalle.getCantidad();
			total += parcial;
		}
		return total;
	}

	public void mostrarDetalle() {
	}

	/**
	 * @return the cantidadGenerada
	 */
	public static int getCantidadGenerada() {
		return cantidadGenerada;
	}

	/**
	 * @param cantidadGenerada the cantidadGenerada to set
	 */
	public static void setCantidadGenerada(int cantidadGenerada) {
		FacturasB.cantidadGenerada = cantidadGenerada;
	}

}
