package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

/**
 * Clases base de Jugadores.
 * Se deben implemenntar las clases hijas Tortuga, Liebre y CorreCaminos
 * @author eserrano
 *
 */
public abstract class JugadorBasico implements IJugador {

	private String nombre;
	private int velocidadPunta;
	private int ultimaTiradaT;
	private int ultimaTiradaC;
	private int ultimaTiradaL;
	private int recorridoT;
	private int recorridoL;
	private int recorridoC;
	private String caminosT;
	private String caminosL;
	private String caminosC;
	private DadoBase dado;
	private TipoJugador tipo;

	
	public int getUltimaTiradaT() {
		return ultimaTiradaT;
	}

	public void setUltimaTiradaT(int ultimaTiradaT) {
		this.ultimaTiradaT = ultimaTiradaT;
	}

	public int getUltimaTiradaC() {
		return ultimaTiradaC;
	}

	public void setUltimaTiradaC(int ultimaTiradaC) {
		this.ultimaTiradaC = ultimaTiradaC;
	}

	public int getUltimaTiradaL() {
		return ultimaTiradaL;
	}

	public void setUltimaTiradaL(int ultimaTiradaL) {
		this.ultimaTiradaL = ultimaTiradaL;
	}

	
	
	
	
	
	public JugadorBasico() {
		// TODO Auto-generated constructor stub
		//Modificación david
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanza() {
		dado.lanzarDado();
		if (getTipo() == TipoJugador.TORTUGA) {
			if (getRecorridoT() == 100) {
				setUltimaTiradaT(dado.getDado());
			} else {
				switch (dado.getDado()) {
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
				setUltimaTiradaL(dado.getDado());
			} else {
				if (dado.getDado() == 3) {
					setRecorridoL(3);
					caminosL = caminosL + "  ";
					System.out.print(caminosL + "L");
				} else {
					Scanner sc = new Scanner(System.in);
					System.out.println("El número que ha salido piensas que es mayor o menor que tres?");
					String mayMenRes = sc.next();
					String MayMen;
					if (dado.getDado() > 3) {
						MayMen = "mayor";
					} else {
						MayMen = "menor";
					}
					if (mayMenRes.equalsIgnoreCase(MayMen)) {
						switch (dado.getDado()) {
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
				setUltimaTiradaC(dado.getDado());
			} else {
				switch (dado.getDado()) {
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
	

}
