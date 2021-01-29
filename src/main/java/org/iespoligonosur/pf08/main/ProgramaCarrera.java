package org.iespoligonosur.pf08.main;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.iespoligonosur.pf08.clases.CorreCamino;
import org.iespoligonosur.pf08.clases.IJugador;
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.Tortuga;

public class ProgramaCarrera {

	private static IJugador[] jugadores;

	private static int longitudPistaCarreras = 100;
	private static LocalDateTime inicioPartida;
	private static LocalDateTime finalPartida;
	private static int ganador;
	static Scanner sc = new Scanner(System.in);
	private static int numero = 0;

	public ProgramaCarrera() {
	}

	/**
	 * Este metodo ejecutara el programa de Carreras El usuario debe poder realizar
	 * tantas carreras como quiera Se pueden repetir carreras con los usuarios
	 * creados Se pueden repetir carreras creando nuevos usuarios
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenido al juego");
		do {
			System.out.println("¿Cuántos usuarios van a jugar?");
			numero = sc.nextInt();
			if (2 > numero || numero > 6) {
				System.out.println("Numero incorrecto, el numero de jugadores es de 2 a 6 usuarios por partida");
			}
		} while (2 > numero || numero > 6);
		jugadores = new IJugador[numero];
		creaJugadores();
		iniciaPartida();
		ejecutaTurno();
	}

	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores con la ayuda del
	 * usuario que introduce los datos a traves de la consola.
	 */
	private static void creaJugadores() {

		int animal;
		for (int i = 0; i < numero; i++) {

			do {
				System.out.println("Jugador " + (i + 1) + ": ");
				System.out.println("¿Cual quieres que sea tu alias en el juego?");
				String nombreUsu = sc.next();
				System.out.println("Elige el animal que quieras:\n 1.Tortuga\n 2.Liebre\n 3.CorreCaminos");
				animal = sc.nextInt();

				switch (animal) {
				case 1:
					jugadores[i] = new Tortuga(nombreUsu);
					break;
				case 2:
					jugadores[i] = new Liebre(nombreUsu);
					break;
				case 3:
					jugadores[i] = new CorreCamino(nombreUsu);
					break;
				}
			} while (animal > 3 || animal <= 0);

		}

	}

	/*
	 * Este metodo inicia la partida con los jugadores ya previamente creados por el
	 * usuario La partida termina cuando cualquiera de los jugadores recorre toda la
	 * longitud determinada para la pista alcanzando la meta.
	 */
	private static void iniciaPartida() {
		System.out.println("¡Empieza la partida!");
		pintaIniPartida();
		inicioPartida = LocalDateTime.now();

		while (jugadores[ganador].getRecorrido() < longitudPistaCarreras) {
			System.out.println("Turno Siguiente:");
			ejecutaTurno();
		}
		System.out.println("La partida ha terminado");
		finalPartida = LocalDateTime.now();
		imprimeEstadisticaCarrera();
		System.exit(0);
	}

	private static void pintaIniPartida() {
		for (int i = 0; i < jugadores.length; i++) {
			System.out.println(jugadores[i].getNombre() + "-->");
		}
	}

	/**
	 * Este metodo realiza una representacion grafica en consola de la pista y la
	 * posicion de los jugadores en la misma
	 */

	private static void pintaCarrera(IJugador jugador) {
		System.out.println(jugador.getCaminos() + jugador.getNombre());
	}
	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes de la
	 * carrea para ejecutar un turno de la carrera
	 */
	private static void ejecutaTurno() {

		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i].avanza();
			pintaCarrera(jugadores[i]);
			if (jugadores[i].getRecorrido() >= longitudPistaCarreras) {
				ganador = i;
				break;
			}
		}

	}

	/**
	 * Este metodo debe imprimir la estadistica de la carrera Fecha y Hora de la
	 * realizacion Duracion en minutos Numero de participantes Ranking de
	 * participantes Velocidad Punta Maxima y Jugador que la alcanzo Velocidad Media
	 * mas alta y jugador que la alcanzo
	 */
	private static void imprimeEstadisticaCarrera() {

		System.out.println("\nEl Resultado: ");
		for (int i = 0; i < jugadores.length; i++) {
			System.out.println(jugadores[i].getCaminos() + jugadores[i].getNombre());
		}
		LocalTime ini = inicioPartida.toLocalTime();
		LocalTime fin = finalPartida.toLocalTime();

		imprimeJugadoresOrdenados(ordenaRanking());
		System.out.println("__________________________________________________________________");

		imprimeJugadoresOrdenados(ordenaRanking());
		int duracion = (int) ChronoUnit.MINUTES.between(ini, fin);
		DateTimeFormatter DateHour = DateTimeFormatter.ofPattern("dd MM yyyy hh:mm:ss");
		String formatDateIni = inicioPartida.format(DateHour);
		String formatDateFin = finalPartida.format(DateHour);
		System.out.println("La partida comenzo: " + formatDateIni + "\nLa partida termino: " + formatDateFin
				+ "\nLa partida duro: " + duracion + " minutos.");
		System.out.println("__________________________________________________________________");
		System.out.println("En esta partida han participado " + jugadores.length + " usuarios.");
		System.out.println("El jugador con maxima velocidad punta: " + masVeloz().getNombre() + ". La velocidad: "
				+ masVeloz().getVelocidadAlcanzadaMaxima());
		// Convirtiendo la media de velocidad de double a String para limitar la
		// cantidad de la parte decimal
		DecimalFormat df = new DecimalFormat("#.00");
		String mediaF = df.format(mayorMedia().getVelocidadMedia());


		System.out.println(
				"El jugador con maxima velocidad media: " + mayorMedia().getNombre() + ". La velocidad: " + mediaF);

		System.out.println("El jugador con maxima velocidad media: " + mayorMedia().getNombre()
				+ ". La velocidad: " + mediaF);
	
	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * punta
	 * 
	 * @return
	 */
	private static IJugador masVeloz() {

		IJugador velMaxJugador = jugadores[0];
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i].getVelocidadAlcanzadaMaxima() > velMaxJugador.getVelocidadAlcanzadaMaxima()) {
				velMaxJugador = jugadores[i];
			}
		}
		return velMaxJugador;
	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * media
	 * 
	 * @return
	 */
	private static IJugador mayorMedia() {
		IJugador velMaxMedJugador = jugadores[0];
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i].getVelocidadMedia() > velMaxMedJugador.getVelocidadMedia()) {
				velMaxMedJugador = jugadores[i];
			}
		}
		return velMaxMedJugador;
	}

	/**
	 * Metodo que devuelve un array de Jugadores con los jugadores de la partida
	 * ordenados por puesto de carrera. En caso de que dos jugadores lleguen a meta
	 * en el mismo turno, o sin llegar a meta empaten en el numero de pasos
	 * recorridos, gana aquel que su velocidad en el ultimo turno fuera mas alta
	 * 
	 * @return
	 */
	private static IJugador[] ordenaRanking() {

		IJugador aux;
		for (int i = 0; i < jugadores.length - 1; i++) {
			for (int j = i; j < jugadores.length; j++) {
				if (jugadores[j].getRecorrido() > jugadores[i].getRecorrido()) {
					aux = jugadores[i];
					jugadores[i] = jugadores[j];
					jugadores[j] = aux;
				} else if (jugadores[j].getRecorrido() == jugadores[i].getRecorrido()) {
					if (jugadores[j].getVelocidadUltimoTurno() > jugadores[i].getVelocidadUltimoTurno()) {
						aux = jugadores[i];
						jugadores[i] = jugadores[j];
						jugadores[j] = aux;
					}
				}
			}
		}
		return jugadores;
	}

	private static void imprimeJugadoresOrdenados(IJugador[] arrayJug) {

		System.out.println("Ranking: ");
		for (int i = 0; i < jugadores.length; i++) {
			System.out.println((i + 1) + ": " + arrayJug[i].getNombre());
		}
	}

}
