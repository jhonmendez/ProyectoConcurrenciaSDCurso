package edu.cecar;


import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import edu.cecar.models.ResultCalculateSale;
import edu.cecar.services.CalculateStatisticService;

/**
 * Unit test for simple App.
 */

@SpringBootTest
public class TestCalculateStatistic 
{   
	
	@Value("${spring.path}")
	private String path;
	
	@Autowired
	private CalculateStatisticService calculateStatisticService;
	
    @Test
    public void testStastiticcSale()
    {
        
		int numberCores = 1;

		ResultCalculateSale resultCalculateSale = calculateStatisticService
				.getCalulateSaleStatistic(numberCores);
				
		
		BigDecimal sumExpected =  new BigDecimal("638418644944.03394687544");
		BigDecimal avgExpected = new BigDecimal("255368.45797761360");
		int numberSales = 10000000;
		
		
		
    }
}
