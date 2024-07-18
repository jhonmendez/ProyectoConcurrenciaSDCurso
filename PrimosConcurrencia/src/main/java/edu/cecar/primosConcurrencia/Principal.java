/**
 * Class: Principal.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.primosConcurrencia;

import java.io.IOException;
import java.util.stream.Collectors;

import edu.cecar.componentes.Utilidades;
import edu.cecar.concurrencia.BuscarPrimoEnRango;
import edu.cecar.modelos.ResultadoNumeroPrimo;

public class Principal {
	
	public static void main(String[] args) {
		
		int numeroNucloes =  Utilidades.getNumberCores();
		Long rangoMaximoBuscarNumero = 1000000L;
		
		new BuscarPrimoEnRango(rangoMaximoBuscarNumero, numeroNucloes);
		
		String resultado = ResultadoNumeroPrimo.getNumerosPrimosObtenidosOrdenadosAscendentemente()
				           .stream()
				           .map(Object::toString)
				           .collect(Collectors.joining(", "));
	
		try {
			
			Utilidades.createPathWithNameFromText("resultados/numerosPrimos.txt", resultado);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
