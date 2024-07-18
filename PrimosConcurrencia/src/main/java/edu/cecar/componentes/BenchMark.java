/** 
 * Clase: BenchMark
 *
 *
 * Version: 1.0
 *
 *
 * Fecha : 2014-02-26
 *
 *
 * Autor: Ing. Jhon Jaime Mendez
 *
 *
 * Copyrigth: CECAR
 *
 **/

package edu.cecar.componentes;

public class BenchMark {
	
	private static long inicio;
	
	public static void iniciarConteo() {
		
		inicio = System.currentTimeMillis();
	}

	
	public static long finalizarConteo() {
		
		long tiempoTranscurrido = System.currentTimeMillis() - inicio;
	    
		return  tiempoTranscurrido;
	   
		
	}
	
	
}
