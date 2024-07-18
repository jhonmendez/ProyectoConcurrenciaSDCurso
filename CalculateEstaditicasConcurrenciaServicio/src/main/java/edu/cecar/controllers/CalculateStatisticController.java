/**
 * Class: CalculateStatisticController.java
 * 
 * @since 18/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cecar.models.ResultCalculateSale;
import edu.cecar.services.CalculateStatisticService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/calculate")
@Slf4j
public class CalculateStatisticController {
	
	@Autowired
	private CalculateStatisticService calculateStatisticService;

	@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
	@GetMapping("/{numbersCores}")
	public ResultCalculateSale listarEstadisticas(@PathVariable int numbersCores) {
		
		return calculateStatisticService.getCalulateSaleStatistic(numbersCores);
		
	}
	
}
