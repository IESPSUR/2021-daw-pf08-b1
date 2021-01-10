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
	private double media;
	private final static int pista = 100;
	private int[] velocidadNum = new int[pista];
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
	 * Devuelve la velocidad máxima de cada jugador
	 */
	@Override
	public int getVelocidadAlcanzadaMaxima() {
		int VelocidadMax = 0;
		for (int i = 0; i < (contVelo + 1); i++) {
			if (velocidadNum[i] > VelocidadMax) {
				VelocidadMax = velocidadNum[i];
			}
		}
		return VelocidadMax;
	}

	public double getVelocidadMedia() {
		double sum = 0;
		for (int i = 0; i < velocidadNum.length - 1; i++) {
			sum = sum + velocidadNum[i];
		}
		media = sum / contVelo + 1;
		return media;
	}

	/**
	 * Determina los caminos que se tienen que pintar dependiendo del número que
	 * salga
	 * 
	 * @param recorrido
	 */
	public void setRecorridoTotal(int recorrido) {
		contVelo++;
		for (int i = 0; i < recorrido; i++) {
			setCaminos(getCaminos() + "-");
		}
		velocidadNum[contVelo] = recorrido;// Rellenando un array de velocidades para después saber la máxima velocidad
		this.recorrido = this.recorrido + recorrido;
	}

	@Override
	public void resetea() {
		setCaminos("");
		setRecorrido(0);
		setUltimaTirada(0);
		contVelo = -1;
		setVelocidadMedia(0);
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

	public int getRecorrido() {
		return recorrido;
	}

	public String getCaminos() {
		return caminos;
	}

	public void setCaminos(String caminos) {
		this.caminos = caminos;
	}

	public void setUltimaTirada(int ultimaTirada) {
		this.ultimaTirada = ultimaTirada;
	}

	@Override
	public String getNombre() {
		return nombre;
	}


}
