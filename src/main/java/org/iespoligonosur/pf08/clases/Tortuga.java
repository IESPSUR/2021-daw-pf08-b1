package org.iespoligonosur.pf08.clases;


public class Tortuga extends JugadorBasico {

	// Variables
	TipoJugador tipo = TipoJugador.TORTUGA;
	Dado dado = new Dado(3);

	// El constructor
	public Tortuga(String nombre) {
		super(nombre);
	}
    //El getter del tipo del jugador
	public TipoJugador getTipo() {
		return tipo;

	}
    /**
     * Sobreescribir el método avanza de la interface IJugador
     */
	@Override
	public void avanza() {
		int dadoValor = dado.lanzarDado();
		 
			setRecorridoTotal(dadoValor);
			setUltimaTirada(dadoValor);
	}
	
}
