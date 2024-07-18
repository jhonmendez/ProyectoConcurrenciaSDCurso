/**
 * Class: GeneradorPosibleNumeroPrimo.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/

package edu.cecar.concurrencia;

public class ProductorPosibleNumeroPrimo {

	private Long rangoMinimoParaBuscarNumerosPrimos = 2L;
	private Long rangoMaximoParaBuscarNumerosPrimos;

	public ProductorPosibleNumeroPrimo(long rangoMaximoParaBuscarNumerosPrimos) {

		this.rangoMaximoParaBuscarNumerosPrimos = rangoMaximoParaBuscarNumerosPrimos;
	}

	public synchronized Long getPosibleNumeroPrimo() {

		return rangoMinimoParaBuscarNumerosPrimos < rangoMaximoParaBuscarNumerosPrimos
				? rangoMinimoParaBuscarNumerosPrimos++
				: null;
	}

}
