/**
 * Class: BuscarPrimoEnRango.java
 * 
 * @since 17/07/2024
 * 
 * @version 0.1
 * 
 * @author Ing. Jhon Jaime Mendez
 * 
 * @copyrigth JASOFT
 **/

package edu.cecar.concurrencia;

import edu.cecar.componentes.BenchMark;
import edu.cecar.modelos.ResultadoNumeroPrimo;

/**
 * Clase que inicia la busqueda de primeros en un rango. Debe tener en cuenta
 * que el rangoincial es 2
 */

public class BuscarPrimoEnRango {

	public BuscarPrimoEnRango(Long rangoMaximoBuscarNumero, int cantidadNucleos) {

		ResultadoNumeroPrimo.iniciarLista();

		BenchMark.iniciarConteo();

		buscarNumeroPrimosEnRangoConCantidadNucleos(rangoMaximoBuscarNumero, cantidadNucleos);

		System.out.println(String.format("El tiempo de ejecucion es de %d(s)", BenchMark.finalizarConteo()/1000));

	}

	private void buscarNumeroPrimosEnRangoConCantidadNucleos(Long rangoMaximoBuscarNumero, int cantidadNucleos) {

		ProductorPosibleNumeroPrimo productorPosibleNumeroPrimo = new ProductorPosibleNumeroPrimo(
				rangoMaximoBuscarNumero);

		Thread[] threads = new Thread[cantidadNucleos];

		for (int i = 0; i < cantidadNucleos; i++) {

			ConsumidorPosibleNumeroPrimo consumidorPosibleNumeroPrimo = new ConsumidorPosibleNumeroPrimo(
					productorPosibleNumeroPrimo);
			threads[i] = consumidorPosibleNumeroPrimo;
			threads[i].start();

		}
		
		bloquearThreadsHastaTerminar(threads);

	}

	private void bloquearThreadsHastaTerminar(Thread[] threads) {

		// Bloquearse hasta que se termine toda la ejecucion de los thread
		for (Thread thread : threads) {
			try {

				thread.join();

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}
