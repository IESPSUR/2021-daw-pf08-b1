package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class Liebre extends JugadorBasico {

	// Variables
	TipoJugador tipo = TipoJugador.LIEBRE;
	Dado dado = new Dado(6);

	// El constructor
	public Liebre(String nombre) {
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
		if (dadoValor == 3) {
			setRecorridoTotal(dadoValor);
			setUltimaTirada(dadoValor);
			System.out.println(getCaminos() + getNombre());
		} else {
			apuesta(dadoValor);
		}

	}

	/**
	 * El método apuesta que en el caso que el jugador acierte, avanza.
	 * @param dadoValor
	 */
	private void apuesta(int dadoValor) {
		Scanner sc = new Scanner(System.in);
		String mayMen;
		if (dadoValor > 3) {
			mayMen = "mayor";
		} else {
			mayMen = "menor";
		}
		boolean format = false;
		String res;
		do {
			System.out.println(getNombre() + ", el número que ha salido es mayor o menor que 3? (mayor/menor)");
			res = sc.next();
			if (res.equalsIgnoreCase("menor") || res.equalsIgnoreCase("mayor")) {
				format = true;
			}
		} while (format == false);
		if (res.equalsIgnoreCase(mayMen)) {
			setUltimaTirada(dadoValor);
			setRecorridoTotal(dadoValor);
			System.out.println(getCaminos() + getNombre());
		} else {
			System.out.println(getCaminos() + getNombre() + ": No puede mover");
		}

	}

}
