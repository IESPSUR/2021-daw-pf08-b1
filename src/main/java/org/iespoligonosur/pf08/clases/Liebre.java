package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class Liebre extends JugadorBasico {

	TipoJugador tipo = TipoJugador.LIEBRE;
	Dado dado = new Dado(6);

	public Liebre(String nombre) {
		super(nombre);
	}

	@Override
	public TipoJugador getTipo() {
		return tipo;
	}

	@Override
	public void avanza() {
		Scanner sc = new Scanner(System.in);
		int dadoValor = dado.lanzarDado();
		if (getRecorrido() >= 100) {
			setUltimaTirada(dadoValor);
		} else {
			if (dadoValor == 3) {
				setRecorridoTotal(dadoValor);
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
					System.out.println("El número que ha salido es mayor o menor que 3? (mayor/menor)");
					res = sc.next();
					if (res.equalsIgnoreCase("menor") || res.equalsIgnoreCase("mayor")) {
						format = true;
					}
				} while (format == false);
				if (res.equalsIgnoreCase(mayMen)) {
					setRecorridoTotal(dadoValor);
					System.out.println(dadoValor);
					System.out.println(getCaminos() + getNombre());
				}
			}
		}
		sc.close();
	}

}
