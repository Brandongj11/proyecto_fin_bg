package proyecto.fin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAuto {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String opcion;
		String placa = null;
		String cedula = null;
		String modelo = null;
		String marca = null;
		String anioFabricacion = null;
		String paisFabricacion = null;
		String cilindraje = null;
		String precioAuto = null;
		LocalDate diaActual = LocalDate.now();
		LocalDate diaFinal;

		List<Auto> listMetrocard = new ArrayList<Auto>();
		Auto auto = new Auto();

		do {
			System.out.println("***AUTOS METROCARD***");
			System.out.println("1.Clientes:");
			System.out.println("***a.Consultar autos***");
			System.out.println("***b.Reservar auto***");
			System.out.println("2.Empleado:");
			System.out.println("***a.Ingresar un auto***");
			System.out.println("***b.Alquilar un auto***");
			System.out.println("***c.Aplazar fecha de entrega***");
			System.out.println("3.SALIR");
			opcion = teclado.nextLine();
			if (opcion.equals("1.a")) {
				System.out.println("Ingrese el modelo del auto:");
				modelo = teclado.nextLine();
				System.out.println("Ingrese la marca del auto:");
				marca = teclado.nextLine();
				System.out.println("Autos: ");
				for (int i = 0; i < listMetrocard.size(); i++) {
					Auto auto1 = listMetrocard.get(i);
					boolean buscador = auto.getModelo().contains(modelo);
					boolean buscador1 = auto.getMarca().contains(marca);

					if (buscador == true || buscador1 == true) {
						Auto auto2 = listMetrocard.get(i);
						System.out.println(auto2);
					} else {
						System.out.println("El auto ingresado no se encuentra en la base de datos");

					}

				}

			} else if (opcion.equals("1.b")) {
				System.out.println("Ingrese la placa del auto a reservar:");
				placa = teclado.nextLine();
				System.out.println("Ingrese la cedula:");
				cedula = teclado.nextLine();
				auto.setCedula(cedula);

				for (int i = 0; i < listMetrocard.size(); i++) {
					Auto auto1 = listMetrocard.get(i);
					boolean buscador = auto.getPlaca().contains(placa);
					if (buscador == true) {
						boolean buscador1 = auto.getEstado().equals("Disponible");
						if (buscador1 == true) {
							auto.setEstado("Reservado");
							diaFinal = diaActual.plusDays(2);
							auto.setFechaEntrega(diaFinal);
							auto.getFechaEntrega();
							System.out.println("Su auto ha sido reservado correctamente retirelo en el patio de autos");

						} else {
							System.out.println("El auto que busca no está disponible");

						}

					} else {
						System.out.println("No se ha encontrado el auto");

					}
				}
			} else if (opcion.equals("2.a")) {
				System.out.println("Ingrese la placa:");
				placa = teclado.nextLine();
				auto.setPlaca(placa);
				System.out.println("Ingrese el modelo:");
				modelo = teclado.nextLine();
				auto.setModelo(modelo);
				System.out.println("Ingrese la marca:");
				marca = teclado.nextLine();
				auto.setMarca(marca);
				System.out.println("Ingrese el año de fabricacion:");
				anioFabricacion = teclado.nextLine();
				auto.setAnioFabricacion(anioFabricacion);
				System.out.println("Ingrese el país de fabricacion:");
				paisFabricacion = teclado.nextLine();
				auto.setPaisFabricacion(paisFabricacion);
				System.out.println("Ingrese el cilindraje:");
				cilindraje = teclado.nextLine();
				auto.setCilindraje(cilindraje);
				System.out.println("Ingrese el avalúo(precio del auto):");
				precioAuto = teclado.nextLine();
				auto.setPrecioAuto(precioAuto);
				System.out.println("Que tipo de auto es:");
				System.out.println("1.Automóvil");
				System.out.println("2.Camioneta");
				String tipoAuto = teclado.nextLine();
				if (tipoAuto.equals("1")) {
					System.out.println("Ingrese el número de puertas del Automóvil:");
					String puerta = teclado.nextLine();
					auto.setPuerta(puerta);
				} else if (tipoAuto.equals("2")) {
					System.out.println("Ingrese el peso que soporta la Camioneta");
					String peso = teclado.nextLine();
					auto.setPeso(peso);
				}
				listMetrocard.add(auto);
				System.out.println("La información ha sido guardada exitosamente");
			} else if (opcion.equals("2.b")) {
				System.out.println("Ingrese la placa del auto:");
				placa = teclado.nextLine();
				for (int i = 0; i < listMetrocard.size(); i++) {
					Auto auto1 = listMetrocard.get(i);
					boolean buscador = auto.getPlaca().contains(placa);
					if (buscador == true) {
						boolean buscador1 = auto.getEstado().equals("Reservado");
						if (buscador1 == true) {
							System.out.println("Auto = Placa: " + auto.getPlaca() + " - Modelo: " + auto.getModelo()
									+ " - Estado: " + auto.getEstado() + " - Fecha Entrega: " + auto.getFechaEntrega()
									+ " - Reservado por: " + auto.getCedula());
							System.out.println("¿Desea alquilarlo?");
							System.out.println("1.Alquilar");
							System.out.println("2.No Alquilar");
							String opcionAlquiler = teclado.nextLine();
							if (opcionAlquiler.equals("1")) {
								auto.setEstado("Alquilado");
								diaFinal = diaActual.plusDays(2);
								auto.setFechaEntrega(diaFinal);
								System.out.println("El auto debe ser entregado el: " + auto.getFechaEntrega());

							} else if (opcionAlquiler.equals("2")) {
								System.out.println("El auto no ha sido alquilado");
							}
						}
					}
				}
			} else if (opcion.equals("2.c")) {
				System.out.println("Ingrese la placa del auto alquilado:");
				placa = teclado.nextLine();
				System.out.println("Ingrese la cedula del cliente:");
				cedula = teclado.nextLine();
				for (int i = 0; i < listMetrocard.size(); i++) {
					Auto auto1 = listMetrocard.get(i);
					boolean buscador = auto.getPlaca().contains(placa);
					if (buscador == true) {
						boolean buscador1 = auto.getCedula().contains(cedula);
						if (buscador1 == true) {
							System.out.println("Placa: " + auto.getPlaca() + " - Modelo: " + auto.getModelo()
									+ " - Estado: " + auto.getEstado() + " - Fecha de Entrega: "
									+ auto.getFechaEntrega() + " - Alquilado a: " + auto.getCedula());
							System.out.println("¿Desea aplazar la fecha de entrega?");
							System.out.println("1.Aplazar");
							System.out.println("2.No Aplazar");
							String opcionAplazar = teclado.nextLine();
							if (opcionAplazar.equals("1")) {
								System.out.println(
										"El auto debe ser entregado el: " + auto.getFechaEntrega().plusDays(3));

							} else if (opcionAplazar.equals("2")) {
								System.out.println("No se puede aplazar el día de entrega");
							}
						}
					}
				}
			}
		} while (!opcion.equals("3"));

	}

}
