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
	private int ultimaTirada;
	private int recorrido;
	private String caminos;
	private DadoBase dado;
	private TipoJugador tipo;

	public JugadorBasico(String nombre) {
		this.nombre = nombre;
	}

	public int getUltimaTirada() {
		return ultimaTirada;
	}

	public void setUltimaTirada(int ultimaTirada) {
		this.ultimaTirada = ultimaTirada;
	}

	public JugadorBasico() {
		// TODO Auto-generated constructor stub
		// Modificación david
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetea() {
		setCaminos("");
		setRecorridoCero(0);
		setUltimaTirada(0);
	}

	@Override
	public void avanza() {
		dado.lanzarDado();
		if (getRecorrido() >= 100) {
			setUltimaTirada(dado.getDado());
		} else {
			System.out.println(getCaminos() + getNombre());
		}
	}

	public void setRecorrido(int recorrido) {
		for (int i = 0; i < recorrido; i++) {
			caminos = caminos + " ";
		}
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

}
