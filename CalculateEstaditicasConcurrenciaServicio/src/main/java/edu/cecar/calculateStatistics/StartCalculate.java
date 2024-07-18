/**
 * Class: StartCalculate.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/

package edu.cecar.calculateStatistics;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import edu.cecar.models.ResultCalculateSale;

public class StartCalculate {
	
	private String pathDirectoryToProcess;
	private int numberCores;
	private String fileHasHeader;
	
	private StartCalculate(String pathDirectoryToProcess, int numberCores,String fileHasHeader) {
		this.pathDirectoryToProcess = pathDirectoryToProcess;
		this.numberCores = numberCores;
		this.fileHasHeader = fileHasHeader;
	}
	
	public static StartCalculate startCalculateInPathDirectoryWithNumberCores(String pathDirectoryToProcess,
			int numberCores,String fileHasHeader) {
		
		return new StartCalculate(pathDirectoryToProcess,numberCores,fileHasHeader);
	}
	
	

	public ResultCalculateSale startCalculate() {
		
		File directoryToProcess = new File(pathDirectoryToProcess);

		ExecutorService executorService = Executors.newFixedThreadPool(numberCores);
		List<CompletableFuture<ResultCalculateSale>> futures = new ArrayList<CompletableFuture<ResultCalculateSale>>();

		for (File file : directoryToProcess.listFiles()) {
			
			Supplier<ResultCalculateSale> task = () ->  CalculateStatistics.calculateStatisticsConcurrentlyWithFileAndFilehasHeader(file,fileHasHeader)
					.startStatisticalCalculations();
			CompletableFuture<ResultCalculateSale> future = CompletableFuture.supplyAsync(task, executorService);
			futures.add(future);
		}

		
		
		return caculateTotalResults(futures);

	}

	private ResultCalculateSale caculateTotalResults(List<CompletableFuture<ResultCalculateSale>> futures) {

		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal averageSales = BigDecimal.ONE;
		long numberSales = 0;
		
		for (CompletableFuture<ResultCalculateSale> completableFuture : futures) {

			try {

				sum = sum.add(completableFuture.get().getSum());
				averageSales = averageSales.add(completableFuture.get().getAverageSales());
				numberSales += completableFuture.get().getNumberSales();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		ResultCalculateSale resultCalculateSaleTotal = new ResultCalculateSale();
		resultCalculateSaleTotal.setAverageSales(averageSales);
		resultCalculateSaleTotal.setNumberSales(numberSales);
		resultCalculateSaleTotal.setSum(sum);
		return resultCalculateSaleTotal;
	}

}
