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

	public TipoJugador getTipo() {
		return tipo;
	}

	@Override
	public void avanza() {
		Scanner sc = new Scanner(System.in);
		int dadoValor = dado.lanzarDado();

		if (dadoValor == 3) {
			setRecorridoTotal(dadoValor);
			setUltimaTirada(dadoValor);
			System.out.println(getCaminos() + getNombre());
		} else {
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


}
