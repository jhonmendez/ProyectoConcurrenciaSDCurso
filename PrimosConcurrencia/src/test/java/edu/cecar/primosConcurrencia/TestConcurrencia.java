package edu.cecar.primosConcurrencia;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.cecar.componentes.Utilidades;
import edu.cecar.concurrencia.BuscarPrimoEnRango;
import edu.cecar.modelos.ResultadoNumeroPrimo;

/**
 * Test Concurrencia.
 */
public class TestConcurrencia {

	private List<Long> primosEsperados = Arrays.asList(
            2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L,
            101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L, 139L, 149L, 151L, 157L, 163L, 167L, 173L, 179L, 181L, 191L, 193L,
            197L, 199L, 211L, 223L, 227L, 229L, 233L, 239L, 241L, 251L, 257L, 263L, 269L, 271L, 277L, 281L, 283L, 293L, 307L,
            311L, 313L, 317L, 331L, 337L, 347L, 349L, 353L, 359L, 367L, 373L, 379L, 383L, 389L, 397L, 401L, 409L, 419L, 421L,
            431L, 433L, 439L, 443L, 449L, 457L, 461L, 463L, 467L, 479L, 487L, 491L, 499L, 503L, 509L, 521L, 523L, 541L, 547L,
            557L, 563L, 569L, 571L, 577L, 587L, 593L, 599L, 601L, 607L, 613L, 617L, 619L, 631L, 641L, 643L, 647L, 653L, 659L,
            661L, 673L, 677L, 683L, 691L, 701L, 709L, 719L, 727L, 733L, 739L, 743L, 751L, 757L, 761L, 769L, 773L, 787L, 797L,
            809L, 811L, 821L, 823L, 827L, 829L, 839L, 853L, 857L, 859L, 863L, 877L, 881L, 883L, 887L, 907L, 911L, 919L, 929L,
            937L, 941L, 947L, 953L, 967L, 971L, 977L, 983L, 991L, 997L
        );

	@Test
	public void testearNumeroPrimosHastaMilConTodosCores() {
		
		int numeroNucleos =  Utilidades.getNumberCores();
		Long rangoMaximoBuscarNumero = 1000L;
		
		
		new BuscarPrimoEnRango(rangoMaximoBuscarNumero, numeroNucleos);
	 
		assertArrayEquals(primosEsperados.toArray(), ResultadoNumeroPrimo.getNumerosPrimosObtenidosOrdenadosAscendentemente().toArray());
		
		
	}
	
	@Test
	public void testearNumeroPrimosHastaMilConUnCore() {
		
		int numeroNucleos =  1;
		
		Long rangoMaximoBuscarNumero = 1000L;
		
		new BuscarPrimoEnRango(rangoMaximoBuscarNumero, numeroNucleos);
		
		assertArrayEquals(primosEsperados.toArray(), ResultadoNumeroPrimo.getNumerosPrimosObtenidosOrdenadosAscendentemente().toArray());
		
		
	}
}
