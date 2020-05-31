/**
 *
 *
 * @author IVANB
 * @since 11 mar. 2020
 * TodoDulce
 * Principal.java
 *
 * @version 0.0 Creacion del archivo.
 */
package tododulce;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import funciones.Fechas;
import funciones.Funciones;
import sun.security.jca.GetInstance;

/**
 * Clase de
 *
 * @author IVANB
 * @since 11 mar. 2020
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class Principal {

	/**
	 * Listados de las facturas que hay en el sistema.
	 *
	 * @var ArrayList<Facturas> facturas
	 */
	private ArrayList<Facturas> facturas = new ArrayList<Facturas>();

	/**
	 * Listados de las sucursales que hay en el sistema.
	 *
	 * @var ArrayList<Sucursales> sucursales
	 */
	private ArrayList<Sucursales> sucursales = new ArrayList<Sucursales>();

	/**
	 * Listados de las golosinas que hay en el sistema.
	 *
	 * @var ArrayList<Golosinas> golosinas
	 */
	private ArrayList<Golosinas> golosinas = new ArrayList<Golosinas>();

	/**
	 * Listados de los Clientes que hay en el sistema.
	 *
	 * @var ArrayList<Clientes> Clientes
	 */
	private ArrayList<Clientes> Clientes = new ArrayList<Clientes>();

	/**
	 * Listados de los depositos que hay en el sistema.
	 *
	 * @var ArrayList<Depositos> depositos
	 */
	private ArrayList<Depositos> depositos = new ArrayList<Depositos>();

	/**
	 * Monto que se utiliza para mostrar las facturas vencidas.
	 *
	 * @var long importeMinVto;
	 */
	private long importeMinVto;

	/*
	 * *****************************************************************************
	 * ************* PANTALLAS DE MENU DE LA APLICACION *
	 * *****************************************************************************
	 * ***********
	 */

	/**
	 * Muestra en pantalla el menu principal de la aplicacion. Captura por teclado
	 * la seleccion de opcion y ejecuta la funcion correspondiente. Luego de
	 * ejecutada vuelve a mostrar el menu.
	 *
	 * @throws Exception
	 */
	public void imprimirMenu() throws Exception {
		System.out.println("MENU del programa");
		System.out.println("1 - ABM de Facturas");
		System.out.println("2 - ABM de Clientes");
		System.out.println("3 - ABM de Productos");
		System.out.println("4 - ABM de Sucursales");
		System.out.println("5 - ABM de Depositos");
		System.out.println("6 - Informe de los periodos del año en curzo");
		System.out.println("66 - SALIR");

		int respuesta = Funciones.pedirEnteroPositivo("");

		switch (respuesta) {
		case 1:
			m_abm_facturas();
			break;
		case 2:
			m_abm_Clientes();
			break;
		case 3:
			m_abm_productos();
			break;
		case 4:
			m_abm_sucursales();
			break;
		case 5:
			m_abm_depositos();
			break;
		case 6:
			Calendar hoy = Calendar.getInstance();
			mostrarDatosPeriodo(hoy.get(Calendar.YEAR));
			break;
		case 66:
			System.exit(0);
			break;
		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		imprimirMenu();
	}

	/**
	 * Muestra el menu con las opciones referidas a los depositos
	 * 
	 * @throws Exception
	 */
	private void m_abm_depositos() throws Exception {
		System.out.println("ABM de Depositos");
		System.out.println("1 - Deposito nuevo");
		System.out.println("2 - Buscar deposito");
		System.out.println("3 - Ver datos deposito");
		System.out.println("4 - Editar deposito");
		System.out.println("5 - Listar depositos");
		System.out.println("66 - SALIR");

		int respuesta = Funciones.pedirEnteroPositivo("");

		switch (respuesta) {
		case 1:
			nuevo_deposito();
			break;
		case 2:

			int nDepo = buscar_deposito();
			if (nDepo != 666) {
				System.out.println(depositos.get(nDepo));
			}
			break;
		case 3:
			ver_deposito();
			break;
		case 4:
			int codigo = ver_deposito();
			depositos.get(codigo).modificarDeposito();

			break;
		case 5:
			listar_depositos();
			break;

		case 66:
			imprimirMenu();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		m_abm_depositos();
	}

	/**
	 * Lista los depositos. Pide que se inserte el identificador de uno, lo muestra
	 * y retorna su codigo
	 * 
	 * @return int Codigo del deposito seleccionado
	 */
	private int ver_deposito() {
		if (listar_depositos() == true) {

			int codigo = Funciones.pedirEnteroPositivo("Ingrese el codigo del deposito");

			System.out.println(depositos.get(codigo));

			return codigo;
		} else {
			return 0;
		}

	}

	/**
	 * Pide que se ingrese un string y dusca entre los depositos su hay uno que
	 * coincida.
	 * 
	 * @return int El indice del deposito o 666 en caso de error.
	 */
	private int buscar_deposito() {

		String nombre = Funciones.pedirString("Ingrese el nombre del deposito");

		for (int j = 0; j < depositos.size(); j++) {
			if (depositos.get(j).getNombre().equalsIgnoreCase(nombre)) {
				return j;
			}
		}

		System.out.println("Deposito no encontrado");
		return 666;
	}

	/**
	 * Crea un nuevo deposito, lo agrega al arrayList y lo retorna
	 */
	private Depositos nuevo_deposito() {

		Depositos deposito = new Depositos();
		deposito.nuevo_deposito();
		depositos.add(deposito);

		return deposito;

	}

	/**
	 *
	 */
	private void m_abm_sucursales() throws Exception {
		System.out.println("ABM de Sucursales");
		System.out.println("1 - Sucursal nueva");
		System.out.println("2 - Buscar sucursal");
		System.out.println("3 - Ver datos sucursal");
		System.out.println("4 - Editar sucursal");
		System.out.println("5 - Listar sucursales");
//		System.out.println("6 - Crear archivos");
//		System.out.println("7 - Datos al azar");
		System.out.println("66 - SALIR");

		int respuesta = Funciones.pedirEnteroPositivo("");

		switch (respuesta) {
		case 1:
			nueva_sucursal();
			break;
		case 2:

			int nSuc = buscar_sucursal();
			if (nSuc != 666) {
				System.out.println(sucursales.get(nSuc));
			}
			break;
		case 3:
			ver_sucursal();
			break;
		case 4:
			editar_sucursal();
			break;
		case 5:
			listar_sucursales();
			break;

		case 66:
			imprimirMenu();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		m_abm_sucursales();

	}

	/**
	 *
	 */
	private void editar_sucursal() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 * @throws Exception
	 *
	 */
	private int ver_sucursal() throws Exception {

		if (listar_sucursales() == true) {

			int codigo = Funciones.pedirEnteroPositivo("Ingrese el codigo de la sucursal");

			System.out.println(sucursales.get(codigo));

			return codigo;
		} else {
			return 0;
		}
	}

	/**
	 *
	 */
	private int buscar_sucursal() {
		return 0;
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	private void nueva_sucursal() {
		sucursales.add(new Sucursales());
		sucursales.get(sucursales.size() - 1).setCodigo(sucursales.size());
		sucursales.get(sucursales.size() - 1).setNroUltimaFactura(0);

		System.out
				.println("El numero asignado de la sucursal es: " + sucursales.get(sucursales.size() - 1).getCodigo());

		System.out.println("Ingrese la diereccion de la sucursal");
		sucursales.get(sucursales.size() - 1).getDireccion().nueva_direccion();

		System.out.println("Sucursal creada.");

	}

	/**
	 *
	 */
	private void m_abm_productos() throws Exception {
		System.out.println("ABM de Productos");
		System.out.println("1 - Producto nuevo");
		System.out.println("2 - Buscar producto");
		System.out.println("3 - Ver datos producto");
		System.out.println("4 - Editar producto");
		System.out.println("5 - Listar productos");
		System.out.println("6 - Buscar facturas con el producto");
		System.out.println("7 - Golocinas por paquete no vendidas en el ano");
		System.out.println("66 - SALIR");

		int respuesta = Funciones.pedirEnteroPositivo("");

		switch (respuesta) {
		case 1:
			nuevo_producto();
			break;
		case 2:
			int nProd = buscar_producto();
			if (nProd != 666) {
				System.out.println(golosinas.get(nProd));
			}
			break;
		case 3:
			ver_producto();
			break;
		case 4:
			editar_producto();
			break;
		case 5:
			listar_golosinas();
			break;
		case 6:
			mostrarFacBuscGolo(Funciones.pedirString("Ingrese el parametro de busqueda"));
			break;
		case 7:
			golosinasNoVendidas(1, true, false);
			break;
		case 66:
			imprimirMenu();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		m_abm_productos();

	}

	private void golosinasNoVendidas(int tipoGolo, boolean totales, boolean completo) {
		int cantidad = 0;

		Calendar actual = Calendar.getInstance();

		for (int i = 0; i < golosinas.size(); i++) {
			boolean pepe = false;

			for (Facturas fac : facturas) {
				if ((fac.tieneGolo(golosinas.get(i)) == false)
						&& (fac.fechaEmision.get(Calendar.YEAR) == actual.get(Calendar.YEAR))) {

					if (tipoGolo == 0) {
						pepe = true;
					} else if (tipoGolo == 1 && golosinas.get(i) instanceof GoloPaquete) {
						pepe = true;
					} else if (tipoGolo == 2 && golosinas.get(i) instanceof GoloKilo) {
						pepe = true;
					}

				}
			}

			if (pepe == true) {
				cantidad++;

				if (completo == true) {
					System.out.println(golosinas.get(i));
				}
			}

		}

		if (totales == true) {
			System.out.println("Hay un total de " + cantidad + " que no fueron vendidos.");
		}
	}

	/**
	 *
	 */
	private void editar_producto() {
		int codigo = ver_producto();

		if (Funciones.pedirBooleano("Desea modificar la descripcion? s/n", "s", "n")) {
			golosinas.get(codigo).setDescripcion(Funciones.pedirString("Ingrese la nueva descripcion"));
		}

		if (Funciones.pedirBooleano("Desea modificar el precio? s/n", "s", "n")) {
			golosinas.get(codigo).setPrecio(Funciones.pedirFloat("ingrese el nuevo precio"));
		}

	}

	/**
	 * @return
	 *
	 */
	private int ver_producto() {
		if (listar_golosinas() == true) {

			int codigo = Funciones.pedirEnteroPositivo("Ingrese el codigo del producto");

			System.out.println(golosinas.get(codigo));

			return codigo;
		} else {
			return 0;
		}

	}

	/**
	 * Va a traer la primer coincidencia total
	 *
	 */
	private int buscar_producto() {

		String nombre = Funciones.pedirString("Ingrese la descripcion del producto");

		for (int j = 0; j < golosinas.size(); j++) {
			if (golosinas.get(j).getDescripcion().equalsIgnoreCase(nombre)) {
				return j;
			}
		}

		System.out.println("Producto no encontrado");
		return 666;
	}

	/**
	 * Agrega un nuevo producto a la lista
	 *
	 * FIXME Esto creo que podria pasarse a la clase Golosinas
	 */
	private void nuevo_producto() {
		// TODO Auto-generated method stub
		Golosinas golo;
		if (Funciones.pedirBooleano(
				"Desea agregar un producto de venta por kilo o por paquete? \n1 - kilo\n2 - Paquete", "1", "2")) {
			golo = new GoloKilo();

		} else {
			golo = new GoloPaquete();
		}

		golo.setCodigo(golosinas.size());

		golo.setDescripcion(Funciones.pedirString("Ingrese la descripcion"));

		golo.setPrecio(Funciones.pedirFloat("Ingrese el precio"));

		do {
			golo.add_sabor();
		} while (Funciones.pedirBooleano("Desea agregar otro sabor? s/n", "s", "n"));

		if (golo instanceof GoloKilo) {
			if (Funciones.pedirBooleano("Tiene descuento? s/n", "s", "n")) {
				((GoloKilo) golo).setDescuento(Funciones.pedirFloat("ingrese el porcentaje de descuento"));
			}
		} else {
			((GoloPaquete) golo).setOferta(Funciones.pedirBooleano("Esta en promocion? s/n", "s", "n"));

			do {
				Depositos deposito;

				if (Funciones.pedirBooleano(
						"Desea agregar un nuevo deposito o ver los existentes? \n1 - Nuevo\n2 - Ver existentes", "1",
						"2")) {
					deposito = nuevo_deposito();

					depositos.add(deposito);
				} else {
					deposito = depositos.get(ver_deposito());
				}

				((GoloPaquete) golo).addDeposito(deposito);
			} while (Funciones.pedirBooleano("Desea agregar otro deposito? s/n", "s", "n"));
		}
		this.golosinas.add(golo);
	}

	/**
	 *
	 */
	private void m_abm_Clientes() throws Exception {
		System.out.println("ABM de Clientes");
		System.out.println("1 - Cliente nuevo");
		System.out.println("2 - Buscar cliente");
		System.out.println("3 - Ver datos cliente");
		System.out.println("4 - Editar cliente");
		System.out.println("5 - Listar Clientes");
//		System.out.println("6 - Crear archivos");
//		System.out.println("7 - Datos al azar");
		System.out.println("66 - SALIR");

		int respuesta = Funciones.pedirEnteroPositivo("");

		switch (respuesta) {
		case 1:
			nuevo_cliente();
			break;
		case 2:

			int nClie = buscar_cliente();
			if (nClie != 666) {
				System.out.println(Clientes.get(nClie));
				if (Funciones.pedirBooleano("Desea ver sus facturas asociadas? s/n", "s", "n")) {
					this.mostrarFacturasAsociadas(Clientes.get(nClie), 60);
				}
			}
			break;

		case 3:
			ver_cliente();
			break;
		case 4:
			editar_cliente();
			break;
		case 5:
			listar_Clientes();
			break;

		case 66:
			imprimirMenu();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		m_abm_Clientes();

	}

	/**
	 * Dado un cliente muestra por pantalla todas las facturas que lo tengan como
	 * registro. En caso de no haber ninguna factura del cliente muestra un mensaje
	 * avisandolo. Hay que pasar ademas la cantidad de dias hacia atras a buscar. Si
	 * es cero se buscara en todas las fechas.
	 * 
	 * @param Clientes2
	 * @param dias
	 * @throws ParseException
	 */
	private void mostrarFacturasAsociadas(Clientes Clientes2, int dias) throws ParseException {
		boolean mostro = false;

		boolean soloNum = Funciones.pedirBooleano("Desea ver solo los numeros de factura o todo el detalle? s/n", "s",
				"n");

		Calendar toDay = Calendar.getInstance();

		for (int j = 0; j < facturas.size(); j++) {
			if (dias == 0 || Fechas.diferenciaDiasTotal(facturas.get(j).getFechaEmision(), toDay) < dias)
				if (facturas.get(j).getCliente().equals(Clientes2)) {
					mostro = true;
					if (soloNum == true) {
						System.out.println(facturas.get(j).retornarNumeroFactura());
					} else {
						System.out.println(facturas.get(j));
					}
				}
		}
		if (mostro == false) {
			System.out.println("El cliente no registra facturas");
		}
	}

	/**
	 *
	 */
	private void editar_cliente() {
		int codigo = ver_cliente();

		if (Funciones.pedirBooleano("Desea modificar el CUIT? s/n", "s", "n")) {
			Clientes.get(codigo).setCUIT(Funciones.pedirLong("Ingrese el nuevo cuit: "));
		}

		if (Funciones.pedirBooleano("Desea modificar la razon social? s/n", "s", "n")) {
			Clientes.get(codigo).setRazonSocial(Funciones.pedirString("Ingrese la nueva razon social: "));
		}

		if (Funciones.pedirBooleano("Desea modificar la condicion del IVA? s/n", "s", "n")) {
			Clientes.get(codigo)
					.setResponsableInscripto(Funciones.pedirBooleano("Es responsable inscripto? s/n", "s", "n"));
		}
	}

	/**
	 * @return
	 *
	 */
	private int ver_cliente() {
		if (listar_Clientes() == true) {

			int codigo = Funciones.pedirEnteroPositivo("Ingrese el codigo del cliente");

			System.out.println(Clientes.get(codigo));

			return codigo;
		} else {
			return 0;
		}

	}

	/**
	 *
	 */
	private int buscar_cliente() {

		long numero = Funciones.pedirLong("Ingrese el numero de cuil a buscar");

		for (int j = 0; j < Clientes.size(); j++) {
			if (Clientes.get(j).getCUIT() == numero) {
				return j;
			}
		}

		System.out.println("Cliente no encontrado");
		return 666;
	}

	/**
	 * @throws Exception
	 *
	 */
	private void m_abm_facturas() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ABM de Facturas");
		System.out.println("1 - Factura nueva");
		System.out.println("2 - Buscar factura");
		System.out.println("3 - Ver factura nro");
		System.out.println("4 - Editar factura nro");
		System.out.println("5 - Listar facturas");
		System.out.println("6 - Pagar factura");
		System.out.println("7 - Ver facturas vencidas");
		System.out.println("8 - Mostrar cantidad de facturas B generadas");
		System.out.println("9 - Buscar facturas con el producto");
		System.out.println("66 - SALIR");

		int respuesta = Funciones.pedirEnteroPositivo("");

		switch (respuesta) {
		case 1:
			nueva_factura();
			break;
		case 2:
			int nFac = buscar_factura();
			if (nFac != 666) {
				System.out.println(facturas.get(nFac));
			}
			break;
		case 3:
			ver_factura();
			break;
		case 4:
			editar_factura();
			break;
		case 5:
			listar_facturas();
			break;
		case 6:
			pagar_facturas();
			break;
		case 7:
			mostrarFacturasVencidas(importeMinVto, 2, false, true);
			break;
		case 8:
			System.out.println("Se generaron un total de: " + FacturasB.getCantidadGenerada() + " facturas B.");
			break;
		case 9:
			mostrarFacBuscGolo(Funciones.pedirString("Ingrese el parametro de busqueda"));
			break;
		case 66:
			imprimirMenu();
			break;

		}
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Precione una tecla para continuar...");
		stdin.nextLine();
		m_abm_facturas();
	}

	/**
	 * @throws Exception
	 *
	 */
	private void pagar_facturas() throws Exception {
		int nFac = buscar_factura();
		if (nFac != 666) {
			System.out.println(facturas.get(nFac));

			if (facturas.get(nFac).getPago() != null) {
				facturas.get(nFac).getPago().modificar_pago();
			} else {
				facturas.get(nFac).getPago().regis_pago();
			}

		}
	}

	/**
	 *
	 */
	private void editar_factura() {
		int codigo = ver_factura();
//
//	if (Funciones.pedirBooleano("Desea modificar el domicilio? s/n", "s", "n")) {
//		depositos.get(codigo).setDomicilio(editar_domicilio(depositos.get(codigo).getDomicilio()));
//	}

	}

	/**
	 * @return
	 *
	 */
	private int ver_factura() {
		if (listar_facturas() == true) {
// FIXME deberia pedir sucursal y numero de factura
			int codigo = Funciones.pedirEnteroPositivo("Ingrese el codigo de la factura");

			System.out.println(facturas.get(codigo));

			return codigo;
		} else {
			return 0;
		}

	}

	/**
	 * @return
	 *
	 */
	private int buscar_factura() {
		int suc = 1;

		if (Funciones.pedirBooleano("Desea ingresar el numero de la sucirsal? s/n", "s", "n")) {
			suc = Funciones.pedirEnteroPositivo("Ingrese el numero de la sucursal");
		}

		long numero = Funciones.pedirLong("Ingrese el numero de factura a buscar");

		for (int j = 0; j < facturas.size(); j++) {
			if (facturas.get(j).getSucursal().getCodigo() == suc) {
				if (facturas.get(j).getNumero() == numero) {
					return j;
				}
			}
		}

		System.out.println("Numero de factura no encontrado");
		return 666;
	}

	/**
	 * @throws Exception
	 *
	 */
	private void nueva_factura() throws Exception {

		int respuesta = Funciones.pedirEnteroPositivo(
				"Desea dar de alta un nuevo cliente o usar uno existente? \n1 - Nuevo\n2 - Buscar");

		Clientes cliente = new Clientes();

		if (respuesta == 1) {

			cliente = nuevo_cliente();

			if (cliente == null) {

				System.out.println("Seleccione el cliente.");
				listar_Clientes();

				int index = Funciones.pedirEnteroPositivo("");
				cliente = Clientes.get(index);
			}

		} else if (respuesta == 2) {

			System.out.println("Seleccione el cliente.");
			listar_Clientes();

			int index = Funciones.pedirEnteroPositivo("");
			cliente = Clientes.get(index);

		}

		if (cliente.isResponsableInscripto() == true) {
			facturas.add(new FacturasA());
		} else {
			facturas.add(new FacturasB());
		}

		System.out.println("Seleccione la sucursal.");
		if (listar_sucursales() == false) {
			nueva_sucursal();
			facturas.get(facturas.size() - 1).setSucursal(sucursales.get(sucursales.size() - 1));

			facturas.get(facturas.size() - 1).setNumero(sucursales.get(sucursales.size() - 1).nextNroFactura());

		} else {
			int index = Funciones.pedirEnteroPositivo("");

			facturas.get(facturas.size() - 1).setSucursal(sucursales.get(index));

			facturas.get(facturas.size() - 1).setNumero(sucursales.get(index).nextNroFactura());
		}
		facturas.get(facturas.size() - 1).setCliente(cliente);

		facturas.get(facturas.size() - 1).setFechaEmision(Funciones.pedirFecha("Ingrese la fercha de emicion"));

		do {
			Detalles detalle = new Detalles();

			System.out.println("Seleccione el producto vendido.");
			if (listar_golosinas() == false) {
				if (Funciones.pedirBooleano("Desea agregar un nuevo producot? s/n", "s", "n") == true) {
					nuevo_producto();

					detalle.setProducto(golosinas.get(golosinas.size() - 1));
				} else {
					break;
				}
			} else {
				int indexgolo = Funciones.pedirEnteroPositivo("");

				detalle.setProducto(golosinas.get(indexgolo));
			}
			detalle.setCantidad(Funciones.pedirFloat("ingrese la cantidad vendida"));

			facturas.get(facturas.size() - 1).getDetalles().add(detalle);

		} while (Funciones.pedirBooleano("Desea agregar otro item a la factura? s/n", "s", "n"));

	}

	private boolean listar_golosinas() {

		if (golosinas.isEmpty()) {
			System.out.println("No hay golosinas registradas.");
			return false;
		} else {
			if (Funciones.pedirBooleano("Desea ver un listado de las golosinas? s/n", "s", "n")) {

				int i = 0;
				for (Golosinas golosina : golosinas) {
					System.out.print(i + " - ");
					System.out.println(golosina.getDescripcion());
					i++;
				}
			}
			return true;
		}

	}

	private boolean listar_Clientes() {

		if (Clientes.isEmpty()) {
			System.out.println("No hay Clientes registrados.");
			return false;
		} else {
			if (Funciones.pedirBooleano("Desea ver un listado de los Clientes? s/n", "s", "n")) {

				int i = 0;

				for (Clientes cliente : Clientes) {
					System.out.print(i + " - ");
					System.out.println(cliente);
					i++;
				}
			}
			return true;
		}
	}

	private boolean listar_sucursales() {

		if (sucursales.isEmpty()) {
			System.out.println("No hay sucursales registradas.");
			return false;
		} else {
			if (Funciones.pedirBooleano("Desea ver un listado de las sucursales? s/n", "s", "n")) {

				int i = 0;
				for (Sucursales sucursal : sucursales) {
					System.out.print(i + " - ");
					System.out.println(sucursal);
					i++;
				}
			}
			return true;
		}

	}

	private boolean listar_depositos() {

		if (depositos.isEmpty()) {
			System.out.println("No hay depositos registradas.");
			return false;
		} else {
			if (Funciones.pedirBooleano("Desea ver un listado de los depositos? s/n", "s", "n")) {

				int i = 0;
				for (Depositos deposito : depositos) {
					System.out.print(i + " - ");
					System.out.println(deposito);
					i++;
				}
			}
			return true;
		}

	}

	private boolean listar_facturas() {

		if (facturas.isEmpty()) {
			System.out.println("No hay facturas registradas.");
			return false;
		} else {
			if (Funciones.pedirBooleano("Desea ver un listado de las facturas? s/n", "s", "n")) {

				int i = 0;
				for (Facturas factura : this.facturas) {
					System.out.print(i + " - ");
					System.out.println(factura.retornarNumeroFactura());
					i++;
				}
			}
			return true;
		}

	}

	/**
	 * Agrega un nuevo cliente a la lista }Realiza una verificacion del numero de
	 * cuit para evitar agregar duplicados.
	 * 
	 * @return
	 * @throws Exception
	 */
	public Clientes nuevo_cliente() throws Exception {

		Clientes cliente = new Clientes();

		long cuit = Funciones.pedirLong("Ingrese el cuit: ");
		if (this.comprobar_cuit(cuit) == true) {
//			throw new Exception("El cuit ya se encuentra registrado");
			System.out.println("El cuit ya se encuentra registrado");
			if (Funciones.pedirBooleano("Desea intentar con otro cuit? s/n", "s", "n")) {
				cuit = Funciones.pedirLong("");
				if (this.comprobar_cuit(cuit) == true) {
//					throw new Exception("El cuit ya se encuentra registrado");
					return null;
				}
			} else {
				return null;
			}
		}

		cliente.setCUIT(cuit);

		String razonSocial = Funciones.pedirString("Ingrese la razon social: ");
		cliente.setRazonSocial(razonSocial);

		boolean iva = Funciones.pedirBooleano("Es responsable inscripto? s/n", "s", "n");
		cliente.setResponsableInscripto(iva);

		Clientes.add(cliente);

		return cliente;
	}

	/**
	 * Verifica si el cuit se encuentra entre alguno de los Clientes registrados. En
	 * caso de encontrarlo retorna true. En caso de que la lista este vasia o que no
	 * se encuentre retornara false
	 * 
	 * @param cuit
	 * @return
	 */
	public boolean comprobar_cuit(long cuit) {
		if (this.Clientes.isEmpty()) {

			return false;
		} else {
			for (Clientes cliente : this.Clientes) {
				if (cliente.getCUIT() == cuit) {
					return true;
				}
			}
		}
		return false;

	}

	public void mostrarFacturasVencidas(float montoMin, int tipoProd, boolean mostrarTodo, boolean inverso) {

		ArrayList<String> faras = new ArrayList<String>();

		for (int i : buscarIdsFacVencidas()) {
			if (montoMin == 0 || facturas.get(i).calcularTotal() > montoMin) {

				if (tipoProd == 0) {
					faras.add(facturas.get(i).retornarNumeroFactura());

				} else if (tipoProd == 1) {
					for (Detalles detalle : facturas.get(i).getDetalles()) {
						if (detalle.getProducto() instanceof GoloPaquete) {

							faras.add(facturas.get(i).retornarNumeroFactura());
						}
					}
				} else if (tipoProd == 2) {
					for (Detalles detalle : facturas.get(i).getDetalles()) {
						if (detalle.getProducto() instanceof GoloKilo) {

							faras.add(facturas.get(i).retornarNumeroFactura());
						}
					}
				}

			}
		}

		Collections.sort(faras);

		if (inverso == true) {
			Collections.reverse(faras);
		}

		for (String factur : faras) {
			if (mostrarTodo == true) {
				for (Facturas fac : facturas) {
					if (fac.retornarNumeroFactura().equalsIgnoreCase(factur)) {
						System.out.println(fac);
					}
				}

			} else {
				System.out.println(factur);
			}
		}
	}

	public int[] buscarIdsFacVencidas() {

		int listaId[] = new int[facturas.size()];
		int e = 0;
		for (int i = 0; i < facturas.size(); i++) {
			if (facturas.get(i).getPago() == null) {
				listaId[e] = i;
				e++;
			}
		}

		return listaId;

	}

	public ArrayList<Facturas> getFacturas() {
		return facturas;
	}

	public ArrayList<Sucursales> getSucursales() {
		return sucursales;
	}

	public ArrayList<Golosinas> getGolosinas() {
		return golosinas;
	}

	public ArrayList<Clientes> getClientes() {
		return Clientes;
	}

	public ArrayList<Depositos> getDepositos() {
		return depositos;
	}

	/**
	 * @return the importeMinVto
	 */
	public long getImporteMinVto() {
		return importeMinVto;
	}

	/**
	 * @param importeMinVto the importeMinVto to set
	 */
	public void setImporteMinVto(long importeMinVto) {
		this.importeMinVto = importeMinVto;
	}

	public void mostrarDatosPeriodo(int anio) {

		int cantA_T = 0;
		int cantB_T = 0;
		float iva_T = 0;
		float ivaDicri_T = 0;

		for (int i = 0; i < 12; i++) {
			int cantA = 0;
			int cantB = 0;
			float iva = 0;
			float ivaDicri = 0;

			for (Facturas factu : facturas) {
				if (factu.getFechaEmision().get(Calendar.YEAR) == anio
						&& factu.getFechaEmision().get(Calendar.MONTH) == i) {
					if (factu instanceof FacturasB) {
						cantB++;
					} else {
						cantA++;
						ivaDicri = ivaDicri + (factu.calcularTotal() * 21 / 100);
					}
					iva = iva + (factu.calcularTotal() * 21 / 100);
				}
			}
			cantA_T = cantA_T + cantA;
			cantB_T = cantB_T + cantB;
			iva_T = iva_T + iva;
			ivaDicri_T = ivaDicri_T + ivaDicri;

			System.out.println("El periodo " + i + "/" + anio + " tiene un total de:\n" + cantA + " facturas A\n"
					+ cantB + " facturas B\n'nRegistra un iva total de: " + iva + "\nde los que " + ivaDicri
					+ " esta discriminado en las facturasA\n");
		}
		System.out.println("En lo que va del ano " + anio + " se registra un total de:\n" + cantA_T + " facturas A\n"
				+ cantB_T + " facturas B\n'nRegistra un iva total de: " + iva_T + "\nde los que " + ivaDicri_T
				+ " esta discriminado en las facturasA\n");
	}

	public void mostrarFacBuscGolo(String busque) {
		System.out.println("Facturas que contienen golosina que comiencen con " + busque.substring(0, 1));
		boolean pepinos = false;

		for (Facturas fac : facturas) {
			boolean mostar = false;

			for (Detalles dtalle : fac.getDetalles()) {
				if (dtalle.getProducto().getDescripcion().substring(0, 1).equalsIgnoreCase(busque.substring(0, 1))) {
					pepinos = mostar = true;
				}
			}

			if (mostar == true) {
				System.out.print(fac.retornarNumeroFactura());
				if (fac.getPago() == null) {
					System.out.print(", no pagado.\n");
				} else {
					System.out.print(", fecha de pago " + Fechas.fechaAString(fac.getPago().getFecha(), '/') + "\n");
				}
			}
		}
		if (pepinos == false) {
			System.out.println("No hay facturas que coincidan ");
		}
	}
}