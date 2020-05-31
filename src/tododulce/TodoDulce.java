/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tododulce;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import funciones.Funciones;

/**
 *
 * @author IVANB
 */
public class TodoDulce {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		try {
			Principal base = new Principal();

			String[] fPago = { "Efectivo", "Debito", "Credito", "Cheque", "Transferencia" };

			base.getClientes().add(new Clientes(20313430465L, "Pandora-inc", true));
			base.getClientes().add(new Clientes(24308686154L, "Julia M Ponti", false));
			base.getClientes().add(new Clientes(30548721364L, "Pepinillos", true));
			base.getClientes().add(new Clientes(24308686666L, "Mytthos", true));
			base.getClientes().add(new Clientes(31658932144L, "Estocolmo", true));
			base.getClientes().add(new Clientes(12786545329L, "Evolianos unidos", false));

			base.getDepositos().add(new Depositos("Aca serca", true));
			base.getDepositos().get(base.getDepositos().size() - 1)
					.setDomicilio(new Domicilios("Argentina", "Buenos Aires", "Merlo", 1721, "Merlo", 120));
			base.getDepositos().add(new Depositos("Paso", true));
			base.getDepositos().get(base.getDepositos().size() - 1)
					.setDomicilio(new Domicilios("Argentina", "CABA", "CABA", 1031, "Paso", 707, 5, "12"));
			base.getDepositos().add(new Depositos("El holanda", true));
			base.getDepositos().get(base.getDepositos().size() - 1)
					.setDomicilio(new Domicilios("Argentina", "Buenos Aires", "Ituzaingo", 1714, "Holanda", 2485));
			base.getDepositos().add(new Depositos("Mordor", false));
			base.getDepositos().get(base.getDepositos().size() - 1).setDomicilio(
					new Domicilios("Argentina", "Buenos Aires", "Mariano Acosta", 1724, "Hugo del Carril", 1024));
			base.getDepositos().add(new Depositos("Usalizate", false));
			base.getDepositos().get(base.getDepositos().size() - 1)
					.setDomicilio(new Domicilios("Argentina", "CABA", "CABA", 1030, "Rodriguez Peña", 714, 3, "0"));

			base.getSucursales().add(new Sucursales());
			base.getSucursales().get(base.getSucursales().size() - 1)
					.setDireccion(new Domicilios("Argentina", "Buenos Aires", "Ituzaingo", 1714, "Piran", 1076));

			base.getSucursales().add(new Sucursales());
			base.getSucursales().get(base.getSucursales().size() - 1)
					.setDireccion(new Domicilios("Argentina", "CABA", "CABA", 1027, "Olazabal", 637, 6, "C"));

			base.getSucursales().add(new Sucursales());
			base.getSucursales().get(base.getSucursales().size() - 1)
					.setDireccion(new Domicilios("Argentina", "Buenos Aires", "Merlo", 1717, "Cordoba", 849));

			base.getSucursales().add(new Sucursales());
			base.getSucursales().get(base.getSucursales().size() - 1)
					.setDireccion(new Domicilios("Argentina", "Buenos Aires", "Castelar", 1819, "El espacio", 77));

			base.getGolosinas()
					.add(new GoloKilo(
							250, 707, "Grageas de todos los Sabores", new String[] { "futilla", "Limon", "anana",
									"naranja", "Manzana", "pepino", "moco", "Tierra", "Bomito", "Cera de los oidos" },
							15));
			base.getGolosinas().add(new GoloKilo(150, 328, "Gomitas",
					new String[] { "futilla", "Limon", "anana", "naranja", "Manzana" }, 20));
			base.getGolosinas().add(
					new GoloKilo(75.5F, 852, "Caramelos", new String[] { "futilla", "Limon", "anana", "naranja" }));
			base.getGolosinas().add(
					new GoloKilo(252.75F, 123, "Chupetines", new String[] { "futilla", "Limon", "anana", "naranja" }));

			base.getGolosinas()
					.add(new GoloPaquete(275.8F, 600, "Chocolate", new String[] { "Amargo", "Leche", "Blanco" },
							new Depositos[] { base.getDepositos().get(3), base.getDepositos().get(1) }, true));
			base.getGolosinas().add(new GoloPaquete(275.8F, 600, "Huevos choco", new String[] { "Celeste", "Rosa" },
					new Depositos[] { base.getDepositos().get(3), base.getDepositos().get(4) }, false));
			base.getGolosinas()
					.add(new GoloPaquete(275.8F, 600, "Alfajor Jorgito",
							new String[] { "Chocolate", "Dulce de Leche", "Fruta" },
							new Depositos[] { base.getDepositos().get(3), base.getDepositos().get(2) }, false));
			base.getGolosinas().add(new GoloPaquete(275.8F, 600, "Sonrisas", new String[] { "Tradicional" },
					new Depositos[] { base.getDepositos().get(3) }, true));
			base.getGolosinas()
					.add(new GoloPaquete(275.8F, 600, "Marrok", new String[] { "Tradicional" }, new Depositos[] {
							base.getDepositos().get(3), base.getDepositos().get(3), base.getDepositos().get(0) },
							true));

			for (int n = 0; n < Funciones.enteroAleatorio(1, 35); n++) {

				Random r = new Random();
				int recibo = 1;

				Calendar ff = Calendar.getInstance();
				ff.set(Calendar.YEAR, 2019);
				ff.set(Calendar.MONTH, 0);
				ff.set(Calendar.DATE, 1);
				ff.add(Calendar.DAY_OF_YEAR, Funciones.enteroAleatorio(0, 7));

				ArrayList<Detalles> detalles = new ArrayList<Detalles>();
				for (int i = 0; i < Funciones.enteroAleatorio(1, 10); i++) {
					detalles.add(new Detalles(Funciones.enteroAleatorio(1, 100),
							base.getGolosinas().get(Funciones.enteroAleatorio(0, base.getGolosinas().size() - 1))));
				}

				Sucursales suc = base.getSucursales()
						.get(Funciones.enteroAleatorio(0, base.getSucursales().size() - 1));

				if (r.nextBoolean() == true) {
					base.getFacturas().add(new FacturasA(ff, suc, suc.nextNroFactura(), detalles,
							base.getClientes().get(Funciones.enteroAleatorio(0, base.getClientes().size() - 1))));
				} else {
					base.getFacturas().add(new FacturasB(ff, suc, suc.nextNroFactura(), detalles,
							base.getClientes().get(Funciones.enteroAleatorio(0, base.getClientes().size() - 1))));
				}

				if (r.nextBoolean() == true) {

					Calendar fecha = base.getFacturas().get(base.getFacturas().size() - 1).getFechaEmision();
					fecha.add(Calendar.DAY_OF_YEAR, Funciones.enteroAleatorio(0, 10));

					Pagos pago = new Pagos(fecha, fPago[Funciones.enteroAleatorio(0, 4)], recibo);
					base.getFacturas().get(base.getFacturas().size() - 1).setPago(pago);

					recibo++;
				}
			}
			if (args[0] != null) {
				base.setImporteMinVto(Long.parseLong(args[0]));
			} else {
				base.setImporteMinVto(0);
			}
			base.imprimirMenu();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
