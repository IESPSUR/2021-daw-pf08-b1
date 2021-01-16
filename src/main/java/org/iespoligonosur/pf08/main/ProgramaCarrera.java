package org.iespoligonosur.pf08.main;

import java.time.LocalDateTime;

import org.iespoligonosur.pf08.clases.IJugador;
import org.iespoligonosur.pf08.clases.JugadorBasico;

public class ProgramaCarrera {

	// Array con los jugadores
	private JugadorBasico[] jugadores = new JugadorBasico[6];
	private int longitudPistaCarreras = 100;
	private int turno;
	private int ganador;
	private LocalDateTime inicioPartida;
	private LocalDateTime finalPartida;

	public ProgramaCarrera() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Este metodo ejecutara el programa de Carreras El usuario debe poder realizar
	 * tantas carreras como quiera Se pueden repetir carreras con los usuarios
	 * creados Se pueden repetir carreras creando nuevos usuarios
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores con la ayuda del
	 * usuario que introduce los datos a través de la consola.
	 */
	private void creaJugadores() {

	}

	/**
	 * Este metodo inicia la partida con los jugadores ya previamente creados por el
	 * usuario La partida termina cuando cualquiera de los jugadores recorre toda la
	 * longitud determinada para la pista alcanzando la meta.
	 */
	private void iniciaPartida() {

	}

	/**
	 * Este metodo realiza una representacion grafica en consola de la pista y la
	 * posicion de los jugadores en la misma
	 */
	private void pintaCarrera() {

	}

	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes de la
	 * carrea para ejecutar un turno de la carrera
	 */
	private void ejecutaTurno() {
		turno = 6;
		for (int i = 0; i < turno; i++) {
			jugadores[i].avanza();
			if (jugadores[i].getRecorrido() >= longitudPistaCarreras) {
				ganador = i;
				break;
			}
		}
	}

	/**
	 * Este método debe imprimir la estadística de la carrera Fecha y Hora de la
	 * realización Duración en minutos Número de participantes Ranking de
	 * participantes Velocidad Punta Máxima y Jugador que la alcanzó Velocidad Media
	 * más alta y jugador que la alcanzo
	 */
	private void imprimeEstadisticaCarrera() {
		System.out.println("El Resultado: ");
		for (int i = 0; i < 6; i++) {
			System.out.println(jugadores[i].getCaminos() + jugadores[i].getNombre());
		}
		System.out.println("El jugador con maxima velocidad punta: " + masVeloz().getNombre());
		System.out.println("El jugador con maxima media de velocidad punta: " + mayorMedia().getNombre());
		imprimeJugadoresOrdenados(ordenaRanking());
	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * punta
	 * 
	 * @return
	 */
	private IJugador masVeloz() {
		IJugador velMaxJugador = jugadores[0];
		for (int i = 0; i < 6; i++) {
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
	private IJugador mayorMedia() {
		JugadorBasico velMaxMedJugador = jugadores[0];
		for (int i = 0; i < 6; i++) {
			if (jugadores[i].getVelocidadMedia() > velMaxMedJugador.getVelocidadMedia()) {
				velMaxMedJugador = jugadores[i];
			}
		}
		return velMaxMedJugador;
	}

	/**
	 * Método que devuelve un array de Jugadores con los jugadores de la partida
	 * ordenados por puesto de carrera. En caso de que dos jugadores lleguen a meta
	 * en el mismo turno, o sin llegar a meta empaten en el numero de pasos
	 * recorridos, gana aquel que su velocidad en el ultimo turno fuera mas alta
	 * 
	 * @return
	 */
	private IJugador[] ordenaRanking() {
		return null;
	}

	
	private void imprimeJugadoresOrdenados(IJugador[] arrayJug) {
		
	}

}
