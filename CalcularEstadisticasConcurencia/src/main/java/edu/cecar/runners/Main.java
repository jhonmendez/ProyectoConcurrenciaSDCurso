/**
 * Class: Main.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/

package edu.cecar.runners;

import java.util.logging.Logger;

import edu.cecar.calculateStatistics.StartCalculate;
import edu.cecar.componentes.BenchMark;
import edu.cecar.componentes.Configuration;
import edu.cecar.componentes.Utilidades;
import edu.cecar.models.ResultCalculateSale;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		BenchMark.iniciarConteo();
		
		logger.info("Starting processing");

		String pathDirectoryToProcess = Configuration.getKeyWithName("path");
		
		int numberCores = Utilidades.getNumberCores();

		ResultCalculateSale resultCalculateSale = StartCalculate
				.startCalculateInPathDirectoryWithNumberCores(pathDirectoryToProcess, numberCores)
				.startCalculate();

		logger.info(String.format("Tiempo Ejecucion %d(s)", BenchMark.finalizarConteo()/1000));
		
		logger.info("Sumatoria: " + resultCalculateSale.getSum());
		logger.info("Promedio: " + resultCalculateSale.getAverageSales());
		logger.info("Numero ventas: " + resultCalculateSale.getNumberSales());
	}

}
