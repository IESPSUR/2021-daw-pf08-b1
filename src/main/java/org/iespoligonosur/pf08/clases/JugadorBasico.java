package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

/**
 * Clases base de Jugadores. Se deben implemenntar las clases hijas Tortuga,
 * Liebre y CorreCaminos
 * 
 * @author eserrano
 *
 */
public abstract class JugadorBasico implements IJugador {

	private String nombre;
	private int velocidadPunta;
	private int ultimaTiradaT;
	private int ultimaTiradaL;
	private int ultimaTiradaC;
	private int recorridoT;
	private int recorridoL;
	private int recorridoC;
	private TipoJugador tipo;
	private IDado dado;
	String caminosT;
	String caminosL;
	String caminosC;

	public JugadorBasico() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public TipoJugador getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {

		return 0;
	}

	@Override
	public void resetea() {
		setNombre("");
		setRecorridoT(0);
		setRecorridoL(0);
		setRecorridoC(0);
		caminosT = "";
		caminosC = "";
		caminosL = "";
		setUltimaTiradaL(0);
		setUltimaTiradaC(0);
		setUltimaTiradaT(0);
		setVelocidadPunta(0);
	}

	@Override
	public void avanza() {
		dado.lanzarDado();
		if (getTipo() == TipoJugador.TORTUGA) {
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
			}
		}

	}

	public void setRecorridoT(int recorridoT) {
		this.recorridoT = this.recorridoT + recorridoT;
	}

	public int getRecorridoT() {
		return recorridoT;
	}

	public int getRecorridoL() {
		return recorridoL;
	}

	public void setRecorridoL(int recorridoL) {
		this.recorridoL = this.recorridoL + recorridoL;
	}

	public int getRecorridoC() {
		return recorridoC;
	}

	public void setRecorridoC(int recorridoC) {
		this.recorridoC = this.recorridoC + recorridoC;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVelocidadPunta() {
		return velocidadPunta;
	}

	public void setVelocidadPunta(int velocidadPunta) {
		this.velocidadPunta = velocidadPunta;
	}

	public int getUltimaTiradaT() {
		return ultimaTiradaT;
	}

	public void setUltimaTiradaT(int ultimaTiradaT) {
		this.ultimaTiradaT = ultimaTiradaT;
	}

	public int getUltimaTiradaL() {
		return ultimaTiradaL;
	}

	public void setUltimaTiradaL(int ultimaTiradaL) {
		this.ultimaTiradaL = ultimaTiradaL;
	}

	public int getUltimaTiradaC() {
		return ultimaTiradaC;
	}

	public void setUltimaTiradaC(int ultimaTiradaC) {
		this.ultimaTiradaC = ultimaTiradaC;
	}

	public IDado getDado() {
		return dado;
	}

	public void setDado(IDado dado) {
		this.dado = dado;
	}

}
