package tododulce;

import funciones.Funciones;

public class Domicilios implements iBasica {

	private String pais;

	private String provincia;

	private String ciudad;

	private int codigoPostal;

	private String calle;

	private int numero;

	private int piso;

	private String depto;

	/**
	 *
	 */
	public Domicilios() {
	}

	/**
	 * @param pais
	 * @param provincia
	 * @param ciudad
	 * @param codigoPostal
	 * @param calle
	 * @param numero
	 * @param piso
	 * @param depto
	 */
	public Domicilios(String pais, String provincia, String ciudad, int codigoPostal, String calle, int numero) {
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numero = numero;
	}

	/**
	 * @param pais
	 * @param provincia
	 * @param ciudad
	 * @param codigoPostal
	 * @param calle
	 * @param numero
	 * @param piso
	 * @param depto
	 */
	public Domicilios(String pais, String provincia, String ciudad, int codigoPostal, String calle, int numero,
			int piso, String depto) {
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.depto = depto;
	}

	@Override
	public String toString() {
		return this.getCalle() + " " + this.getNumero() + ", " + ((this.piso > 0) ? this.getPiso() + ", " : "")
				+ ((this.depto != "" && this.depto != null) ? this.getDepto() + ", " : "") + "\nCP:"
				+ this.getCodigoPostal() + " - " + this.getCiudad() + ", " + this.getProvincia() + "\n"
				+ this.getPais();

	}

	/**
	 * Pregunta y setea los atributos del domicilio
	 */
	public void nueva_direccion() {
		this.setPais(Funciones.pedirString("Ingrese el pais"));
		this.setProvincia(Funciones.pedirString("Ingrese la provincia"));
		this.setCiudad(Funciones.pedirString("Ingrese la ciudad"));
		this.setCodigoPostal(Funciones.pedirEnteroPositivo("Ingrese el codigo postal"));
		this.setCalle(Funciones.pedirString("Ingrese la calle"));
		this.setNumero(Funciones.pedirEnteroPositivo("Ingrese el numero de puerta"));
		if (Funciones.pedirBooleano("Es un departamento? s/n", "s", "n")) {
			this.setPiso(Funciones.pedirEnteroPositivo("Ingrese el piso"));
			this.setDepto(Funciones.pedirString("ingreso el departamento"));
		}
	}

	/**
	 * Pregunta por cada uno de los elementos a editar y lo hace en caso de ser
	 * afirmativo.
	 */
	public void editar_domicilio() {

		if (Funciones.pedirBooleano("Desea modificar el pais? s/n", "s", "n")) {
			this.setPais(Funciones.pedirString("Ingrese el pais"));
		}

		if (Funciones.pedirBooleano("Desea modificar la provincia? s/n", "s", "n")) {
			this.setProvincia(Funciones.pedirString("Ingrese la provincia"));
		}

		if (Funciones.pedirBooleano("Desea modificar la ciudad? s/n", "s", "n")) {
			this.setCiudad(Funciones.pedirString("Ingrese la ciudad"));
		}

		if (Funciones.pedirBooleano("Desea modificar el codigo postal? s/n", "s", "n")) {
			this.setCodigoPostal(Funciones.pedirEnteroPositivo("Ingrese el codigo postal"));
		}

		if (Funciones.pedirBooleano("Desea modificar la calle? s/n", "s", "n")) {
			this.setCalle(Funciones.pedirString("Ingrese la calle"));
		}

		if (Funciones.pedirBooleano("Desea modificar el numero? s/n", "s", "n")) {
			this.setNumero(Funciones.pedirEnteroPositivo("Ingrese el numero de puerta"));
		}

		if (Funciones.pedirBooleano("Es un departamento? s/n", "s", "n")) {
			if (Funciones.pedirBooleano("Desea modificar el piso? s/n", "s", "n")) {
				this.setPiso(Funciones.pedirEnteroPositivo("Ingrese el piso"));
			}

			if (Funciones.pedirBooleano("Desea modificar el departamento? s/n", "s", "n")) {
				this.setDepto(Funciones.pedirString("ingreso el departamento"));
			}
		}

	}

	/**
	 * @return el dato de pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais para cargar en pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return el dato de provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia para cargar en provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return el dato de ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad para cargar en ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return el dato de codigoPostal
	 */
	public int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param i para cargar en codigoPostal
	 */
	public void setCodigoPostal(int i) {
		this.codigoPostal = i;
	}

	/**
	 * @return el dato de calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle para cargar en calle
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return el dato de numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero para cargar en numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return el dato de piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * @param piso para cargar en piso
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}

	/**
	 * @return el dato de depto
	 */
	public String getDepto() {
		return depto;
	}

	/**
	 * @param depto para cargar en depto
	 */
	public void setDepto(String depto) {
		this.depto = depto;
	}

}
