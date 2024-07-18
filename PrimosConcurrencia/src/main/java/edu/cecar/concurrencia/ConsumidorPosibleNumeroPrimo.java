/**
 * Class: ConsumidorPosibleNumeroPrimo.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/

package edu.cecar.concurrencia;

import edu.cecar.modelos.ResultadoNumeroPrimo;

public class ConsumidorPosibleNumeroPrimo extends Thread {

	private ProductorPosibleNumeroPrimo productorPosibleNumeroPrimo;

	public ConsumidorPosibleNumeroPrimo(ProductorPosibleNumeroPrimo productorPosibleNumeroPrimo) {

		this.productorPosibleNumeroPrimo = productorPosibleNumeroPrimo;

	}

	@Override
	public void run() {

		Long numeroPosibleNumero;

		while ((numeroPosibleNumero = productorPosibleNumeroPrimo.getPosibleNumeroPrimo()) != null)

			if (esPrimo(numeroPosibleNumero))

				ResultadoNumeroPrimo.adicionarNumeroPrimo(numeroPosibleNumero);

	}

	public boolean esPrimo(Long numeroPosibleNumero) {

		boolean esPrimo = true;

		long limite = numeroPosibleNumero >= 10 ? numeroPosibleNumero / 2 : numeroPosibleNumero - 1;

		for (int i = 2; i <= limite && esPrimo; i++)

			if (numeroPosibleNumero % i == 0)
				esPrimo = false;

		return esPrimo;
	}

}
