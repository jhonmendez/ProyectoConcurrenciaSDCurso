/**
 * Class: ResultadoNumeroPrimo.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.modelos;

import java.util.ArrayList;
import java.util.List;

public class ResultadoNumeroPrimo {
	
	private static List<Long> numerosPrimosObtenidos;
	
	private ResultadoNumeroPrimo() throws IllegalAccessException {
		
		throw new IllegalAccessException("Constructor Privado");
	}
	
	
	public static synchronized void adicionarNumeroPrimo(Long numeroPrimoEncontrado) {
		
		numerosPrimosObtenidos.add(numeroPrimoEncontrado);
	}

	
	public static List<Long> getNumerosPrimosObtenidosOrdenadosAscendentemente() {
		
		numerosPrimosObtenidos.sort((a, b) -> a.compareTo(b));
		
		return numerosPrimosObtenidos;
	}
	
	public static void iniciarLista() {
		
		numerosPrimosObtenidos  = new ArrayList<>();
	}
}
