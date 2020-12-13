package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Definicion de una clase base para la implementacion de dados de N caras
 * @author eserrano
 *
 */
public abstract class DadoBase implements IDado{

	 private int numeroCaras;
	    private int resultadoDado;

	    public DadoBase(int numeroCaras) {
	    	this.numeroCaras = numeroCaras;
	    }
	    
	    @Override
		public void lanzarDado() {
		 Random dadoBase = new Random();
		 resultadoDado = 1 + dadoBase.nextInt(numeroCaras);
	 }

		public int getDado() {
			return resultadoDado;
		}

}
/* primer comentario */
