package tododulce;

import java.util.Calendar;

import funciones.Fechas;
import funciones.Funciones;

public class Pagos implements iBasica {

	/**
	 * Fecha en la que fue realizado el pago
	 */
	private Calendar fecha;

	/**
	 * Forma en la que se realizo el pago. Medio de pago. Estos pueden ser:
	 * Efectivo, Debito, Credito, Cheque, Transferencia.
	 */
	private String formaPago;

	/**
	 * Numero de recibo identificatorio que se le otorgo.
	 */
	private int nroRecibo;

	/**
	 * Numero de transaccion realizada por el sistema
	 */
	private static int nroTransaccion;

	@SuppressWarnings("static-access")
	public Pagos() {
		this.nroTransaccion = this.nroTransaccion + 1;
		this.fecha = Calendar.getInstance();
	}

	public Pagos(String formaPago, int nroRecibo) {
		super();
		this.formaPago = formaPago;
		this.nroRecibo = nroRecibo;
	}

	public Pagos(Calendar fecha, String formaPago, int nroRecibo) {
		super();
		this.fecha = fecha;
		this.formaPago = formaPago;
		this.nroRecibo = nroRecibo;
	}

	@Override
	public String toString() {
		return "Pago realizado el: " + Fechas.fechaAString(this.getFecha(), '/') + "\nNro. de recibo: "
				+ this.getNroRecibo() + "\nMedio de pago: " + this.getFormaPago();

	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) throws Exception {

		if (formaPago.equalsIgnoreCase("Efectivo")) {
			this.formaPago = "Efectivo";

		} else if (formaPago.equalsIgnoreCase("Debito")) {
			this.formaPago = "Debito";

		} else if (formaPago.equalsIgnoreCase("Credito")) {
			this.formaPago = "Credito";

		} else if (formaPago.equalsIgnoreCase("Cheque")) {
			this.formaPago = "Cheque";

		} else if (formaPago.equalsIgnoreCase("Transferencia")) {
			this.formaPago = "Transferencia";

		} else {
			throw new Exception("Forma de pago invalida");
		}

	}

	public int getNroRecibo() {
		return nroRecibo;
	}

	public void setNroRecibo(int nroRecibo) {
		this.nroRecibo = nroRecibo;
	}

	public static int getNroTransaccion() {
		return nroTransaccion;
	}

	public void modificar_pago() throws Exception {
		if (this.formaPago.length() > 0) {
			System.out.println("Su forma de pago actual es: " + this.formaPago);
			if (Funciones.pedirBooleano("Desea cambiarla? s/n", "s", "n")) {
				this.registrar_f_pago();
			}

			System.out.println("Su fecha de pago actual es: " + Fechas.fechaAString(this.fecha, '/'));
			if (Funciones.pedirBooleano("Desea cambiarla? s/n", "s", "n")) {
				this.setFecha(Funciones.pedirFecha("ingrese la nueva fecha"));
			}

			System.out.println("Su numero de recibo actual es: " + this.nroRecibo);
			if (Funciones.pedirBooleano("Desea cambiarlo? s/n", "s", "n")) {
				this.setNroRecibo(Funciones.pedirEnteroPositivo("ingrese en nuevo nro de resibo"));
			}

			this.nroTransaccion = this.nroTransaccion + 1;
		}
	}

	public void registrar_f_pago() throws Exception {
		int fp = Funciones.pedirEnteroPositivo(
				"Ingrese la Forma de pago: \n1 - Efectivo\n2 - Tarjeta de Debito\n3 - Tarjeta de Credito\n4 - Cheque\n5 - Transferencia bancaria",
				1, 5);
		String fPago = "";

		switch (fp) {
		case 1:
			fPago = "Efectivo";
			break;
		case 2:
			fPago = "Debito";
			break;
		case 3:
			fPago = "Credito";
			break;
		case 4:
			fPago = "Cheque";
			break;
		case 5:
			fPago = "Transferencia";
			break;

		}

		this.setFormaPago(fPago);
	}

	public void regis_pago() throws Exception {
		this.registrar_f_pago();
		this.setNroRecibo(Funciones.pedirEnteroPositivo("Ingrese el numero de recibo"));
	}
}
