/**
 * Class: CalculateStatisticsConcurrently.java
 * 
 * @since 17/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/

package edu.cecar.calculateStatistics;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import edu.cecar.componentes.Configuration;
import edu.cecar.models.ResultCalculateSale;

public class CalculateStatistics {

	private File fileProcesed;
	
	public CalculateStatistics(File fileProcesed) {

		this.fileProcesed = fileProcesed;

	}

	public static CalculateStatistics calculateStatisticsConcurrentlyWithFile(File fileProcesed) {

		return new CalculateStatistics(fileProcesed);

	}

	public ResultCalculateSale startStatisticalCalculations() {

		ResultCalculateSale resultCalculateSale = new ResultCalculateSale();
		
		try (CSVReader csvReader = new CSVReader(new FileReader(fileProcesed))) {
			
			verifyHeaderInFile(csvReader);
			
			String[] records = null;
			

			while ((records = csvReader.readNext()) != null) {
				
				String valueString = records[3];
				Integer yearString = Integer.parseInt(records[2].substring(0, 4));

				resultCalculateSale.addValue(valueString);
				resultCalculateSale.countSales();
				resultCalculateSale.calculateAverage();
				resultCalculateSale.addSalesByYear(yearString, valueString);

			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return resultCalculateSale;

	}

	private void verifyHeaderInFile(CSVReader csvReader) throws CsvValidationException, IOException {
	
		if (Configuration.getKeyWithName("fileHasHeader").equalsIgnoreCase("true"))
			
			csvReader.readNext();
		
	}

}
