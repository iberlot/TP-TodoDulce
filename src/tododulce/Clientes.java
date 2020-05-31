package tododulce;

public class Clientes implements iBasica {

	private long CUIT;

	private String razonSocial;

	private boolean responsableInscripto;

	/**
	 *
	 */
	public Clientes() {
	}

	/**
	 * @param cUIT
	 * @param razonSocial
	 * @param responsableInscripto
	 */
	public Clientes(long cUIT, String razonSocial, boolean responsableInscripto) {
		CUIT = cUIT;
		this.razonSocial = razonSocial;
		this.responsableInscripto = responsableInscripto;
	}

	@Override
	public String toString() {
		return getRazonSocial() + " - CUIT: " + getCUIT() + "\nEs responsable inscripto: "
				+ ((isResponsableInscripto()) ? "si" : "no");
	}

	/**
	 * @return el dato de cUIT
	 */
	public long getCUIT() {
		return CUIT;
	}

	/**
	 * @param cUIT para cargar en cUIT
	 */
	public void setCUIT(long cUIT) {
		CUIT = cUIT;
	}

	/**
	 * @return el dato de razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial para cargar en razonSocial
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return el dato de responsableInscripto
	 */
	public boolean isResponsableInscripto() {
		return responsableInscripto;
	}

	/**
	 * @param responsableInscripto para cargar en responsableInscripto
	 */
	public void setResponsableInscripto(boolean responsableInscripto) {
		this.responsableInscripto = responsableInscripto;
	}

}
