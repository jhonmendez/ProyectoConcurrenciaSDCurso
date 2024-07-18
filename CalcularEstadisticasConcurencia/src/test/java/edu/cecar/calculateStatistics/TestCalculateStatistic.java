package edu.cecar.calculateStatistics;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import edu.cecar.componentes.Configuration;
import edu.cecar.componentes.Utilidades;
import edu.cecar.models.ResultCalculateSale;

/**
 * Unit test for simple App.
 */
public class TestCalculateStatistic 
{   
    @Test
    public void testStastiticcSale()
    {
        
    	String pathDirectoryToProcess = Configuration.getKeyWithName("path");

		int numberCores = Utilidades.getNumberCores();

		ResultCalculateSale resultCalculateSale = StartCalculate
				.startCalculateInPathDirectoryWithNumberCores(pathDirectoryToProcess, numberCores)
				.startCalculate();
		
		BigDecimal sumExpected =  new BigDecimal("638418644944.03394687544");
		BigDecimal avgExpected = new BigDecimal("255368.45797761360");
		int numberSales = 10000000;
		
		
		assertEquals("Sum not equals",sumExpected,resultCalculateSale.getSum());
		assertEquals("Avg not equals",avgExpected,resultCalculateSale.getAverageSales());
		assertEquals("Number Sales not equals",numberSales,resultCalculateSale.getNumberSales());
    }
}
