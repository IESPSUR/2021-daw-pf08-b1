package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Definicion de una clase base para la implementacion de dados de N caras
 * @author eserrano
 *
 */
public abstract class DadoBase implements IDado{

	private int numeroCaras;

	public DadoBase(int numeroCaras) {
		this.numeroCaras = numeroCaras;
	}

	@Override
	public int lanzarDado() {
		Random dadoBase = new Random();
		int resultadoDado = 1 + dadoBase.nextInt(numeroCaras);
		return resultadoDado;
	}

}
