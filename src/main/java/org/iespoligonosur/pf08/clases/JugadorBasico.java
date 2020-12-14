package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

/**
 * Clases base de Jugadores. Se deben implemenntar las clases hijas Tortuga,
 * Liebre y CorreCaminos
 * 
 * @author eserrano
 *
 */
public class JugadorBasico implements IJugador {

	// Creando las variables
	private String nombre;
	private int velocidadPunta;
	private int ultimaTirada;
	private int recorrido = 0;
	private String caminos = "";
	private DadoBase dado;
	private final static int pista = 100;
	private int[] velocidadNum = new int[pista];
	private int contVelo = -1;
	private TipoJugador tipo;
	private int dadoValor;

	/**
	 * El constructor
	 * 
	 * @param nombre Recibe el nombre del jugador
	 */
	public JugadorBasico(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public TipoJugador getTipo() {
		return tipo;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		return ultimaTirada;
	}

	/**
	 * Devuelve la velocidad máxima de cada jugador
	 */
	@Override
	public int getVelocidadAlcanzadaMaxima() {
		int VelocidadMax = 0;
		for (int i = 0; i < velocidadNum.length - 1; i++) {
			if (velocidadNum[i] > VelocidadMax) {
				VelocidadMax = velocidadNum[i];
			}
		}
		return VelocidadMax;
	}

	@Override
	public void resetea() {
		setCaminos("");
		setRecorridoCero(0);
		setUltimaTirada(0);

	}

	/**
	 * Con este método el jugador avanza en la consola dependiendo del número del
	 * dado
	 */
	@Override
	public void avanza() {
		this.dadoValor = dado.lanzarDado();
		if (getRecorrido() >= pista) {
			setUltimaTirada(dadoValor);
		} else {
			setRecorrido(dadoValor);
			System.out.println(getCaminos() + getNombre());
			/*if (getTipo() == TipoJugador.TORTUGA) {
				if (getRecorridoT() == 100) {
					setUltimaTiradaT(dado.lanzarDado());
				} else {
					switch (dado.lanzarDado()) {
					case 1:
						setRecorridoT(1);
						System.out.println(caminosT + "T");
					case 2:
						setRecorridoT(2);
						caminosT = caminosT + " ";
						System.out.println(caminosT + "T");
					case 3:
						setRecorridoT(3);
						caminosT = caminosT + "  ";
						System.out.println(caminosT + "T");
					}
				}
			} else if (getTipo() == TipoJugador.LIEBRE) {
				if (getRecorridoL() == 100) {
					setUltimaTiradaL(dado.lanzarDado());
				} else {
					if (dado.lanzarDado() == 3) {
						setRecorridoL(3);
						caminosL = caminosL + "  ";
						System.out.print(caminosL + "L");
					} else {
						Scanner sc = new Scanner(System.in);
						System.out.println("El número que ha salido piensas que es mayor o menor que tres?");
						String mayMenRes = sc.next();
						String MayMen;
						if (dado.lanzarDado() > 3) {
							MayMen = "mayor";
						} else {
							MayMen = "menor";
						}
						if (mayMenRes.equalsIgnoreCase(MayMen)) {
							switch (dado.lanzarDado()) {
							case 1:
								setRecorridoL(1);
								System.out.println(caminosL + "L");
							case 2:
								setRecorridoL(2);
								caminosL = caminosL + " ";
								System.out.println(caminosL + "L");
							case 4:
								setRecorridoL(4);
								caminosL = caminosL + "   ";
								System.out.println(caminosL + "L");
							case 5:
								setRecorridoL(5);
								caminosL = caminosL + "    ";
								System.out.println(caminosL + "L");
							case 6:
								setRecorridoL(6);
								caminosL = caminosL + "     ";
								System.out.println(caminosL + "L");
							}
						}
						sc.close();
					}
				}
			} else if (getTipo() == TipoJugador.CORRECAMINOS) {
				if (getRecorridoC() == 100) {
					setUltimaTiradaC(dado.lanzarDado());
				} else {
					switch (dado.lanzarDado()) {
					case 2:
						setRecorridoC(2);
						caminosC = caminosC + " ";
						System.out.println(caminosC + "C");
					case 4:
						setRecorridoC(4);
						caminosC = caminosC + "   ";
						System.out.println(caminosC + "C");
					case 6:
						setRecorridoC(6);
						caminosC = caminosC + "     ";
						System.out.println(caminosC + "C");
					case 8:
						setRecorridoC(8);
						caminosC = caminosC + "       ";
						System.out.println(caminosC + "C");
					case 10:
						setRecorridoC(10);
						caminosC = caminosC + "         ";
						System.out.println(caminosC + "C");
					}
				}*/
		}
	}

	/**
	 * Determina los caminos que se tienen que pintar dependiendo del número que
	 * salga
	 * 
	 * @param recorrido
	 */
	
	public void setRecorrido(int recorrido) {
		contVelo++;
		for (int i = 0; i < recorrido; i++) {
			caminos = caminos + " ";
		}
		velocidadNum[contVelo] = recorrido;// Rellenando un array de velocidades para después saber la máxima velocidad
		this.recorrido = this.recorrido + recorrido;
	}

	public void setRecorridoCero(int recorrido) {
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

}
