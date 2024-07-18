/**
 * Class: CalculateStatisticService.java
 * 
 * @since 18/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.services;

import static edu.cecar.calculateStatistics.StartCalculate.startCalculateInPathDirectoryWithNumberCores;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import edu.cecar.models.ResultCalculateSale;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculateStatisticService {
	
	@Value("${spring.path}")
	private String path;
	
	@Value("${spring.fileHasHeader}")
	private String fileHasHeader;

	public ResultCalculateSale getCalulateSaleStatistic(int numbersCores) {
		
		log.info("Starting processing");
		
		StopWatch watch = new StopWatch();

		watch.start();
		
		ResultCalculateSale resultCalculateSale = startCalculateInPathDirectoryWithNumberCores(path,
				numbersCores,fileHasHeader).startCalculate();
		
		watch.stop();
		
		log.info("Processing order with ID: {}", watch.getTotalTime(TimeUnit.SECONDS));
		
		return resultCalculateSale;
		
	}
	
}
