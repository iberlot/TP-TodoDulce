package tododulce;

import java.util.ArrayList;
import java.util.Calendar;

public class FacturasA extends Facturas {

	public FacturasA() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fechaEmision
	 * @param sucursal
	 * @param numero
	 * @param detalles
	 * @param cliente
	 */
	public FacturasA(Calendar fechaEmision, Sucursales sucursal, long numero, ArrayList<Detalles> detalles,
			Clientes cliente) {
		super(fechaEmision, sucursal, numero, detalles, cliente);
		// TODO Auto-generated constructor stub
	}

	public FacturasA(Calendar fechaEmision, Sucursales sucursal, long numero, ArrayList<Detalles> detalles,
			Clientes cliente, Pagos pago) {
		super(fechaEmision, sucursal, numero, detalles, cliente, pago);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String fact = "\n\t\tB\n\nFanctua Nro: " + retornarNumeroFactura() + "\n";
		int i = 0;
		float total = 0;
		for (Detalles detalle : detalles) {

			float valor = (detalle.getProducto().getPrecio());
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
		fact += "\n\nIVA:\t\t" + (total * 21 / 100);
		fact += "\nTotal:\t\t" + total;

		return fact;
	}

	public float calcularIVATotal() {
		return calcularTotal() * 21 / 100;
	}

	public float calcularTotal() {

		float total = 0;
		for (Detalles detalle : detalles) {
			total += detalle.getProducto().getPrecio() * detalle.getCantidad();
		}
		return total;
	}
//
//	public void mostrarDetalle() {
//	}
}
