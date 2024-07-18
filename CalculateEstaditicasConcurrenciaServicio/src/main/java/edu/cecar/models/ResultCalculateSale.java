/**
 * Class: ResultCalculateSale.java
 * 
 * @since 5/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ResultCalculateSale {
	
	
	private  BigDecimal sum = BigDecimal.ZERO;
	private  BigDecimal averageSales = BigDecimal.ONE;
	
	private  long numberSales;
	
	private  Map<Integer,BigDecimal> salesByYear = new HashMap<Integer, BigDecimal>();
	
	public  BigDecimal getSum() {
		return sum;
	}
	
	public  long getNumberSales() {
		return numberSales;
	}
	
	public  BigDecimal getAverageSales() {
		return averageSales;
	}
	
	public  Map<Integer, BigDecimal> getSalesByYear() {
		return salesByYear;
	}
	
	public  void addValue(String value) {
		
		sum = sum.add(new BigDecimal(value));
	}

	
	public  void countSales() {
		
		numberSales++;
	}
	
	
	public  void addSalesByYear(Integer year, String value) {
		
		BigDecimal valueDecimal = new BigDecimal(value);
		
		
		if (salesByYear.containsKey(year))
			
			salesByYear.put(year, salesByYear.get(year).add(valueDecimal));
		
		else
			
			salesByYear.put(year, valueDecimal);
		
	}
	
	
    public  void calculateAverage() {
		
    	averageSales = sum.divide(BigDecimal.valueOf(numberSales), RoundingMode.CEILING);
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public void setAverageSales(BigDecimal averageSales) {
		this.averageSales = averageSales;
	}

	public void setNumberSales(long numberSales) {
		this.numberSales = numberSales;
	}

	public void setSalesByYear(Map<Integer, BigDecimal> salesByYear) {
		this.salesByYear = salesByYear;
	}
    
    
}
