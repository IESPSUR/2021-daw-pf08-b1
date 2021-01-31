package org.iespoligonosur.pf08.clases;

/**
 * Clases base de Jugadores. Se deben implemenntar las clases hijas Tortuga,
 * Liebre y CorreCaminos
 * 
 * @author eserrano
 *
 */
public abstract class JugadorBasico implements IJugador {

	// Creando las variables
	private String nombre;
	private int ultimaTirada;
	private int recorrido = 0;
	private String caminos = "";
	private int velocidadPunta;
	private double media;
	private final static int pista = 100;
	private int contVelo = -1;

	/**
	 * El constructor
	 * 
	 * @param nombre Recibe el nombre del jugador
	 */
	public JugadorBasico(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Determina los caminos que se tienen que pintar dependiendo del número que
	 * salga y el recorrido total del jugador en la partida.
	 * 
	 * @param recorrido
	 */
	public void setRecorridoTotal(int recorrido) {
		if (recorrido > velocidadPunta) {
			velocidadPunta = recorrido;
		}
		contVelo++;
		for (int i = 0; i < recorrido; i++) {
			setCaminos(getCaminos() + "-");
		}
		this.recorrido = this.recorrido + recorrido;
	}

	/**
	 * Devuelve la velocidad máxima de cada jugador devuelve la velocidad máxima
	 */
	@Override
	public int getVelocidadAlcanzadaMaxima() {
		return velocidadPunta;
	}

	/**
	 * Calcula la velocidad media del jugador
	 * 
	 * @return devulve la media
	 */
	@Override
	public double getVelocidadMedia() {
		media = getRecorrido() / contVelo;
		return media;
	}

	/**
	 * Resetea los datos del jugador
	 */
	@Override
	public void resetea() {
		setCaminos("");
		setRecorrido(0);
		setUltimaTirada(0);
		contVelo = -1;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setVelocidadMedia(double media) {
		this.media = media;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		return ultimaTirada;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}

	@Override
	public double getRecorrido() {
		return recorrido;
	}

	@Override
	public String getCaminos() {
		return caminos;
	}

	public void setCaminos(String caminos) {
		this.caminos = caminos;
	}

	public void setUltimaTirada(int ultimaTirada) {
		this.ultimaTirada = ultimaTirada;
	}

}
