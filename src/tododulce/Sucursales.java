package tododulce;

/**
 * Clase de Sucursales
 *
 * @author IVANB
 * @since 11 mar. 2020
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class Sucursales implements iBasica {

	/**
	 * Codigo de la sucursal.
	 */
	private int codigo;

	/**
	 * direccion de la sucursal.
	 */
	private Domicilios direccion;

	private long nroUltimaFactura;

	private static int codigoUltimaSucursal;

	/**
	 * Constructor de la clase.
	 */
	public Sucursales() {
		this.direccion = new Domicilios();
		this.codigoUltimaSucursal++;
		this.codigo = this.codigoUltimaSucursal;

	}

	/**
	 * Constructor de la clase.
	 *
	 * @param codigo
	 */
	public Sucursales(int codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * Constructor de la clase.
	 *
	 * @param codigo
	 * @param direccion
	 */
	public Sucursales(int codigo, Domicilios direccion) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
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
	 * @return el dato de direccion
	 */
	public Domicilios getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion para cargar en direccion
	 */
	public void setDireccion(Domicilios direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return el dato de nroUltimaFactura
	 */
	public long getNroUltimaFactura() {
		return nroUltimaFactura;
	}

	/**
	 * @param nroUltimaFactura para cargar en nroUltimaFactura
	 */
	public void setNroUltimaFactura(long nroUltimaFactura) {
		this.nroUltimaFactura = nroUltimaFactura;
	}

	/**
	 * Le agrega uno a la ultima factura y retorna dico valor
	 *
	 */
	public long nextNroFactura() {
		this.nroUltimaFactura = this.nroUltimaFactura + 1;

		return nroUltimaFactura;
	}

	@Override
	public String toString() {
		return "Sucursal " + codigo + "\n" + direccion;
	}

	public static int getCodigoUltimaSucursal() {
		return codigoUltimaSucursal;
	}

}
