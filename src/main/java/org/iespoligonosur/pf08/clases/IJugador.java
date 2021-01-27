package org.iespoligonosur.pf08.clases;

public interface IJugador {

	/**
	 * Devuelve el nombre del Jugador
	 * 
	 * @return Nombre del jugador
	 */
	public String getNombre();

	/**
	 * Devuelve la tipología del Jugador
	 * 
	 * @return
	 */
	public TipoJugador getTipo();

	/**
	 * Devuelve la velocidad que alcanzo el jugador en el ultimo avance
	 * 
	 * @return Velocidad del ultimo turno
	 */
	public int getVelocidadUltimoTurno();

	/**
	 * Almacena la velocidad máxima que ha alcanzado el jugador durante algún avance
	 * 
	 * @return velocidad maxima alcanzada
	 */
	public int getVelocidadAlcanzadaMaxima();

	/**
	 * Devuelve la velocidad media alcanzada en la partida de cada jugador
	 * 
	 * @return double
	 */
	public double getVelocidadMedia();

	/**
	 * Devuelve El recorrido total que ha realizado cada jugador
	 * 
	 * @return int
	 */
	public int getRecorrido();

	/**
	 * Devuelve un String de caminos para pintarlos en la consola
	 * 
	 * @return String
	 */
	public String getCaminos();

	/**
	 * Resetea todos los valores internos del objeto para ponerse en disposicion de
	 * empezar una nueva partida
	 */
	public void resetea();

	/**
	 * Este método lanza el dado del jugador que se comportara segun su tipo. El
	 * avance modifica el estado interno del objeto
	 */
	public void avanza();

}
