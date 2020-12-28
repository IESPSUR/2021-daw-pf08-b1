package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class Liebre extends JugadorBasico {

	public Liebre(String nombre) {
		super(nombre);
	}

	Dado dado = new Dado(6);

	@Override
	public void avanza() {
		Scanner sc = new Scanner(System.in);
		int dadoValor = dado.lanzarDado();
		if (getRecorrido() >= 100) {
			setUltimaTirada(dadoValor);
		} else {
			if (dadoValor == 3) {
				setRecorrido(dadoValor);
				System.out.println(getCaminos() + getNombre());
			} else {
				String mayMen;
				if (dadoValor > 3) {
					mayMen = "mayor";
				} else {
					mayMen = "menor";
				}
				System.out.println("El número que ha salido es mayor o menor que 3? (mayor/menor)");
				String res = sc.next();
				if (res.equalsIgnoreCase(mayMen)) {
					setRecorrido(dadoValor);
					System.out.println(dadoValor);
					System.out.println(getCaminos() + getNombre());
				}
			}
		}

	}

}
