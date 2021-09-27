package proyecto.fin;

import java.time.LocalDate;

public class Auto {
	private String modelo;
	private String marca;
	private String anioFabricacion;
	private String paisFabricacion;
	private String cilindraje;
	private String precioAuto;
	private String puerta;
	private String peso;
	private String placa;
	private String cedula;
	private String estado = "Disponible";
	private LocalDate fechaEntrega;

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getPaisFabricacion() {
		return paisFabricacion;
	}

	public void setPaisFabricacion(String paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getPrecioAuto() {
		return precioAuto;
	}

	public void setPrecioAuto(String precioAuto) {
		this.precioAuto = precioAuto;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Placa:" + placa + "-Modelo:" + modelo + "-Marca:" + marca + "-Año:" + anioFabricacion
				+ "-Estado:" + estado + "-Fecha Entrega:" +fechaEntrega+ "";
	}

}
	