package org.iespoligonosur.pf08.clases;

public class CorreCamino extends JugadorBasico {

	// Las variables.
	TipoJugador tipo = TipoJugador.CORRECAMINOS;
	// Dado que devueve un numero entre 1 y 10.
	Dado dado = new Dado(10);

	// Constructor
	public CorreCamino(String nombre) {
		super(nombre);

	}

	// Get de TipoJugador
	@Override
	public TipoJugador getTipo() {

		return tipo;
	}

	@Override
	public void avanza() {
		// Variable de tipo int al que se le ha asignado el metodo lanzarDado.
		int dadoValor = dado.lanzarDado();
		// Si el valor del dado es par avanza, si es impar no avanza.
		if (dadoValor % 2 == 0) {
			setRecorridoTotal(dadoValor);
			setUltimaTirada(dadoValor);

		} else {
			System.out.println("No ha salido un n�mero par!! No podr�s avanzar!");

		}
	}
}
